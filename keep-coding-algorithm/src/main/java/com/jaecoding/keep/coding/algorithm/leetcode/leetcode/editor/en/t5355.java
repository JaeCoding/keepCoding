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
public class t5355 {
    public double frogPosition(int n, int[][] edges, int t, int target) {
        if (edges == null || edges.length == 0) {
            return 0;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            List<Integer> orDefault = map.getOrDefault(from, new ArrayList<>());
            orDefault.add(to);
            map.put(from, orDefault);

            List<Integer> orDefault2 = map.getOrDefault(to, new ArrayList<>());
            orDefault2.add(from);
            map.put(to, orDefault2);
        }

        // 找到路径
        return dfs(map, 1, 0, target, t);

    }

    double dfs(Map<Integer, List<Integer>> map, int cur, int from, int target, int step) {
        List<Integer> nextList = map.get(cur);

        // if step equals 0, or reach the leafNode, should look whether reach target
        // from != 0 to solve  "1-2" at 1 mean start
        if (step == 0 || (nextList.size() == 1 && from != 0)) {
            return cur == target ? 1 : 0;
        }

        // only in 1 can jump to each other, otherwise can jump back
        int choose = from == 0 ? nextList.size() : nextList.size() - 1;
        double pNext = (double) 1 / choose;

        double maxPNext = 0;
        for (Integer next : nextList) {
            if (next == from) {
                continue;
            }
            maxPNext = Math.max(maxPNext, dfs(map, next, cur, target, step - 1));
        }
        return pNext * maxPNext;
    }

    public static void main(String[] args) {

        int[][] a = {{1,2},{1,3},{1,7},{2,4},{2,6},{3,5}};
        int[][] b = {{2,1},{3,2}};
        int[][] c = {{2,1},{3,2},{4,1},{5,1},{6,4},{7,1},{8,7}};

//        new t5355().frogPosition(7, a, 2, 4);
        new t5355().frogPosition(3, b, 1, 2);
//        new t5355().frogPosition(8, c, 7, 7);
    }

}
