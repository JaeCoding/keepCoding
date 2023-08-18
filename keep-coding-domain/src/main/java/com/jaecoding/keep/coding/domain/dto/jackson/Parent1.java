package com.jaecoding.keep.coding.domain.dto.jackson;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Parent1 {
    private String parentName;
    private int parentAge;

    public static class ParentBulder {
        public String parentName;

        public ParentBulder parentName(String parentName) {
            this.parentName = parentName;
            return this;
        }
    }
}
