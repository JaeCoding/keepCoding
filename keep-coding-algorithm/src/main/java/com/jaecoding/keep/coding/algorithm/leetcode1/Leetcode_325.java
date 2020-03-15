package com.jaecoding.keep.coding.algorithm.leetcode1;

import java.util.HashMap;


/**
 * 给定数组数和目标值k，找到求 和为k的子数组的最大长度 。如果没有，则返回0。
 * <p>
 * Example 1:
 * Given nums = [1, -1, 5, -2, 3], k = 3,
 * return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)
 * <p>
 * Example 2:
 * Given nums = [-2, -1, 2, 1], k = 1,
 * return 2. (because the subarray [-1, 2] sums to 1 and is the longest)
 * <p>
 * Follow Up:
 * Can you do it in O(n) time?
 */
public class Leetcode_325 {

    public static void main(String[] args) {
        int[] nums = {1, -1, 5, -2, 3};
        int k = 3;
        int st = maxSubArrayLen(nums, k);
        System.out.println(st);
    }

    /**
     * 先求出每个位置的从index = 0加到此位置的和，这时（和i - 和j） 就是j~i之间的subarray的和，
     * 那我们有了最大当前sum，找sum-k就好了呀
     * 意思是 我们能沿路保存下来 每个i的前缀和，  两个前缀和 的差，若等于k，就说明这两个前缀之间的序列满足
     * <p>
     * 这样我们一路下来，更新保存最长的 序列，返回长度就行。
     * <p>
     * 因此，我们用hashmap的方法来检测sum2 = sum1 - taget 中的sum2是否存在 在map中，
     * 当遍历到sum1的时候，思路类似于two sum的hashmap方法。
     */
    public static int maxSubArrayLen(int[] nums, int k) {
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>(); //key:prefix和; value:到第几个数
        int max = 0;
        map.put(0, 0);
        for (int i = 1; i < nums.length + 1; i++) {
            sum += nums[i - 1];
            int lookingfor = sum - k;
            if (map.containsKey(lookingfor)) {
                max = Math.max(max, i - map.get(lookingfor));//当前位置 减 对应lookingfor的最新（右）的位置
            }
            if (!map.containsKey(sum))
                map.put(sum, i);//key是sum，value是index，若sum相同需要更新value，是为了确定i的位置
        }
        return max;
    }


}
