package com.jaecoding.keep.coding.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * TODO 注释
 *
 * @author pengwenjie3
 * @date 2019/8/29
 * @since 1.8
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@AllArgsConstructor
public abstract class AbstractTeacher implements Teach {

    /**
     * Id field, displaying the recipe name this component reside.
     */
    public String recipeId;

}
