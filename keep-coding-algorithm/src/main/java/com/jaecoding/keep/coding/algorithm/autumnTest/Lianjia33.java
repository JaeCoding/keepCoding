package com.jaecoding.keep.coding.algorithm.autumnTest;

import java.util.*;

/**
 * @Author: 彭文杰
 * @Date: Created in 2018/8/16 19:06
 * @Description :
 * <p>
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 65536KB；其他语言 589824KB
 * 题目描述：
 * 多米诺骨牌大家想必都不陌生，现在有n块多米诺骨牌放在x轴上，
 * 每一块骨牌有一个所在位置下标和高度，每一块骨牌都只会向x轴正方向倒下，当处于位置x0，高度为h0的多米诺骨牌倒下，
 * 会压倒[x + 1, x + h - 1]内的所有多米诺骨牌，对于每一块骨牌。我们希望知道，如果我把这块骨牌推倒，那么至多可以倒下多少块骨牌。
 * <p>
 * 输入
 * 输入第一行包含一个正整数n，表示多米诺骨牌的数量(1<=n<=10^5)
 * 接下来n行，每行包含两个正整数x,h，分别表示第i块多米诺骨牌的位置和高度(-10^8<=x<=10^8,2<=h<=10^8)。保证不会有两块骨牌在同一高度。
 * 输出
 * 对于每个测试数据，输出一行， 包含n个正整数，第i个数字表示，如果推倒第i块多米诺骨牌，可以使得多少个骨牌倒下。
 * 样例输入
 * 4
 * 16 5
 * 20 5
 * 10 10
 * 18 2
 * 样例输出
 * 3 1 4 1
 */
public class Lianjia33 {

    public static class Node {
        int position;
        int heigh;
        int order;
        int count;
        List<Integer> include;

        public Node(int position, int heigh, int order, int count) {
        }
    }


    //第二题
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//人数asd
        List<Node> list = new ArrayList<>();
        //先找到1？
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();//x坐标
            int h = sc.nextInt();//高度
            Node n1 = new Node(x, h, i, 0);
            n1.position = x;
            n1.heigh = h;
            n1.order = i;
            n1.count = 1;
            list.add(n1);

        }
        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.position, o2.position);
            }
        });

        //按照坐标排序完了  哈哈，开始计算能推倒几个, 从后往前比较排好
        boolean i = true;
        Node now = null;
        Node next = null;
        for (int j = list.size() - 2; j >= 0; j--) {
            now = list.get(j);
            next = list.get(j + 1);
            if (now.position + now.heigh >= next.position) {
                for (int k = j; k < list.size(); k++) {
                }
            }


        }
        //根据order排序啊
        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.order, o2.order);
            }
        });


    }
}
