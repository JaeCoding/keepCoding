package com.jaecoding.keep.coding.algorithm.leetcode.leetcode.editor.en;

import java.util.Arrays;

/**
 * TODO
 *
 * @author pengwenjie3
 * @date 2020/2/23
 * @since 1.8
 */
class Solution_5171 {

    public int[] closestDivisors(int num) {
        // only to resolve the number less than the sqrt
        int top = (int) Math.ceil(Math.sqrt(num + 2));

        int r1 = 0;
        int r2 = Integer.MAX_VALUE;
        for (int i = 1; i < top + 1; i++) {

            // dividend only be able to divide by one
            int dividend = (num + 1) % i == 0 ? (num + 1) : (num + 2);

            if (dividend % i == 0) {
                int divisor = dividend / i;
                if (Math.abs(i-divisor) < Math.abs(r2-r1)) {
                    r2 = i;
                    r1 = divisor;
                }
            }
        }
        return new int[]{r1,r2};
    }

    public static void main(String[] args) {
        System.out.println(new Solution_5171().closestDivisors(9));
    }
}
