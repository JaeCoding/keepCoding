package java8;

/**
 * @author Jae
 */
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