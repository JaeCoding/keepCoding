package com.jaecoding.keep.coding.domain.dto.superJson;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jaecoding.keep.coding.domain.dto.jackson.Child1;
import lombok.SneakyThrows;

public class Test {
    @SneakyThrows
    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        String json = "{\"superProperty\":\"fatherName\",\"parentAge\":0,\"fieldA\":\"3123\",\"childAge\":15}";
        SubA a = mapper.readValue(json, SubA.class);
        System.out.println(mapper.writeValueAsString(a));
        System.out.println(a.getSuperProperty());
    }
}
