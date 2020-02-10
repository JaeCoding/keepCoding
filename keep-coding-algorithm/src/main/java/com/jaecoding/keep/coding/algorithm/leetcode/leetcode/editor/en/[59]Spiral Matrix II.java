package com.jaecoding.keep.coding.algorithm.leetcode.leetcode.editor.en;//Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
//
// Example: 
//
// 
//Input: 3
//Output:
//[
// [ 1, 2, 3 ],
// [ 8, 9, 4 ],
// [ 7, 6, 5 ]
//]
// 
// Related Topics Array



//leetcode submit region begin(Prohibit modification and deletion)
class Solution_59 {
    public static void main(String[] args) {
        new Solution_59().generateMatrix(3);
    }

    public int[][] generateMatrix(int n) {
        if (n == 1) {
            return new int[][]{{1}};
        }

        int[][] arrays = new int[n][n];

        int topLeft = 0;
        int bottomRight = n - 1;

        int num = 1;
        while (topLeft <= bottomRight) {
            num = tile(arrays, topLeft++, bottomRight--, num);
        }
        return arrays;
    }

    private int tile(int[][] arrays, int topLeft, int bottomRight, int num) {
        // boundary condition
        if (topLeft == bottomRight) {
            arrays[topLeft][bottomRight] = num++;
            return num;
        }
        for (int i = topLeft; i < bottomRight; i++) {
            arrays[topLeft][i] = num++;
        }
        for (int i = topLeft; i < bottomRight; i++) {
            arrays[i][bottomRight] = num++;
        }
        for (int i = bottomRight; i > topLeft; i--) {
            arrays[bottomRight][i] = num++;
        }
        for (int i = bottomRight; i > topLeft; i--) {
            arrays[i][topLeft] = num++;
        }
        return num;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
