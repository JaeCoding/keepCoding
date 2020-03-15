package com.jaecoding.keep.coding.guava.event;

import com.google.common.eventbus.EventBus;

/**
 * TODO
 *
 * @author pengwenjie3
 * @date 2020/2/27
 * @since 1.8
 */
public class DeadEventBusExample {
    public static void main(String[] args) {

        // 重写EventBus的toString方法，使eventBus的名称为 DEAD-EVENT-BUS
        final EventBus eventBus = new EventBus(){
            @Override public String toString() {
                return "DEAD-EVENT-BUS";
            }
        };

        DeadEventListener deadEventListener = new DeadEventListener();

        eventBus.register(deadEventListener);
        eventBus.register(new SimpleListener());

        // has match subscriber
        eventBus.post("DeadEventListener event");
        // has no subscriber -> deadEvent
        eventBus.post(0.1f);

    }
}
