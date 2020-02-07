package com.jaecoding.keep.coding.algorithfasdasd.autumnTest;

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
public class DIDI22 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int P = sc.nextInt();//P
        int Q = sc.nextInt();//Q
        int R = sc.nextInt();//R
        int len = P + Q + R;
        List<String> list = new LinkedList<>();
        for (int j = 0; j < P; j++) {
            list.add("0");
        }
        for (int j = 0; j < Q; j++) {
            list.add("1");
        }
        for (int j = 0; j < R; j++) {
            list.add("2");
        }
        String str = new String();
        int count = 0;
        count = greed(list, str, len, count);
        System.out.println(count);

    }

    public static int greed(List list, String str, int len, int count) {
        if (str.length() == len) {
            count++;
            return count;
        }

        for (int i = 0; i < list.size(); i++) {
            if (str.length() == 0) {
                str += (list.remove(i));
                count = greed(list, str, len, count);
            } else {
                for (int j = 0; j < list.size(); j++) {
                    if (str.charAt(str.length() - 1) + "" == list.get(j)) {
                        continue;
                    }
                    str += (list.remove(j));
                    count = greed(list, str, len, count);
                }
            }
        }
        return count;

    }
}
