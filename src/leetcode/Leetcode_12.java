package leetcode;


import java.util.HashMap;

public class Leetcode_12 {

    public static String intToRoman(int num) {
        int[] base = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] str = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX",
                "V", "IV", "I"};
        StringBuilder s = new StringBuilder();
        int i = 0;//下标
        while (num > 0) {
            if (num >= base[i]) {
                s.append(str[i]);
                num -= base[i];
            } else {
                i++;
            }
        }
        return String.valueOf(s);
    }
    public static void main(String[] args) {
        System.out.println(intToRoman(1234));
    }


}
