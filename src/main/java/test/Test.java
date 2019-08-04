package test;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Predicate;

public class Test {

    public static void main(String[] args) throws IOException {

        Set<BigDecimal> treeSet = new TreeSet<>();
        treeSet.add(new BigDecimal("1.0"));
        treeSet.add(new BigDecimal("1.00"));

        Set<BigDecimal> hashSet = new HashSet<>();
        hashSet.add(new BigDecimal("1.0"));
        hashSet.add(new BigDecimal("1.00"));

        //最后treeSet中只有一个，而hashSet有两个
        treeSet.forEach(System.out::println);
        System.out.println("=====");
        hashSet.forEach(System.out::println);

        //由于二进制表达小数的机制，浮点数无法精确表达，结果是10.000002，
        //因为有一些十进制小数，无法被表达为二进制数，比如0.1，只能无限去逼近这个数
        f1();

    }

    private static void f1(){
        float f = 0f;
        for (int i = 0; i < 100; i++) {
            f += 0.1;
        }
        System.out.println(f);
    }
}




