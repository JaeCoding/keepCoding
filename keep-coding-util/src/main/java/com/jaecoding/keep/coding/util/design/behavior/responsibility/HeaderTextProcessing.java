package com.jaecoding.keep.coding.util.design.behavior.responsibility;

public class HeaderTextProcessing<T> extends ProcessingObject<String> {

    @Override
    public String handleWork(String text) {
        return "From Raoul, Mario and Alan: " + text;
    }
}
