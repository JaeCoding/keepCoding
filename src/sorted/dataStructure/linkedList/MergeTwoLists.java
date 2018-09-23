package sorted.dataStructure.linkedList;


/**
 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

 示例：

 输入：1->2->4, 1->3->4
 输出：1->1->2->3->4->4
 */
public class MergeTwoLists {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 使用了一个 前置哨兵 dummy  一个cur表示当前的尾部
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode dummy = new ListNode(-1), cur = dummy;//用一个哨兵，前置节点
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

