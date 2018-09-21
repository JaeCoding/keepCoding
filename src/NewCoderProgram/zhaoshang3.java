package NewCoderProgram;

import java.util.Scanner;


/**
 * @author: 彭文杰
 * @create: 2018-08-16 21:23
 *  可以反转的好数字
 **/
public class zhaoshang3 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt()+1;
        int count = 0;
        for (int i = 0; i < n; i++) {
            String s = String.valueOf(i);
            String re = reverse(s);
            if (re.equals("Bad")) continue;
            if (!s.equals(re)) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static String reverse(String s) {
        int len = s.length();
        char[] cs = s.toCharArray();
        for (int i = 0; i < len; i++) {
            if (cs[i] == '3' || cs[i] == '4' || cs[i] == '7') {
                return "Bad";
            }else if (cs[i] == '2') {
                cs[i] = '5';
            }else if (cs[i] == '5') {
                cs[i] = '2';
            }else if (cs[i] == '6') {
                cs[i] = '9';
            }else if (cs[i] == '9') {
                cs[i] = '6';
            }
        }
        String re = "";
        for (int i = 0; i < len; i++) {
            re += cs[i];
        }
        return re;
    }
}
