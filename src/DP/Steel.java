package DP;

/**
 * @author: 彭文杰
 * @create: 2018-08-17 00:02
 * 钢条切割问题
 * 价格表
 * 长度： 1 2 3 4  5  6  7  8  9 10
 * 价格： 1 5 8 9 10 17 17 20 24 30
 *
 * 提供一个长度  求切割后的最大价值
 **/
public class Steel {

    public static void main(String[] args) {
        int[] values = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        System.out.println(cut(values, 2));
    }


    /**
     * 自底向上的DP  用数组保存 小问题的最优解
     * 很多很多坑
     * 坑1：提供的数组 是没有0的  但是我们求出的 最优值数组 是有0的
     *     所以在实现的时候，要注意各种 边界问题
     */
    public static int cut(int[] values, int length) {
        if (length == 0) return 0;
        int[] maxValues = new int[length + 1];//申请比length大1 的数组  保存子问题的解  也就是 当前下标长度 的最大价值
        int len = length + 1;//用于存最大值的数组 长度
        maxValues[0] = 0;
        for (int i = 1; i < len; i++) {
            int valueNow = 0;
            for (int j = 1; j < i + 1; j++) {//i + 1是因为 当j=i的时候  也要判断
                //values[j]是长度为j 不可切的 钢条价值
                //maxValues[i - j] 是 i-j 长度 可切 最大钢条价值
                //i定下为 总长度  考虑所有可切方法， 子问题从数组中取  因为是从小到大 所以一定能取到
                valueNow = Math.max(valueNow, values[j - 1] + maxValues[i - j]);//j - 1 是因为原数组没有0的位置
            }
            //保存下 当前i 的最大价值
            maxValues[i] = valueNow;
        }
        return maxValues[length];
    }


}