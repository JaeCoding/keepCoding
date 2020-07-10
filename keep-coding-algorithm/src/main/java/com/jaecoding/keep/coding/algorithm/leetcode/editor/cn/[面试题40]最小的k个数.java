package com.jaecoding.keep.coding.algorithm.leetcode.editor.cn;//English description is not available for the problem. Please switch to Chinese
//. Related Topics 堆 分治算法


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {

        if (k > arr.length) {
            return arr;
        }

        // 堆的构造, 构造一个K大的堆，从K/2 分支节点开始构造下沉
        for (int i = Math.max(0, k / 2 - 1); i >= 0; i--) {
            sink(arr, i, k-1);
        }

        for (int i = k; i < arr.length; i++) {
            if (arr[i] < arr[0]) {
                swap(arr, i, 0);
                sink(arr, 0, k-1);
            }
        }

        return Arrays.copyOfRange(arr, 0, k);
    }

    private void sink(int[] arr, int now, int len) {
        // 只要还有子节点
        while (2 * now < len) {
            // 左子节点
            int left = 2 * now + 1;
            if (left < len && arr[left] < arr[left + 1]) {
                // 如果left < len，说明右节点在范围内，并且左<右，则选择右来交换。目标是找大数
                left++;
            }
            if (arr[now] >= arr[left]) {
                break;
            }
            swap(arr, now, left);
            now = left;
        }
    }

    private void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[j] ^ arr[i];
        arr[i] = arr[i] ^ arr[j];
    }


    public static void main(String[] args) {
        int[] a = new int[]{0,1,1,2,4,4,1,3,3,2};
        int[] ints = new Solution().getLeastNumbers(a, 6);
        System.out.println(ints.toString());
    }

}
//leetcode submit region end(Prohibit modification and deletion)
