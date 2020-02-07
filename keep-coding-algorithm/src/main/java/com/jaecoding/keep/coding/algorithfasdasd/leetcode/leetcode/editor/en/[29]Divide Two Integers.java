package com.jaecoding.keep.coding.algorithfasdasd.leetcode.leetcode.editor.en;
//Given two integers dividend and divisor, divide two integers without using multiplication,
// division and mod operator.
//
// Return the quotient after dividing dividend by divisor. 
//
// The integer division should truncate toward zero. 
//
// Example 1: 
//
// 
//Input: dividend = 10, divisor = 3
//Output: 3 
//
// Example 2: 
//
// 
//Input: dividend = 7, divisor = -3
//Output: -2 
//
// Note: 
//
// 
// Both dividend and divisor will be 32-bit signed integers. 
// The divisor will never be 0. 
// Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231, 231 − 1]. For the purpose of this problem, assume that your function returns 231 − 1 when the division result overflows. 
// 
// Related Topics Math Binary Search



//leetcode submit region begin(Prohibit modification and deletion)
class Solution29 {

    public static void main(String[] args) {
        new Solution29().divide(-2147483648, -3);
    }


    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        // xor 同0异1
        // -1 -1 true ^ true
        int flag = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
        System.out.println(flag);
        System.out.println((true ^ true));
        if (Integer.MIN_VALUE == dividend && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        // suspend and bit compute
        long dividend1 = Math.abs((long) dividend);
        long divisor1 = Math.abs((long) divisor);

        int result = 0;
        while (dividend1 >= divisor1) {
            // use bit to reduce the scale
            long subtracted = divisor1, count = 1;
            while (subtracted >= (subtracted << 1)) {
                subtracted <<= 1;
                count <<= 1;
            }
            dividend1 -= subtracted;
            result+=count;
        }
        return flag*result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
