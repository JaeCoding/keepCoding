package com.jaecoding.keep.coding.algorithfasdasd.autumnTest;

import java.util.Scanner;


/**
 * @author: 彭文杰
 * @create: 2018-08-16 21:23
 * 题目描述：
 **/
public class PDD2 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        int[] redis = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            nums[i] = x;
            count = Math.max(count, x);
        }
//        for (int i = 0; i < n; i++) {//i为缓存
//            if (nums[i]%4 == nums[i]) count++;
//        }
        System.out.println(count / 2 + 1);
    }
}
