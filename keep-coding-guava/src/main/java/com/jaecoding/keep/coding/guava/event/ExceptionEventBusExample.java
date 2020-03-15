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
        //在EventBus构造函数中传入 SubscriberExceptionHandler来对异常信息进行处理
        //下面是通过lambda表达式来实现SubscriberExceptionHandler接口
        final EventBus eventBus = new EventBus((exception, context) -> {
            System.out.println(context.getEvent());//Exception event
            System.out.println(context.getEventBus());//defalut
            System.out.println(context.getSubscriber());//ExceptionListener
            System.out.println(context.getSubscriberMethod());//m3
        });
        eventBus.register(new ExceptionListener());
        eventBus.post("Exception event");
    }
}
