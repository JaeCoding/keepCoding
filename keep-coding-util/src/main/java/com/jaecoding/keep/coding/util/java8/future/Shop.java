package com.jaecoding.keep.coding.util.java8.future;

import lombok.Getter;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class Shop {

    @Getter
    private String name;

    public Shop(String name) {
        this.name = name;
    }

    public double getPrice(String product) {
        return calculatePrice(product);
    }

    public String getPrice2(String product) {
        double price = calculatePrice(product);
        //Discount.Code.values()返回一个enum[]
        Discount.Code code = Discount.Code.values()[
                new Random().nextInt(Discount.Code.values().length)];
        return String.format("%s:%.2f:%s", name, price, code);
    }

    /**
     * 异步方法
     * @param product
     * @return
     */
    public Future<Double> getPriceAsync(String product) {
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        //在另一个线程中，异步计算
        new Thread(() -> {
            try {
                double price = calculatePrice(product);
                //将计算好的结果，cas置于future中，cas成功返回T，失败返回F
                futurePrice.complete(price);
            } catch (Exception ex) {
                futurePrice.completeExceptionally(ex);
            }
        }).start();
        return futurePrice;
    }

    /**
     * 将一个Supplier签名lambda作为 参数
     * 生产者方法会交由 ForkJoinPool池中的某个执行线程（ Executor ）运行
     *
     * @return 工厂方法supplyAsync产生CompletableFuture对象
     * <p>
     * 重载版本 第二个参数可以指定不同的执行线程
     */
    public Future<Double> getPriceAsync2(String product) {
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }

    /**
     * 延时，然后随机生成 产品价格
     */
    private double calculatePrice(String product) {
        Utils.delay();
        return new Random().nextDouble() * product.charAt(0) + product.charAt(1);
    }


}
