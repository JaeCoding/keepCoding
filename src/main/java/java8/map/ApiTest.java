package java8.map;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * 新api测试
 *
 * @author pengwenjie3
 * @date 2019/8/18
 * @since 1.8
 */
public class ApiTest {

    public static void main(String[] args) {

        Map<String, Integer> map = oneMap();


        // 计算key及value
        Integer compute = map.compute("key:1", (k,v) -> Integer.valueOf(k.split(":")[1]) + v);
        System.out.println(compute.toString());

        // key存在则返回，不存在则按照提供函数计算，set上并返回！
        Integer integer = map.computeIfAbsent("key:100", k -> Integer.valueOf(k.split(":")[1]));
        System.out.println(integer);

        // 根据k，oldV 替换现有值（在存在的情况下）
        map.computeIfPresent("key:2", (k, v) -> Integer.valueOf(k.split(":")[1]) + 1);

        // 根据function，更新所有value
        map.replaceAll((k,oldv) -> oldv = oldv + Integer.valueOf(k.split(":")[1]));


    }



    public static HashMap<String, Integer> oneMap() {
        HashMap<String, Integer> map = new HashMap<>();

        IntStream.rangeClosed(1, 5)
                .forEach(value -> map.put("key:"+value, value));

        return map;
    }
}
