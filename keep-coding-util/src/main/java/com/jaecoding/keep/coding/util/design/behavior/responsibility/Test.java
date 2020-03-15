package com.jaecoding.keep.coding.util.design.behavior.responsibility;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Test {
    public static void main(String[] args) {
        ProcessingObject<String> p1 = new HeaderTextProcessing<>();
        ProcessingObject<String> p2 = new SpellCheckerProcessing<>();

        /*
        p1持有p2，p1调用完让p2调用，直到持有null停下
         */
        p1.setSuccessor(p2);

        String result = p1.handle("Aren't labdas really sexy?!!");
        System.out.println(result);

        /*
        lambda写法
        责任链模式 看起来像 利用组合的方法 链接（构造）函数
        那么每一个函数 可以看做一个实例啊 UnaryOperator<String>  签名 T -> T
         */

        //第一个操作对象 签名 T -> T
        UnaryOperator<String> headerProcessing =
                (String text) -> "From Raoul, Mario and Alan: " + text;

        //第二个操作对象 UnaryOperator<String>和Function<String, String>签名相同  可互换
        Function<String, String> spellProcessing =
                (String text) -> text.replaceAll("labda", "lambda");

        //将两个方法结合起来，结果就是一个操作链
        Function<String, String> pipeline = headerProcessing.andThen(spellProcessing);

        String result1 = pipeline.apply("Aren't labdas really sexy?!!");
    }
}
