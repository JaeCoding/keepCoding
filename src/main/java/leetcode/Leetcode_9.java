package leetcode;

public class Leetcode_9 {

    /**
     * Determine whether an integer is a palindrome.
     * n integer is a palindrome when it reads the same backward as forward.
     * Example 1:
     *
     * Input: 121
     * Output: true
     * Example 2:
     *
     * Input: -121
     * Output: false
     */
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String s = String.valueOf(x);
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(new Leetcode_9().isPalindrome(0));
    }
}

