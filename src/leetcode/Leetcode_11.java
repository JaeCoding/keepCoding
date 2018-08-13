package leetcode;

public class Leetcode_11 {

    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;//双指针，短边影响到了盛水高度，所以我们舍去短边
        int area = Math.min(height[left], height[right]) * (right - left);//起始点左右面积

        while (left < right) {

            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
            area = Math.max(area, Math.min(height[left], height[right]) * (right - left));//只取大者哟
        }
        return area;

    }


    public static void main(String[] args) {
        int[] height = {1,2,1};
        int st = maxArea(height);
        System.out.println(st);
    }


}
