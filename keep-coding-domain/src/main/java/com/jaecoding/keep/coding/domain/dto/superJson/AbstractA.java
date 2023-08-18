package com.jaecoding.keep.coding.domain.dto.superJson;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.jaecoding.keep.coding.domain.dto.superJson.SubA;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

@Getter
public abstract class AbstractA {

    @JsonProperty
    protected String superProperty;
}
