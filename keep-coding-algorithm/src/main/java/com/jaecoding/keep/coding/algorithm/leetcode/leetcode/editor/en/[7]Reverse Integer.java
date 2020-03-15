package com.jaecoding.keep.coding.algorithm.leetcode.leetcode.editor.en;
//Given a 32-bit signed integer, reverse digits of an integer.
//
// Example 1: 
//
// 
//Input: 123
//Output: 321
// 
//
// Example 2: 
//
// 
//Input: -123
//Output: -321
// 
//
// Example 3: 
//
// 
//Input: 120
//Output: 21
// 
//
// Note: 
//Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231, 231 − 1].
// For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
// Related Topics Math


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reverse2(int x) {
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverse(1947483649));
    }

    public int reverse(int x) {
        boolean flag = x > 0;
        String s = String.valueOf(Math.abs((long) x));
        StringBuffer buffer = new StringBuffer();
        for (int i = s.length() -1 ; i >= 0; i--) {
            buffer.append(s.charAt(i));
        }
        String result = flag ? buffer.toString() : "-" + buffer.toString();
        if (Long.parseLong(result) > Integer.MAX_VALUE ||
                Long.parseLong(result) < Integer.MIN_VALUE) {
            return 0;
        } else {
            return Integer.parseInt(result);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
