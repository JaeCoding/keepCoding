package qiuzhaoBISHI;

// 本题为考试多行输入输出规范示例，无需提交，不计分。
import java.util.Scanner;

public class wangyiZ1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        str = str + str;
        int len = str.length();
        int max = 1;
        char c1;
        int count = 1;
        char c2;
        for (int i = 0; i < len-1; i++) {
            c1 = str.charAt(i);
            c2 = str.charAt(i+1);
            if (c1 != c2) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 1;
            }
        }
        max = Math.min(max, len/2);
        System.out.println(max);
    }
}
