package NewCoderProgram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: 彭文杰
 * @Date: Created in 2018/8/16 19:06
 * @Description :
 */
public class Lianjia {


    //第二题
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        Object[] arr = list.toArray();
        Arrays.sort(arr);
        int sum = 0;
        for (int i = 1; i < n; i++) {
            sum += Integer.parseInt(String.valueOf(arr[i]));
        }
        System.out.println(sum+"");

    }
}
