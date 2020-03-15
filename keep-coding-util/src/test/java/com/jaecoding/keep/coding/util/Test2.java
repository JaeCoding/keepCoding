package com.jaecoding.keep.coding.util;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.jaecoding.keep.coding.domain.dto.Teacher;

import java.util.ArrayList;
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

//        Teacher teacher = Optional.ofNullable(JSON.parseObject(null, Teacher.class)).orElse(new Teacher());
//
//        System.out.println(teacher);
//
//        teacher.setAge(Optional.ofNullable(teacher.getAge()).orElse(0) + 1);
//
//        System.out.println(teacher);
//
//        teacher.setAge(Optional.ofNullable(teacher.getAge()).orElse(0) + 1);
//
//        System.out.println(teacher);

        ArrayList<Object> list = Lists.newArrayList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.forEach(a -> {
            if (a.equals("2")) {
                return;
            }
            System.out.println(a);
        });

    }
}
