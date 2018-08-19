package leetcode;


/**
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 * 示例:
 * <p>
 * 输入:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 *
 *
 * 思路： 很明显，问题具有 重复子问题（相互比较会用到子问题） 和 最优子空间 （每个问题能化为子问题的最优解）
 * 采用DP
 * 从左上角到右下角
 * 使用自底向上的，保存当前最优子问题解  二维数组
 * 分为四类： 1.0 0 位置 2.第一行 3.第一列 4.其他情况
 *
 */
public class Leetcode_64 {
    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(minPathSum(grid) + "");
    }

    public static int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid == null) return 0;
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[0][0];
                    continue;
                }
                if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                    continue;
                }
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                    continue;
                }
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[row - 1][col - 1];
    }
}
