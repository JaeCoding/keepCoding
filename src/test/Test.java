package test;

import java.awt.*;
import java.io.*;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.zip.GZIPOutputStream;

public class Test {
    public static void main(String[] args) throws IOException {
//        Base b = new Sub();
//        System.out.println(b.x);
//        System.out.println(b.methon());
//        int i;
//        System.out.println("" + i);
        Base b = new Base();
        Sub s = new Sub();
        int t;
        new ObjectInputStream(new FileInputStream("a.txt"));
        Lock rock = new ReentrantLock();
    }

    static class Base {
        private int x = 2;
        int methon(int m) {
            return m;
        }
    }
    static class Sub extends Base {
        int x = 3;
//        int methon() {
//            return x;
//        }
    }
}
