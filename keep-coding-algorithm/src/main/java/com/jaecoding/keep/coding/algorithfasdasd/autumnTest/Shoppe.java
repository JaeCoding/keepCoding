package com.jaecoding.keep.coding.algorithfasdasd.autumnTest;

import java.util.Scanner;

/**
 * @author: 彭文杰
 * @create: 2018-09-12 17:29
 **/
public class Shoppe {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
//        String[] str1s = str1.split(",");
//        String[] str2s = str2.split(",");
//        int[] a = new int[str1s.length];
//        for (int i = 0; i < str1s.length; i++) {
//            a[i] = Integer.parseInt(str1s[i]);
//        }
//        int[] b = new int[str2s.length];
//        for (int i = 0; i < str2s.length; i++) {
//            b[i] = Integer.parseInt(str2s[i]);
//        }

        System.out.println(findcommon(str1, str2) ? "True" : "False");
    }

    public static boolean findcommon(String a, String b) {
        int i = 0, j = 0;
        int size1 = a.length();
        int size2 = b.length();
        while (i < size1 && j < size2) {
            if (a.charAt(i) == b.charAt(j))
                return true;
            if (a.charAt(i) > b.charAt(j))
                j += 2;
            if (a.charAt(i) < b.charAt(j))
                i += 2;
        }
        return false;
    }
}
