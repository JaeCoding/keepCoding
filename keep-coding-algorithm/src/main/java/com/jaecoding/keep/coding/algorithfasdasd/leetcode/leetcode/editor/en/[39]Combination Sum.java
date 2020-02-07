package com.jaecoding.keep.coding.algorithfasdasd.leetcode.leetcode.editor.en;
// Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
// find all unique combinations in candidates where the candidate numbers sums to target.
//
// The same repeated number may be chosen from candidates unlimited number of times. 
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
//Input: candidates = [2,3,6,7], target = 7,
//A solution set is:
//[
//  [7],
//  [2,2,3]
//]
// 
//
// Example 2: 
//
// 
//Input: candidates = [2,3,5], target = 8,
//A solution set is:
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//]
//
// Related Topics Array Backtracking
// lc39: arrays without duplicates, and can be repeat select
// lc40: repeatable within array, but result can't be repeat
// tips
//  1) backTracing : one list for add and remove nums,
//     target :  less than 0 => return; equals 0 => add duplication; more than 0 => recursive
//  2) recursive : save current position,

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_39 {

    public static void main(String[] args) {
        new Solution_39().combinationSum(new int[]{2, 3, 5}, 8);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            // TIPS need to add the duplication instead of reference
            result.add(new ArrayList<>(out));
        } else {
            for (int i = position; i < candidates.length; i++) {
                out.add(candidates[i]);
                recursive(candidates, result, out, target - candidates[i], i);
                out.remove(out.size() - 1);
            }
        }
    }

}

class Solution_39_2 {

    public static void main(String[] args) {
        new Solution_39_2().combinationSum(new int[]{2, 3, 5}, 8);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        // one for result , one for store
        List<List<Integer>> result = new ArrayList<>();
        if (candidates.length == 0) {
            return result;
        }
        List<Integer> out = new ArrayList<>();
        recursive(candidates, 0, target, result, out);
        return result;

    }

    private int recursive(int[] candidates, int position, int target, List<List<Integer>> result, List<Integer> out) {
        // stop condition
        if (0 == target) {
            result.add(new ArrayList<>(out));
            return 0;
        } else if (target < 0) {
            return -1;
        } else {
            for (int i = position; i < candidates.length; i++) {
                out.add(candidates[i]);
                int cutFlag = recursive(candidates, i, target - candidates[i], result, out);
                out.remove(out.size() - 1);
                // Pruning:
                if (cutFlag <= 0) {
                    break;
                }
            }
        }
        return 1;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
