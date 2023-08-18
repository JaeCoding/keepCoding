package com.jaecoding.keep.coding.domain.dto.jackson;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.jaecoding.keep.coding.domain.dto.superbuilder.Parent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@EqualsAndHashCode(callSuper = false)
@JsonDeserialize(builder = Child1.Child1Builder.class)
public final class Child1 extends Parent1 {
    private String childName;
    private int childAge;

//    @JsonPOJOBuilder(withPrefix = "", buildMethodName = "create")
//    public static class Child1Builder extends ParentBulder{
//        public Child1 create() {
//            Child1 build = this.build();
//            build.setParentName(this.parentName);
//            return build;
//        }
//    }

    @JsonPOJOBuilder(withPrefix = "")
    public static class Child1Builder{
        public Child1 build() {
            return new Child1(this.childName, this.childAge);
        }
    }


}
