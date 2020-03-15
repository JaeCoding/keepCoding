package com.jaecoding.keep.coding.algorithm.leetcode.leetcode.editor.en;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * TODO
 *
 * @author pengwenjie3
 * @date 2020/2/23
 * @since 1.8
 */
class Solution_5170 {

    /**
     * 判断是否是合法的二叉树
     * @param n          数量
     * @param leftChild  i位置的左子节点
     * @param rightChild i位置的右子节点
     * @return
     */
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {

        int[] fathers = new int[n];
        Arrays.fill(fathers, -1);

        for (int i = 0; i < leftChild.length; i++) {

            int l = leftChild[i];
            if (l >= 0) {
                // one node can't be change twice, cause it mean the node has two father
                if (fathers[l] > -1) return false;
                fathers[l] = i;
            }

            int r = rightChild[i];
            if (r >= 0){
                // same
                if (fathers[r] > -1) return false;
                fathers[r] = i;
            }
        }

        // code block for cycle find the root father, useless code in here

//        for (int i = 0; i < fathers.length; i++) {
//            // father not be itself, unless cause cycle
//            while (fathers[i] >= 0 && fathers[i] != fathers[fathers[i]]) {
//                int father = fathers[fathers[i]];
//                if (father < 0) {
//                    break;
//                }
//                fathers[i] = father;
//            }
//        }

        int count = 0;
        for (int father : fathers) {
            count = father == -1 ? count + 1 : count;
        }
        return count == 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_5170().validateBinaryTreeNodes(4, new int[]{1,-1,3,-1}, new int[]{2,-1,-1,-1}));
        // condition of  1<->2
        System.out.println(new Solution_5170().validateBinaryTreeNodes(2, new int[]{1,0}, new int[]{-1,-1}));
        System.out.println(new Solution_5170().validateBinaryTreeNodes(6, new int[]{1,-1,-1,4,-1,-1}, new int[]{2,-1,-1,5,-1,-1}));
        System.out.println(new Solution_5170().validateBinaryTreeNodes(4, new int[]{1,-1,3,-1}, new int[]{2,3,-1,-1}));
    }
}
