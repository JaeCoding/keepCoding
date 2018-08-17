package NewCoderProgram;

import java.util.Scanner;

/**
 * @Author: 彭文杰
 * @Date: Created in 2018/8/16 19:06
 * @Description :
 */
public class Sqrt {


    //求数列的和
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            double n = in.nextDouble();
            double m = in.nextDouble();
            double sum = 0;
            for (int i = 1; i <= m; i++) {
                sum += n;
                n = Math.sqrt(n);
            }
            System.out.printf("%.2f", sum);
        }
    }

}
