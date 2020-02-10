package com.jaecoding.keep.coding.algorithm.leetcode1;

public class Leetcode_4_3 {


    public double findKSortedArrays(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        if (m > n) {
            return findKSortedArrays(nums2, nums1, k);
        }
        if (m == 0) {
            return nums2[k - 1];
        }
        if (m + n == k) {
            return Math.max(nums1[m - 1], nums2[n - 1]);
        }
        int i = m / 2;
        while (true) {
            int j = k - i;
            //边界情况
            if (i < m && j > 0 && nums2[j - 1] > nums1[i]) {
                i++;
            } else if (i > 0 && j < n && nums1[i - 1] > nums2[j]) {
                i--;
            } else {
                if (i == 0) {
                    return nums2[j - 1];
                } else if (j == 0) {
                    return nums1[i - 1];
                } else {
                    return Math.max(nums1[i - 1], nums2[j - 1]);
                }
            }
        }
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double d1 = findKSortedArrays(nums1, nums2, (nums1.length + nums2.length + 1) / 2);
        double d2 = findKSortedArrays(nums1, nums2, (nums1.length + nums2.length + 2) / 2);
        return (d1 + d2) / 2.0;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1};
        int[] b = new int[]{1};
        double d = new Leetcode_4_3().findMedianSortedArrays(a, b);
//        double d1 = new Leetcode_4_3().findKSortedArrays(a, b,4);
        System.out.println(d);
    }
}

