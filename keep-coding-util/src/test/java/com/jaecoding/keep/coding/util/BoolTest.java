package com.jaecoding.keep.coding.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * BoolTest
 *
 * @author pengwenjie3
 * @date 2020/3/3
 * @since 1.8
 */
public class BoolTest {
    public static List<Integer> findIndices(String stringA, String stringB) {
        List<Integer> indices = new ArrayList<>();
        int index = 0;

        while (index != -1) {
            index = stringA.indexOf(stringB, index);

            if (index != -1) {
                indices.add(index);
                index += stringB.length();
            }
        }

        return indices;
    }

    public static void main(String[] args) {
        String stringA = "Hello world, hello Java, hello Java world!";
        String stringB = "hello";

        List<Integer> indices = findIndices(stringA, stringB);

        System.out.println("Indices of '" + stringB + "' in '" + stringA + "': " + indices);
    }
}
