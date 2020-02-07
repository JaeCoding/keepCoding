package com.jaecoding.keep.coding.util.design.behavior.strategy;

public class IsAllLowerCase implements ValidationStrategy {
    @Override
    public boolean execute(String s) {
        return s.matches("[a-z]+");
    }

    public void a(int a) {

    }
}
