package lc.leetcode.editor.en;//Given a collection of distinct integers, return all possible permutations.
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
        List<Integer> out = new ArrayList<>();

        boolean[] used = new boolean[nums.length];

        backTrack(nums, result, out, used);

        return result;
    }

    private void backTrack(int[] nums, List<List<Integer>> result, List<Integer> out, boolean[] used) {

        if (out.size() == nums.length) {
            result.add(new ArrayList<>(out));
        } else {
            for (int i = 0; i < nums.length; i++) {
                // skip the duplication
                if (!used[i]) {
                    out.add(nums[i]);
                    used[i] = true;
                    backTrack(nums, result, out, used);
                    out.remove(out.size() - 1);
                    used[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        new Solution_46().permute(new int[]{1});
    }
}
//leetcode submit region end(Prohibit modification and deletion)
