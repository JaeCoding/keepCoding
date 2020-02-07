package com.jaecoding.keep.coding.algorithfasdasd.leetcode1;


import java.util.ArrayList;
import java.util.List;

/**
 * 全排列 ！ 不带重复数字的
 * <p>
 * 给定一个  没有重复数字 的序列，返回其所有可能的全排列。
 * 没有重复数字 没有重复数字 没有重复数字
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class Leetcode_46 {
    public static void main(String[] args) {
        final int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> lists = permute(nums);
        //用了用lambda还挺爽的
        lists.forEach(list -> {
            list.forEach(num -> {
                System.out.print(num + " ");
            });
            System.out.println();
        });
    }

    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> arrayList = new ArrayList<>();//大集合
        List<Integer> temp = new ArrayList<>();//内部小集合
        boolean[] visited = new boolean[nums.length];
        dfs(arrayList, temp, visited, nums, 0);
        return arrayList;
    }

    /**
     * @param visited 访问数组 表示此点是否已经添加 到了 temp 中
     * @param nums
     * @param start
     */
    private static void dfs(List<List<Integer>> arrayList, List<Integer> temp, boolean[] visited, int[] nums, int start) {
        if (temp.size() >= nums.length) {
            arrayList.add(new ArrayList<Integer>(temp));
            return;
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!visited[i]) {
                    temp.add(nums[i]);
                    visited[i] = true;
                    dfs(arrayList, temp, visited, nums, i + 1);
                    temp.remove(temp.size() - 1);
                    visited[i] = false;
                }
            }
        }
    }


}

