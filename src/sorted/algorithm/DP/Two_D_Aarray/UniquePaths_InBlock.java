package sorted.algorithm.DP.Two_D_Aarray;


/**
 * @author Jae
 * @updated 2018-8-20 22:20:07
 * <p>
 * 不同路径 II 带多个障碍物
 * <p>
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * <p>
 * 二维数组 有多少不同路径 中间有障碍物
 * <p>
 * 思路： 问题具有 重复子问题（相互比较会用到子问题） 和 最优子空间 （每个问题能化为子问题的最优解）
 * 采用DP
 * 坑：！！！有多个障碍物
 * <p>
 * <p>
 * 若障碍物在 ij上
 * 特点： 数量 = dp（mn） - [ dp（ij） * dp（m-i + 1）*（n-j + 1） ]
 */
public class UniquePaths_InBlock {
    public static void main(String[] args) {

        int sum = uniquePathsWithObstacles(new int[][]{{0, 0}});

        System.out.println(sum);
    }

    /**
     * 坑！！ 多个障碍物  记录下所有的障碍点的坐标好了
     * 但是！ 没那么简单
     * 并不是简单的 相减
     *
     * 所以还是回归最淳朴的 DP吧
     */
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) return 0;
        int[][] dp = new int[m][n];
        //第一行的循环
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 0) {
                dp[0][i] = 1;
                continue;
            } else {
                break;
            }
        }
        //第一列的循环
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 0) {
                dp[i][0] = 1;
                continue;
            } else {
                break;
            }
        }
        //之后的循环
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
