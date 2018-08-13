package leetcode;

import java.util.HashMap;

public class Leetcode_325 {

    public static void main(String[] args) {
        int[] nums = {1, -1, 5, -2, 3};
        int k = 3;
        int st = maxSubArrayLen(nums, k);
        System.out.println(st);
    }

    /**
     * 先求出每个位置的从index = 0加到此位置的和，这时（和i - 和j） 就是j~i之间的subarray的和，
     * 那我们有了最大当前sum，找sum-k就好了呀
     * 因此，我们用hashmap的方法来检测target-sum1=sum2中的sum2是否存在，
     * 当遍历到sum1的时候，思路类似于two sum的hashmap方法。
     */
    public static int maxSubArrayLen(int[] nums, int k) {
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>(); //key:prefix和; value:到第几个数
        int max = 0;
        map.put(0, 0);
        for (int i = 1; i < nums.length + 1; i++) {
            sum += nums[i - 1];
            int lookingfor = sum - k;
            if (map.containsKey(lookingfor)) {
                max = Math.max(max, i - map.get(lookingfor));
            }
            if (!map.containsKey(sum))
                map.put(sum, i);
        }
        return max;
    }


}
