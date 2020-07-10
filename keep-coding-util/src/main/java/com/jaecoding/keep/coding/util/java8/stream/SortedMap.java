package com.jaecoding.keep.coding.util.java8.stream;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * SortedMap
 *
 * @author pengwenjie3
 * @date 2020/5/19
 * @since 1.8
 */
public class SortedMap {
    public static void main(String[] args) {

        Map<String, String> map = new TreeMap<>();
        map.put("1", "1");
        map.put("3", "3");
        map.put("2", "2");

        TreeMap<String, String> collect = map.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (v1, v2) -> {
                            throw new RuntimeException(String.format("Duplicate key for values %s and %s", v1, v2));
                        },
                        TreeMap::new
                ));

        String a = null;





    }
}
