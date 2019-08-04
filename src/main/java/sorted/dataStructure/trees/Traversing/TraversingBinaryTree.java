package sorted.dataStructure.trees.Traversing;

import java.util.Stack;

/**
 * @author: 彭文杰
 * @create: 2018-09-04 12:00
 **/
public class TraversingBinaryTree {

    static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        Node n4 = new Node(4, null, null);
        Node n5 = new Node(5, null, null);
        Node n2 = new Node(2, n4, n5);
        Node n6 = new Node(6, null, null);
        Node n7 = new Node(7, null, null);
        Node n3 = new Node(3, n6, n7);
        Node n1 = new Node(1, n2, n3);
        //标准的一棵完全二叉树
        //前序 ： 1 2 4 5 3 6 7  中序
        aheadRecur(n1);
        System.out.println("递归前序");
        aheadNotRecur(n1);
        System.out.println("非递归前序");
        midRecur(n1);
        System.out.println("递归中序");
        midNotRecur(n1);
        System.out.println("非递归中序");
        lastRecur(n1);
        System.out.println("递归后序");
        lastNotRecur(n1);
        System.out.println("非递归后序");

    }

    /**
     * 前序遍历 递归  中 左 右
     *
     * @param head
     */
    public static void aheadRecur(Node head) {
        if (head == null) return;
        System.out.print(head.val + " ");
        aheadRecur(head.left);
        aheadRecur(head.right);
    }

    /**
     * 前序遍历 非递归
     * 思路：栈  因为打印顺序 是  中 左 右
     * 所以沿路 弹出打印  ，压入右边  再压入左边， 这样让左节点在上，右节点在下
     */
    public static void aheadNotRecur(Node head) {
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.print(cur.val + " ");
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    /**
     * 中序遍历 递归   左 中 右
     */
    public static void midRecur(Node head) {
        if (head == null) return;
        midRecur(head.left);
        System.out.print(head.val + " ");
        midRecur(head.right);
    }

    /**
     * 中序遍历 非递归   左 中 右
     * 思路： 栈   因为打印顺序是 左 中 右  所以栈内
     * 步骤1：cur=root 先一路向左 下到底部，依次压入栈。cur =cur.left
     * 步骤2：遇到null，则弹出记为node，打印，让cur=node.rigth，进行步骤1
     */
    public static void midNotRecur(Node head) {
        if (head == null) return;
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                Node node = stack.pop();
                System.out.print(node.val + " ");
                cur = node.right;
            }
        }
    }

    /**
     * 后序遍历 递归   左 右 中
     * <p>
     * 4 5 2 6 7 3 1
     */
    public static void lastRecur(Node head) {
        if (head == null) return;
        lastRecur(head.left);
        lastRecur(head.right);
        System.out.print(head.val + " ");
    }

    /**
     * 后序遍历  非递归   左 右 中
     * <p>
     * 借助 双栈实现
     * 栈 s1 ： 压入head，弹出直到为空  并且 压入弹出节点的左右（如果存在）
     * 栈 s2 ： 负责压入 从 s1中 弹出的
     * 最后弹光s2 输出
     */
    public static void lastNotRecur(Node head) {
        if (head == null) return;
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        s1.push(head);
        while (!s1.empty()) {
            Node cur = s1.pop();
            s2.push(cur);
            if (cur.left != null) s1.push(cur.left);
            if (cur.right != null) s1.push(cur.right);
        }
        while (!s2.empty()) {
            System.out.print(s2.pop().val + " ");
        }
    }


}
