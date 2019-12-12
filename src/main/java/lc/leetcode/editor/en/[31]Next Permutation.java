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



//leetcode submit region begin(Prohibit modification and deletion)
class Solution_31 {
    public static void main(String[] args) {
        new Solution_31().nextPermutation(new int[]{1,3,2});

    }

    public void nextPermutation(int[] nums) {

        int left = nums.length - 2;
        int right = nums.length - 1;
        while (left >= 0) {
            if (nums[left] < nums[right]) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                return;
            } else {
                left--;
                right--;
            }
        }
        // sort

    }
}
//leetcode submit region end(Prohibit modification and deletion)
