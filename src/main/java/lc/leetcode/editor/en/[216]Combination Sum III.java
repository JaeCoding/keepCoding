package lc.leetcode.editor.en;
//
// Find all possible combinations of k numbers that add up to a number n,
// given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
//
// Note: 
//
// 
// All numbers will be positive integers. 
// The solution set must not contain duplicate combinations. 
// 
//
// Example 1: 
//
// 
//Input: k = 3, n = 7
//Output: [[1,2,4]]
// 
//
// Example 2: 
//
// 
//Input: k = 3, n = 9
//Output: [[1,2,6], [1,3,5], [2,3,4]]
// 
// Related Topics Array Backtracking


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_216 {

    public static void main(String[] args) {
        new Solution_216().combinationSum3(4, 10);
    }
    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> out = new ArrayList<>();

        recursive(result, out, 1, k, n);

        return result;
    }

    private void recursive(List<List<Integer>> result, List<Integer> out, int cur, int len, int target) {

        if (target < 0 || (target > 0 && out.size() == len)) {
            return;
        } else if (target == 0) {
            if (out.size() == len) {
                result.add(new ArrayList<>(out));
            }
            return;
        } else {
            for (int i = cur; i <= 9 || i <= target; i++) {
                // cause the num is limited from 1 to 9
                out.add(i);
                recursive(result, out, i + 1, len, target - i);
                out.remove(out.size() - 1);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
