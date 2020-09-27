package com.jaecoding.keep.coding.util;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.inject.internal.util.Sets;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.io.FilenameFilter;
import java.util.*;
import java.util.function.BiPredicate;

/**
 * ATest
 *
 * @author pengwenjie3
 * @date 2020/8/17
 * @since 1.8
 */
public class ATest {

    public static class Student {
        String name;

        Student(String name) {
            this.name = name;
        }
        Boolean equals(Student s) {
            return this.name.equals(s.name);
        }
        static Boolean isNB(Student s) {
            return "B哥".equals(s.name);
        }
    }

    public static void main(String[] args) {
//        // 第一种
//        Function<Student, Boolean> isNB = Student::isNB;
//        System.out.println(isNB.apply(new Student("B哥")));
//        // 第二种
//        BiPredicate<Student,Student> bp = Student::equals;
//        Student a = new Student("a");
//        Student b = new Student("b");
//        System.out.println(bp.test(a, b));
//        //第三种
//        BiPredicate<Student,Student> filenameFilter = (c, d) -> {
//            return c.equals(d);
//        };


//        Map<String, String> string = ImmutableMap.of("firstName", "John", "lastName", "Doe");

//        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss.s");
//        DateTime d1 = dateTimeFormatter.parseDateTime("2020-08-20 15:12:00.0");
//        DateTime d2 = dateTimeFormatter.parseDateTime("2020-08-21 15:12:00.0");
//
//
//        System.out.println(d1.compareTo(d2));


//        Date d1 = new DateTime("2020-08-20 15:12:00").toDate();
//        System.out.println(d1.toDate());
//        System.out.println(d1.toDateTime());
//
//        Date d2 = new DateTime("2020-08-20 15:12:00.0").toDate();
//
//        System.out.println(d2);

        handler(new HashMap<>(), p -> {
            HashMap<Object, Object> objectObjectHashMap = new HashMap<>(166666);
            objectObjectHashMap.put("1", "2");
            objectObjectHashMap.put("3", "2");
            objectObjectHashMap.put("4", "2");
            objectObjectHashMap.put("5", "2");
            objectObjectHashMap.put("6", "2");
            objectObjectHashMap.put("7", "2");
            throw new RuntimeException("3");
        });

    }

    public static boolean handler(Object param, Function<Object, Boolean> func){
        return func.apply(param);
    }




}
