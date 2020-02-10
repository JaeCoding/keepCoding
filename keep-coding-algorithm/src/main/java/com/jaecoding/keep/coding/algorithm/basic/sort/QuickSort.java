package com.jaecoding.keep.coding.algorithm.basic.sort;

import java.util.Arrays;

/**
 * @author: 彭文杰
 * @create: 2018-08-15 23:11
 **/
public class QuickSort {

    public static void main(String[] args) {

        int[] arr = {7, 13, 4, 246};
        System.out.println(more(7, 4) + "");
        quickSort(arr);
        for (int a : arr
        ) {
            System.out.println(a + "");
        }
    }

    public int min(int[] arr) {
        Arrays.sort(arr);
        return arr[0];
    }


    /**
     * 彭文杰 下面两个坑你容易踩
     * <p>
     * 坑1： 切分点k 位置在切分后固定下来了 所以只要递归 low, k - 1 和 k + 1, high
     * 坑2： 递归终止条件是 low >= high
     *
     * @param arr
     */
    private static void quickSort(int[] arr) {
        int n = arr.length - 1;
        quickSort(arr, 0, n);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low >= high) return;
        int k = patition2(arr, low, high);
        quickSort(arr, low, k - 1); //注意啊  k这个点不用排序啦 已经稳定了
        quickSort(arr, k + 1, high);
    }

    private static int patition(int[] arr, int low, int high) {
        int par = arr[low];
        int j = low + 1, k = high;
        while (j < k) {
            if (par > arr[j]) {
                j++;
                continue;
            }
            if (arr[k] > par) {
                k--;
                continue;
            }
            exch(arr, j, k);
            j++;
            k--;
        }
        exch(arr, low, j);
        return j;
    }

    /**
     * 大循环 终止条件 ：左指针 >= 右指针
     * 小循环终止条件： 1.左找到大于par的  右找到小于par的  或者到底
     *
     * @return
     */
    private static int patition2(int[] arr, int low, int high) {
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


    /**
     * 类似字典序的比较方式    比如 2 > 15
     *
     * @param par
     * @param i
     * @return
     */
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

    private static void exch(int[] arr, int j, int k) {
        int temp = arr[j];
        arr[j] = arr[k];
        arr[k] = temp;
    }
}
