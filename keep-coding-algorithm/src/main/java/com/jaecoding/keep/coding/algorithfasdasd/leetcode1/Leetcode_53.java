package com.jaecoding.keep.coding.algorithfasdasd.leetcode1;

/**
 * 给定一个整数数组 nums ，找到一个具有 最大和的  连续!!连续~子数组（ 子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 * <p>
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * <p>
 * 解法一：暴力枚举
 * <p>
 * 解法二：分治递归
 * <p>
 * 解法三：kadane算法，动态规划
 */
public class Leetcode_53 {
    public static void main(String[] args) {
    }

    /**
     * 分治递归  将数组分为两部分，当前数组的 最大子序列 要么在左半边，要么在右半边，要么在中间。
     * <p>
     * 左边和右边的最大值，递归调用此方法即可求出，
     * 边界停止条件：  当数组只剩下一个元素，为当前数组 最大子序列和
     * <p>
     * 中间位置的最大值：取处于中间位置的数，先后向左 向右累加，并保存下最大值，即可获得中部的最大子序列 的和
     *
     * @return
     */
    private static int maxSubArray(int[] nums, int left, int right) {
        if (left >= right) {
            return nums[left];
        }
        int mid = (left + right) / 2;
        int lmax = maxSubArray(nums, left, mid - 1);
        int rmax = maxSubArray(nums, mid + 1, right);
        int mmax = nums[mid];
        int temp = mmax;
        for (int i = mid - 1; i >= left; i--) {
            temp += nums[i];
            mmax = Math.max(temp, mmax);
        }
        /**
         * {-2,1,-3,4,-1,2,1,-5,400}  temp=3,是从4，-1开始的，并不是从-1开始，所以让temp = mmax而不是nums[mid]
         */
        temp = mmax;
        for (int i = mid + 1; i <= right; i++) {
            temp += nums[i];
            mmax = Math.max(temp, mmax);
        }
        int max = Math.max(lmax, Math.max(rmax, mmax));
        return max;
    }

    /**
     * 复杂度为O(n) kadane算法 利用了数学归纳法和动态规划
     * <p>
     * 第一个数 开始，随着数组的扩充，可以轻易的求出 任意一个数组 的最大子列和，先求1，再求2，最后根据i求到i+1.
     * ---------------------------------------------------------------------
     * maxSum 必然是以nums[i]结尾的某段构成的，也就是说maxSum的candidate必然是以nums[i]结果的。如果遍历每个candidate，然后进行比较，那么就能找到最大的maxSum了。
     * <p>
     * 把nums[i]之前的连续段叫做sum。可以很容易想到:
     * <p>
     * 1. 如果sum>=0， 就可以和nums[i]拼接在一起构成新的sum。 因为不管nums[i]多大，加上一个正数(sum)总会更大，这样形成一个新的candidate。
     * <p>
     * 2.反之，如果sum<0，就没必要和nums[i]拼接在一起了。因为不管nums[i]多小，加上一个负数(sum)总会更小。
     * 此时由于题目要求数组连续，所以没法保留原sum，所以只能让sum等于从nums[i] 重新开始的新的一段数了，这一段数字形成新的candidate。
     * <p>
     * 3. 如果每次得到新的candidate都和 全局的maxSum进行比较，那么必然能找到最大的max sum subarray.
     * <p>
     * 总结
     */
    public static int maxSum(int[] nums) {
        int thisSum = 0; //sum为单纯的累加和，逐数添加。
        int maxSum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (thisSum > 0) { //若sum>0，则让其加上num[i],
                thisSum += nums[i];
            } else { //若sum<= 0,则舍弃，让新的sum等于num[i]
                thisSum = nums[i];
            }
            if (thisSum > maxSum) {
                maxSum = thisSum; //用maxSum记录历史最大的值。从nums[0]到nums[n-1]一步一步地进行
            }
        }
        return maxSum;
    }

    public int maxSubArray(int[] nums) {
        return maxSubArray(nums, 0, nums.length - 1);
    }

}

