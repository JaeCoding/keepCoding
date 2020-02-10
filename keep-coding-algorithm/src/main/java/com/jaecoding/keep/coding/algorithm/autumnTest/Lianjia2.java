package com.jaecoding.keep.coding.algorithm.autumnTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: 彭文杰
 * @Date: Created in 2018/8/16 19:06
 * @Description :
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 65536KB；其他语言 589824KB
 * 题目描述：
 * 假设有这样一个计算器，该计算器只有两个按钮，按下第一个按钮能使显示数值减少1，按下第二个按钮能使显示数值乘以2，当前显示数值为N，那么至少要按多少次按钮才能使显示数值变成M？
 * <p>
 * 输入
 * 输入两个整数N和M，1≤N，M≤109。
 * <p>
 * 输出
 * 输出使显示数值变成M的最少按按钮次数。
 * <p>
 * <p>
 * 样例输入
 * 4 5
 * 样例输出
 * 3
 */
public class Lianjia2 {


    //第二题
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        Object[] arr = list.toArray();
        Arrays.sort(arr);
        int sum = 0;
        for (int i = 1; i < n; i++) {
            sum += Integer.parseInt(String.valueOf(arr[i]));
        }
        System.out.println(sum + "");

    }
}
