package com.jaecoding.keep.coding.algorithfasdasd.autumnTest;

import java.text.DecimalFormat;
import java.util.Scanner;


/**
 * @author: 彭文杰
 * @create: 2018-08-16 21:23
 **/
public class PDD5 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("######0.00000");
        int m = sc.nextInt();
        int a = sc.nextInt();
        int r = sc.nextInt();
        double d1 = 1f;
        df.format(d1);
        System.out.println(d1);
    }
}
