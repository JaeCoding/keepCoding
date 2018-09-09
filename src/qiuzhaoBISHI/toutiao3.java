package qiuzhaoBISHI;


import java.util.Scanner;

/**
 * @author: 彭文杰
 * @create: 2018-09-09 10:02
 **/


public class toutiao3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = n + "";
        int len = str.length();
        if (len < 4) {
            System.out.println(0);
        }
        int insert = len - 1;
        int count = 0;
        for(int i = len-1; i > 0; i--){
            for (int j = i-1; j > 0; j--) {
                for (int k = j-1; k > 0; k--) {
                    StringBuffer sb = new StringBuffer(str);
                    sb.insert(i, ".");
                    sb.insert(j, ".");
                    sb.insert(k, ".");
                    String str12 = sb.toString();
                    String[] strs = str12.split("\\.");
                    if (ok(strs)) {
                        count++;
                        System.out.println(sb);
                    }
                }
            }
        }
        System.out.println(count);
    }

    public static boolean ok(String[] strings) {
        for (String str1 : strings
                ) {
            if (str1.length() > 1 && str1.charAt(0) == '0') {
                return false;
            }
            if (Integer.parseInt(str1) < 0 || Integer.parseInt(str1) > 255) {
                return false;
            }
        }
        return true;
    }
}
