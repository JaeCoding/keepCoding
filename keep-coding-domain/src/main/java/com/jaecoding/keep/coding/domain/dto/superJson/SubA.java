package com.jaecoding.keep.coding.domain.dto.superJson;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

@Data
@Builder
//@JsonDeserialize(builder = SubA.SubABuilderImpl.class)
public class SubA extends AbstractA {

    @JsonProperty
    private final String fieldA;

//    @JsonPOJOBuilder(withPrefix = "")
//    public static class SubABuilderImpl {
//    }
}
