package com.jaecoding.keep.coding.util.design.structure.proxy.interceptor;

import com.jaecoding.keep.coding.util.design.structure.proxy.HelloWorld;
import com.jaecoding.keep.coding.util.design.structure.proxy.HelloWorldImpl;

public class TestMyInterceptor {
    public static void main(String[] args) {
        new TestMyInterceptor().testInterceptor();
    }

    private void testInterceptor() {
        HelloWorld proxy = (HelloWorld) InterceptorJdkProxy.bind(
                new HelloWorldImpl(),
                "com.jaecoding.keepCoding.design.structure.proxy.interceptor.MyInterceptor"
        );
        proxy.sayHelloWorld();
    }
}
