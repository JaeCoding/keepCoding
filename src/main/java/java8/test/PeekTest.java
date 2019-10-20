package java8.test;

import java8.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * TODO 注释
 *
 * @author pengwenjie3
 * @date 2019/8/20
 * @since 1.8
 */
public class PeekTest {

    public static void main(String[] args) {

        ArrayList<Apple> list = new ArrayList<>();

        list.add(new Apple(10));
        list.add(new Apple(11));
        list.add(new Apple(12));
        list.forEach(System.out::println);

//        List<Apple> collect = list.stream()
//                .peek(a -> a.setWeight(a.getWeight() + 1))
//                .collect(Collectors.toList());
//        collect.forEach(System.out::println);



//
        List<Apple> collect1 = list.stream()
                .map(a -> {
                    a.setWeight(a.getWeight() + 1);
                    return a;
                })
                .collect(Collectors.toList());

        collect1.forEach(System.out::println);

        list.forEach(System.out::println);
//
//        list.forEach(System.out::println);


        List<String> stockList = Arrays.asList("GOOG", "AAPL", "MSFT", "INTC");
        List<String> stockList2 =
                stockList.stream()
                        .filter(e -> !e.contains("M"))
                        .map(String::toLowerCase)
                        .collect(Collectors.toList());
        stockList2.forEach(System.out::println);
        stockList.forEach(System.out::println);
    }
}
