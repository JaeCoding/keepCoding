package lc.leetcode.editor.en;
//Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
// (permutation means to exchange)

// If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order). 
//
// The replacement must be in-place and use only constant extra memory. 
//
// Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column. 
//
// 1,2,3 → 1,3,2 
//3,2,1 → 1,2,3 
//1,1,5 → 1,5,1 
// Related Topics Array


import java.util.Arrays;

// TIPS: lexicographically means

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_31 {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3};
        new Solution_31().nextPermutation(a);

        Arrays.stream(a).forEach(System.out::println);


    }

    public void nextPermutation(int[] nums) {

        int i = nums.length - 1 ;
        while (i > 0) {
            // find first condition that nums[i-1] less than nums[i]
            // ig.: 1 8 2 7 5 3 2 2 1
            if (nums[i - 1] < nums[i]) {
                // find first number from the tail that more than nums[i]
                for (int j = nums.length - 1; j > i - 1; j--) {
                    if (nums[j] > nums[i-1]) {
                        nums[j] = nums[j] ^ nums[i-1];
                        nums[i-1] = nums[j] ^ nums[i-1];
                        nums[j] = nums[j] ^ nums[i-1];
                        break;
                    }
                }
                // sort the nums[i] to tail
                Arrays.sort(nums, i, nums.length);
                return;
            }
            i--;
        }
        // arrays in reverse condition
        Arrays.sort(nums);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
