package question;

import java8.Test;

import java.util.concurrent.*;

/**
 * TODO
 *
 * @author pengwenjie3
 * @date 2019/11/7
 * @since 1.8
 */
public class threadTest {

    public static void main(String[] s) throws InterruptedException {
//        ExecutorService pool = new ThreadPoolExecutor(1, 1, 0,
//                TimeUnit.MICROSECONDS,
//                new SynchronousQueue<>(),
//                Thread::new,
//                (r, executor) -> System.out.println("拒绝执行"));
//
//        pool.execute(() -> System.out.println("dd"));


//        pool.execute(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("hello + " + new Date().toString());
//            }
//        });

        test2();
//        new CountDownLatch(1).await();
    }

    private static void test() throws InterruptedException {
        ExecutorService pool = new ThreadPoolExecutor(8, 100, 0, TimeUnit.MICROSECONDS, new ArrayBlockingQueue<>(100),
                Thread::new,
                (r, executor) -> System.out.println("拒绝执行"));

        for (int i = 0; i < 9; i++) {
            pool.execute(() -> {
                System.out.println("dd");
                for (; ; ) {
                }
            });
        }


        new CountDownLatch(1).await();

    }

    private static void test2() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i % 2);
        }
    }
}
