package com.jaecoding.keep.coding.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.google.common.io.ByteStreams;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * TODO 注释
 *
 * @author pengwenjie3
 * @date 2019/8/29
 * @since 1.8
 */
@Data
@AllArgsConstructor
@Builder
@JsonDeserialize(builder = Teacher.TeacherBuilder.class)
public class Teacher extends AbstractTeacher implements Teach{

    private String name;

    private Integer age = 1;

    private Boolean sex;

//    @Builder
//    public Teacher(String recipeID, String name, int age, boolean sex) {
//        super(recipeID);
//        this.name = name;
//        this.age = age;
//        this.sex = sex;
//    }

    @JsonPOJOBuilder(withPrefix = "")
    public static final class TeacherBuilder {
        String recipeId = "333";
        public TeacherBuilder recipeId(String recipeId) {
            this.recipeId = recipeId;
            return this;
        }
    }

    public static void main(String[] args) throws IOException {
        Teacher teacher = Teacher.builder().recipeId("123").build();



        String recipeId = teacher.recipeId;
        System.out.println(teacher);
        System.out.println(teacher.getRecipeId());


        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(teacher);
        System.out.println(s);
//
//        System.out.println("====");
//        String json = "{\"recipeId\":\"111\",\"name\":\"test\",\"age\":null,\"sex\":null}";
//
//        Teacher teacher1 = mapper.readValue(json, Teacher.class);
//        System.out.println(mapper.writeValueAsString(teacher1));
//
//        System.out.println("====2");
//        String json2 = "{\"name\":\"test\",\"age\":null,\"sex\":null}";
//        Teacher teacher2 = mapper.readValue(json2, Teacher.class);
//        System.out.println(mapper.writeValueAsString(teacher2));

//        File file = new File("/Users/pwenjie/workspace/lc/keepCoding/keep-coding-domain/src/main/java/com/jaecoding/keep/coding/domain/dto/dd.txt");
//        JsonNode jsonNode = mapper.readTree(file);
//
//        ObjectReader objectReader = mapper.readerFor(Object.class);
//        MappingIterator<Object> objectMappingIterator = objectReader.readValues(file);
//
//        if (objectMappingIterator.hasNext()) {
//            Object next = objectMappingIterator.next();
//            System.out.println(next);
//        }

        // System.out.println(jsonNode);


    }
}
