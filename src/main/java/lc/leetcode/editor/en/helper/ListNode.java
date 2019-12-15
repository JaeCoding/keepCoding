package lc.leetcode.editor.en.helper;

/**
 * TODO
 *
 * @author Jae
 * @date 2019/12/15
 * @since 1.8
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }
    public ListNode(int x,ListNode next) {
        val = x;
        next = next;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();


        ListNode cur = this;
        while (cur != null) {
            stringBuilder.append(cur.val).append("->");
            cur = cur.next;
        }

        return stringBuilder.toString();
    }
}
