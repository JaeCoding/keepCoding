package com.jaecoding.keep.coding.algorithm.leetcode.leetcode.editor.en;
//Given a sorted linked list, delete all nodes that have duplicate numbers, leav
//ing only distinct numbers from the original list. 
//
// Example 1: 
//
// 
//Input: 1->2->3->3->4->4->5
//Output: 1->2->5
// 
//
// Example 2: 
//
// 
//Input: 1->1->1->2->3
//Output: 2->3
// 
// Related Topics Linked List


//leetcode submit region begin(Prohibit modification and deletion)

import com.jaecoding.keep.coding.algorithm.leetcode.leetcode.editor.en.helper.ListNode;
import com.jaecoding.keep.coding.algorithm.leetcode.leetcode.editor.en.helper.ListNodeUtils;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution_82 {
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode latter = dummy;
        ListNode pre = head;

        // two pointer(pre and latter), when pre != pre.next, two pointer go together
        // when pre == pre.next, latter stop going, pre go until pre != pre.next
        // stop condition: pre reach the end

        while (pre != null) {

            if (pre.next != null && pre.val == pre.next.val) {

                // internal circulation, stop when pre != pre.next
                do {
                    pre = pre.next;
                } while (pre.next != null && pre.val == pre.next.val);

                // change pointer
                latter.next = pre.next;
                pre = pre.next;
            } else {

                // when pre != pre.next , two pointer move backward as the same time
                pre = pre.next;
                latter = latter.next;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNodeUtils.createNodeList("1,3,3,4,4,5");
        new Solution_82().deleteDuplicates(head);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
