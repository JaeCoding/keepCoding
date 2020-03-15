package com.jaecoding.keep.coding.algorithm.classification.math;

import java.util.Scanner;


/**
 * @author: 彭文杰
 * @create: 2018-08-16 21:23
 * <p>
 * min
 **/
public class MinCnommonMultipleNum {

    public static int minbeishu(int a) {
        return a;
    }

    public static int minbeishu(int a, int b)//定义一个含参方法
    {
        int k, r = 0;
        int c = a * b;
        int n = Math.max(a, b);
        int m = Math.min(a, b);
        while (m != 0)//求出两个数的最大公约数
        {
            r = n % m;
            n = m;
            m = r;
        }
        k = c / n;//k即为最小公倍数
        return k;
    }

    public static int minbeishu(int[] a)//定义一个含参方法
    {
        if (a.length == 1) return a[0];
        int result = minbeishu(a[0], a[1]);
        for (int i = 2; i < a.length; i++) {
            result = minbeishu(result, a[i]);
        }
        return result;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
//        int[] a = new int[n];
//        for (int i = 1; i <= n; i++) {
//            a[i - 1] = i;
//        }
//        int s=minbeishu(a);// 1 - n 的最小公倍数
//        System.out.println(s);
        int s1 = 0;
        int s2 = 0;
        int m = 0;
        for (int i = 1; i < 1000; i++) {
            int[] b = new int[i];
            for (int j = 0; j < b.length; j++) {
                b[j] = n + j;
            }
            s1 = minbeishu(b);

            int[] quan = new int[i + n];
            for (int j = 0; j < quan.length; j++) {
                quan[j] = j + 1;
            }
            s2 = minbeishu(quan);
            if (s2 == s1) {
                m = n + i;
                break;
            }
        }
        System.out.println(m);
    }
}