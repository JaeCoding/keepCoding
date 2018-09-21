package leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * 数的组合
 *
 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

 示例:

 输入: n = 4, k = 2   也就是1-4 的所有2 字组合（组合可以用顺序）
 输出:
 [
 [2,4],
 [3,4],
 [2,3],
 [1,2],
 [1,3],
 [1,4],
 ]
 https://blog.csdn.net/u010500263/article/details/18435495
 思路：因为是组合，  所以无关顺序，并且发现 前面的数都小于后面的数。 故可采用递归

 递归需要：  外层大集合，内层小集合， n，  k   ，当前 迭代的 开始位置
 */
public class Leetcode_77 {

    public static void main(String[] args) {
        List<List<Integer>> list = new Leetcode_77().combine(5, 3);
        for (List<Integer> list1 : list
             ) {
            for (Integer in : list1
                 ) {
                System.out.print(in+" ");
            }
            System.out.println("-");
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> comSet = new ArrayList<>();//大集合
        if (k > n) return comSet;
        List<Integer> comb = new ArrayList<>();//内部小集合
        recur(comSet, comb, n, k, 1);
        return comSet;
    }


    /**
     * 如何保证 内集合 的独立性？  添加后不会相互影响. 思路是 在考虑每次情况后，都清理掉当前添加的元素
     * @param start 表示当前递归的 开始位置（所添加的元素）
     * DFS 的思想  思路是
     *              开始
     *           1              2         3       4       5
     *        2    3   4      3  4  5    4  5
     *     3 4 5  4 5   5    4 4  5
     */
    private void recur(List<List<Integer>> comSet, List<Integer> comb, int n, int k, int start) {
        if (comb.size() == k) {
            comSet.add(new ArrayList<Integer> (comb));//这里只能存 comb的副本，不能存com，否则会有影响的！！！
            return;
        } else {
            for (int i = start; i <= n; i++) {//当前添加的i，<= n 才行
                comb.add(i);
                recur(comSet, comb, n, k, i+1);
                comb.remove(comb.size() - 1);//当递归调用返回后，需要移除掉添加的元素，因为comb共用的。
            }
        }
    }
}
