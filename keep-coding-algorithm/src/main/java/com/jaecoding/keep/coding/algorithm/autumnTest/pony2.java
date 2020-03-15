package com.jaecoding.keep.coding.algorithm.autumnTest;

import java.util.Scanner;


/**
 * @author: 彭文杰
 * @create: 2018-08-16 21:23
 **/
public class pony2 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            if (flag) {
                System.out.println("Yes");
                flag = !flag;
            } else {
                System.out.println("No");
            }
        }
    }

    public static void dfs(int count, int spot, char[][] dp, char charr, int row, int col) {
        return;
    }
}

//black win,    14
// "white win",   19
// "draw",        5
// "invalid board",    48
// "not finished"};   14