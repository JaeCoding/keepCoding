package com.jaecoding.keep.coding.algorithm.leetcode1;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * <p>
 * 说明：给定的 n 保证是有效的。
 * 进阶：
 * 你能尝试使用一趟扫描实现吗？
 */
public class Leetcode_19 {

    /**
     * 删除 链表的倒数第n个节点
     * 思路：用快慢指针  找到倒数n+1个节点  删除之后的那个
     * 坑： 若要删除的是第一个节点，是无法找到第n+1的节点的（因为fast.next为空了，fast.next.next会报空指针）。
     * 解决：在移动快指针前加了一个判断，  （当前快指针为空，且后面还有一次循环，表明为删除头结点）
     * <p>
     * 坑2：注意单节点的情况
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < n + 1; i++) {
            if (fast == null && i == n) {
                head = head.next;
                return head;
            }
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        ListNode del = slow.next;
        slow.next = slow.next.next;
        del = null;
        return head;
    }

    /**
     * 思路2 更简单明了
     * <p>
     * 我们知道 找到倒数第n个 是走n步后  判断fast是否为空
     * 推广：  找到倒数第n + 1个 ，是走n步后  判断fast.next是否为空 。相当于提前了
     * <p>
     * 首先让指针fast指向头节点，然后让其向后移动n步，
     * 接着让指针slow指向头结点，并和first一起向后移动。
     * 当first的next指针(这里高明的是判断next而不是first）为NULL时，sec即指向了要删除节点的前一个节点，接着让first指向的next指针指向要删除节点的下一个节点即可。
     * <p>
     * 注意如果要删除的节点是首节点，那么first向后移动结束时会为NULL，这样加一个判断其是否为NULL的条件，若为NULL则返回头结点的next指针。
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        if (head.next == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
            if (fast == null) {
                return head = head.next;
            }
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        ListNode del = slow.next;
        slow.next = slow.next.next;
        del = null;
        return head;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        l1.next = l2;
        removeNthFromEnd(l1, 2);
    }
}

