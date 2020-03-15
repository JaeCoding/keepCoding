package com.jaecoding.keep.coding.algorithm.leetcode.leetcode.editor.en;
//A message containing letters from A-Z is being encoded to numbers using the fo
//llowing mapping: 
//
// 
//'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
// 
//
// Given a non-empty string containing only digits, determine the total number o
//f ways to decode it. 
//
// Example 1: 
//
// 
//Idput: "12"
//Output: 2
//Explanation: It could be decoded as "AB" (1 2) or "L" (12).
// 
//
// Example 2: 
//
// 
//Idput: "226"
//Output: 3
//Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6)
//. 
// Related Topics String Dynamic Programming


import org.bouncycastle.util.Integers;

import java.sql.SQLOutput;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_91 {
    public int numDecodings(String s) {

        // start dp from back to front
        // eg: 2206
        // nD("6") = 1, nD("06") = 0, nD("206") = nD("2 06") + nD("20 6") = 0 + 1
        // conclude 3 cases below, we can find:
        // dp[i] means numDecodings(s.substring(i,end), like dp[0] = numDecodings(s), dp[1] = numDecodings(s.substring(1,end))

        // 1. s[i] equals "0", its nums = 0
        // 2. s[i] + s[i+1] <= 26, dp[i] = dp[i+1] + dp[i+2]
        // 3. s[i] + s[i+1] > 26, dp[i] = dp[i+1]
        int n = s.length();
        // when i = length - 2, it will used
        int[] dp = new int[n + 1];
        dp[n] = 1;
        // solve the last one
        dp[n - 1] = s.charAt(n - 1) == '0' ? 0 : 1;
        for (int i = n - 2; i >= 0; i--) {

            if (s.charAt(i) == '0') {
                dp[i] = 0;
                continue;
            }

            if (Integer.parseInt(s.substring(i, i + 2)) <= 26) {
                dp[i] = dp[i + 1] + dp[i + 2];
            } else {
                dp[i] = dp[i + 1];
            }

        }
        return dp[0];
    }




    public static void main(String[] args) {
        new Solution_91().numDecodings("226");
    }

}

class Solution_91_2 {
    public int numDecodings(String s) {


        if (s.length() == 1) {
            return Integer.parseInt(s) == 0 ? 0 : 1;
        }

        // start dp from back to front
        // eg: 2206
        // nD("6") = 1, nD("06") = 0, nD("206") = nD("2 06") + nD("20 6") = 0 + 1
        // conclude 3 cases below, we can find:
        // dp[i] means numDecodings(s.substring(i,end), like dp[0] = numDecodings(s), dp[1] = numDecodings(s.substring(1,end))

        // 1. s[i] equals "0", its nums = 0
        // 2. s[i] + s[i+1] <= 26, dp[i] = dp[i+1] + dp[i+2]
        // 3. s[i] + s[i+1] > 26, dp[i] = dp[i+1]
        int n = s.length();
        // when i = length - 2, it will used
        int lastTwo = 1;
        // solve the last one
        int lastOne = s.charAt(n - 1) == '0' ? 0 : 1;
        int thisOne = 1;
        for (int i = n - 2; i >= 0; i--) {

            if (s.charAt(i) == '0') {
                thisOne = 0;
                lastTwo = lastOne;
                lastOne = thisOne;
                continue;
            }

            if (Integer.parseInt(s.substring(i, i + 2)) <= 26) {
                thisOne = lastOne + lastTwo;
            } else {
                thisOne = lastOne;
            }
            lastTwo = lastOne;
            lastOne = thisOne;
        }
        return thisOne;
    }




    public static void main(String[] args) {
        new Solution_91().numDecodings("226");
    }

}
//leetcode submit region end(Prohibit modification and deletion)
