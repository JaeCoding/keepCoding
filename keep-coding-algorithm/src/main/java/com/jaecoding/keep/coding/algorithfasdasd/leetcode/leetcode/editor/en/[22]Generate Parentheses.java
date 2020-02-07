package com.jaecoding.keep.coding.algorithfasdasd.leetcode.leetcode.editor.en;
//
//Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
// 
//
// 
//For example, given n = 3, a solution set is:
// 
// 
//[
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"
//]
// Related Topics String Backtracking


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_22 {
    public static void main(String[] args) {
        new Solution_22().generateParenthesis(1);

    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        recursive(result, "", n, 0, 0);
        return result;
    }

    private void recursive(List<String> result, String str, int n, int left, int right) {
        // dfs , add "(" to str first if left < n, then add ")" if right < left second
        if (str.length() == 2 * n) {
            result.add(str);
            return;
        }

        if (left < n) {
            recursive(result, str + "(", n, left + 1, right);
        }
        // tips : notice that use two if instead of if-else, cause its need add ")" when recursive return
        if (left > right) {
            recursive(result, str + ")", n, left, right + 1);
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
