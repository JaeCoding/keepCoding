package com.jaecoding.keep.coding.algorithfasdasd.dataStructure.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 * <p>
 * <p>
 * 判断一颗二叉树  是不是搜索树   即严格满足 左< 中 < 右
 */
class ValidateBinarySearchTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }

    /**
     * 错误的解法
     * 坑： 父节点要大于 此节点的 左子节点。 所以不能用单纯的递归
     *
     * @param root
     * @return
     */
    public boolean isValidBST_WRONG(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) {
            return true;
        } else if (root.left == null) {
            if (root.val < root.right.val) {
                return isValidBST(root.right);
            } else return false;
        } else if (root.right == null) {
            if (root.val > root.left.val) {
                return isValidBST(root.left);
            } else return false;
        } else {
            if (root.val > root.left.val && root.val < root.right.val) {
                return isValidBST(root.left) && isValidBST(root.right);
            } else return false;
        }
    }


    /**
     * 采用了 保存上一次值的方式 用pre保留
     * 也是 深度搜索 的一种
     * 也是 中序遍历 的一种
     */
    private TreeNode pre;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean f = isValidBST(root.left);//一直向左 判断到底
        boolean f2 = pre == null || pre.val < root.val;  //判断 上一次保存的值 < 当前值
        pre = root;// 更新保存值 为当前值
        return f && f2 && isValidBST(root.right); //需要同时满足 三个条件 才返回T

    }


    /**
     * 根据性质 ： 二叉搜索树 的 中序遍历 是递增地
     * 缺点：速度较慢
     *
     * @param root
     * @return
     */
    public boolean isValidBST2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        LDR(root, list);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    private void LDR(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        LDR(root.left, list);//一路走到最左边 直到走到头
        list.add(root.val);
        LDR(root.right, list);
    }


}
