package sorted.algorithm.DP;

import java.util.Scanner;

/**
 * @author: 彭文杰
 * @create: 2018-09-16 20:06
 *
 * 简单的dp走台阶
 **/
public class Walk {
    public static int climbStairs(int n) {
        int result = 0;
        if (n == 1) {
            result = 1;
        }
        else if (n == 2) {
            result = 2;
        }
        else if (n > 2) {
            int[] dp = new int[n];
            dp[0] = 1;
            dp[1] = 2;
            for (int i = 2; i < dp.length; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            result = dp[dp.length - 1];
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(climbStairs(n));
    }

}
