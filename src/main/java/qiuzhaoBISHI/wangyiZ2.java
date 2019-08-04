package qiuzhaoBISHI;

// 本题为考试多行输入输出规范示例，无需提交，不计分。

import java.util.*;

public class wangyiZ2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int n1 = sc.nextInt();//总数
            int n2 = sc.nextInt();//住户
            int n3 = n1 - n2;//可住
            if (n2 < 2 || n3 < 1) {
                System.out.println("0 0");
            }
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < n3; j++) {
                sb.append("0");
            }
            for (int j = 0; j < n2; j++) {
                sb.append("1");
            }
            String A = sb.toString();
            char[] arrayA = A.toCharArray();
            Set<String> set = new HashSet<>();

            allPermutation(set, A);

            int max = 0;
            for (String strc : set
            ) {
                int count = 0;
                for (int j = 1; j < strc.length() - 1; j++) {
                    if (strc.charAt(j) == '0' && strc.charAt(j - 1) == '1' && strc.charAt(j + 1) == '1') {
                        count++;
                    }
                }
                max = Math.max(max, count);
            }
            System.out.println("0 " + max);
        }


    }


    public static void allPermutation(Set<String> set, String str) {
        if (str == null || str.length() == 0)
            return;
        //保存所有的全排列

        allPermutation(str.toCharArray(), set, 0);

    }


    private static void allPermutation(char[] c, Set<String> set, int start) {

        if (start == c.length - 1)
            set.add(String.valueOf(c));//System.out.println(String.valueOf(c));
        else {
            for (int i = start; i <= c.length - 1; i++) {
                //只有当没有重叠的字符 才交换
                if (!isSwap(c, start, i)) {
                    swap(c, i, start);//相当于: 固定第 i 个字符
                    allPermutation(c, set, start + 1);//求出这种情形下的所有排列
                    swap(c, start, i);//复位
                }
            }
        }
    }

    private static void swap(char[] c, int i, int j) {
        char tmp;
        tmp = c[i];
        c[i] = c[j];
        c[j] = tmp;
    }

    private static void print(LinkedList<String> listStr) {
        Collections.sort(listStr);//使字符串按照'字典顺序'输出
        for (String str : listStr) {
            System.out.println(str);
        }
        System.out.println("size:" + listStr.size());
    }

    //[start,end) 中是否有与 c[end] 相同的字符
    private static boolean isSwap(char[] c, int start, int end) {
        for (int i = start; i < end; i++) {
            if (c[i] == c[end])
                return true;
        }
        return false;
    }

}
