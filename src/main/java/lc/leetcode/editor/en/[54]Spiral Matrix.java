package lc.leetcode.editor.en;
//Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
//
// Example 1: 
//
// 
//Input:
//[
// [ 1, 2, 3 ],
// [ 4, 5, 6 ],
// [ 7, 8, 9 ]
//]
//Output: [1,2,3,6,9,8,7,4,5]
// 
//
// Example 2: 
// 
//Input:
//[
//  [1, 2, 3, 4],
//  [5, 6, 7, 8],
//  [9,10,11,12]
//]
//Output: [1,2,3,4,8,12,11,10,9,5,6,7]
// Related Topics Array


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_54 {

    public static void main(String[] args) {
//        int[][] ints = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};
        int[][] ints = new int[][]{{1,2,3,4,5,6,7,8,9,10}};
        new Solution_54().spiralOrder(ints);
    }

    /**
     * matrix problem : we do not need focus on how to solution the x, y's coordinate
     * to simulate the real condition
     * we could view the problem in sub-problem
     *
     * treat the matrices are nested matrices
     */
    public List<Integer> spiralOrder(int[][] matrix) {

        if (matrix.length == 0) {
            return new ArrayList<>();
        }
        int rowC1 = 0;
        int colC1 = 0;
        int rowC2 = matrix.length - 1;
        int colC2 = matrix[0].length - 1;
        ArrayList<Integer> list = new ArrayList<>();
        while (rowC1 <= rowC2 && colC1 <= colC2) {
            loopAdd(matrix, list, rowC1++, colC1++, rowC2--, colC2--);
        }
        list.forEach(System.out::println);
        return list;

    }

    private void loopAdd(int[][] matrix, ArrayList<Integer> list, int rowC1, int colC1, int rowC2, int colC2) {
        // solve the condition that matrix is one line or one row
        if (rowC1 == rowC2) {
            /**
             * [1,3,4,6]
             */
            for (int i = colC1; i <= colC2; i++) {
                list.add(matrix[rowC1][i]);
            }
        } else if (colC1 == colC2) {
            /**
             * [ 1,
             *   2,
             *   3]
             */
            for (int i = rowC1; i <= rowC2; i++) {
                list.add(matrix[i][colC1]);
            }
        } else {
            /**
             * [1,2,3]
             * [4,5,6]
             * [7,8,9]
             * divide the loop into four identical sub-cases
             * first: 1,2  second: 3,6 third: 9,8  fourth: 7,4
             */
            for (int i = colC1; i < colC2; i++) {
                list.add(matrix[rowC1][i]);
            }
            for (int i = rowC1; i < rowC2 ; i++) {
                list.add(matrix[i][colC2]);
            }
            for (int i = colC2; i > colC1; i--) {
                list.add(matrix[rowC2][i]);
            }
            for (int i = rowC2; i > rowC1; i--) {
                list.add(matrix[i][colC1]);
            }
        }
    }

    // TODO could you add the element by ZigZag
}
//leetcode submit region end(Prohibit modification and deletion)
