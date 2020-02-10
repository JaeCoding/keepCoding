package com.jaecoding.keep.coding.algorithm.leetcode.leetcode.editor.en;
//Given a collection of numbers that might contain duplicates, return all possib
//le unique permutations. 
//
// Example: 
//
// 
//Input: [1,1,2]
//Output:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//]
// 
// Related Topics Backtracking


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> out = new ArrayList<>();
        boolean[] contain = new boolean[nums.length];
        backTrack(nums, result, out, contain);
        return result;

    }

    private void backTrack(int[] nums, List<List<Integer>> result, List<Integer> out, boolean[] contain) {

        if (out.size() == nums.length) {
            result.add(new ArrayList<>(out));
        } else {
            for (int i = 0; i < nums.length; i++) {

                // skip duplication
                // 1. itself  2. same as previous, and previous not add , as [1, 1, 3] when add second 1
                if (contain[i] ||  (i > 0 && nums[i] == nums[i - 1] && !contain[i-1])) {
                    continue;
                }
                out.add(nums[i]);
                contain[i] = true;
                backTrack(nums, result, out, contain);
                out.remove(out.size() - 1);
                contain[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        new Solution_47().permuteUnique(new int[]{1, 1, 3,3});
    }
}
//leetcode submit region end(Prohibit modification and deletion)
