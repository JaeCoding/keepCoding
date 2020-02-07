package com.jaecoding.keep.coding.algorithfasdasd.leetcode1;

public class Leetcode_14 {
    public static void main(String[] args) {
        Leetcode_14 lc = new Leetcode_14();
        System.out.println(lc.longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }


    public String longestCommonPrefix(String[] strs) {
        if(strs == new String[]{""} || strs == null || strs.length == 0) return "";
        int n = strs.length, i = 0, j = 0, count = 1;
        int len = strs[0].length();
        //to find the shortest str
        for (String str : strs) {
            if ("".equals(str)) return "";
            if (str.length() <= len)
                len = str.length();
        }
        //j表示字符位置，i表示所选字符串
        while (j < len){
            i = 0;
            while (i < n-1) {
                if (strs[i].charAt(j) != strs[i + 1].charAt(j)) {
                    return j == 0 ? "" : strs[0].substring(0, j);
                }
                i++;
            }
            j++;
        }
        return strs[0].substring(0, j);
    }
}

