package qiuzhaoBISHI;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class JD1 {



    //第二题
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//组数
        for (int i = 0; i < n; i++) {
            int N = sc.nextInt();//点
            int[][] arr = new int[N+1][N+1];
            int M = sc.nextInt();//边
            for (int j = 0; j < M; j++) {
                int n1 = sc.nextInt();//点
                int n2 = sc.nextInt();//点
                arr[n1][n2] = 1;
                arr[n2][n1] = 1;
            }
            int flag = 0;
            for (int j = 1; j < N+1; j++) {
                int count = 0;
                for (int k = 1; k < N+1; k++) {
                    if (arr[j][k] == 1) count++;
                }
                if (count < 2) {
                    System.out.println("NO");
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                System.out.println("YES");
            }
        }
    }
}


