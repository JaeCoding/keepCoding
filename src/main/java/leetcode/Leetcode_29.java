package leetcode;

import com.google.common.primitives.Longs;

public class Leetcode_29 {
    public static void main(String[] args) {
        new Leetcode_29().divide(-2147483648 ,1);
    }

    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean flag = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);

        // how to fix the overflows
        long dividend1 = Math.abs((long)dividend);
        long divisor1 = Math.abs((long)divisor);

        // 10 3
        long result = 0;
        while (dividend1 >= divisor1) {
            long subtracted = divisor1, count = 1;
            // 若满足条件（规模可缩减），则使用位运算缩小规模 缩减一次 相当于倍数扩大一次，缩到不能缩再把对应 被减数去掉 倍数加上
            while (dividend1 >= (subtracted << 1) ) {
                subtracted <<= 1;
                count <<= 1;
            }
            dividend1 -= subtracted;
            result += count;
        }
        return Math.toIntExact(flag ? result : -result);
    }
}

