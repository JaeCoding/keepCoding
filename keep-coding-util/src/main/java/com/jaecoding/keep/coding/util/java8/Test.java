package com.jaecoding.keep.coding.util.java8;

import java.io.BufferedReader;
import java.io.File;


import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static java.util.Comparator.comparing;

public class Test {


    public static void main(String[] args) {


        File[] hiddenFiles = new File(".").listFiles(File::isHidden);

        List<Apple> inventory = new ArrayList<>();
        filterApples(inventory, (Apple a) -> a.getWeight() > 150);
        filterApples(inventory, (Apple a) -> a.getWeight() > 150);

        process(() -> System.out.print("a"));
        inventory.stream()
                .sorted(comparing(Apple::getWeight));
    }

    public static void process(Runnable r) {
    }


    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            //关键部分
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static boolean isGreedApple(Apple apple) {
        return "green".equals(apple.getColor());
    }


    public static String processFile() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            return br.readLine();
        }
    }

}




