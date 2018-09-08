package leetcode;


/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]

       _______3______
     /                \
   ___5__             ___1__
 /      \           /       \
 6        _2        0       8
        /  \
        7   4
 示例 1:

 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 输出: 3
 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 示例 2:

 所有节点的值都是唯一的。
 p、q 为不同节点且均存在于给定的二叉树中。
 */
public class Leetcode_236 {


    /**
     *思路：要找到 二叉树root节点树下 两个点的公共祖先
     *
     * 终止条件：当前root 为null 或者等于 p q中的一个  直接返回root说明找到了一个节点 或者标记此树下无pq
     *
     * 此树不为null，且root也不是pq，我们可以递归在 左右子树中 寻找pq
     * 左= 找到的节点或者 null
     * 右= 找到的节点或者 null
     * 1.如果左右都为空，则返回null，表明此子树不包含（pq）。这种情况多半发生在树偏下的位置
     * 2.左右中 一个为 null， 直接返回 非空的节点，表明当前子树只找到一个。  这种情况多半发生在树中间的位置
     * 3.左右节点 都不为空，  说明当前节点 就是 pq的 最小公共祖先
     *
     * 从整体上看lowestCommonAncestor方法，就是返回当前root树，对于包含pq节点的情况
     * 1.不包含：null
     * 2.包含一个： p或者q
     * 3.都包含： root
     * 包含与否的判定，在于判定左右节点是否为空。递归回到根节点时候，则会返回对应的 公共祖先
     *
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null|| root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        return left == null ? right : left;
    }

    public static void main(String[] args) {

    }
    public class TreeNode {
        int val;
        TreeNode left;

        TreeNode right;
        TreeNode(int x) {
            val = x;
        }

    }
}

