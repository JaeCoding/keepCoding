package leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
public class Leetcode_22 {
    public static void main(String[] args) {
        List<String> list = generateParenthesis(3);
        for (String string: list
             ) {
            System.out.println(string);
        }

    }


    /**
     * 思想： 回溯算法
     *
     * 在包含问题的所有解的解空间树中，按照深度优先搜索的策略，从根结点出发深度探索解空间树。
     * 当探索到某一结点时，要先 判断该结点是否包含问题的解，如果包含，就从该结点出发继续探索下去，如果该结点不包含问题的解，则逐层向其祖先结点回溯。（一般是不处理 或者return）
     * （其实回溯法就是对隐式图的深度优先搜索算法）。
     * 若用回溯法求问题的所有解时，要回溯到根，且根结点的所有可行的子树都要已被搜索遍才结束。
     * 而若使用回溯法 求 任一个解时，只要搜索到问题的 一个解 就可以结束。
     *
     * 此题：
     * 深度搜索： 每次都添加一个 （ 或者 ）
     * 终止条件： 所有括号都用完了
     * 限制条件： 选择操作在此条件下才进行，即 左括号没有用完（才可以加左括号），右括号数目小于左括号数目（才可以加右括号）（关键）
     *
     *
     * 比较失败：没法去重 看下一段代码
     */
    public static List<String> generateParenthesis2(int n) {
        List<String> list =new ArrayList<>();
        if (n == 0) {
            return null;
        }
        backTrace("",list, n, n, n);
        return list;
    }

    private static void backTrace(String s, List<String> list, int nleft, int nright, int n) {
        if (s.length() == 2 * n) {//用长度 替代左右为0
            list.add(s);
            return;
        }
        if (nleft > 0) { //左括号没有用完（才可以加左括号）
            s += "(";
            nleft -= 1;
            backTrace(s, list, nleft, nright, n);
        }
        if (nleft < nright) { //右括号数目小于左括号数目（才可以加右括号）
            s += ")";
            nright -= 1;
            backTrace(s, list, nleft, nright, n);
        }
    }


    /**
     * 计算左括号 和 有括号 的数量
     *
     * 底层停止条件： 字符串长度达到 2n
     * 限制条件： 左括号： 数量小于n时候可以添加
     *          右括号： 数量 小于 左括号时 可以添加
     *
     */
    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    public static void backtrack(List<String> list, String str, int open, int close, int max){

        if(str.length() == max*2){
            list.add(str);
            return;
        }
        if(open < max)
            backtrack(list, str+"(", open+1, close, max);
        if(close < open)
            backtrack(list, str+")", open, close+1, max);
    }
}
