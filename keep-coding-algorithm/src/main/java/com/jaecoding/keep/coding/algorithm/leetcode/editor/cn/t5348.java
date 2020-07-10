package com.jaecoding.keep.coding.algorithm.leetcode.editor.cn;

/**
 * TODO
 *
 * @author Jae
 * @date 2020/3/21
 * @since 1.8
 */
public class t5348 {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int result = 0;
        for (int i = 0; i < arr1.length; i++) {
            int i2 = arr1[i];
            boolean flag = true;
            for (int i1 = 0; i1 < arr2.length; i1++) {
                int i3 = arr2[i1];
                if (Math.abs(i2 - i3) <= d) {
                    flag = false;
                    break;
                }
            }
            result += flag ? 1 : 0;
        }
        return result;
    }
}
