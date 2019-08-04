package leetcode;

public class Leetcode5 {

    /**
     * 中心扩展法：时间复杂度O(n^2)
     */
    public String longestPalindrome(String s) {
        StringBuffer sb = new StringBuffer(" ");
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            sb.append(" ");
        }
        int maxi = 1, maxlen = 0;
        int length = sb.length();
        for (int i = 1; i < length; i++) {
            if (i >= length - 1 - maxlen) break;
            int len = 1;
            while (i - len >= 0 && i + len < sb.length()) {
                if (sb.charAt(i - len) != sb.charAt(i + len)) {
                    break;
                }
                len++;
            }
            len--;
            if (len > maxlen) {
                maxi = i;
                maxlen = len;
            }
        }
        return s.substring((maxi - maxlen) / 2, (maxi + maxlen) / 2);
    }

    /**
     * 动态规划
     * dp[i][j]表示i到j的子串
     * 1.i=j,dp[i][j] = true;
     * 2.i+1=j 相邻， dp[i][j] = s.i == s.j
     * 3. 相隔 dp[i][j] 为 s.i == s.j && dpM(i+1,j-1)
     *
     */
    public String longestPalindrome2(String s) {
        int len = s.length();
        if (len == 0 || len == 1) return s;
        boolean[][] dp = new boolean[len][len];
        int maxLen = 0;
        int maxi = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                if (i > j) {
                    continue;
                } else {
                    dp[i][j] = dpM(s, dp, i, j);
                    if (dp[i][j] && j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        maxi = i;
                    }
                }
            }
        }
        return s.substring(maxi, maxi + maxLen);
    }
    public boolean dpM(String s, boolean[][] dp, int i, int j) {
        if (i == j) {
            return true;
        } else if (j == i + 1) {
            return s.charAt(i) == s.charAt(j);
        } else {
            return s.charAt(i) == s.charAt(j) && dpM(s, dp, i + 1, j - 1);
        }
    }


    public static void main(String[] args) {
        String s = new Leetcode5().longestPalindrome2("abcdd");
        System.out.println(s);
    }
}

