package com.jaecoding.keep.coding.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.util.List;
import java.util.Map;


/**
 * 杰克逊跑龙套
 *
 * @author pengwenjie3
 * @date 2020/06/02
 */
public class JsonUtil {

    /**
     * 对象映射器
     */
    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * @param src
     * @param <T>
     * @return
     */
    @SneakyThrows
    public static <T> String toJson(T src)  {
        return objectMapper.writeValueAsString(src);
    }

    /**
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    @SneakyThrows
    public static <T> T fromJson(String json, Class<T> clazz) {
        return objectMapper.readValue(json, clazz);
    }

    /**
     * @param json
     * @return
     */
    @SneakyThrows
    public static JsonNode parseObject(String json) {
        return objectMapper.readTree(json);
    }

    /**
     * 解析对象
     */
    @SneakyThrows
    public static <M, T> T parseObject(M src, Class<T> clazz) {
        return objectMapper.readValue(objectMapper.writeValueAsString(src), clazz);
    }

    /**
     * 列表转换
     *
     */
    @SneakyThrows
    public static <M, T> List<T> parseList(M src, Class<T> clazz) {
        String json = objectMapper.writeValueAsString(src);
        return objectMapper.readValue(json, new TypeReference<List<T>>(){});
    }

    /**
     * 列表转换
     *
     */
    @SneakyThrows
    public static <M, T, K> Map<T, K> parseMap(M src, Class<T> keyClazz, Class<K> valueClazz) {
        String json = objectMapper.writeValueAsString(src);
        return objectMapper.readValue(json, new TypeReference<Map<T, K>>(){});
    }

}
