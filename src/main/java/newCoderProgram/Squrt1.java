package newCoderProgram;

import java.util.Scanner;

/**
 * @author: 彭文杰
 * @create: 2018-08-16 21:22
 **/
public class Squrt1 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            double num = sc.nextInt();
            int n = sc.nextInt();
            double sum = num;
            for (int i = 1; i < n; i++) {
                num = Math.sqrt(num);
                sum += num;
            }
            String result = String.format("%.2f", sum);
            System.out.println(result);
        }
    }
}
