package lc.leetcode.editor.en;
//Given a collection of numbers that might contain duplicates, return all possible unique permutations.
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
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> out = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backTrack(nums, result, out, used);

        return result;

    }

    private void backTrack(int[] nums, List<List<Integer>> result, List<Integer> out, boolean[] used) {
        if (out.size() == nums.length) {
            result.add(new ArrayList<>(out));
            return;
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!used[i]) {
                    // TIPS Deduplication, key is “!used[i-1]”
                    if (i > 0 && nums[i] == nums[i - 1] && !used[i-1]) {
                        continue;
                    }
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
        new Solution_47().permuteUnique(new int[]{1, 1, 2});
    }
}
//leetcode submit region end(Prohibit modification and deletion)
