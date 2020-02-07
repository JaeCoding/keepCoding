package com.jaecoding.keep.coding.util.java8;

import lombok.Data;

/**
 * @author Jae
 */
@Data
public class Apple {
    private int weight;
    private String color;

    public <T> Apple(int weight) {
        this.weight = weight;
    }

    public <T> Apple(String color, int weight) {
        this.color = color;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }
}
