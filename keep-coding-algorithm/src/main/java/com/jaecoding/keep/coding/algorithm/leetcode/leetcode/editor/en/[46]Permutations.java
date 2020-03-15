package com.jaecoding.keep.coding.algorithm.leetcode.leetcode.editor.en;
//Given a collection of distinct integers, return all possible permutations.
//
// Example: 
//
// 
//Input: [1,2,3]
//Output:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]
// 
// Related Topics Backtracking


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_46 {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
//        Set<Integer> out = new HashSet<>();
        Stack<Integer> out = new Stack<>();

        backTrack(nums, result, out, 0);

        return result;
    }

    private void backTrack(int[] nums, List<List<Integer>> result, Stack<Integer> out, int cur) {

        if (out.size() == nums.length) {
            result.add(new ArrayList<>(out));
        } else {
            for (int i = 0; i < nums.length; i++) {
                // skip the duplication
                if (!out.contains(nums[i])) {
                    out.push(nums[i]);
                    backTrack(nums, result, out, 0);
                    out.pop();
                }
            }
        }
    }

    public static void main(String[] args) {
        new Solution_46().permute(new int[]{1, 2, 3});
    }
}

class Solution_46_2 {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        // use List instead of set, cause element in set is random, and remove will influence result
        Set<Integer> out = new HashSet<>();

        backTrack(nums, result, out);

        return result;
    }

    private void backTrack(int[] nums, List<List<Integer>> result, Set<Integer> out) {
        if (out.size() == nums.length) {
            result.add(new ArrayList<>(out));
        } else {
            for (int num : nums) {

                if (!out.contains(num)) {
                    out.add(num);
                    backTrack(nums, result, out);
                    out.remove(num);
                }

            }
        }

    }

    public static void main(String[] args) {
        new Solution_46().permute(new int[]{1, 2, 3});
    }
}
//leetcode submit region end(Prohibit modification and deletion)
