package com.jaecoding.keep.coding.domain.dto.superbuilder;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jaecoding.keep.coding.domain.dto.jackson.Child1;
import lombok.SneakyThrows;

public class Test {
    @SneakyThrows
    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        String json = "{\"parentName\":\"fatherName\",\"parentAge\":0,\"childName\":\"3123\",\"childAge\":15}";
        Child child1 = mapper.readValue(json, Child.class);
        System.out.println(mapper.writeValueAsString(child1));
        System.out.println(child1.getParentName());
    }
}
