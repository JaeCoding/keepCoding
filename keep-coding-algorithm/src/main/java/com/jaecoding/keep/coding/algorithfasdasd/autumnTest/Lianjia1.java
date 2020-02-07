package com.jaecoding.keep.coding.algorithfasdasd.autumnTest;

/**
 * @Author: 彭文杰
 * @Date: Created in 2018/8/16 19:06
 * @Description :
 * <p>
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 65536KB；其他语言 589824KB
 * 题目描述：
 * 小明和小红是亲兄妹，他俩一起翻了翻他们家的族谱，发现他们家非常庞大，有非常多的名字在族谱里面。族谱中会写清楚每一个人的父亲是谁，当然每个人都只会有一个父亲。
 * <p>
 * 对于祖先的定义，我们在这儿举个例子：族谱里面会写小王的父亲是小丁，小丁的父亲是小东，那么实际上小东就是小王的爷爷，也是小王的祖先。
 * <p>
 * 小明很聪明，小明理了理他们的家庭关系，很快就弄清楚了，知道了族谱中每一个人的祖先关系。
 * <p>
 * 但是小红却依旧困惑，于是问了很多问题，希望你能够解答。
 * <p>
 * 小红的问题是，请问A是B的祖先关系是什么？究竟A是不是B的祖先，或者说B是A的祖先，亦或者B和A不存在祖先关系呢。
 * <p>
 * 输入
 * 输入第一行包括一个整数n表示家族成员个数。
 * <p>
 * 接下来n行每行一对整数对a和b表示a是b的父亲，或者b是a的父亲，这需要你来判断。
 * <p>
 * 如果b是-1，那么a就是整个家族的根，也就是辈分最大的人，保证只有一个。
 * <p>
 * 第n+2行是一个整数m表示小红的询问个数。
 * <p>
 * 接下来m行，每行两个正整数A和B。
 * <p>
 * 表示小红想知道A是B的祖先关系。
 * <p>
 * n,m≤40000，每个节点的编号都不超过40000。
 * <p>
 * 输出
 * 对于每一个询问。
 * <p>
 * 输出1表示A是B的祖先，输出2表示B是A的祖先，都不是输出0
 * <p>
 * <p>
 * 样例输入
 * 10
 * 1 -1
 * 3 1
 * 4 1
 * 5 1
 * 6 1
 * 7 1
 * 8 1
 * 9 1
 * 10 1
 * 2 10
 * 5
 * 1 2
 * 2 3
 * 2 4
 * 2 5
 * 2 10
 * 样例输出
 * 1
 * 0
 * 0
 * 0
 * 2
 */
public class Lianjia1 {


//    //第二题
//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();//人数
////        List<Integer> list = new ArrayList<>();
//        Map<Integer,Integer> map = new HashMap<>();
//        //先找到1？
//        for (int i = 0; i < n; i++) {
//            int m1 = sc.nextInt();
//            int m2 = sc.nextInt();
//
//        }
//        Object[] arr = list.toArray();
//        Arrays.sort(arr);
//        int sum = 0;
//        for (int i = 1; i < n; i++) {
//            sum += Integer.parseInt(String.valueOf(arr[i]));
//        }
//        System.out.println(sum+"");
//
//    }
}
