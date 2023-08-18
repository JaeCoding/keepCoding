package com.jaecoding.keep.coding.domain.dto.jackson;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

public class Test {
    @SneakyThrows
    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        String json = "{\"parentName\":\"fatherName\",\"parentAge\":0,\"childName\":\"3123\",\"childAge\":15}";
        Child1 child11 = mapper.readValue(json, Child1.class);
        System.out.println(mapper.writeValueAsString(child11));
        System.out.println(child11.getParentName());
    }
}
