package test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MockServiceExample {

    /**
     * 使用场景：在主线程中开启多个任务，并且主线程需要等待其他子任务全部执行完毕之后才能汇总结果继续执行
     */
    private static final int items = 50;
    private static volatile CountDownLatch countDownLatch = new CountDownLatch(items);

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(items, items, 0,
                TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>());
        threadPoolExecutor.prestartAllCoreThreads(); //预先将核心线程都启动起来

        long s1 = System.currentTimeMillis();
        for (int i = 0; i < items; i++) {
            threadPoolExecutor.execute(new Task());
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long cost = System.currentTimeMillis() - s1;

        System.out.println("cost:" + cost);
        threadPoolExecutor.shutdownNow();
    }

    static class Task implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                countDownLatch.countDown();
            }
        }
    }
}