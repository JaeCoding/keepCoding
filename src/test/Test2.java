package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * 用于选择题 的快速测试
 */
public class Test2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        System.out.println(new t1().a);
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        Class c = classLoader.loadClass("test.A");
        System.out.println("Test");
        c.forName("A");
    }

    public static String func1() {
        try {
            System.out.println("A");
            return func2();
        }finally {
            System.out.println("B");
        }
    }

    public static String func2() {
        System.out.println("C");
        return "D";
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
class A {
    //    public  final String a = new String("OK");
    static
    {
        System.out.println("A");
    }

}