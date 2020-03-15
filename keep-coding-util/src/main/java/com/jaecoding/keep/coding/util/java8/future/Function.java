package com.jaecoding.keep.coding.util.java8.future;

import com.jaecoding.keep.coding.util.java8.future.enums.Money;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Function {

    static List<Shop> shops = Arrays.asList(new Shop("BestPrice"),
            new Shop("LetsSaveBig"),
            new Shop("MyFavoriteShop"),
            new Shop("BuyItAll"),
            new Shop("74124yItAll")
    );

    /**
     * 定制的执行器
     * <p>
     * 这里 只要 线程池大小 > 任务数  就能保证 并行下耗时控制在 1s，即便 工作线程数 > cpu线程
     * 原因： 因为采取的是sleep模拟耗时， sleep后会让出cpu资源，
     * 而对于同步API，虽然sleep也会让出cpu，但是方法会阻塞等待结果
     */
    private static final Executor EXECUTOR =
            Executors.newFixedThreadPool(
                    Math.min(shops.size(), 100),
                    r -> {
                        Thread t = new Thread(r);
                        t.setDaemon(true);
                        return t;
                    });

    public static void calTime(long start, String s) {
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println(s + duration + " msecs");
    }

    /**
     * 同步API 按顺序执行
     * 用时4091 ms
     */
    public static List<String> findPrices(String product) {
        return shops.stream()
                .map(shop -> String.format("%s price is %.2f",
                        shop.getName(), shop.getPrice(product)))
                .collect(toList());
    }

    /**
     * 并行流版本
     * 使用了parallelStream
     * 用时1093 ms
     */
    public static List<String> findPrices2(String product) {
        return shops.parallelStream()
                .map(shop -> String.format("%s price is %.2f",
                        shop.getName(), shop.getPrice(product)))
                .collect(toList());
    }

    /**
     * 异步FUTURE API 按顺序执行
     * 用时1056 ms （本机支持4线程）
     */
    public static List<String> findPrices3(String product) {
        List<CompletableFuture<String>> priceFuture =
                shops.stream()
                        //shops -> CompletableFuture<String>
                        .map(shop -> CompletableFuture.supplyAsync(
                                () -> shop.getName() + " price is " + shop.getPrice(product),
                                //重载的supplyAsync，选择了executor
                                EXECUTOR))
                        .collect(toList());

        //然后将List<CompletableFuture<String>> 转化为 List<String>

        //可以把两个连起来么？不可以，因为Stream 的延迟特性会引起顺序执行
        //也就是会造成第一个future1.join()（类似get，显然很耗时）得到结果后，才会创建第二个future

        // 所以先创建出所有List<CompletableFuture<String>>分配任务

        //精髓：先将耗时操作都丢给
        return priceFuture.stream()
                //join类似get，但是不用处理中断，用于lambda中
                .map(CompletableFuture::join)
                .collect(toList());
    }

    /**
     * 获取折扣价格 串行版本
     * 可改为并行流，但效果不好，因为parallelStream底层依赖 线程数量固定（默认为CPU数量）的通用线程池
     * 两个延迟： 1.获取价格每个延迟1000ms  2.获取折扣每个延迟1000ms
     */
    public static List<String> findPricesWithDiscount(String product) {
        return shops.stream()
                .map(shop -> shop.getPrice2(product))
                .map(Quote::parse)
                .map(Discount::applyDiscount)
                .collect(toList());
    }

    /**
     * 使用 CompletableFuture
     *
     * @param product
     * @return
     */
    public static List<String> findPricesWithDiscount2(String product) {
        List<CompletableFuture<String>> priceFuture =
                shops.stream()
                        //1.获取价格。耗时，使用异步
                        //shop -> CompletableFuture<String> ，使用CompletableFuture.supplyAsync()
                        .map(shop -> CompletableFuture.supplyAsync(
                                () -> shop.getPrice2(product), EXECUTOR))

                        //2.解析报价（string->pojo)，不耗时，使用同步
                        //可以立马使用同步操作thenApply，参数为对T的操作。
                        //含义为 若T存在，则对T进行lambda参数操作，转化为Q。（依旧是封装在CF中）
                        .map(future -> future.thenApply(Quote::parse))


                        //3.计算折扣，需要模拟远程Discount耗时
                        // thenCompose允许你对两个异步操作进行流水线，第一个操作完成时
                        // 相当于 future1.thenCompose(future2)


                        // CF<Quote> -> future.thenCompose(Function)
                        // 内部Function(Quote -> CF<Quote>)
                        .map(future -> future.thenCompose(
                                //第二个异步操作，以lambda方式,作为参数传递给thenCompose
                                quote -> CompletableFuture.supplyAsync(
                                        () -> Discount.applyDiscount(quote))
                        ))
                        .collect(toList());

        return priceFuture.stream()
                .map(CompletableFuture::join)
                .collect(toList());

    }

    /**
     * 运用thenCombine 演示A不依赖于B的结合
     */
    public static Double findPriceInUSD(String product, Shop shop) {
        Future<Double> futurePriceInUSD =
                // 同步supply函数，产生一个参数price
                CompletableFuture.supplyAsync(() -> shop.getPrice(product))
                        .thenCombine(
                                //参数一 ：获取计算的第二个参数 rate
                                CompletableFuture.supplyAsync(() -> Utils.getRate(Money.EUR, Money.USD)),
                                //参数二：运算前两者的BiFunction
                                (price, rate) -> price * rate
                        );

        try {
            return futurePriceInUSD.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return 0d;
    }

    /**
     * 重构 findPrices 方法返回一个由 Future 构成的流
     */
    public Stream<CompletableFuture<String>> findPricesStream(String product) {
        return shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(
                        () -> shop.getPrice2(product), EXECUTOR))
                .map(future -> future.thenApply(Quote::parse))
                .map(future -> future.thenCompose(quote ->
                        CompletableFuture.supplyAsync(
                                () -> Discount.applyDiscount(quote), EXECUTOR)));
    }

    public void differ() {
//         * 两者区别，一个用于同步计算  一个用于异步计算
          CompletableFuture<Integer> future =
              CompletableFuture.supplyAsync(() -> 1)
                              .thenApply(x -> x+1);
         
          CompletableFuture<Integer> future2 =
              CompletableFuture.supplyAsync(() -> 1)
                               .thenCompose(x -> CompletableFuture.supplyAsync(() -> x+1));

    }

}
