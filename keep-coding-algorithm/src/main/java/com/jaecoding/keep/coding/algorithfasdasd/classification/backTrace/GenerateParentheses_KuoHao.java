package com.jaecoding.keep.coding.algorithfasdasd.classification.backTrace;


import java.util.ArrayList;
import java.util.List;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class GenerateParentheses_KuoHao {
    public static void main(String[] args) {
        List<String> list = generateParenthesis(3);
        for (String string : list
        ) {
            System.out.println(string);
        }

    }

    /**
     * 思想： 回溯算法
     * <p>
     * 在包含问题的 所有解的解空间树 中，按照 深度优先搜索 的策略，从根结点出发深度探索解空间树。
     * 当探索到某一结点时，要先 判断该结点是否包含问题的解，如果包含，就从该结点出发继续探索下去，如果该结点不包含问题的解，则逐层向其祖先结点回溯。（一般是不处理 或者return）
     * （其实回溯法就是对 隐式图的深度优先搜索算法 ）。
     * 若用回溯法求问题的所有解时，要回溯到根，且根结点的所有可行的子树都要已被搜索遍才结束。
     * 而若使用回溯法 求 任一个解时，只要搜索到问题的 一个解 就可以结束（或者添加到解集中，回溯继续求解）。
     * 计算左括号 和 有括号 的数量
     * <p>
     * 底层停止条件： 字符串长度达到 2n
     * 限制条件： 左括号： 数量小于n时候可以添加
     * 右括号： 数量 小于 左括号时 可以添加
     */
    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    public static void backtrack(List<String> list, String str, int open, int close, int max) {

        if (str.length() == max * 2) {
            list.add(str);
            return;
        }
        if (open < max)
            backtrack(list, str + "(", open + 1, close, max);
        if (close < open)
            backtrack(list, str + ")", open, close + 1, max);
    }
}
