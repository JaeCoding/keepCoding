package leetcode;

import design.structure.decorator.Stream;

import java.util.Arrays;

public class Leetcode_58 {
    public int lengthOfLastWord(String s) {
        String[] strings = s.split("\\s+");
//        Arrays.asList(strings).forEach(System.out::println);
        return strings.length == 0 ? 0 : strings[strings.length - 1].length();
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode_58().lengthOfLastWord(" as s    134   1 "));
    }
}

