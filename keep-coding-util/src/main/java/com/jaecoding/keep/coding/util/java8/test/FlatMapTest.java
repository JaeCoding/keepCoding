package com.jaecoding.keep.coding.util.java8.test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

public class FlatMapTest {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> powlist =
                list.stream()
                        .map(num -> num * num)
                        .collect(toList());


        List<Integer> list1 = Arrays.asList(1, 2, 3);

        List<Integer> list2 = Arrays.asList(3, 4);

        List<Integer[]> list3 =
                list1.stream()
                        .flatMap(i -> list2.stream()
                                .map(j -> new Integer[]{i, j}))
                        .collect(toList());

        List<Integer[]> list4 =
                list1.stream()
                        .flatMap(i -> list2.stream()
                                .map(j -> new Integer[]{i, j})
                                //为什么筛选要放在里面，而不能再放flatMap后面
                                .filter(arr -> (arr[0] + arr[1]) % 3 == 0))
                        .collect(toList());

        list4.forEach(nums -> Arrays.stream(nums).forEach(System.out::println));


        //reduce的使用，第一个参数是包含在list的吗:结论，不包含，但是需要添加。比如乘法就要输入1，加法为0
        List<Integer> list5 = Arrays.asList(2, 3, 4);
        int product = list5.stream().reduce(0, (a, b) -> a * b);
        //max，若不穿参数，则只能用Optional来承接
        int max = list5.stream().reduce(Integer.MIN_VALUE, Math::max);
        Optional<Integer> op = list5.stream().reduce(Math::max);


        System.out.println(product);
    }
}
