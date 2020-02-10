package com.jaecoding.keep.coding.algorithm.autumnTest;


import java.io.UnsupportedEncodingException;
import java.util.Random;
import java.util.Scanner;

/**
 * @author: 彭文杰
 * @create: 2018-09-09 10:02
 **/


public class toutiao4 {
    public static boolean isUTF8(String key) {
        try {
            key.getBytes("utf-8");
            return true;
        } catch (UnsupportedEncodingException e) {
            return false;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int n1 = sc.nextInt();
            if (!isUTF8(n1 + "")) {
                System.out.println(0);
            }
        }
        int[] a = {0, 1};
        Random r = new Random();
        int r1 = r.nextInt(2);
        System.out.println(r1);
    }
}
