package com.jaecoding.keep.coding.algorithm.classification.backTrace;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象：一种代表多种， 多个前者 求 多个后者的组合问题
 * <p>
 * 电话号码的字母组合
 * <p>
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * 示例:
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * <p>
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 */
public class PhoneNumber {
    public static void main(String[] args) {

    }

    /**
     * @param s
     * @param digits
     * @param flag    表示 指针 指向 当前数字 对应 字母数组 的位置
     * @param strList
     */
    public static void backtrack(String s, String digits, int flag, List<String> strList) {
        String[] strings = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};//避免传参 还是都加上这个吧
        //回溯法 底层~！！！底层终止条件
        //若flag达到最后一层，添加到list，并且回溯
        if (flag == digits.length()) {
            strList.add(s);
            return;
        }
        //没有达到底层，就顺序添加上字母 然后继续回溯 更近一层
        String chars = strings[digits.charAt(flag) - '0'];//  -'0'  就能够把 字符 转 数字了
        //现在有了字符串 添加哪个位置的呢？都要添加！！
        for (int i = 0; i < chars.length(); i++) {
            backtrack(s + chars.charAt(i), digits, flag + 1, strList);
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> strList = new ArrayList<>();
        if (digits.length() == 0 || digits == null) return strList;
        backtrack("", digits, 0, strList);
        return strList;
    }
}

