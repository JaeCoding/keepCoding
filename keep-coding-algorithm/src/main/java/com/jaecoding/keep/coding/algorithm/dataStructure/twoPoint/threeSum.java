package com.jaecoding.keep.coding.algorithm.dataStructure.twoPoint;


import com.jaecoding.keep.coding.algorithm.leetcode1.Leetcode_15;

import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class threeSum {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};

    }

    /**
     * 排序后  [-1, 0, 1, 2, -1, -4]  变为 -4 -1 -1 0 1 2
     * 指定一个值num，双指针两端开始。
     * 注意避开重复的情况。一是num的重复  二是指针扫描的重复
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums, int sum) {
        return new Leetcode_15().threeSum(nums, sum);
    }
}

