package com.jaecoding.keep.coding.util.help;

// 本题为考试多行输入输出规范示例，无需提交，不计分。

import java.math.BigInteger;
import java.util.Scanner;

public class BigInteger1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long w = sc.nextLong();

        BigInteger bn = new BigInteger(String.valueOf(n));

        BigInteger total = bn.pow((int) w);

        BigInteger un1 = new BigInteger(String.valueOf(n));

        BigInteger bn1 = new BigInteger(String.valueOf(n - 1));

        BigInteger total2 = bn1.pow((int) (w - 1));

        un1 = un1.multiply(total2);

        BigInteger jian = total.subtract(un1);
        BigInteger bw2222 = new BigInteger(String.valueOf("100003"));

        BigInteger jianaaa = jian.remainder(bw2222);


        System.out.println(jianaaa.toString());

    }
}
