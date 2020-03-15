package com.jaecoding.keep.coding.algorithm.leetcode1;

import java.util.*;

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
public class Leetcode_15 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(new Leetcode_15().threeSum(nums, -6));
    }

    /**
     * 思路：
     * 排序 + 定一取相反数 + 双指针
     *
     * 排序后  [-1, 0, 1, 2, -1, -4]  变为 -4 -1 -1 0 1 2
     * 指定一个值num，双指针两端开始。
     * 注意避开重复的情况。一是num的重复  二是指针扫描的重复
     */
    public List<List<Integer>> threeSum(int[] nums) {
        return threeSum(nums, 0);
    }

    public List<List<Integer>> threeSum(int[] nums, int sum) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num > 0) break;
            //num与上一位重复，跳过
            if (i > 0 && num == nums[i - 1]) continue;
            int target = sum - num;
            //排序后，从后一位开始双指针
            for (int j = i + 1, k = nums.length - 1; j < k; ) {
                //后半部分是 情况二指针重复，跳过
                if (nums[j] + nums[k] > target || (k < nums.length - 1 && nums[k] == nums[k + 1])) {
                    k--;
                } else if (nums[j] + nums[k] < target || (j > i + 1 && nums[j] == nums[j - 1])) {
                    j++;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(num);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    result.add(list);
                    //找到后，接下来的数必然在两者之间（因为不重复）
                    j++;
                    k--;
                }
            }
        }
        return result;
    }
}

