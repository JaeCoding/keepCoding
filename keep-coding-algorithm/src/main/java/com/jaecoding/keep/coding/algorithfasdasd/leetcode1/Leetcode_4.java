package com.jaecoding.keep.coding.algorithfasdasd.leetcode1;

public class Leetcode_4 {

    /**
     * 思路：要找第K大，就分别找两个数组的第K/2个
     *      分为1.一组找不到 2.两组都找到 两种情况（不可能两组都找不到）
     *      1.一组找不到，直接另一组指针后移K/2，找的K也减去K/2，递归找
     *      2.都找到，若第一个小，则肯定不在数组1的前K/2个数，那就去掉此部分继续递归
     *      停止边界： 指针越界（指针>=长度），说明此数组都划掉了，直接在另一个中找
     *               k=1，直接比较两指针元素，取小者

     * @return
     */
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        /* 奇偶不同情况
        寻找数组的中位数，若数组长为m，原思路要根据m是奇数还是偶数选择。
        技巧：找第(m+1)/2 与 第(m+2)/2个，然后求其平均值（奇数情况下两数相同
        */
        int m = nums1.length, n = nums2.length, left = (m + n + 1) / 2, right = (m + n + 2) / 2;
        return (findKth(nums1, 0, nums2, 0, left) + findKth(nums1, 0, nums2, 0, right)) / 2.0;
    }

    /**
     *
     * @param i 数组1初始指针位置，决定了此时参与分治的 数组长度
     * @param j 数组2初始指针位置
     * @param k 寻找第K大的
     * @return
     */
    int findKth(int[] nums1, int i, int[] nums2, int j, int k) {
        //若指针移动超过了长度，表明直接在另一个数组中寻找第j + k - 1个
        //递归的边界
        if (i >= nums1.length) return nums2[j + k - 1];
        if (j >= nums2.length) return nums1[i + k - 1];
        if (k == 1) return Math.min(nums1[i], nums2[j]);
        //分别找到两数组中，第k/2个元素，
        // 情况1：k/2超过了此时数组1长度，则第k个肯定不在数组2的前k/2个元素中（因为数组1不够用），给数组1的第k/2赋一个极大值
        // 情况2：反过来同理
        // 情况3：得到两数组的第k/2个元素，如果第一个数组的第K/2个数字小的话，那么说明我们要找的数字肯定不在nums1中的前K/2个数字，
        //       比如[1,6,9][2,3,5],找K=3,4  3的时候找1，对应1和2，1小于2，所以排除1，i+1，k-1（也就是2），继续递归
        //       也就是在[6,9][2,3,5]中找k=2
        //        所以我们可以将其淘汰，将nums1的起始位置向后移动K/2个，并且此时的K也自减去K/2(因为只怕排除前面）
        int midVal1 = (i + k / 2 - 1 < nums1.length) ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
        int midVal2 = (j + k / 2 - 1 < nums2.length) ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;
        //如果超过了此时数组1长度，则第k个肯定不在数组2的前j + k / 2个元素中
        if (midVal1 < midVal2) {
            return findKth(nums1, i + k / 2, nums2, j, k - k / 2);
        } else {
            return findKth(nums1, i, nums2, j + k / 2, k - k / 2);
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 6, 9};
        int[] b = new int[]{2, 3, 5};
        double d = new Leetcode_4().findMedianSortedArrays(a, b);
        System.out.println(d);
    }
}

