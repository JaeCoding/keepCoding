package com.jaecoding.keep.coding.guava.event;

import com.google.common.eventbus.DeadEvent;
import com.google.common.eventbus.Subscribe;

/**
 * 当注册的订阅者中， 没有找到处理该事件的方法
 *
 * @author pengwenjie3
 * @date 2020/2/27
 * @since 1.8
 */
public class DeadEventListener {

    @Subscribe
    public void handle(DeadEvent event){
        System.out.println("this is a dead event, can't find the right object");//DEAD-EVENT-BUS
        // 获取事件源
        System.out.println("EventBus Name: " + event.getSource());//DEAD-EVENT-BUS
        // 获取事件
        System.out.println("EventBus Event: " + event.getEvent());//DeadEventListener event
    }
}
