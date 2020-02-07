//leetcode submit region end(Prohibit modification and deletion)
package com.jaecoding.keep.coding.algorithfasdasd.leetcode.leetcode.editor.en;
//Given a collection of candidate numbers (candidates) and a target number (target),
// find all unique combinations in candidates where the candidate numbers sums to target.
//
// Each number in candidates may only be used once in the combination. 
//
// Note: 
//
// 
// All numbers (including target) will be positive integers. 
// The solution set must not contain duplicate combinations. 
// 
//
// Example 1: 
//
// 
//Input: candidates = [10,1,2,7,6,1,5], target = 8,
//A solution set is:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
// 
//
// Example 2: 
//
// 
//Input: candidates = [2,5,2,1,2], target = 5,
//A solution set is:
//[
//  [1,2,2],
//  [5]
//]
//
// lc39: arrays without duplicates, and can be repeat select
// lc40: repeatable within array, but result can't be repeat

// Related Topics Array Backtracking


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_40 {
    public static void main(String[] args) {
        new Solution_40().combinationSum2(new int[]{1, 1, 2, 5, 6, 7, 10}, 8);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        // one for result , one for store
        List<List<Integer>> result = new ArrayList<>();
        if (candidates.length == 0) {
            return result;
        }
        List<Integer> out = new ArrayList<>();
        recursive(candidates, result, out, target, 0);
        return result;

    }

    private void recursive(int[] candidates, List<List<Integer>> result, List<Integer> out, int target, int position) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            result.add(new ArrayList<>(out));
            return;
        } else {
            for (int i = position; i < candidates.length; i++) {
                // tips when candidates[i] == candidates[i - 1], skip the step
                if (i > position && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                out.add(candidates[i]);
                // tips nums can't be use repeated, so put the i + 1 as position instead of i
                recursive(candidates, result, out, target - candidates[i], i + 1);
                out.remove(out.size() - 1);
            }
        }
    }
}

class Solution_40_2 {
    public static void main(String[] args) {
        new Solution_40_2().combinationSum2(new int[]{1, 1, 2, 5, 6, 7, 10}, 8);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        // one for result , one for store
        List<List<Integer>> result = new ArrayList<>();
        if (candidates.length == 0) {
            return result;
        }
        List<Integer> out = new ArrayList<>();
        recursive(candidates, result, out, target, 0);
        return result;

    }

    private int recursive(int[] candidates, List<List<Integer>> result, List<Integer> out, int target, int position) {
        // stop condition
        if (target == 0) {
            result.add(new ArrayList<>(out));
            return 0;
        } else if (target < 0) {
            return -1;
        } else {

            for (int i = position; i < candidates.length; i++) {
                // prevent duplication
                if (i > position && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                out.add(candidates[i]);
                int flag = recursive(candidates, result, out, target - candidates[i], i + 1);
                out.remove(out.size() - 1);
                if (flag <= 0) {
                    break;
                }
            }
            return 1;
        }
    }

}
