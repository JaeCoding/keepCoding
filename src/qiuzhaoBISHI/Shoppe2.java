package qiuzhaoBISHI;

import java.util.Scanner;

/**
 * @author: 彭文杰
 * @create: 2018-09-12 17:29
 **/
public class Shoppe2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        a = a < 0 ? -a : a;
        int count = 0;
        while (a > 0) {
            count = a % 2 == 1 ? count + 1 : count;
            a = a >> 1;
        }
        System.out.println(count);

//        String str = Integer.toBinaryString(a);
//        System.out.println(str);
    }
}
