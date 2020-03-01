package com.jaecoding.keep.coding.algorithm.leetcode.leetcode.editor.en;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 5345. 通过投票对团队排名
 *
 * @author Jae
 * @date 2020/3/1
 * @since 1.8
 */
public class a5345 {
    public String rankTeams(String[] votes) {

        if (votes.length == 1) {
            return votes[0];
        }
        StringBuilder sb = new StringBuilder();
        Map<Character, int[]> map = new HashMap<>();
        // i 是投票人
        for (String vote : votes) {
            // j 是投票位置
            for (int j = 0; j < vote.length(); j++) {
                char c = vote.charAt(j);
                int[] ints = map.getOrDefault(c, new int[vote.length()]);
                // 计数
                ints[j]++;
                map.put(c, ints);
            }
        }
        // 排序
        map.entrySet().stream()
                .sorted((o1,o2) -> {
                    int[] rank1 = o1.getValue();
                    int[] rank2 = o2.getValue();
                    for (int i = 0; i < rank1.length; i++) {
                        if (rank1[i] > rank2[i]) {
                            // 默认是升序，但是我们要把大的排前面，所以改成-1，表示更小
                            return -1;
                        } else if (rank1[i] < rank2[i]) {
                            return 1;
                        }
                    }
                    // 默认是升序，但是我们要把大的排前面，所以用小的减去大的
                    return o1.getKey() - o2.getKey();
                })
                .forEach(characterEntry -> {
                    sb.append(characterEntry.getKey());
                });
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = new a5345().rankTeams(new String[]{"BCA","CAB","CBA","ABC","ACB","BAC"});
        System.out.println(s);

    }
}
