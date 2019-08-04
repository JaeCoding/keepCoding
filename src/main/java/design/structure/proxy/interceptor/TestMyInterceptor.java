package design.structure.proxy.interceptor;

import design.structure.proxy.HelloWorld;
import design.structure.proxy.HelloWorldImpl;

public class TestMyInterceptor {
    public static void main(String[] args) {
        new TestMyInterceptor().testInterceptor();
    }

    private void testInterceptor() {
        HelloWorld proxy = (HelloWorld) InterceptorJdkProxy.bind(
                new HelloWorldImpl(),
                "design.structure.proxy.interceptor.MyInterceptor"
        );
        proxy.sayHelloWorld();
    }
}
