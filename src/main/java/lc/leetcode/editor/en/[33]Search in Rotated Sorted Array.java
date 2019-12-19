package lc.leetcode.editor.en;
//Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
//
// (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]). 
//
// You are given a target value to search. If found in the array return its index, otherwise return -1. 
//
// You may assume no duplicate exists in the array. 
//
// Your algorithm's runtime complexity must be in the order of O(log n). 
//
// Example 1: 
//
// 
//Input: nums = [4,5,6,7,0,1,2], target = 0
//Output: 4
// 
//
// Example 2: 
//
// 
//Input: nums = [4,5,6,7,0,1,2], target = 3
//Output: -1 
// Related Topics Array Binary Search



//leetcode submit region begin(Prohibit modification and deletion)
class Solution_33 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left;
        if (nums[0] <= nums[nums.length - 1]) {
            // binary search
            return binarySearch(nums, 0, nums.length - 1, target);
        }
        int rotated = findRotated(nums, 0, nums.length - 1);
        if (target >= nums[0]) {
            return binarySearch(nums, 0, rotated - 1, target);
        } else {
            return binarySearch(nums, rotated, nums.length - 1, target);
        }
    }

    private int binarySearch(int[] nums, int left, int right, int target) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (nums[mid] > target) {
            return binarySearch(nums, left, mid - 1, target);
        } else if (nums[mid] < target) {
            return binarySearch(nums, mid + 1, right, target);
        } else {
            return mid;
        }
    }

    private int findRotated(int[] nums, int left, int right) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (left + 1 == right && nums[left] >= nums[right]) {
            return right;
        }
        // 当为偶数时偏左
        int mid = (left + right) / 2;
        if (nums[left] < nums[mid] && nums[mid] < nums[right]) {
            return left;
        } else if (nums[left] > nums[mid]) {
            return findRotated(nums, left, mid);
        } else if (nums[left] < nums[mid]){
            return findRotated(nums, mid, right);
        }
        return -1;
    }



    public static void main(String[] args) {
//        new Solution_33().findRotated(new int[]{4, 5, 6, 7, 8, 0, 1, 2}, 0, 7);
        new Solution_33().search(new int[]{1}, 0);

    }
}
//leetcode submit region end(Prohibit modification and deletion)
