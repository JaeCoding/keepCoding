package com.jaecoding.keep.coding.algorithm.dataStructure.trees;

/**
 * @author: 彭文杰
 * @create: 2018-09-16 18:36
 **/
public class HeadAndMid2Back {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            this.val = x;
        }
    }

    public class CreateTree {
        public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
            TreeNode root = createTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
            return root;
        }


        private TreeNode createTree(int[] pre, int startpre, int endpre, int[] in, int startin, int endin) {
            if (startpre > endpre || startin > endin) {
                return null;
            }
            TreeNode root = new TreeNode(pre[startpre]);//树的根
            for (int i = startin; i <= endin; i++) {
                if (pre[startpre] == in[i]) {
                    root.left = createTree(pre, startpre + 1, startpre + i, in, startin, i - 1);//去除掉已经确定的根节点
                    root.right = createTree(pre, i - startin + startpre + 1, endpre, in, i + 1, endin);
//说明：i-startin 是i这个元素的左子树   解释来自  深水的鱼
                }
            }
            return root;
        }
    }
}
