package com.jaecoding.keep.coding.algorithm.autumnTest;

import java.util.*;


/**
 * @author: 彭文杰
 * @create: 2018-08-16 21:23
 * 题目描述：
 * 给定三种类型的小球P、Q、R，每种小球的数量分别为np、nq、nr个。现在想将这些小球排成一条直线，但是不允许相同类型的小球相邻，问有多少种排列方法。如若np=2，nq=1，nr=1则共有6种排列方式：PQRP，QPRP，PRQP，RPQP，PRPQ以及PQPR。 如果无法组合出合适的结果，则输出0。
 * 输入
 * 一行以空格相隔的三个数，分别表示为np，nq，nr。
 * 输出
 * 排列方法的数量。
 * <p>
 * 样例输入
 * 2 1 1
 * 样例输出
 * 6
 **/
public class DIDI2 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int P = sc.nextInt();//P
        int Q = sc.nextInt();//Q
        int R = sc.nextInt();//R
        StringBuffer sb = new StringBuffer();
        for (int j = 0; j < P; j++) {
            sb.append("0");
        }
        for (int j = 0; j < Q; j++) {
            sb.append("1");
        }
        for (int j = 0; j < R; j++) {
            sb.append("2");
        }
        String A = sb.toString();
        char[] arrayA = A.toCharArray();
        Set<String> set = new HashSet<>();

        allPermutation(set, A);
        int count = 0;
        for (String string : set
        ) {
            System.out.println(string);
            boolean flag = true;
            for (int i = 0, j = 1; i < string.length() - 1; i++, j++) {
                if (string.charAt(i) == string.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) count++;
        }
        System.out.println(count);
    }


    public static void allPermutation(Set<String> set, String str) {
        if (str == null || str.length() == 0)
            return;
        //保存所有的全排列

        allPermutation(str.toCharArray(), set, 0);

    }


    private static void allPermutation(char[] c, Set<String> set, int start) {

        if (start == c.length - 1)
            set.add(String.valueOf(c));//System.out.println(String.valueOf(c));
        else {
            for (int i = start; i <= c.length - 1; i++) {
                //只有当没有重叠的字符 才交换
                if (!isSwap(c, start, i)) {
                    swap(c, i, start);//相当于: 固定第 i 个字符
                    allPermutation(c, set, start + 1);//求出这种情形下的所有排列
                    swap(c, start, i);//复位
                }
            }
        }
    }

    private static void swap(char[] c, int i, int j) {
        char tmp;
        tmp = c[i];
        c[i] = c[j];
        c[j] = tmp;
    }

    private static void print(LinkedList<String> listStr) {
        Collections.sort(listStr);//使字符串按照'字典顺序'输出
        for (String str : listStr) {
            System.out.println(str);
        }
        System.out.println("size:" + listStr.size());
    }

    //[start,end) 中是否有与 c[end] 相同的字符
    private static boolean isSwap(char[] c, int start, int end) {
        for (int i = start; i < end; i++) {
            if (c[i] == c[end])
                return true;
        }
        return false;
    }
}
