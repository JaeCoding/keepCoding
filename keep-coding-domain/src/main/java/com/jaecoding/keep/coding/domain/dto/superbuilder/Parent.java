package com.jaecoding.keep.coding.domain.dto.superbuilder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Parent {
    private String parentName;
    private int parentAge;
}
