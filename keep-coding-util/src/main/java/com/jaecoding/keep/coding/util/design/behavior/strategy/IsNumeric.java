package com.jaecoding.keep.coding.util.design.behavior.strategy;

public class IsNumeric implements ValidationStrategy {
    @Override
    public boolean execute(String s) {
        return s.matches("\\d+");
    }

    public void a(int a) {

    }
}
