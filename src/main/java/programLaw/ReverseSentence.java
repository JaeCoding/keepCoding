package programLaw;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * change "I am a student."
 * to "student. a am I"
 */
public class ReverseSentence {

    public static StringBuffer reverseSentence(String s) {
        if (s == null || s.length() == 0) {

            return null;
        }
        StringBuffer sb = new StringBuffer();
        //记录一下单词起始位置
        for (int i = s.length() - 1, j = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                sb.append(s.substring(i + 1, j + 1));
                sb.append(" ");
                j = i;
            }
            if (i == 0) {
                sb.append(s.substring(i, j + 1));
            }
        }
        return sb;
    }


    public static void main(String[] args) throws IOException {
//        String s = "billId is null.";
//        s = String.valueOf(reverseSentence(s));
//        System.out.println(s + "");

        Scanner sc = new Scanner(System.in);
//        while (sc.hasNextLine()) {
        String string = sc.nextLine();
        System.out.println(String.valueOf(reverseSentence(string)));
//        }
//        sc.close();

//        out();

    }

    public static void out() throws IOException {
        BufferedReader brs = new BufferedReader(new InputStreamReader(System.in));
        String inputString = brs.readLine();
        String[] numbers = inputString.split(" ");
        // 字符分割后，倒序输出即可
        for (int i = numbers.length - 1; i >= 0; i--) {
            if (i == 0) {
                System.out.print(numbers[i]);
            } else {
                System.out.print(numbers[i] + " ");
            }
        }

    }


}
