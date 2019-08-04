package sorted.algorithm.DP;

/**
 * @author: 彭文杰
 * @create: 2018-08-18 15:00
 * <p>
 * <p>
 * LCS: 最长公共子序列问题 自序列 只需注意顺序，不用连续
 * <p>
 * <p>
 * <p>
 * 状态转移方程：
 * 序列 X = {X1,X2......Xm}  Y = {Y1,Y2......Yn}
 * c(i, j) 表示 序列Xi 与 序列Yj 的最长自序列长度
 * <p>
 * 0             若i=0 或者 j=0
 * c(i, j) =  c(i-1, j-1) + 1   若i，j>0 且Xi = Yj  即序列的尾巴相等，长度加1 化为 求 子问题
 * MAX（ c(i, j-1)， c(i-1, j) ）   若i，j>0 且Xi ≠ Yj  即序列的尾巴不等 比较两种缩小方案的 LCS
 * <p>
 * 很明显，我们要用二维数组 保存各种ij的c(i, j)的值
 **/
public class LCS {
}
