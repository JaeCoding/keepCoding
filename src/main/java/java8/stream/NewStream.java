package java8.stream;

import java8.Dish;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class NewStream {
    public static void main(String[] args) {
        test2();
    }

    /**
     * 数一数 文件中 单词的种类
     */
    public static void test1() {

        long uniqueWords = 0;
        try (Stream<String> lines =
                     //Files.lines，返回一个由指定文件中的各行构成的 字符串流
                     Files.lines(Paths.get("data.txt"), Charset.defaultCharset())) {
            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                    .distinct()
                    .count();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 斐波纳契数0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55…
     * 生成斐波纳契元组序列前20个 (1, 1), (1, 2), (2, 3), (3, 5), (5, 8), (8, 13), (13, 21)
     */
    public static void test2() {

        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(10)
                .forEach(ints -> System.out.println("(" + ints[0] + "," + ints[1] + ")"));
    }


    public enum CaloricLevel {DIET, NORMAL, FAT}

    /**
     * 测试归约
     */
    public static void test3() {

        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));
        /*
        目的：返回menu的总卡路里
        上：应用自定义收集器收集
        下：先映射成Calories流，然后reduce汇总
         */
        int totalCalories = menu.stream().collect(reducing(0,
                Dish::getCalories,
                Integer::sum));
        int totalCalories1 = menu.stream().map(Dish::getCalories).reduce(0, Integer::sum);

        /*
        groupingBy是分类函数 test<? super T, ? extends K>
         */
        Map<CaloricLevel, List<Dish>> dishesByType =
                menu.stream().collect(groupingBy(NewStream::getCaloricLevel
                ));
        /*
        测试 多级分组
         */
        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel =
                menu.stream().collect(
                        groupingBy(Dish::getType,
                                groupingBy(NewStream::getCaloricLevel)
                        )
                );

        Map<Dish.Type, Set<CaloricLevel>> caloricLevelsByType =
                menu.stream().collect(
                        //groupingBy（ 分类规则 作为key , Collector作为分类Value)
                        //也是个Map   mapping（分类规则，分类器）
                        groupingBy(Dish::getType, mapping(
                                NewStream::getCaloricLevel,
                                toCollection(HashSet::new))));
    }

    private static CaloricLevel getCaloricLevel(Dish dish) {
        if (dish.getCalories() <= 400) {
            return CaloricLevel.DIET;
        } else if (dish.getCalories() <= 700) {
            return CaloricLevel.NORMAL;
        } else {
            return CaloricLevel.FAT;
        }
    }


}
