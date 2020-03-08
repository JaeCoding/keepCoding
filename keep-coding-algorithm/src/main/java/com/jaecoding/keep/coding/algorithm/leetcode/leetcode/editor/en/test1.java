package com.jaecoding.keep.coding.algorithm.leetcode.leetcode.editor.en;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * TODO
 *
 * @author Jae
 * @date 2020/3/7
 * @since 1.8
 */
public class test1 {

    public String sortString(String s) {
        char[] chars = s.toCharArray();
        List<String> a = new ArrayList<>();
        for (char aChar : chars) {
            a.add(String.valueOf(aChar));
        }
        StringBuilder result = new StringBuilder();
        while (!a.isEmpty()) {
            a.stream()
                    .distinct()
                    .sorted()
                    .forEach(s1 -> {
                        a.remove(s1);
                        result.append(s1);
                    });
            System.out.println(result.toString());
            a.stream()
                    .distinct()
                    .map(Object::toString)
                    .sorted(Comparator.reverseOrder())
                    .forEach(s1 -> {
                        a.remove(s1);
                        result.append(s1);
                    });

            System.out.println(result.toString());
        }


        System.out.println(result.toString());
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println((char)('a' + 3));
//        new test1().sortString("ggggggg");
    }
}
