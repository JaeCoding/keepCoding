package com.jaecoding.keep.coding.algorithfasdasd.point;

public class Question_nk_1 {
    public static boolean Find(int target, int[][] array) {
        int i = array.length - 1;
        int j = 0;
        while (i >= 0) {
            while (j <= array[0].length - 1) {
                if (array[j][i] > target) {
                    j--;
                } else if (array[j][j] < target) {
                    i++;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] a = {{1, 2, 8, 7}, {2, 4, 9, 21}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        System.out.println("" + Find(7, a));
    }
}