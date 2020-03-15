package com.jaecoding.keep.coding.algorithm.leetcode.leetcode.editor.en;//Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
//
// Example 1: 
//
// 
//Input: num1 = "2", num2 = "3"
//Output: "6" 
//
// Example 2: 
//
// 
//Input: num1 = "123", num2 = "456"
//Output: "56088"
// 
//
// Note: 
//
// 
// The length of both num1 and num2 is < 110. 
// Both num1 and num2 contain only digits 0-9. 
// Both num1 and num2 do not contain any leading zero, except the number 0 itself. 
// You must not use any built-in BigInteger library or convert the inputs to integer directly. 
// 
// Related Topics Math String


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_43 {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int minLen = Math.min(num1.length(), num2.length());
        int maxLen = Math.max(num1.length(), num2.length());
        String maxOne = num1.length() >= num2.length() ? num1 : num2;
        String minOne = num1.length() < num2.length() ? num1 : num2;

        String result = "0";
        String zeros = "";
        for (int i = minLen - 1; i >= 0; i--) {
            String multiplyResult = multiplyOne(maxOne, minOne.substring(i, i + 1)) + zeros;
            result = add(result, multiplyResult);
            zeros = zeros + "0";
        }
        return result;

    }

    public String multiplyOne(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int len = num1.length();
        Integer multiplier = Integer.valueOf(num2);
        String result = "";
        // 进位倍数
        Integer round = 0;
        for (int i = len - 1; i >= 0; i--) {
            Integer m1 = Integer.valueOf(num1.substring(i, i + 1));
            int multiplyResult = m1 * multiplier + round;
            Integer remainder = multiplyResult % 10;
            round = multiplyResult / 10;
            result = remainder + result;
        }
        result = round.equals(0) ? result : round + result;
        return result;
    }

    public String add(String num1, String num2) {
        int minLen = Math.min(num1.length(), num2.length());
        int maxLen = Math.max(num1.length(), num2.length());
        String maxOne = num1.length() >= num2.length() ? num1 : num2;
        String minOne = num1.length() < num2.length() ? num1 : num2;
        String result = "";
        int round = 0;
        for (int i = minLen - 1, j = maxLen -1 ; i >= 0; i--, j--) {
            int sum = round + Integer.parseInt(minOne.substring(i, i + 1)) + Integer.parseInt(maxOne.substring(j, j + 1));
            Integer remainder = sum % 10;
            round = sum / 10;
            result = remainder + result;
        }
        String prefixS = maxOne.substring(0, maxLen - minLen);
        String prefix;
        if ("".equals(prefixS)) {
            prefix = round == 0 ? "" : String.valueOf(round);
        } else {
            prefix = add(prefixS, String.valueOf(round));
        }
        return prefix + result;
    }


    public static void main(String[] args) {

//        new Solution_43().multiplyOne("123", "6");
//        new Solution_43().multiply("584", "18");
        new Solution_43().add("4672", "5840");
        System.out.println("12345".substring(0,0));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
