package qiuzhaoBISHI;


import java.util.*;


public class Lianjia3 {

    public static class Node {
        public int position;
        public int heigh;
        public int order;
        public int count;

        public Node(int position, int heigh, int order, int count) {
        }
    }


    //第二题
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//人数
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
                return Integer.compare(o2.position, o1.position);
            }
        });
//        for (Node now : list
//                ) {
//            System.out.println(now.count);
//        }

        //按照坐标排序完了  哈哈，开始计算能推倒几个, 从后往前比较排好
        //倒序
        boolean i = true;
        Node pre = null;
        for (Node now : list
        ) {
            if (i) {//最后一个
                i = false;
                pre = now;
                continue;
            }
            //问题出在这
            if (now.position + now.heigh - 1 >= pre.position) {
                now.count = pre.count + 1;
            }
            pre = now;
        }
        //根据order排序啊
        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.order, o2.order);
            }
        });

        for (Node now : list
        ) {
            System.out.println(now.count);
        }
    }
}
