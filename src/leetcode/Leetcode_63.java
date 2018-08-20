package leetcode;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jae
 * @updated 2018-8-20 22:20:07
 *
 * 不同路径 II 带障碍物
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 * 二维数组 有多少不同路径 中间有障碍物
 *
 * 思路： 问题具有 重复子问题（相互比较会用到子问题） 和 最优子空间 （每个问题能化为子问题的最优解）
 * 采用DP
 * 坑：！！！有多个障碍物
 *
 *
 * 若障碍物在 ij上
 * 特点： 数量 = dp（mn） - [ dp（ij） * dp（m-i + 1）*（n-j + 1） ]
 */
public class Leetcode_63 {
    public static void main(String[] args) {

        int sum = uniquePathsWithObstacles(new int[][]{{0,1,0,0,0},{1,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}});

        System.out.println(sum);
    }

    /**
     * 坑！！ 多个障碍物  记录下所有的障碍点的坐标好了
     * 但是！ 没那么简单
     * 并不是简单的 相减
     * @param obstacleGrid
     * @return
     */
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1) return 0;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    if (obstacleGrid[i][j] == 0) {
                        dp[i][j] = 1;
                    } else {
                        for (int k = j; k < n; k++) {
                            dp[i][k] = Integer.MAX_VALUE;
                        }
                    }
                    continue;
                }
                if (j == 0) {
                    if (obstacleGrid[i][j] == 0 && dp[i][j] != 1 && dp[i][j] != Integer.MAX_VALUE) {
                        dp[i][j] = 1;
                    } else {
                        for (int k = i; k < m; k++) {
                            dp[k][j] = Integer.MAX_VALUE;
                        }
                    }
                    continue;
                }
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = Integer.MAX_VALUE;
                } else {
                    if (dp[i - 1][j] == Integer.MAX_VALUE && dp[i][j - 1] == Integer.MAX_VALUE) {
                        dp[i][j] = Integer.MAX_VALUE;
                    } else if (dp[i - 1][j] == Integer.MAX_VALUE || dp[i][j - 1] == Integer.MAX_VALUE) {
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]);
                    } else {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    }
                }
            }
        }
        return dp[m - 1][n - 1] == Integer.MAX_VALUE ? 0 : dp[m - 1][n - 1];
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
