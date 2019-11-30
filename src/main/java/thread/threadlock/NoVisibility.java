package thread.threadlock;

import javax.swing.plaf.TableHeaderUI;

/**
 * 线程间的可见性
 *
 * @author pengwenjie3
 * @date 2019/11/21
 * @since 1.8
 */
public class NoVisibility {

    private static boolean ready;

    private static int number;

    private static class ReaderThread extends Thread {
        @Override
        public void run() {
            while (!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        new ReaderThread().start();
        number = 13;
        ready = true;
    }

}
