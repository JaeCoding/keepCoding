package com.jaecoding.keep.coding.algorithm.leetcode.leetcode.editor.en.helper;

import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * TODO
 *
 * @author pengwenjie3
 * @date 2020/2/11
 * @since 1.8
 */
public class TreeNodeUtils {

    /**
     * @param nodes
     * @return
     */
    public static TreeNode getBinaryTree(List<TreeNode> nodes) {

        Map<String, TreeNode> collect = nodes.stream().collect(Collectors.toMap(TreeNode::getUuid, Function.identity()));

        TreeNode root = nodes.get(0);

        nodes.forEach(node -> {
            TreeNode left = collect.get(node.getLeftUuid());
            if (left != null) {
                node.setLeft(left);
            }
            TreeNode right = collect.get(node.getRightUuid());
            if (right != null) {
                node.setRight(right);
            }
        });

        return root;
    }

    /**
     * 特点：
     * （1） 结果数组，第一个元素一定是根
     * @param s    传入 "" 即可
     */
    public static String preOrder(TreeNode head, String s) {

        if (head != null) {
            s += head.getUuid();
            s = preOrder(head.getLeft(), s);
            s = preOrder(head.getRight(), s);
        }
        return s;
    }

    public static String inOrder(TreeNode head, String s) {
        if (head != null) {
            s = inOrder(head.getLeft(), s);
            s += head.getUuid();
            s = inOrder(head.getRight(), s);
        }
        return s;
    }

    public static String postOrder(TreeNode head, String s) {
        if (head != null) {
            s = postOrder(head.getLeft(), s);
            s = postOrder(head.getRight(), s);
            s += head.getUuid();
        }
        return s;
    }

    /**
     *                A
     *                |
     *        -----------------
     *        |               |
     *        B               E
     *        |               |
     *    ---------       ---------
     *    |       |       |       |
     *            C               F
     *    |       |       |       |
     *  -----   -----   -----   -----
     *  |   |   |   |   |   |   |   |
     *          D               G
     *  |   |   |   |   |   |   |   |
     * --- --- --- --- --- --- --- ---
     * | | | | | | | | | | | | | | | |
     *                         H K
     * @param head
     * @return
     */
    public static String printTree(TreeNode head) {


        int height = getHeight(head);
        int printWidth = getPrintWidth(head);
        // 第一行，字母行的空格数量
        int blockNums = (printWidth - 1) / 2;
        int layer = 1;

        Map<Integer, List<TreeNode>> layerQueueMap = new HashMap<>();
        StringBuilder result = new StringBuilder();

        while (layer <= height) {

            List<TreeNode> layerTreeNodeList = layerQueueMap.computeIfAbsent(layer, innerLayer -> {
                List<TreeNode> headList = new ArrayList<>();
                headList.add(head);
                return headList;
            });
            int layerWidth = (int) (printWidth / Math.pow(2, layer - 1));

            // 当计数达到当前层数的最后一个元素时，不需要添加" ",但是要添加换行符号, 并且此时将进入下一层
            for (int i = 0; i < layerTreeNodeList.size(); i++) {
                TreeNode node = layerTreeNodeList.get(i);
                // add uuid
                String uuid = StringUtils.isEmpty(node.getUuid()) ? " " : node.getUuid();
                IntStream.rangeClosed(1, blockNums).forEach(num -> result.append(" "));
                result.append(uuid);
                IntStream.rangeClosed(1, blockNums).forEach(num -> result.append(" "));
                // 对此层最后一个元素的处理
                result.append(i == layerTreeNodeList.size() - 1 ? "\n" : " ");
            }

            // 最后一层只用加字母
            if (layer != height) {
                for (int i = 0; i < layerTreeNodeList.size(); i++) {
                    // add  |
                    IntStream.rangeClosed(1, blockNums).forEach(num -> result.append(" "));
                    result.append("|");
                    IntStream.rangeClosed(1, blockNums).forEach(num -> result.append(" "));
                    result.append(i == layerTreeNodeList.size() - 1 ? "\n" : " ");
                }

                for (int i = 0; i < layerTreeNodeList.size(); i++) {
                    // add  -
                    int minusNums = blockNums + 2;
                    int minusBlockNums = (layerWidth - minusNums) / 2;
                    IntStream.rangeClosed(1, minusBlockNums).forEach(num -> result.append(" "));
                    IntStream.rangeClosed(1, minusNums).forEach(num -> result.append("-"));
                    IntStream.rangeClosed(1, minusBlockNums).forEach(num -> result.append(" "));
                    result.append(i == layerTreeNodeList.size() - 1 ? "\n" : " ");
                }

                for (int i = 0; i < layerTreeNodeList.size(); i++) {
                    // add |
                    int minusNums = blockNums + 2;
                    int minusBlockNums = (layerWidth - minusNums) / 2;
                    int minusBlockNums2 = minusNums - 2;
                    IntStream.rangeClosed(1, minusBlockNums).forEach(num -> result.append(" "));
                    result.append("|");
                    IntStream.rangeClosed(1, minusBlockNums2).forEach(num -> result.append(" "));
                    result.append("|");
                    IntStream.rangeClosed(1, minusBlockNums).forEach(num -> result.append(" "));
                    result.append(i == layerTreeNodeList.size() - 1 ? "\n" : " ");
                }

                for (TreeNode node : layerTreeNodeList) {
                    List<TreeNode> queue1 = layerQueueMap.computeIfAbsent(layer + 1, innerLayer -> new ArrayList<>());
                    TreeNode left = Optional.ofNullable(node.getLeft()).orElse(new TreeNode());
                    TreeNode right = Optional.ofNullable(node.getRight()).orElse(new TreeNode());
                    queue1.add(left);
                    queue1.add(right);
                }
            }

            // 层数加一， 以及下一层首行空格数量
            layer++;
            blockNums = (blockNums - 1) / 2;
        }

        return result.toString();
    }

    public static int getHeight(TreeNode root) {
        if (root.getLeft() == null && root.getRight() == null) {
            return 1;
        } else if (root.getLeft() == null) {
            return getHeight(root.getRight()) + 1;
        } else if (root.getRight() == null) {
            return getHeight(root.getLeft()) + 1;
        } else {
            return Math.max(getHeight(root.getLeft()), getHeight(root.getRight())) + 1;
        }
    }

    public static int getPrintHeight(TreeNode root) {
        int height = getHeight(root);
        return 4 * height - 3;
    }

    // 获取节点最多那一层的节点数量
    public static int getWidth(TreeNode root) {
        return 1;
    }

    /**
     * 用于打印二叉树，只与高度有关
     *
     * @param root
     * @return
     */
    public static int getPrintWidth(TreeNode root) {
        int height = getHeight(root);
        int width = 1;
        for (int i = 1; i < height; i++) {
            width = 2 * width + 1;
        }
        return width;
    }


    public static void main(String[] args) {
        List<TreeNode> objects = new ArrayList<>();
        objects.add(new TreeNode(1, "A", "B", "E"));
        objects.add(new TreeNode(2, "B", "", "C"));
        objects.add(new TreeNode(3, "C", "D", ""));
        objects.add(new TreeNode(4, "D", "", ""));
        objects.add(new TreeNode(5, "E", "", "F"));
        objects.add(new TreeNode(6, "F", "G", ""));
        objects.add(new TreeNode(7, "G", "H", "K"));
        objects.add(new TreeNode(8, "H", "", ""));
        objects.add(new TreeNode(9, "K", "", ""));


//        objects.add(new TreeNode(1, "A", "B", ""));
//        objects.add(new TreeNode(2, "B", "C", ""));
//        objects.add(new TreeNode(3, "C", "", ""));

        TreeNode root = getBinaryTree(objects);

        System.out.println(printTree(root));

    }
}
