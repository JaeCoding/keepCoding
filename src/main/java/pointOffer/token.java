package pointOffer;

import java.util.Scanner;

public class token {
    String tohex(int num) {
        if (num >= 0) {
            return transe(num);//自然数
        } else {
            System.out.println((Math.pow(16, 8) + num) + "");
            return transe((long) Math.pow(16, 8) + num);
        }
    }


    String transe(long num) {
        StringBuffer s = new StringBuffer();
        long temp = 0;
        while (num != 0) {
            temp = num % 16;
            s.append(sixteen(temp));
            num = (num - temp) / 16;
        }
        return s.reverse().toString();
    }


    String sixteen(long num) {
        if (num <= 9 && num >= 0) return (num + "");
        else return (char) (num - 10 + 'A') + "";
    }

    public static void main(String[] args) {
        token t = new token();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(t.tohex(n));
    }
}