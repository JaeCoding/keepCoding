package qiuzhaoBISHI;

// 本题为考试多行输入输出规范示例，无需提交，不计分。
import java.util.Scanner;

public class yixinZ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strs = str.split(" ");
        String s1 = strs[0];
        String s2 = strs[1];
        int a = s1.indexOf(s2);
        System.out.println(a);
    }
    //abcdabcdefg bcd
}
