package com.jaecoding.keep.coding.util.java8.future;

import java.util.Random;

public class Utils {

    public static void delay() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static double getRate(String m1, String m2) {
        delay();
        return 1;
    }

    private static final Random random = new Random();
    public static void randomDelay() {
        int delay = 500 + random.nextInt(2000);
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
