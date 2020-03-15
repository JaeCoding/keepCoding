package com.jaecoding.keep.coding.algorithm.leetcode.leetcode.editor.en;
//Given a linked list, rotate the list to the right by k places, where k is non-
//negative. 
//
// Example 1: 
//
// 
//Input: 1->2->3->4->5->NULL, k = 2
//Output: 4->5->1->2->3->NULL
//Explanation:
//rotate 1 steps to the right: 5->1->2->3->4->NULL
//rotate 2 steps to the right: 4->5->1->2->3->NULL
// 
//
// Example 2: 
//
// 
//Input: 0->1->2->NULL, k = 4
//Output: 2->0->1->NULL
//Explanation:
//rotate 1 steps to the right: 2->0->1->NULL
//rotate 2 steps to the right: 1->2->0->NULL
//rotate 3 steps to the right: 0->1->2->NULL
//rotate 4 steps to the right: 2->0->1->NULL 
// Related Topics Linked List Two Pointers




//leetcode submit region begin(Prohibit modification and deletion)

import com.jaecoding.keep.coding.algorithm.leetcode.leetcode.editor.en.helper.ListNode;
import com.jaecoding.keep.coding.algorithm.leetcode.leetcode.editor.en.helper.ListNodeUtils;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 *
 * NOTE:
 *   0) find len (and endNode by the way)
 *   1) remainder k to realK by %
 *   2）find the last k+1 node
 *   3) end point to head, lastK+1 point to null, return lastK
 */

class Solution_61 {
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || k == 0) {
            return head;
        }

        int len = 1;
        ListNode end = head;
        while (end.next != null) {
            len++;
            end = end.next;
        }

        // find the realK that less the len
        int realK = k % len;

        // find the last K+1 nodes named latter
        ListNode pre = head;
        for (int i = 0; i < realK + 1; i++) {
            pre = pre.next;
        }
        ListNode latter = head;
        while (pre != null) {
            pre = pre.next;
            latter = latter.next;
        }

        //change point
        end.next = head;
        ListNode newHead = latter.next;
        latter.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = ListNodeUtils.createNodeList("1,2,3");
        new Solution_61().rotateRight(head, 4);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
