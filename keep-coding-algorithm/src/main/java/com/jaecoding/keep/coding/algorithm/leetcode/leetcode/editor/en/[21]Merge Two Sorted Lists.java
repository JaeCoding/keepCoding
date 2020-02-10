package com.jaecoding.keep.coding.algorithm.leetcode.leetcode.editor.en;
//Merge two com.jaecoding.keepCoding.sorted linked lists and return it as a new list.
// The new list should be made by splicing together the nodes of the first two lists.
//
// Example:
// 
//Input: 1->2->4, 1->3->4
//Output: 1->1->2->3->4->4
// 
// Related Topics Linked List


//leetcode submit region begin(Prohibit modification and deletion)

// TIPS : Consider recursion in linked list topics

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution_21 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // cause the linked list topic that we can split the problem into sub-question
        // use recursive, return the result of mergeTwoLists(l1.next, l2) when l1 is less than l2

        if (null == l1 || null == l2) {
            return l1 == null ? l2 : l1;
        } else if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    /**
     * TIPS : dummy, curNode
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        // use Node cur to save reference
        ListNode dummy = new ListNode(-1), cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        // when curNode reaches the tail of one,
        // out of the loop and attach the tail of other to curNode
        cur.next = null == l1 ? l2 : l1;
        return dummy.next;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
