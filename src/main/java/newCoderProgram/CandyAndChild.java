package newCoderProgram;

import java.util.Arrays;
import java.util.Scanner;


/**
 * @author: 彭文杰
 * @create: 2018-08-16 21:23
 * <p>
 * 分糖果 （有个大小）  小盆友(有个期望值）   大于才能分
 **/
public class CandyAndChild {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String g = sc.nextLine();
        String s = sc.nextLine();
        String[] gs = g.split(" ");
        int[] gi = new int[gs.length];
        for (int i = 0; i < gs.length; i++) {
            gi[i] = Integer.valueOf(gs[i]);
        }

        String[] ss = s.split(" ");
        int[] si = new int[ss.length];
        for (int i = 0; i < ss.length; i++) {
            si[i] = Integer.valueOf(ss[i]);
        }

        Arrays.sort(gi);
        Arrays.sort(si);
        int count = 0;
        //i是糖果  j是人
        for (int i = 0, j = 0; i < si.length && j < gi.length; i++) {
            if (si[i] >= gi[j]) {
                count++;
                j++;
            }
        }
        System.out.println(count);
    }
}
