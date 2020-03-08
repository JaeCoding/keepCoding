package com.jaecoding.keep.coding.algorithm.leetcode.leetcode.editor.en;

/**
 * TODO
 *
 * @author Jae
 * @date 2020/3/8
 * @since 1.8
 */
public class t5352 {
    public String generateTheString(int n) {
        StringBuilder result = new StringBuilder();
        if (n % 2 == 0) {
            for (int i = 0; i < n - 1; i++) {
                result.append("a");
            }
            result.append("b");
        } else {
            for (int i = 0; i < n; i++) {
                result.append("a");
            }
        }
        return result.toString();
    }
}
