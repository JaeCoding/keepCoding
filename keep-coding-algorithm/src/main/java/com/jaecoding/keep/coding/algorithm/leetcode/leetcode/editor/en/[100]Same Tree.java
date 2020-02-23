package com.jaecoding.keep.coding.algorithm.leetcode.leetcode.editor.en;//Given two binary trees, write a function to check if they are the same or not.
// 
//
// Two binary trees are considered the same if they are structurally identical a
//nd the nodes have the same value. 
//
// Example 1: 
//
// 
//Input:     1         1
//          / \       / \
//         2   3     2   3
//
//        [1,2,3],   [1,2,3]
//
//Output: true
// 
//
// Example 2: 
//
// 
//Input:     1         1
//          /           \
//         2             2
//
//        [1,2],     [1,null,2]
//
//Output: false
// 
//
// Example 3: 
//
// 
//Input:     1         1
//          / \       / \
//         2   1     1   2
//
//        [1,2,1],   [1,1,2]
//
//Output: false
// 
// Related Topics Tree Depth-first Search


//leetcode submit region begin(Prohibit modification and deletion)

import com.jaecoding.keep.coding.algorithm.leetcode.leetcode.editor.en.helper.TreeNode;

import java.util.*;

import static com.jaecoding.keep.coding.algorithm.leetcode.leetcode.editor.en.helper.TreeNodeUtils.getBinaryTree;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution_100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // return the most marginal condition at first
        if (p == null && q == null) {
            return true;
        }

        // next condition
        if (p == null || q == null) {
            return false;
        }

        // and now p, q cant be null
        if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }


    public static void main(String[] args) {
//        List<TreeNode> objects = new ArrayList<>();
//        objects.add(new TreeNode(1, "A", "B", "C"));
//        objects.add(new TreeNode(2, "B", "", ""));
//        objects.add(new TreeNode(3, "C", "", ""));
//        TreeNode root = getBinaryTree(objects);
//
//        List<TreeNode> objects2 = new ArrayList<>();
//        objects.add(new TreeNode(1, "A", "B", "C"));
//        objects.add(new TreeNode(2, "B", "", ""));
//        objects.add(new TreeNode(3, "C", "", ""));
//        TreeNode root2 = getBinaryTree(objects2);
//

        int[][] a = new int[][]{{1, 2}, {1, 2},{3, 3},{1, 5},{1, 5}};
        new Solution_100().maxEvents(a);


    }

    public int maxEvents(int[][] events) {
        Arrays.sort(events, Comparator.comparingInt(o -> o[1]));

        int day = 0;

        Set<Integer> in = new HashSet<>();


        for (int i = 0; i < events.length; i++) {

            int[] work = events[i];

            for (int i1 = work[0]; i1 < work[1]+1; i1++) {
                if (!in.contains(i1)) {
                    in.add(i1);
                    day++;
                    break;
                }
            }
        }
        return day;


    }






}
//leetcode submit region end(Prohibit modification and deletion)
