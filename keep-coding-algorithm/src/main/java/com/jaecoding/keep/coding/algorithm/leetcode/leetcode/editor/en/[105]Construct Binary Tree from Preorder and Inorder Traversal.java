package com.jaecoding.keep.coding.algorithm.leetcode.leetcode.editor.en;
//Given preorder and inorder traversal of a tree, construct the binary tree.
//
// Note: 
//You may assume that duplicates do not exist in the tree. 
//
// For example, given 
//
// 
//preorder = [3,9,20,15,7]
//inorder = [9,3,15,20,7] 
//
// Return the following binary tree: 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics Array Tree Depth-first Search


//leetcode submit region begin(Prohibit modification and deletion)

import com.jaecoding.keep.coding.algorithm.leetcode.leetcode.editor.en.helper.TreeNode;
import com.jaecoding.keep.coding.algorithm.leetcode.leetcode.editor.en.helper.TreeNodeUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.jaecoding.keep.coding.algorithm.leetcode.leetcode.editor.en.helper.TreeNodeUtils.getBinaryTree;

/**
 * preOrder: feature：
 *         first is root
 *
 * inOrder: divide by father， left belongs to leftTree, same as right
 */
class Solution_105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return null;
    }
}

class Solution_Official {
    // start from first preorder element
    int pre_idx = 0;
    int[] preorder;
    int[] inorder;
    HashMap<Integer, Integer> idx_map = new HashMap<Integer, Integer>();

    public TreeNode helper(int in_left, int in_right) {
        // if there is no elements to construct subtrees
        if (in_left == in_right)
            return null;

        // pick up pre_idx element as a root
        int root_val = preorder[pre_idx];
        TreeNode root = new TreeNode(root_val);

        // root splits inorder list
        // into left and right subtrees
        int index = idx_map.get(root_val);

        // recursion
        pre_idx++;
        // build left subtree
        root.left = helper(in_left, index);
        // build right subtree
        root.right = helper(index + 1, in_right);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;

        // build a hashmap value -> its index
        int idx = 0;
        for (Integer val : inorder)
            idx_map.put(val, idx++);
        return helper(0, inorder.length);
    }

    public static void main(String[] args) {

        int[] pre = new int[]{3, 9, 20, 15, 7};
        int[] in = new int[]{9, 3, 15, 20, 7};

        TreeNode treeNode = new Solution_Official().buildTree(pre, in);

        String s = TreeNodeUtils.printTree(treeNode);
        System.out.println(s);


    }
}

//leetcode submit region end(Prohibit modification and deletion)
