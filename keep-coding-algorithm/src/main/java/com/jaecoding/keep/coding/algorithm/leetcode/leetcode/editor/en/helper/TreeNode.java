package com.jaecoding.keep.coding.algorithm.leetcode.leetcode.editor.en.helper;

import lombok.Data;

import java.util.stream.IntStream;

/**
 * 二叉树节点
 *
 * @author pengwenjie3
 * @date 2020/2/11
 * @since 1.8
 */
@Data
public class TreeNode {
    private String uuid;
    private int val;
    private TreeNode left;
    private TreeNode right;
    private String leftUuid;
    private String rightUuid;

    TreeNode(int x, String uuid) {
        this.uuid = uuid;
        this.val = x;
    }

    TreeNode(int x, String uuid, String leftUuid, String rightUuid) {
        this.uuid = uuid;
        this.val = x;
        this.leftUuid = leftUuid;
        this.rightUuid = rightUuid;
    }

    /**
     * @param x
     * @param uuid
     * @param s "A-B-C" 表示
     */
    TreeNode(int x, String uuid, String s) {
        this.uuid = uuid;
        this.val = x;
        this.leftUuid = leftUuid;
        this.rightUuid = rightUuid;
    }

    TreeNode() {

    }

    public static void main(String[] args) {
        IntStream.rangeClosed(1, 1).forEach(System.out::println);
    }
}
