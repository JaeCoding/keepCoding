package com.jaecoding.keep.coding.algorithm.leetcode.leetcode.editor.en;
//Given inorder and postorder traversal of a tree, construct the binary tree.
//
// Note: 
//You may assume that duplicates do not exist in the tree. 
//
// For example, given 
//
// 
//inorder = [9,3,15,20,7]
//postorder = [9,15,7,20,3] 
//
// Return the following binary tree: 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
// Related Topics Array Tree Depth-first Search


//leetcode submit region begin(Prohibit modification and deletion)

import com.jaecoding.keep.coding.algorithm.leetcode.leetcode.editor.en.helper.TreeNode;

import java.util.HashMap;
import java.util.Map;

import static com.jaecoding.keep.coding.algorithm.leetcode.leetcode.editor.en.helper.TreeNodeUtils.printTree;

/**
 * postOrder
 */
class Solution_106 {

    int postIndex = 0;
    Map<Integer, Integer> inOrderIndexMap = new HashMap<>();
    int[] in;
    int[] post;

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        in = inorder;
        post = postorder;
        postIndex = postorder.length - 1;
        for (int i = 0; i < postorder.length; i++) {
            inOrderIndexMap.put(in[i], i);
        }

        return recursive(0, postorder.length);
    }

    private TreeNode recursive(int inLeft, int inRight) {
        // could not divide anymore
        if (inLeft == inRight) {
            return null;
        }

        // in postOrder, lastOne is always be root
        int rootValue = post[postIndex];
        TreeNode root = new TreeNode(rootValue);

        // find the index of root in INORDER
        int index = inOrderIndexMap.get(rootValue);

        // to find next root
        postIndex--;

        // divide InOrder into two part by index
        // root is locate in right, so recur right first
        root.right = recursive(index + 1, inRight);
        root.left = recursive(inLeft, index);

        // return itself to set
        return root;

    }

    public static void main(String[] args) {

        int[] inorder = new int[]{9, 3, 15, 20, 7};
        int[] postOrder = new int[]{9, 15, 7, 20, 3};

        TreeNode treeNode = new Solution_106().buildTree(inorder, postOrder);

        System.out.println(printTree(treeNode));


    }
}
//leetcode submit region end(Prohibit modification and deletion)
