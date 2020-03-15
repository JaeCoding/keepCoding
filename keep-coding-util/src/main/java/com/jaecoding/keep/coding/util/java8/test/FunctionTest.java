package com.jaecoding.keep.coding.util.java8.test;

import com.jaecoding.keep.coding.util.java8.Apple;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;

public class FunctionTest {


    /**
     * 根据Function筛选list
     */
    public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for (T s : list) {
            result.add(f.apply(s));
        }
        return result;
    }


    public static <T> void consumerTest(List<T> list, Consumer<T> c) {
        for (T s : list) {
            c.accept(s);
        }
    }

    /**
     * 根据list重量，构造带list重量的Apple List
     * 一个参数的构造函数  使用Function<T, R>接口
     *
     * @return
     */
    public static List<Apple> mapApple(List<Integer> list,
                                       Function<Integer, Apple> f) {
        List<Apple> result = new ArrayList<>();
        for (Integer e : list) {
            //f.apply(e) 下方就是Apple::new，并且隐含用了e，Function签名是 T -> R
            result.add(f.apply(e));
        }
        return result;
    }

    /**
     * @param map 带 重量 和 颜色 的apple List
     * @param bf
     * @return
     */
    public static List<Apple> mapApple(Map<String, Integer> map,
                                       BiFunction<String, Integer, Apple> bf) {
        List<Apple> result = new ArrayList<>();
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            result.add(bf.apply(e.getKey(), e.getValue()));
        }
        return result;
    }

    public static void main(String[] args) {

        // map方法的 使用[7, 2, 6]
        List<Integer> l = map(
                Arrays.asList("lambdas", "in", "action"),
                String::length
        );

        //consumer
        consumerTest(
                Arrays.asList("lambdas", "in", "action"),
                System.out::println
        );

        //函数式接口的一个实例  test<T,R>   签名是   T -> R  以及如何添加异常
        Function<BufferedReader, String> f = (BufferedReader b) -> {
            try {
                return b.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };

        /*
          特殊的void兼容规则,boolean居然可以接收void
         */
        List<String> list = new ArrayList<>();
        Predicate<String> p = list::add;
        //方法引用,左边是 实例 右边是与实例相关的方法。
        //省略掉s可行吗？ 这个消费者函数式接口，表示对于每个参数s，都调用list的add
        Consumer<String> b = s -> list.add(s);
        Consumer<String> c = list::add;


        List<Apple> inventory = new ArrayList<>();
        //这俩哪个好点？
        inventory.sort(comparingInt(Apple::getWeight));
        inventory.sort(comparing(Apple::getWeight));

        /*
        mapApple的使用
         */
        List<Integer> weights = Arrays.asList(7, 3, 4, 10);
        //行为是创建Apple
        List<Apple> apples = mapApple(weights, Apple::new);


        BiFunction<String, Integer, Apple> c3 = Apple::new;
        Apple a3 = c3.apply("green", 110);
    }


}
