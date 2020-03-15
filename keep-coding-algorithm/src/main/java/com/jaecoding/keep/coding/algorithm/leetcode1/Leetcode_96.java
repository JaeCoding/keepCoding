package com.jaecoding.keep.coding.algorithm.leetcode1;

public class Leetcode_96 {
    public static void main(String[] args) {
        Leetcode_96 a = new Leetcode_96();
        System.out.println(a.numTrees(5));
    }

    public int numTrees(int n) {
        if (n == 0) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
}

