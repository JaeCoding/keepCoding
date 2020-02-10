package com.jaecoding.keep.coding.algorithm.leetcode.leetcode.editor.en;
//The set [1,2,3,...,n] contains a total of n! unique permutations. 
//
// By listing and labeling all of the permutations in order, we get the followin
//g sequence for n = 3: 
//
// 
// "123" 
// "132" 
// "213" 
// "231" 
// "312" 
// "321" 
// 
//
// Given n and k, return the kth permutation sequence. 
//
// Note: 
//
// 
// Given n will be between 1 and 9 inclusive. 
// Given k will be between 1 and n! inclusive. 
// 
//
// Example 1: 
//
// 
//Input: n = 3, k = 3
//Output: "213"
// 
//
// Example 2: 
//
// 
//Input: n = 4, k = 9
//Output: "2314"
// 
// Related Topics Math Backtracking




//leetcode submit region begin(Prohibit modification and deletion)
class Solution_60 {
    public String getPermutation(int n, int k) {

        //
        StringBuilder result = new StringBuilder();


        // 0 is not use
        int[] arrays = new int[n + 1];
        for (int i = 0; i < arrays.length; i++) {
            arrays[i] = i;
        }

        backTrack(n, k, result, arrays, 0);

        return result.toString();
        
    }

    private int backTrack(int n, int k, StringBuilder result, int[] arrays, int now) {

        if (result.length() == n) {
            // add the number of permutation position
            return now + 1;
        } else {
            // start in 1
            for (int i = 1; i < n + 1; i++) {
                // -1 means the element has been used
                if (arrays[i] == -1) {
                    continue;
                }
                result.append(arrays[i]);
                arrays[i] = -1;
                now = backTrack(n, k, result, arrays, now);
                if (now == k) {
                    // stop condition in all
                    return now;
                }
                result.delete(result.length() - 1, result.length());
                arrays[i] = i;
            }
        }
        return now;
    }

    public static void main(String[] args) {

        new Solution_60().getPermutation(3, 2);

    }

}

class Solution_60_2 {
    public String getPermutation(int n, int k) {


        int[] factorial = factorial(n);
        boolean[] visited = new boolean[n];

        String s = recursive(n, k, factorial, visited);
        return s;
    }

    private String recursive(int n, int k, int[] factorial, boolean[] visited) {

        int groupNums = factorial[n - 1];

        // n! = n * (n-1)!   n! has n group, each group contains (n-1)! element
        // first find group that kth in, and offset in this group
        int offset = k % groupNums;
        // if offset is 0, means is last one, not to add 1 to index(eg,  n=3, k=2, fac[n-1]=fac[2]=2, is in group1, offset=0)
        int groupIndex = k / groupNums + (offset > 0 ? 1 : 0);

        // find the visited[groupIndex] and it not visited, and it should be append to result
        int i = 0;
        for (; i < visited.length; i++) {
            if (!visited[i]) {
                groupIndex--;
                if (groupIndex == 0) {
                    visited[i] = true;
                    i = i+1;
                    break;
                }
            }
        }

        if (n == 1) {
            return String.valueOf(i);
        } else {
            int nextK = offset == 0 ? groupNums : offset;
            return i + recursive(n - 1, nextK, factorial, visited);
        }
    }

    private int[] factorial(int n) {
        int[] factArray = new int[n];
        factArray[0] = 1;
        int fac = 1;
        for (int i = 1; i < n; i++) {
            fac *= i;
            factArray[i] = fac;
        }
        return factArray;
    }


    public static void main(String[] args) {

        new Solution_60_2().getPermutation(3, 2);

    }

}

//leetcode submit region end(Prohibit modification and deletion)
