package com.jaecoding.keep.coding.domain.dto.jackson;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.BeanDeserializerModifier;
import com.fasterxml.jackson.databind.deser.BuilderBasedDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import freemarker.template.utility.StringUtil;
import lombok.SneakyThrows;

public class TestDeserializer {
    @SneakyThrows
    public static void main(String[] args) {

        ObjectMapper mapper = getObjectMapper();


        String json = "{\"parentName\":\"fatherName\",\"childName\":\"3123\",\"childAge\":15}";
        Child1 child11 = mapper.readValue(json, Child1.class);
        System.out.println(mapper.writeValueAsString(child11));
        System.out.println(child11.getParentName());
    }



    private static ObjectMapper getObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        ItemDeserializer<Parent1> deserializer = new ItemDeserializer<>(Parent1.class);

        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addDeserializer(Parent1.class, deserializer);

        mapper.registerModule(simpleModule);
        return mapper;

    }

    private static ObjectMapper getObjectMapper2() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        SimpleModule module = new SimpleModule();
        module.setDeserializerModifier(new BeanDeserializerModifier() {
            @Override
            public JsonDeserializer<?> modifyDeserializer(DeserializationConfig config,
                                                          BeanDescription beanDesc,
                                                          JsonDeserializer<?> deserializer) {
                // 如果是builder模式 则beanDesc 是builder
//                if (Parent1.class.isAssignableFrom(beanDesc.getBeanClass())) {
                String outerClassName = StringUtil.split(beanDesc.getBeanClass().getName(), '$')[0];
                try {
                    if (deserializer instanceof BuilderBasedDeserializer &&
                            Parent1.class.isAssignableFrom(Class.forName(outerClassName))
                    ) {
                        return new SuperBuilderBasedDeserializer((BuilderBasedDeserializer) deserializer, Parent1.class);
                    }
                } catch (Exception e) {
                    return deserializer;
                }
                return deserializer;
            }
        });
        mapper.registerModule(module);
        return mapper;
    }

}
