package com.jaecoding.keep.coding.algorithfasdasd.leetcode1;


/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 问总共有多少条不同的路径？
 * <p>
 * 二维数组 有多少不同路径
 * <p>
 * 思路： 很明显，问题具有 重复子问题（相互比较会用到子问题） 和 最优子空间 （每个问题能化为子问题的最优解）
 * 采用DP
 * 从左上角到右下角
 * 使用自底向上的，保存当前最优子问题解  二维数组
 */
public class Leetcode_62 {
    public static void main(String[] args) {
        System.out.println(uniquePaths(4, 3));
    }

    public static int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) return 0;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                if (j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
