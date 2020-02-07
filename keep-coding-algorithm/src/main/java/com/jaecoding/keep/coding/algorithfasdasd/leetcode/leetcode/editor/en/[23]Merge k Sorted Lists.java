package com.jaecoding.keep.coding.algorithfasdasd.leetcode.leetcode.editor.en;//Merge k com.jaecoding.keepCoding.sorted linked lists and return it as one com.jaecoding.keepCoding.sorted list. Analyze and describe its complexity.
//
// Example: 
//
// 
//Input:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//Output: 1->1->2->3->4->4->5->6
// 
// Related Topics Linked List Divide and Conquer Heap



//leetcode submit region begin(Prohibit modification and deletion)

import com.jaecoding.keep.coding.algorithfasdasd.leetcode.leetcode.editor.en.helper.ListNode;
import com.jaecoding.keep.coding.algorithfasdasd.leetcode.leetcode.editor.en.helper.ListNodeUtils;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution_23 {

    public static void main(String[] args) {
        ListNode list1 = ListNodeUtils.createNodeList("1,4,5");
        ListNode list2 = ListNodeUtils.createNodeList("1,3");
        ListNode list3 = ListNodeUtils.createNodeList("2");

        ListNode[] ls = new ListNode[]{list1, list2, list3};


        ListNode node = new Solution_23().mergeKLists2(ls);
        System.out.println(node);

    }


    public ListNode mergeKLists(ListNode[] lists) {

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        while (true) {
            ListNode minNode = new ListNode(Integer.MAX_VALUE);
            int nullNums = 0;
            int minIndex = 0;
            // find the minValue
            for (int i = 0; i < lists.length; i++) {
                if (null != lists[i] && lists[i].val < minNode.val) {
                    minNode = lists[i];
                    minIndex = i;
                }
                nullNums = null == lists[i] ? nullNums + 1 : nullNums;
            }
            if (nullNums == lists.length) {
                break;
            }
            lists[minIndex] = lists[minIndex].next;
            cur.next = minNode;
            cur = minNode;
        }

        return dummy.next;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        int listLen = lists.length;
        if (listLen == 0) {
            return null;
        }
        if (listLen == 1) {
            return lists[0];
        }
        if (listLen == 2) {
            return mergeTwoLists(lists[0], lists[1]);
        }
        // 3,4 -> 2  1,2 -> 1
        int resultLen = (listLen + 1) / 2;
        ListNode[] result = new ListNode[resultLen];
        for (int i = 0, j = 0; i < listLen; i += 2) {
            ListNode next = i + 1 < lists.length ? lists[i + 1] : null;
            ListNode newNode = mergeTwoLists(lists[i], next);
            // j mean to position to put
            result[j++] = newNode;
        }
        return mergeKLists2(result);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        //用一个哨兵，前置节点
        ListNode dummy = new ListNode(-1), cur = dummy;
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


}
//leetcode submit region end(Prohibit modification and deletion)
