package com.jaecoding.keep.coding.util;

import java.util.*;

/**
 * @author: 彭文杰
 * @create: 2018-09-22 10:47
 * <p>
 * ListIterator的使用  参考https://blog.csdn.net/goulei2010/article/details/78914975
 **/
public class ListIteratorTest {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        //游标一开始在1之前，最后会移动到4之后
        ListIterator iterator = (ListIterator) list.listIterator();
        while (iterator.hasNext()) {
            if (iterator.hasPrevious()) {
                System.out.println("游标之前元素" + iterator.previous());//这个会往前走一步的
                iterator.next();
            }
            System.out.println("游标之后元素" + iterator.next());
            System.out.println("----游标向后移动----");
        }

        //只有treeSet和linkedList才有 descendingIterator()方法 能 反向迭代
        LinkedList<Integer> linkedList = new LinkedList<>(); //这还不能用List了
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        Iterator iterator1 = linkedList.descendingIterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }
    }
}
