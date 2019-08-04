package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode_13 {
    public static void main(String[] args) {
        Leetcode_13 lc = new Leetcode_13();
        System.out.println(lc.romanToInt("IX"));
    }

    /**
     * 没有IIX这种情况，也就是8只能VIII
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        int num = 0;
        int index = 0;
        Map<Character, Integer> maps = new HashMap<Character, Integer>() {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};
        while (index < s.length()) {
            char c = s.charAt(index);
            if (index + 1 < s.length()) {
                if (maps.get(s.charAt(index)) >= maps.get(s.charAt(index + 1))) {
                    //前者大于等于后者，正常情况
                    num += maps.get(s.charAt(index));
                } else {
                    //前者小于后者，属于组合情况
                    num -= maps.get(s.charAt(index));
                }
            } else {
                num += maps.get(s.charAt(index));
            }
            index++;
        }
        return num;
    }
}

