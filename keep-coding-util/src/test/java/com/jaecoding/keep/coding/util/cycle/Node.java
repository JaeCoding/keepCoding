package com.jaecoding.keep.coding.util.cycle;

/**
 * Node
 *
 * @author pengwenjie3
 * @date 2020/9/15
 * @since 1.8
 */
public class Node {
    private Node parent;
    private Node son;
    private String val;

    public Node(String val) {
        this.val = val;
    }

    public void setParentAndSon(Node parent, Node son) {
        this.parent = parent;
        this.son = son;
    }

    public Node getParent() {
        return this.parent;
    }

    public Node getSon() {
        return this.son;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public void setSon(Node son) {
        this.son = son;
    }
}
