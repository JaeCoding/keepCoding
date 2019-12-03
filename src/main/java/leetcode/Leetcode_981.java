package leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Leetcode_981 {
    public static void main(String[] args) {
        int[] nums = new int[]{7, 8, 8};
        int res = smallestRangeI(nums, 5);
        System.out.println(res);
    }

    public static int smallestRangeI(int[] A, int K) {
        Arrays.sort(A);
        int mid = (A[0] + A[A.length - 1]) / 2;
        for (int i = 0; i < A.length; i++) {
            int des = A[i] - mid;
            if (des <= 0) {
                A[i] = Math.abs(des) > K ? A[i] + K : mid;
            } else {
                A[i] = Math.abs(des) > K ? A[i] - K : mid;
            }
        }
        Arrays.sort(A);
        return A[A.length - 1] - A[0];
    }
}

