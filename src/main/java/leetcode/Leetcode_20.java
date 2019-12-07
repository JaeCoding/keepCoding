package leetcode;

import scala.math.Ordering;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Leetcode_20 {
    public static void main(Ordering.String[] args) {

    }

    public boolean isValid(String s) {

        HashMap<Character, Character> map = new HashMap<>();
        map.put(']', '[');
        map.put(')', '(');
        map.put('}', '{');
        if (null == s || s.length() == 0) {
            return true;
        } else if (s.length() == 1 || map.containsKey(s.charAt(0))) {
            return false;
        }

        // use a stack
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char chars = s.charAt(i);
            if (chars == '(' || chars == '[' || chars == '{') {
                list.push(chars);
            } else if (map.containsKey(chars) && !list.isEmpty()) {
                // when meet '}' ']' ')' , check if the list is empty,
                if (!list.pop().equals(map.get(chars))) {
                    return false;
                }
            } else {
                return false;
            }
        }
        // when loop end, check if the stack is empty
        return list.isEmpty();
    }
}

