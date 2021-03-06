package com.jaecoding.keep.coding.algorithm.leetcode.leetcode.editor.en;
//Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
//
// 
//Symbol       Value
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000 
//
// For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II. 
//
// Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used: 
//
// 
// I can be placed before V (5) and X (10) to make 4 and 9. 
// X can be placed before L (50) and C (100) to make 40 and 90. 
// C can be placed before D (500) and M (1000) to make 400 and 900. 
// 
//
// Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.
//
// Example 1: 
//
// 
//Input: 3
//Output: "III"
//
// Example 2: 
//
// 
//Input: 4
//Output: "IV"
//
// Example 3: 
//
// 
//Input: 9
//Output: "IX"
//
// Example 4: 
//
// 
//Input: 58
//Output: "LVIII"
//Explanation: L = 50, V = 5, III = 3.
// 
//
// Example 5: 
//
// 
//Input: 1994
//Output: "MCMXCIV"
//Explanation: M = 1000, CM = 900, XC = 90 and IV = 4. 
// Related Topics Math String


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_12 {

    public static void main(String[] args) {
        new Solution_12().intToRoman(3999);
    }

    public Map<Integer, String> getMap() {
        Map<Integer, String> map = new LinkedHashMap<>();
        new ArrayList<>();
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

        return map;
    }

    public String intToRoman(int num) {

        Map<Integer, String> map = getMap();
        final int[] currentNum = {num};
        StringBuffer result = new StringBuffer();
        map.forEach((key, value) -> {
            int count = currentNum[0] / key;
            if (count > 0) {
                for (int i = 0; i < count; i++) {
                    result.append(value);
                }
                currentNum[0] = currentNum[0] % key;
            }
        });
        System.out.println(result.toString());
        return result.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
