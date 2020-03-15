package com.jaecoding.keep.coding.algorithm.dataStructure.twoPoint;

/**
 * 盛最多水的容器
 * <p>
 * 标签： 数组，双指针
 * <p>
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49  8-7之间
 */
public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;//双指针，短边影响到了盛水高度，所以我们在逐一比较的时候，会舍去短边
        int area = Math.min(height[left], height[right]) * (right - left);//起始点左右面积，短边 * 宽

        while (left < right) {
            //左右双指针 逐渐向中间移动
            if (height[left] <= height[right]) {//左边小，则左边移动
                left++;
            } else {
                right--;
            }
            area = Math.max(area, Math.min(height[left], height[right]) * (right - left));//保存下最大面积
        }
        return area;

    }


    public static void main(String[] args) {
        int[] height = {1, 2, 1};
        int st = maxArea(height);
        System.out.println(st);
    }


}
