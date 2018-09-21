package qiuzhaoBISHI;

import java.util.Scanner;


/**
 * @author: 彭文杰
 * @create: 2018-08-16 21:23
 **/
public class pony1 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] =sc.nextInt();
        }
        boolean ji1 = true;
        boolean ji2 = true;
        int d = 0;
        int a0 = arr[0];
        int a1 = arr[1];
        int a2 = arr[2];
        int a3 = arr[3];
        if (a0 <= a1 && a1 <= a2 && a2 <= a3) {
            for (int i = 0; i < n; i++) {
                System.out.println(arr[i]);
            }
        } else if (a0 >= a1) {
            d = (a2 - a0)/2;
            int out = a0;
            for (int i = 0; i < n; i++) {
                System.out.println(out);
                out += d;
            }
        } else if (a0 < a1) {
            d = (a3 - a1)/2;
            int out = a1 - d;
            for (int i = 0; i < n; i++) {
                System.out.println(out);
                out += d;
            }
        }
    }
}
