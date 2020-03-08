package com.jaecoding.keep.coding.algorithm.leetcode.leetcode.editor.en;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author Jae
 * @date 2020/3/8
 * @since 1.8
 */
public class t5354 {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> nextMap = new HashMap<>();
        Map<Integer, List<Integer>> infoMap = new HashMap<>();

        for (int i = 0; i < manager.length; i++) {
            List<Integer> orDefault = nextMap.getOrDefault(manager[i], new ArrayList<>());
            orDefault.add(i);
            nextMap.put(manager[i], orDefault);
        }
        return dfs(headID, informTime, nextMap);

    }

    public int dfs(Integer curId, int[] informTime, Map<Integer, List<Integer>> nextMap) {

        List<Integer> nextList = nextMap.get(curId);
        if (nextList == null) {
            return 0;
        }

        int now = informTime[curId];
        int nextMax = 0;
        // 下属中最耗时的
        for (int i = 0; i < nextList.size(); i++) {
            nextMax = Math.max(nextMax, dfs(nextList.get(i), informTime, nextMap));
        }
        return now + nextMax;
    }

    public static void main(String[] args) {
        int a = new t5354().numOfMinutes(4, 2, new int[]{3,3,-1,2}, new int[]{0,0,162,914});
        System.out.println(a);
    }
}
