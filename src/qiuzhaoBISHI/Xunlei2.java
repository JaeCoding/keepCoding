package qiuzhaoBISHI;

import java.util.Scanner;


/**
 * @author: 彭文杰
 * @create: 2018-08-16 21:23
 **/
public class Xunlei2 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (i + j < k) continue;
                    if (i * i + j * j == k * k && huzhi(i,j) && huzhi(i,k)) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }

    public static boolean huzhi(int a, int b) {
        int temp;
        if(a < b){
            temp = a;
            a = b;
            b = temp;

        }
        while(a%b != 0){
            temp = a%b;
            a = b;
            b = temp;
        }
        if (b == 1) return true;
        return false;
    }
}

