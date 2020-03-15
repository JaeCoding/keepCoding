package com.jaecoding.keep.coding.algorithm.leetcode1;

import java.util.Arrays;

/**
 * 最接近的三数之和
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * <p>
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 */
public class Leetcode_16 {
    public static void main(String[] args) {
        int[] nums3 = new int[]{-1, 2, 1, -4};
        int[] nums4 = new int[]{1, 1, 1, 0};
        Leetcode_16 a = new Leetcode_16();
        a.threeSumClosest(nums3, 1);
    }

    /**
排序 + 定一取相反数 + 双指针
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minAbs = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int firstNum = nums[i];
            int targetTwo = target - firstNum;
            for (int j = i + 1, k = nums.length - 1; j < k; ) {
                if (Math.abs(nums[j] + nums[k] - targetTwo) < minAbs) {
                    minAbs = Math.abs(nums[j] + nums[k] - targetTwo);
                    sum = firstNum + nums[j] + nums[k];
                }
                //后部分 避免指针重复
                if (nums[j] + nums[k] > targetTwo || (k < nums.length - 1 && nums[k] == nums[k + 1])) {
                    k--;
                } else if (nums[j] + nums[k] < targetTwo || (j > i + 1 && nums[j] == nums[j - 1])) {
                    j++;
                } else {
                    return target;
                }
            }
        }
        return sum;
    }
}

