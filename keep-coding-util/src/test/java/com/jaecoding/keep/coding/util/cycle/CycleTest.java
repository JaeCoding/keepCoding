package com.jaecoding.keep.coding.util.cycle;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.jaecoding.keep.coding.util.help.DataAndCompare;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * CycleTest
 *
 * @author pengwenjie3
 * @date 2020/9/15
 * @since 1.8
 */
public class CycleTest {

    public static class A {
        Date date;

        A(Date date) {
            this.date = date;
        }

        Date getDate() {
            return this.date;
        }

    }


    public static void main(String[] args) throws InterruptedException {

//        Node a = new Node("A");
//        Node b = new Node("B");
//        Node c = new Node("C");
//        a.setParentAndSon(b, c);
//        b.setParentAndSon(c, a);
//        c.setParentAndSon(a, b);
//        String s = JSON.toJSONString(a);
//        System.out.println(s);
//
//        Node aa = JSON.parseObject(s, Node.class);
//
//
//        System.out.println(JSON.toJSONString(aa));
        Date date = new Date();
        System.out.println(date);
        A a = new A(date);

        Thread.sleep(200);

        Date dateb = new Date();
        System.out.println(dateb);
        A b = new A(dateb);

        List<A> es = Lists.newArrayList();


        // 在不包含元素时 .get才报错
        A a1 = es.stream().max(Comparator.comparing(A::getDate)).get();


        ArrayList<Date> dateArrayList = Lists.newArrayList(date, dateb);

//        dateArrayList.stream().max(Comparator.comparing(Date::this))
        dateArrayList.stream().max(Comparator.naturalOrder()).get();



        System.out.println(a1.date);

    }
}
