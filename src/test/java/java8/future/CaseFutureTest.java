package java8.future;

import com.clearspring.analytics.util.Lists;
import java8.optional.Car;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;

/**
 * CaseFuture
 *
 * @author pengwenjie3
 * @date 2019/10/15
 * @since 1.8
 */
public class CaseFutureTest {

    static ExecutorService executor = Executors.newFixedThreadPool(3, new ThreadFactory() {
        int count = 1;

        @Override
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "custom-executor-" + count++);
        }
    });


    @Test
    public void completedFutureExample() {
        CompletableFuture<String> cf = CompletableFuture.completedFuture("message");
        assertTrue(cf.isDone());
        // 若未就绪getNow会返回参数值
        assertEquals("message", cf.getNow(null));
    }

    @Test
    public void runAsyncExample() {
        CompletableFuture<Void> cf = CompletableFuture.runAsync(() -> {
            assertTrue(Thread.currentThread().isDaemon());
            Utils.delay();
        });
        // 未就绪
        assertFalse(cf.isDone());
        Utils.delay();
        // 已就绪
        assertTrue(cf.isDone());
    }


    /**
     * .thenApply
     * 将成功就绪的CF，进行下一步操作
     */
    @Test
    public void thenApplyExample() {
        CompletableFuture<String> cf = CompletableFuture.completedFuture("message").thenApply(s -> {
            assertFalse(Thread.currentThread().isDaemon());
            return s.toUpperCase();
        });
        assertEquals("MESSAGE", cf.getNow(null));
    }

    /**
     * thenApplyAsync
     * 一个异步操作完成后，再执行一个异步操作(using ForkJoinPool.commonPool()).
     */
    @Test
    public void thenApplyAsyncExample() {
        CompletableFuture<String> cf = CompletableFuture.completedFuture("message").thenApplyAsync(s -> {
            assertTrue(Thread.currentThread().isDaemon());
            Utils.delay();
            return s.toUpperCase();
        });
        // 没完成，所以是null
        assertNull(cf.getNow(null));
        assertEquals("MESSAGE", cf.join());
    }

    /**
     * 同上，使用自定义的线程池
     */
    @Test
    public void thenApplyAsyncWithExecutorExample() {
        CompletableFuture<String> cf = CompletableFuture.completedFuture("message").thenApplyAsync(s -> {
            assertTrue(Thread.currentThread().getName().startsWith("custom-executor-"));
            assertFalse(Thread.currentThread().isDaemon());
            Utils.delay();
            return s.toUpperCase();
        }, executor);
        assertNull(cf.getNow(null));
        assertEquals("MESSAGE", cf.join());
    }

    /**
     * .thenAccept
     * 若下个场景只消费值（Consumer而不是Function），可使用 thenAccept替代thenApply
     */
    @Test
    public void thenAcceptExample() {
        StringBuilder result = new StringBuilder();
        CompletableFuture.completedFuture("thenAccept message")
                .thenAccept(result::append);
        assertTrue("Result was empty", result.length() > 0);
    }

    /**
     * thenAcceptAsync
     */
    @Test
    public void thenAcceptAsyncExample() {
        StringBuilder result = new StringBuilder();
        CompletableFuture<Void> cf = CompletableFuture.completedFuture("thenAcceptAsync message")
                .thenAcceptAsync(result::append);
        cf.join();
        assertTrue("Result was empty", result.length() > 0);
    }

    /**
     * 异常地显式完成异步操作, 将异常封装于CF
     */
    @Test
    public void completeExceptionallyExample() {
        // CompletableFuture.delayedExecutor() 存在于 Java9 delayed executor that waits for 1 second
//        CompletableFuture<String> cf = CompletableFuture.completedFuture("message").thenApplyAsync(String::toUpperCase, CompletableFuture.delayedExecutor());
        // 异步操作后，后续操作也丢给异步线程池处理
        CompletableFuture<String> cf = CompletableFuture.completedFuture("message").thenApplyAsync(String::toUpperCase, executor);

        // 计算完成时触发后续Function，将结果封装到新的CF中了
        CompletableFuture<String> exceptionHandler = cf.handle((s, th) -> (th != null) ? "message upon cancel" : "");

        // put the exception into the CF , and throws out once CF.join was calling
        cf.completeExceptionally(new RuntimeException("completed exceptionally"));
        assertTrue("Was not completed exceptionally", cf.isCompletedExceptionally());

        try {
            cf.join();// will throw Exception
            fail("Should have thrown an exception");
        } catch (CompletionException ex) {
            assertEquals("completed exceptionally", ex.getCause().getMessage());
        }
        // 新的处理结果如同预期
        assertEquals("message upon cancel", exceptionHandler.join());
    }


    @Test
    public void cancelExample() {
        CompletableFuture<String> cf = CompletableFuture.completedFuture("message").thenApplyAsync(String::toUpperCase, executor);
        CompletableFuture<String> cf2 = cf.exceptionally(throwable -> "canceled message");
        // parameter is not used because the implementation dose not employ interruption to do the cancellation(不采用中断来取消）
        // cf was canceled & cf was isCompletedExceptionally
        assertTrue("Was not canceled", cf.cancel(true));
        assertTrue("Was not completed exceptionally", cf.isCompletedExceptionally());
        assertEquals("canceled message", cf2.join());
    }

    private String delayedUpperCase(String s) {
        Utils.delay();
        return s.toUpperCase();
    }

    private String delayedLowerCase(String s) {
        Utils.delay();
        return s.toLowerCase();
    }

    /**
     * .applyToEither
     * return the first-Complete result 先来先得
     */
    @Test
    public void applyToEitherExample() {
        String original = "Message";
        // Async -> Async
        CompletableFuture<String> cf1 = CompletableFuture.completedFuture(original)
                .thenApplyAsync(this::delayedUpperCase);
        CompletableFuture<String> cf2 = CompletableFuture.completedFuture(original).thenApplyAsync(this::delayedLowerCase);
        // the first-completed one will be apply to Function randomly
        CompletableFuture<String> cf3 = cf1.applyToEither(cf2, s -> s + " from applyToEither");
        System.out.println(cf3.join());
        assertTrue(cf3.join().endsWith(" from applyToEither"));
    }

    /**
     * .acceptEither(Consumer)
     * same as last one， replace Function with Consumer as parameter
     */
    @Test
    public void acceptEitherExample() {
        String original = "Message";
        StringBuffer result = new StringBuffer();

        CompletableFuture<Void> cf = CompletableFuture.completedFuture(original)
                // run in Async
                .thenApplyAsync(this::delayedUpperCase)
                .acceptEither(CompletableFuture.completedFuture(original).thenApplyAsync(this::delayedLowerCase),
                        s -> result.append(s).append("acceptEither"));
        cf.join();// call .join to wait Async complete make Consumer apply
        assertTrue("Result was empty", result.toString().endsWith("acceptEither"));
    }

    /**
     * .runAfterBoth
     * will not execute until both Sync CF was done (一个不能少）
     */
    @Test
    public void runAfterBothExample() {
        String original = "Message";
        StringBuilder result = new StringBuilder();
        CompletableFuture.completedFuture(original)
                .thenApply(String::toUpperCase)
                .runAfterBoth(CompletableFuture.completedFuture(original).thenApply(String::toLowerCase),
                        () -> result.append("done"));
        assertTrue("Result was empty", result.length() > 0);
    }

    /**
     * thenAcceptBoth
     * same as last one，replace Runnable with BiConsumer as parameter
     */
    @Test
    public void thenAcceptBothExample() {
        String original = "Message";
        StringBuilder result = new StringBuilder();
        CompletableFuture.completedFuture(original)
                .thenApply(String::toUpperCase)
                .thenAcceptBoth(CompletableFuture.completedFuture(original).thenApply(String::toLowerCase),
                        (s1, s2) -> result.append(s1).append(s2));
        assertEquals("MESSAGEmessage", result.toString());
    }

    /**
     * thenCombine
     * same as last one，replace Runnable with BiFunction as parameter, return String here
     */
    @Test
    public void thenCombineExample() {
        String original = "Message";
        CompletableFuture<String> cf = CompletableFuture.completedFuture(original)
                .thenApply(this::delayedUpperCase)
                .thenCombine(CompletableFuture.completedFuture(original).thenApply(this::delayedLowerCase),
                        (s1, s2) -> s1 + s2);
        assertEquals("MESSAGEmessage", cf.getNow(null));
    }

    /**
     * same as last, .thenCombine used in Async
     */
    @Test
    public void thenCombineAsyncExample() {
        String original = "Message";
        CompletableFuture<String> cf = CompletableFuture.completedFuture(original)
                .thenApplyAsync(this::delayedUpperCase)
                .thenCombine(CompletableFuture.completedFuture(original).thenApplyAsync(this::delayedLowerCase),
                        (s1, s2) -> s1 + s2);
        assertEquals("MESSAGEmessage", cf.join());
    }

    /**
     * .thenCompose （构成）  CF1.thenCompose(upper -> CF2)  upper是CF1锁包含的数据
     * 只有CF1完成，才会执行
     * .thenCombine （结合）  CF1.thenCombine(CF2 , BiFunction )
     * 完成效果与上例相同
     */
    @Test
    public void thenComposeExample() {
        String original = "Message";
        CompletableFuture<String> cf =
                CompletableFuture.completedFuture(original)
                        .thenApply(this::delayedUpperCase)
                        .thenCompose(upper -> CompletableFuture.completedFuture(original)
                                .thenApply(this::delayedLowerCase)
                                .thenApply(s -> upper + s));
        assertEquals("MESSAGEmessage", cf.join());
    }

    private boolean isUpperCase(String res) {
        return res.toUpperCase().equals(res);
    }

    /**
     * whenComplete
     */
    @Test
    public void anyOfExample() {
        StringBuilder result = new StringBuilder();
        List<String> messages = Arrays.asList("a", "b", "c");
        // In Sync
        List<CompletableFuture<String>> futures = messages.stream()
                .map(msg -> CompletableFuture.completedFuture(msg).thenApply(this::delayedUpperCase))
                .collect(Collectors.toList());
        // anyOf 完成后 继续执行 whenComplete 的任务
        // anyOf 只有要有一个完成的CF就触发
        CompletableFuture.anyOf(futures.toArray(new CompletableFuture[futures.size()]))
                .whenComplete((res, th) -> {
                    // res是其上CF所含
                    if (th == null) {
                        assertTrue(isUpperCase((String) res));
                        result.append(res);
                    }
                });
        assertTrue("Result was empty", result.length() > 0);
    }

    /**
     * allOf
     * occur when ALL CF was complete
     */
    @Test
    public void allOfExample() {
        StringBuilder result = new StringBuilder();
        List<String> messages = Arrays.asList("a", "b", "c");
        List<CompletableFuture<String>> futures = messages.stream()
                .map(msg -> CompletableFuture.completedFuture(msg).thenApply(this::delayedUpperCase))
                .collect(Collectors.toList());
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()]))
                .whenComplete((v, th) -> {
                    // TODO v th 都没用上 那么是什么
                    futures.forEach(cf -> assertTrue(isUpperCase(cf.getNow(null))));
                    result.append("done");
                });
        assertTrue("Result was empty", result.length() > 0);
    }

    @Test
    public void allOfAsyncExample() {
        StringBuilder result = new StringBuilder();
        List<String> messages = Arrays.asList("a", "b", "c");
        List<CompletableFuture<String>> futures = messages.stream()
                .map(msg -> CompletableFuture.completedFuture(msg).thenApplyAsync(this::delayedUpperCase))
                .collect(Collectors.toList());
        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()]))
                .whenComplete((v, th) -> {
                    futures.forEach(cf -> assertTrue(isUpperCase(cf.getNow(null))));
                    result.append("done");
                });
        // So we need to call join() on it to wait for its completion(等待其完成取到）
        allOf.join();
        assertTrue("Result was empty", result.length() > 0);
    }

//    @Test
//    public void allStageTest() {
//        List<Car> cars = Lists.newArrayList();
//        cars().thenCompose(cars -> {
//            List<CompletionStage<Car>> updatedCars = cars.stream()
//                    .map(car -> rating(car.manufacturerId).thenApply(r -> {
//                        car.setRating(r);
//                        return car;
//                    })).collect(Collectors.toList());
//            CompletableFuture<Void> done = CompletableFuture
//                    .allOf(updatedCars.toArray(new CompletableFuture[updatedCars.size()]));
//            return done.thenApply(v -> updatedCars.stream().map(CompletionStage::toCompletableFuture)
//                    .map(CompletableFuture::join).collect(Collectors.toList()));
//        }).whenComplete((cars, th) -> {
//            if (th == null) {
//                cars.forEach(System.out::println);
//            } else {
//                throw new RuntimeException(th);
//            }
//        }).toCompletableFuture().join();
//    }
}