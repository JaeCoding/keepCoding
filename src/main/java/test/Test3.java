package test;

import java.util.Arrays;
import java.util.List;

/**
 * @author: 彭文杰
 * @create: 2018-09-11 17:24
 **/
public class Test3 {
    public static void main(String[] args) {
        List list = Arrays.asList(1,2,3);
        list.forEach(System.out::println);
        methond(list);
        list.forEach(System.out::println);

        int x = 3;
        methond2(x);
        System.out.println(x);
    }

    private static void methond(List list) {
        list.set(2, 4);
    }

    private static void methond2(int a) {
        a -= 1;
    }
}
