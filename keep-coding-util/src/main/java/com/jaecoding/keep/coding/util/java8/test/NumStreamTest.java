package com.jaecoding.keep.coding.util.java8.test;


import com.google.common.collect.Lists;

import java.util.List;

/**
 *
 *
 * @author pengwenjie3
 * @date 2019/8/20
 * @since 1.8
 */
public class NumStreamTest {
    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList();
//        Stream.iterate(1, n -> n + 1)
//                .limit(3)
//                .forEach(i ->{
//                    list.add(i);
//                    System.out.println(i);
//                });
        for (int i = 1; i < 2; i++) {
            System.out.println(i);
        }

//        System.out.println(list.get(list.size() - 1));
    }
}
