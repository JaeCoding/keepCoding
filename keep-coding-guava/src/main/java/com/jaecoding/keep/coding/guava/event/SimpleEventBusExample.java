package com.jaecoding.keep.coding.guava.event;

import com.google.common.eventbus.EventBus;

/**
 * TODO
 *
 * @author pengwenjie3
 * @date 2020/2/27
 * @since 1.8
 */
public class SimpleEventBusExample {
    public static void main(String[] args) {
        final EventBus eventBus = new EventBus();

        // 将Listener注册到bus上
        eventBus.register(new SimpleListener());

        System.out.println("post the simple event.");

        // 向bus上的订阅者发送消息，会自动匹配类型
        eventBus.post("Simple Event");
        eventBus.post(1);
    }
}
