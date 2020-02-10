package com.jaecoding.keep.coding.algorithm.dataStructure.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Definition for a binary tree node.
 * <p>
 * 恢复 二叉搜索树 在不改变其结构的情况下  恢复成搜索树
 * 输入: [1,3,null,null,2]
 * <p>
 * 1
 * /
 * 3
 * \
 * 2
 * <p>
 * 输出: [3,1,null,null,2]
 * <p>
 * 3
 * /
 * 1
 * \
 * 2
 * <p>
 * 使用 O(n) 空间复杂度的解法很容易实现。
 * 你能想出一个只使用常数空间的解决方案吗？
 */
class RecoverBinarySearchTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(4);
        TreeNode t3 = new TreeNode(2);
        root.left = t1;
        root.right = t2;
        t2.left = t3;
        recoverTree(root);
        System.out.println(root.right.left.val + "");
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }

    }


    /**
     * 暴力方法  将数 存起来
     * 也是 深度搜索 的一种
     * 也是 中序遍历 的一种
     * <p>
     * 使用了O(n)空间的方法
     * 注意 leetcode里要重置全局变量，不然会越界
     */
    static int n = 0;

    public static void recoverTree(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        LDRaddToList(root, list);
        Object[] arr = list.toArray();
        Arrays.sort(arr);//排序后 重新安放到 二叉数里
        LDRToTree(root, arr);
        n = 0;//重置
    }

    private static void LDRaddToList(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        LDRaddToList(root.left, list);//一路走到最左边 直到走到头
        list.add(root.val);
        LDRaddToList(root.right, list);
    }

    private static void LDRToTree(TreeNode root, Object[] arr) {
        if (root == null) {
            return;
        }
        LDRToTree(root.left, arr);//一路走到最左边 直到走到头
        if (n < arr.length) {
            root.val = (int) arr[n++];
        }
        LDRToTree(root.right, arr);
    }
}
