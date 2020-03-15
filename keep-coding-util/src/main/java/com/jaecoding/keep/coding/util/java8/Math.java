package com.jaecoding.keep.coding.util.java8;

public class Math {

    public int calculate(int n) throws Exception {
        if (n < 0) {
            throw new Exception("负数没有阶乘！");
        } else if (n <= 1) {
            return 1;
        } else {
            return n * calculate(n - 1);
        }
    }
}
