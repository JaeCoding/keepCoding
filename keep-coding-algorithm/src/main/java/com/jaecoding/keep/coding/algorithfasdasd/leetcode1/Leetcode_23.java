package com.jaecoding.keep.coding.algorithfasdasd.leetcode1;


import java.util.*;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */
public class Leetcode_23 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x, ListNode next) {
            val = x;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode l13 = new ListNode(5, null);
        ListNode l12 = new ListNode(4, l13);
        ListNode l11 = new ListNode(1, l12);

        ListNode l23 = new ListNode(11, null);
        ListNode l22 = new ListNode(5, l23);
        ListNode l21 = new ListNode(-1, l22);

        ListNode l32 = new ListNode(10, null);
        ListNode l31 = new ListNode(6, l32);

        ListNode[] lists = new ListNode[4];
        lists[0] = null;
        lists[1] = l21;
        lists[2] = null;
        lists[2] = l31;

        ListNode node = mergeKLists3(lists);
        System.out.println(node.val);
        while (node.next != null) {
            System.out.println(node.next.val);
            node = node.next;
        }
    }


    /**
     * 此方法 思想是 每轮遍历一次 找到当前数组中 最小的连接连接上  然后向后移动
     * <p>
     * 坑主要是 每次使用node.next前，都要判断node是不是null，否则容易空指针
     * 同样 使用了一个 前置哨兵  使用 最小值 最小节点 和最小节点index来辅助移动
     *
     * @return
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0 || (lists.length == 1 && lists[0] == null)) return null;
        int count = lists.length;
        ListNode dummy = new ListNode(-100, null), cur = dummy;
        while (count > 0) {
            ListNode minNode = null;
            int minValue = Integer.MAX_VALUE;
            int index = 0;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null && lists[i].val < minValue) {
                    minNode = lists[i];
                    minValue = lists[i].val;
                    index = i;
                }
            }
            if (cur != null) {
                cur.next = minNode;
                cur = cur.next;
            }
            lists[index] = lists[index] == null ? null : lists[index].next;
            if (lists[index] == null) count--;
        }
        return dummy.next;
    }

    /**
     * 解法二; 分治 多路并归  转化为二分 两个数组的合并
     */
    public static ListNode mergeKLists2(ListNode[] lists) {
        int listLen = lists.length;
        if (listLen == 0 || lists == null) return null;
        if (listLen == 1) return lists[0];
        if (listLen == 2) return mergeTwoLists(lists[0], lists[1]);
        boolean odd = listLen % 2 != 0;
        int resultLen = odd ? listLen / 2 + 1 : listLen / 2;
        ListNode[] result = new ListNode[resultLen];
        for (int i = 0, j = 0; i + 1 < listLen; i += 2) {
            ListNode newNode = mergeTwoLists(lists[i], lists[i + 1]);
            result[j++] = newNode;
        }
        if (odd) {
            result[resultLen - 1] = lists[listLen - 1];
        }
        return mergeKLists2(result);
    }


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode dummy = new ListNode(-1, null), cur = dummy;//用一个哨兵，前置节点
        while (l1 != null && l2 != null) {
            //让cur.next为l1，l2中的小者
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            //移动cur
            cur = cur.next;
        }
        //在有一个为空的时候停下 这时候需要把 停下位置 和 另一条 多余部分部分 给接上
        cur.next = l2 == null ? l1 : l2;
        return dummy.next;
    }

    /**
     * 解法三  优先队列
     * 优先队列 能删除并 返回 队列中的最大元素
     */
    public static ListNode mergeKLists3(ListNode[] lists) {
        Queue<ListNode> heap = new PriorityQueue<>(Comparator.comparingInt(l -> l.val));
        ListNode dummy = new ListNode(-1000, null), tail = dummy;
        Arrays.stream(lists).forEach(node -> {
            if (node != null) heap.offer(node);
        });
        while (!heap.isEmpty()) {
            tail.next = heap.poll();
            tail = tail.next;
            if (tail.next != null) heap.offer(tail.next);
        }
        return dummy.next;
    }
}

