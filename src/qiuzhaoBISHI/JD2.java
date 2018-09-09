package qiuzhaoBISHI;


import java.util.*;


public class JD2 {

    public static class Node {
        public int a;
        public int b;
        public int c;
        public Node(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        public boolean xiaoyu(Node o2) {
            if (this.a < o2.a && this.b < o2.b && this.c < o2.c) {
                return true;
            } else {
                return false;
            }
        }
    }



    //第二题
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        List<Node> list = new ArrayList<>();
        int n = sc.nextInt();//人数
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();//
            int b = sc.nextInt();//
            int c = sc.nextInt();//
            Node n1 = new Node(a, b, c);
            list.add(n1);
        }
//        Comparator cp = new Comparator<Node>() {
//            @Override
//            public int compare(Node o1, Node o2) {
//                if (o1.a > o2.a && o1.b > o2.b && o1.c > o2.c) {
//                    return 1;
//                }
//                if ((o1.a > o2.a && o1.b > o2.b) || (o1.a > o2.a && o1.c > o2.c) || (o1.b > o2.b && o1.c > o2.c)) {
//                    return 1;
//                }
//                if ((o1.a > o2.a || o1.b > o2.b || o1.c > o2.c)) {
//                    return 0;
//                }
//                return -1;
//            }
//        };
//        Collections.sort(list, cp);
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if ((i != j) && list.get(i).xiaoyu(list.get(j))) {
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);

    }
}


