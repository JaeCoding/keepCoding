package sorted.dataStructure.twoPoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在K个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class KSum {
    public static void main(String[] args) {
        KSum k = new KSum();
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        int[] nums2 = new int[]{1, 0, -1, 0, -2, 2};
        int[] nums3 = new int[]{0, 0, 0, 0};

        k.KSum(nums2, 0, 4);
    }


    public List<List<Integer>> KSum(int[] nums, int sum, int k) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        if (k > nums.length) {

            return result;
        }
        int position = 0;
        result = KSum(result, temp, nums, sum, k, position);
        return result;
    }

    /**
     * @param temp
     * @param targetK  当前所找的 目标和
     * @param K        当前为K sum 每次递归K会减1
     * @param position 当前的起始index  防止重复 要求只能在nums的index之后位置查
     * @return
     */
    private List<List<Integer>> KSum(List<List<Integer>> result, List<Integer> temp, int[] nums, int targetK, int K, int position) {

        if (K == 2) {
            for (int i = position, j = nums.length - 1; i < j; ) {
                if (nums[i] + nums[j] > targetK || (j < nums.length - 1 && nums[j] == nums[j + 1])) {//重复二
                    j--;
                } else if (nums[i] + nums[j] < targetK || (i > position && nums[i] == nums[i - 1])) {//重复二
                    i++;
                } else {
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    result.add(new ArrayList<>(temp));
                    temp.remove(temp.size() - 1);
                    temp.remove(temp.size() - 1);
                    i++;
                    j--;
                }
            }
        } else {
            for (int i = position; i < nums.length - K + 1; i++) {
                int numK = nums[i];//表示倒数第K个数
                if (numK > targetK / K + 1) break;//剪枝
                if (i > position && numK == nums[i - 1]) continue;//重复一
                int targetKlow = targetK - numK;
                temp.add(numK);
                result = KSum(result, temp, nums, targetKlow, K - 1, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
        return result;
    }
}

