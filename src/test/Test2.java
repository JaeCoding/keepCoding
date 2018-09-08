package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test2 {
    public static void main(String[] args) throws IOException {
        System.out.println(methon(2));
    }

    public static boolean methon(long num) {
        if (num <= 0) return false;
        if (num == 1) return true;
        long remain;
        while (true) {
            remain = num % 2;
            if (remain == 1) {
                return false;
            }
            num = num >>> 1;
            if (num == 1) {
                return true;
            }
        }
    }

}
