package newCoderProgram;

import java.util.Scanner;

/**
 * @author: 彭文杰
 * @create: 2018-08-15 22:37
 * 题目描述
 * 设有n个正整数，将他们连接成一排，组成一个最大的多位整数。
 * 如:n=3时，3个整数13,312,343,连成的最大整数为34331213。
 * <p>
 * 输入描述:
 * 有多组测试样例，每组测试样例包含两行，第一行为一个整数N（N<=100），第二行包含N个数(每个数不超过1000，空格分开)。
 * 输出描述:
 * 每组数据输出一个表示最大的整数。
 * <p>
 * 输入
 * 2
 * 12 123
 * 4
 * 7 13 4 246
 * <p>
 * 输出
 * <p>
 * 12312
 * 7424613
 **/
public class NumString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        numString(sc);
        while (sc.hasNext()) {
            numString(sc);
        }
    }

    private static void numString(Scanner sc) {
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        quickSort(arr);
        StringBuffer str = new StringBuffer();
        for (int i = n - 1; i >= 0; i--) {
            str.append(arr[i]);
        }
        System.out.println(str);
    }

    private static void quickSort(int[] arr) {
        int n = arr.length - 1;
        quickSort(arr, 0, n);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low >= high) return;
        int k = patition(arr, low, high);
        quickSort(arr, low, k - 1); //注意啊  k这个点不用排序啦 已经稳定了
        quickSort(arr, k + 1, high);
    }

    /**
     * 大循环 终止条件 ：左指针 >= 右指针
     * 小循环终止条件： 1.左找到大于par的  右找到小于par的  或者到底
     *
     * @return
     */
    private static int patition(int[] arr, int low, int high) {
        int par = arr[low];
        int j = low, k = high + 1;//注意这里啊
        while (true) {
            while (more(par, arr[++j])) {
                if (j == high) break;
            }
            while (more(arr[--k], par)) {
                if (k == low) break;
            }
            if (j >= k) break;
            exch(arr, j, k);
        }
        exch(arr, low, k);
        return k;
    }

    private static void exch(int[] arr, int j, int k) {
        int temp = arr[j];
        arr[j] = arr[k];
        arr[k] = temp;
    }

    private static boolean more(int par, int i) {
        String par1 = Integer.toString(par);
        String i1 = Integer.toString(i);
        int len;
        boolean change = false;//默认后者长
        if (par1.equals(i1)) {
            return true;
        } else if (par1.length() > i1.length()) {
            len = i1.length();
            change = true;//前者 长一点
        } else {
            len = par1.length();
        }
        for (int j = 0; j < len; j++) {
            if (par1.charAt(j) > i1.charAt(j)) {
                return true;
            } else if (par1.charAt(j) > i1.charAt(j)) {
                return false;
            } else {
                if (j == len - 1) {
                    return change;
                }
                continue;
            }
        }
        return true;
    }


}
