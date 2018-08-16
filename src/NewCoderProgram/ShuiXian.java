package NewCoderProgram;

import java.util.Scanner;

/**
 * @author: 彭文杰
 * @create: 2018-08-16 21:46
 **/
public class ShuiXian {

    public static void main(String[] args) {
        int[] arr = {153, 370, 371, 407};
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            if (m < arr[0] || n > arr[arr.length - 1]) {
                System.out.println("no");
            } else {
                int low = 0, high = arr.length - 1;
                while (n > arr[low]){
                    if(n <= arr[0] || low == arr.length - 1) break;
                    low++;
                }
                while (m < arr[high]){
                    if(m >= arr[arr.length - 1] || high == 0) break;
                    high--;
                }
                for (int i = low; i <= high; i++) {
                    if (i != high) {
                        System.out.print(arr[i] + " ");
                    } else {
                        System.out.print(arr[i]);
                    }
                }
            }
        }
    }
}
