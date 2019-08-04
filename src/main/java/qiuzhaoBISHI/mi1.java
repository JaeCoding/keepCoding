//package qiuzhaoBISHI;
//
//import java.util.*;
//
//
///**
// * @author: 彭文杰
// * @create: 2018-08-16 21:23
// **/
//public class mi1 {
//    private List<String> str;
//
//
//
///*
//十进制转换为二进制、八进制、十六进制
//1、思路：1、建立一个十六进制的字码表，用数组表示,数组的脚标刚好对应每个元素值
//         2、每次除以被转数的基数取余数，相当于每次和1、7或15做与运算，之后做右移1、3或4位动作，依照此过程重复进行，直到被转换数为零
//         3、每次得出的值存放到一个数组中
//         4、对数组进行翻转遍历即可得出被转换后的数值
//定义：数值序列中包含2~16进制整数，如果序列中有一个数，与序列中其他任何一个数大小都不相等，则这个数叫做“异数”。请找出给定数值序列中所有的“异数”.
//
//输入
//输入数值序列i行(0<i)，每一行分别是进制和数值，以“#”分割。如：n#m, n是整数，代表n进制（1<n<17）,m是n进制下的数值.
//
//输入序列以结束符”END”结束.
//
//输出
//输出j行(0<j<=i),每一行都是输入序列的“异数”。要求：
//
//1.按照输入序列的原序输出;
//
//2.如果没有”异数”,输出字符串”None”
//
//3.结束符“END”不用输出
//
//
//样例输入
//10#15
//4#32
//4#33
//8#17
//END
//样例输出
//4#32
//*/
//
//
//    public static class Node {
//        public int a;
//        public int b;
//        public int c;
//        public Node(int a, int b, int c) {
//            this.a = a;
//            this.b = b;
//            this.c = c;
//        }
//        public boolean xiaoyu(Node o2) {
//            if (this.a < o2.a && this.b < o2.b && this.c < o2.c) {
//                return true;
//            } else {
//                return false;
//            }
//        }
//    }
//
//    public static void main(String[] args)
//    {
//        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine();
//        while (!str.equals("END")) {
//            String[] strs = str.split("#");
//            int decimal = Integer.parseInt(strs[0]);
//            int num = Integer.parseInt(strs[1]);
//            int numBi = trans(num, decimal-1, 1);
//            Node node = new Node(numBi, )
//
//
//
//            listBi.add(String.valueOf(numBi));
//            str = sc.nextLine();
//        }
//        for (String strss : str
//             ) {
//            strss =
//            int countStr = count1(listBi, strss);
//            System.out.println(countStr);
//            maxCount = Math.max(maxCount, countStr);
//        }
//        for (int j = 0; j < str.size(); j++) {
//            int countStr = count1(listBi, str.get(j));
//            if (countStr < maxCount) {
//                System.out.println(str.get(j));
//            }
//        }
////        if (map.size() == 1) {
////            System.out.println("None");
////        } else {
////
////        }
//    }
//
//    public static int count1(List<String> list, String string) {
//        int count = 0;
//        for (String str : list
//             ) {
//            if (str.equals(string)) {
//                count++;
//            }
//        }
//        return count;
//    }
//    //十进制转换为二进制
//    public static void toBin(int num)
//    {
//        trans(num,1,1);
//    }
//    //十进制转换为八进制
//    public static void toOctal(int num)
//    {
//        trans(num,7,3);
//    }
//    //十进制转换为十六进制
//    public static void toHex(int num)
//    {
//        trans(num,15,4);
//    }
//
//
//
//    //定义一个通用的转换方法   base = 进制 - 1
//    public static int trans(int num,int base,int move)
//    {
//        int temp = 0;
//    //定义一个临时存放数组
//        char arr[] = new char[32];
//        int post = arr.length;
//    //定义一个字码表
//        char array[] = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
//        while (num != 0)
//        {
//            temp = num & base;
//            num = num >>> move;
//            arr[--post] = array[temp];
//        }
//        String str = "";
//        for (int j = post;j < arr.length ; j ++)
//        {
//            str += arr[j];
////            System.out.print(arr[j]);
//        }
//        return Integer.valueOf(str);
//    }
//
//}
