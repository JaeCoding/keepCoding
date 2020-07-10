package com.jaecoding.keep.coding.guava.event;

import com.google.common.eventbus.EventBus;

/**
 * ExceptionEventBusExample
 *
 * @author pengwenjie3
 * @date 2020/2/27
 * @since 1.8
 */
public class ExceptionEventBusExample {
    public static void main(String[] args) {
        //在默认情况下，EventBus不会对异常信息进行处理，异常信息也不会终止EventBus的运行，只会简单的打印出异常堆栈信息。

        // 在EventBus构造函数中传入 SubscriberExceptionHandler来对异常信息进行处理

        // 下面是通过lambda表达式来实现SubscriberExceptionHandler接口，作为bus构造入参
        final EventBus eventBus = new EventBus((exception, context) -> {
            System.out.println(context.getEvent());//Exception event
            System.out.println(context.getEventBus());//defalut
            System.out.println(context.getSubscriber());//ExceptionListener com.jaecoding.keep.coding.guava.event.ExceptionListener@5f375618
            System.out.println(context.getSubscriberMethod());//异常绑定到了m3
        });

        // 将 异常handler注册到bus上
        eventBus.register(new ExceptionListener());

        eventBus.post("Exception event");


        //22:14:36.995 [main] INFO com.jaecoding.keep.coding.guava.event.ExceptionListener - Received event [Exception event] and will take m3
        //Exception event
        //EventBus{default}
        //com.jaecoding.keep.coding.guava.event.ExceptionListener@5f375618
        //public void com.jaecoding.keep.coding.guava.event.ExceptionListener.m3(java.lang.String)
        //22:14:37.004 [main] INFO com.jaecoding.keep.coding.guava.event.ExceptionListener - Received event [Exception event] and will take m2
        //22:14:37.004 [main] INFO com.jaecoding.keep.coding.guava.event.ExceptionListener - Received event [Exception event] and will take m1
        // todo 为什么m2先于m1打印日志呢
    }
}
