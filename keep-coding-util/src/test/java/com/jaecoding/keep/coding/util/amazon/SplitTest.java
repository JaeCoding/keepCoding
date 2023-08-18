package com.jaecoding.keep.coding.util.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitTest {

    public static void main(String[] args) {
//        String string = "the official harry potter baking book: 40+ recipes inspired by the films";
        String string = "Wizarding World Harry Potter, 13-inch Hermione Granger Patronus Spell Wand with Otter Figure, Lights and Sounds, Kids Toys for Ages 6 and up";
        List<String> list = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\s+|\\p{Punct}");

        Matcher matcher = pattern.matcher(string);
        int index = 0;
        while (matcher.find()) {
            String match = matcher.group();
            if (index != matcher.start()) {
                String word = string.substring(index, matcher.start());
                list.add(word);
            }
            list.add(match);
            index = matcher.end();
        }
        if (index < string.length()) {
            String word = string.substring(index);
            list.add(word);
        }
//        System.out.println(list);

        for (int i = 0; i < list.size(); i++) {
            String element = list.get(i);
            System.out.println("Element " + i + ": " + element);
        }
    }
}
