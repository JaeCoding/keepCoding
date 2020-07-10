package com.jaecoding.keep.coding.util.java8.flapMap;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * ApiTest
 *
 * @author pengwenjie3
 * @date 2020/4/20
 * @since 1.8
 */
public class ApiTest {


    public static void main(String[] args) {

        List<List<String>> outer = Lists.newArrayList();

        IntStream.range(1,5).forEach(i -> {
            List<String> inner = Lists.newArrayList();
            IntStream.range(1, 5).forEach(j -> {
                inner.add(String.valueOf(j));
            });
            outer.add(inner);
        });

        // 如何将outer拍扁成一层List呢
        List<String> fina = outer.stream()
                // 将List铺平的骚操作
                .flatMap(List::stream)
                .peek(System.out::println)
                .collect(Collectors.toList());
        String a = "2017-11-27T03:16:03.944Z";
        System.out.println(a.substring(0, a.length()-5).concat("Z"));

    }
}
