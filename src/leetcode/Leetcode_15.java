package leetcode;

import java.util.*;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。

 注意：答案中不可以包含重复的三元组。

 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，

 满足要求的三元组集合为：
 [
 [-1, 0, 1],
 [-1, -1, 2]
 ]
 */
public class Leetcode_15 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};

    }

    /**
     * 排序后  [-1, 0, 1, 2, -1, -4]  变为 -4 -1 -1 0 1 2
     * 指定一个值num，双指针两端开始。
     * 注意避开重复的情况。一是num的重复  二是指针扫描的重复
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num > 0) break;
            if (i > 0 && num == nums[i-1]) continue;//重复一
            int target = -num;
            for (int j = i+1, k = nums.length-1 ; j < k;) {
                if (nums[j] + nums[k] > target || (k < nums.length-1 && nums[k] == nums[k+1])) {//重复二
                    k--;
                } else if (nums[j] + nums[k] < target || (j > i+1 && nums[j] == nums[j-1])) {//重复二
                    j++;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(num);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    result.add(list);
                    j++;
                    k--;
                }
            }
        }
        return result;
    }
}

