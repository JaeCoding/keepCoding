package com.jaecoding.keep.coding.util;

import com.alibaba.fastjson.JSON;
import com.jaecoding.keep.coding.domain.dto.Teacher;

import java.util.Optional;

/**
 * TODO
 *
 * @author pengwenjie3
 * @date 2020/2/19
 * @since 1.8
 */
public class Test2 {
    public static void main(String[] args) {

        Teacher teacher = Optional.ofNullable(JSON.parseObject(null, Teacher.class)).orElse(new Teacher());

        System.out.println(teacher);

        teacher.setAge(Optional.ofNullable(teacher.getAge()).orElse(0) + 1);

        System.out.println(teacher);

        teacher.setAge(Optional.ofNullable(teacher.getAge()).orElse(0) + 1);

        System.out.println(teacher);
    }
}
