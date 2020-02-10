package com.jaecoding.keep.coding.algorithm.leetcode.leetcode.editor.en.helper;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * TODO
 *
 * @author Jae
 * @date 2019/12/15
 * @since 1.8
 */
public class ListNodeUtils {

    public static ListNode createNodeList(String string) {

        String[] strings = string.split(",");

        List<ListNode> collect = Arrays.stream(strings)
                .map(s -> new ListNode(Integer.parseInt(s)))
                .collect(Collectors.toList());

        IntStream.range(0, collect.size() - 1)
                .forEach(i -> collect.get(i).next = collect.get(i + 1));

        return collect.get(0);
    }

    public static void main(String[] args) {

        ListNode list = createNodeList("");

        System.out.println(list);

    }
}
