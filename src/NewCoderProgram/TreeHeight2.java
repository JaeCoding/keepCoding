package NewCoderProgram;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author: 彭文杰
 * @Date: Created in 2018/8/16 16:13
 * @Description :
 * 现在有一棵合法的二叉树，树的节点都是用数字表示，现在给定这棵树上所有的父子关系，求这棵树的高度
 *
 * 输入描述:
 * 输入的第一行表示节点的个数n（1 ≤ n ≤ 1000，节点的编号为0到n-1）组成，
 * 下面是n-1行，每行有两个整数，第一个数表示父节点的编号，第二个数表示子节点的编号
 *
 * 输出描述:
 * 输出树的高度，为一个整数
 *
 * 输入
5
0 1
1 2
2 3
3 4
 *
 * 输出
 * 3
 */
public class TreeHeight2 {


    /**
     * 用 双数组 而不是map的方式存储高度
     * 有一个坑
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //给每个节点都 配置一个 属于它的高度 等于他父亲高度 +1
        int[] heighth = new int[n];//高度数组
        int[] parents = new int[n];//baba数组
        heighth[0] = 1;
        int maxHeigh = 0;
        for (int i = 0; i < n - 1; i++) {
            int parent = sc.nextInt();
            int son = sc.nextInt();
            parents[son] = parent;

            heighth[son] = heighth[parents[son]] + 1;
            maxHeigh = Math.max(maxHeigh, heighth[son]);
        }
        System.out.println(maxHeigh+"");
    }
}
