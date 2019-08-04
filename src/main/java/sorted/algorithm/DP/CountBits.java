package sorted.algorithm.DP;

/**
 * @author: 彭文杰
 * @create: 2018-09-15 11:16
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2
 * 输出: [0,1,1]
 * 示例 2:
 * <p>
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 **/
public class CountBits {

    public static void main(String[] args) {
        System.out.println(countBits(4));
    }


    public static int[] countBits(int N) {
        if (N == 0) return new int[]{0};
        if (N == 1) return new int[]{0, 1};
        if (N == 2) return new int[]{0, 1, 1};
        int[] dp = new int[N + 1];
        dp[0] = 0;
        dp[1] = 1;
        int count = 1;
        int num = 2;
        int position = 2;
        while (true) {
            for (int i = 0; i < num; i++) {
                dp[position] = dp[position - num] + 1;
                count += dp[position];
                position++;
                if (position == N + 1) break;
            }
            num = num << 1;
            if (position == N + 1) break;
        }
//        return count;
        return dp;
    }
}
