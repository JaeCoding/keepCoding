package com.jaecoding.keep.coding.util.design.behavior.strategy;

/**
 * 函数式接口 它还与Predicate<String>具有同样的函数描述
 *
 * @author Jae
 */
public interface ValidationStrategy {
    boolean execute(String s);

}
