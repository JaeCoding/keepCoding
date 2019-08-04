package newCoderProgram;

import java.util.Scanner;


/**
 * @author: 彭文杰
 * @create: 2018-08-16 21:23
 **/
public class wangyiyouxi2 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//技能个数
        int m = sc.nextInt();//可用点数
        int[] xiaohao = new int[n];
        int[] max = new int[n];
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            xiaohao[i] = num;
            max[i] = m / num;
        }


    }
}
