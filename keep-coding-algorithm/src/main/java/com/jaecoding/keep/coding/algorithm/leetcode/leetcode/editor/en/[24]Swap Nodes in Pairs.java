package com.jaecoding.keep.coding.algorithm.leetcode.leetcode.editor.en;//Given a linked list, swap every two adjacent nodes and return its head.
//
// You may not modify the values in the list's nodes, only nodes itself may be c
//hanged. 
//
// 
//
// Example: 
//
// 
//Given 1->2->3->4, you should return the list as 2->1->4->3.
// 
// Related Topics Linked List




//leetcode submit region begin(Prohibit modification and deletion)

import com.jaecoding.keep.coding.algorithm.leetcode.leetcode.editor.en.helper.ListNode;

import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution_24 {
    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        dummy.next = head;

        while (pre.next != null && pre.next.next != null) {
            ListNode back = pre.next.next;
            // change point
            pre.next.next = back.next;
            back.next = pre.next;
            pre.next = back;
            // change quote
            pre = back.next;
        }
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
