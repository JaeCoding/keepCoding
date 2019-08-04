package sorted.dataStructure.linkedList;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 示例:
 * <p>
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * .
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换
 */
public class SwapPairs {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x, ListNode next) {
            val = x;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode node4 = new ListNode(4, null);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        ListNode node = swapPairs(node1);
        System.out.println(node.val);
        while (node.next != null) {
            System.out.println(node.next.val);
            node = node.next;
        }
    }

    /**
     * 用两个指针表示移动  用一个指针表示上一次靠后节点， 用于更正后面的位置
     * <p>
     * 坑： 要先修改 p1 再修改 p2 不然p2.next = p1 ;p1.next = p2.next会造成p1的死循环
     */
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode last = p1;
        ListNode newHead = head.next;
        p1.next = p2.next;
        p2.next = p1;
        while (p1.next != null && p1.next.next != null) {
            //指针移动
            p1 = p1.next;
            p2 = p1.next;
            //指针交换
            p1.next = p2.next;//要先修改p1，再修改p2，不然会导致p1.next = p2.next = p1 死循环
            p2.next = p1;
            //last是作为上一次修改的靠后者，也就是p1， 修改指针
            last.next = p2;
            last = p1;
        }
        return newHead;
    }
}

