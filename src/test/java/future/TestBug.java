package future;

import java.util.Arrays;
import java.util.List;

/**
 * TODO
 *
 * @author pengwenjie3
 * @date 2019/10/31
 * @since 1.8
 */
public class TestBug {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(3, 9, 7, 6, 10, 20);
        integers.forEach(i -> System.out.println(50 / i));
    }
}
