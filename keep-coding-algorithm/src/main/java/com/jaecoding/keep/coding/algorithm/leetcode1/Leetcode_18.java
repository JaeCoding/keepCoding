package com.jaecoding.keep.coding.algorithm.leetcode1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * <p>
 * 注意：
 * <p>
 * 答案中不可以包含重复的四元组。
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * <p>
 * 满足要求的四元组集合为：
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 */
public class Leetcode_18 {
    public static void main(String[] args) {
        Leetcode_18 a = new Leetcode_18();
        int[] nums = new int[]{1, -2, -5, -4, -3, 3, 3, 5};
        int[] nums2 = new int[]{1, 0, -1, 0, -2, 2};
        a.fourSum(nums2, 0);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 4 + 1; i++) {
            int num1 = nums[i];
            //剪枝,极端情况是最小连续四个相同 都达不到target  +1是避免分数，放宽一点要求。比如target=10，至少要达到2.5 放宽到10/4+1=3
            if (num1 > target / 4 + 1) break;
            if (i > 0 && num1 == nums[i - 1]) continue;//防止第一个数重复
            int targetThree = target - num1;
            for (int j = i + 1; j < nums.length - 3 + 1; j++) {
                int num2 = nums[j];
                if (num2 > targetThree / 3 + 1) break;//剪枝,极端情况是最小连续三个相同 都达不到targetThree
                if (j > i + 1 && num2 == nums[j - 1]) continue;//防止第二个数重复
                int targetTwo = targetThree - num2;
                for (int k = j + 1, l = nums.length - 1; k < l; ) {
                    if (nums[k] + nums[l] > targetTwo || (l < nums.length - 1 && nums[l] == nums[l + 1])) {//重复三
                        l--;
                    } else if (nums[k] + nums[l] < targetTwo || (k > j + 1 && nums[k] == nums[k - 1])) {//重复三
                        k++;
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(num1);
                        list.add(num2);
                        list.add(nums[k++]);
                        list.add(nums[l--]);
                        result.add(list);
//                        k++;
//                        l--;
                    }
                }
            }
        }
        return result;
    }
}

