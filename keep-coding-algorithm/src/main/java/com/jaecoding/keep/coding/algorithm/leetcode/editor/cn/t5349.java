package com.jaecoding.keep.coding.algorithm.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

/**
 * TODO
 *
 * @author Jae
 * @date 2020/3/21
 * @since 1.8
 */
public class t5349 {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        Arrays.sort(reservedSeats, (o1,o2) -> {
            if (o1[0] > o2[0]) {
                return 1;
            } else if (o1[0] < o2[0]) {
                return -1;
            } else {
                return Integer.compare(o1[1], o2[1]);
            }
        });
        int result = 0;
        int last = 0;
        boolean[] call = new boolean[11];
        for (int i = 0, reservedSeatsLength = reservedSeats.length; i < reservedSeatsLength; i++) {
            int[] seat = reservedSeats[i];
            // 空行了
            int row = seat[0];
            int col = seat[1];
            if (row > last+1) {
                result += (row - last - 1) * 2;
                last = row;
            }
            // 下一个还是此行
            if (i != reservedSeats.length - 1 && row == reservedSeats[i + 1][0]) {
                call[col] = true;
            } else {
                call[col] = true;
                for (int i1 = 1; i1 < 8; i1++) {
                    if (i1 == 2 || i1 == 4 || i1 == 6) {
                        if (!call[i1] && !call[i1 + 1] && !call[i1 + 2] && !call[i1 + 3]) {
                            call[i1 + 2] = true;
                            result++;
                        }
                    }
                    call[i1] = false;
                }
                for (int i1 = 0; i1 < call.length; i1++) {
                    call[i1] = false;
                }
                last = row;
            }
        }
        result += (n - last) * 2;
        return result;
    }

    public static void main(String[] args) {
        new t5349().maxNumberOfFamilies(3, new int[][]{{1,2},{1,3},{1,8},{2,6},{3,1},{3,10}});
//        new t5349().maxNumberOfFamilies(2, new int[][]{{2,1},{1,8},{2,6}});
    }
}
