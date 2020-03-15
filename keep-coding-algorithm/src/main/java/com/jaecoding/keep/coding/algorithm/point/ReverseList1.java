package com.jaecoding.keep.coding.algorithm.point;

public class ReverseList1 {

    static class Node {
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node(1, null);
        Node n2 = new Node(2, null);
        Node n3 = new Node(3, null);
        Node n4 = new Node(4, null);
        Node head = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        while (head != null) {
            System.out.print("\t" + head.value);
            head = head.next;
        }
        System.out.println("");
        Node ne1 = reverseList(n1);
        System.out.println(ne1.value);
        while (ne1 != null) {
            System.out.print("\t" + ne1.value);
            ne1 = ne1.next;
        }

    }

    public static Node reverseList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node pre = head;
        Node cur = head.next;
        Node temp = cur.next;
        while (cur != null) {
            temp = cur.next; //保存后一节点
            cur.next = pre; //改变当前节点next，指向他的父节点
            pre = cur;
            cur = temp;
        }
        head.next = null;
        return cur;
    }

}
