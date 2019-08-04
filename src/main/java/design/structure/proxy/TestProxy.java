package design.structure.proxy;

public class TestProxy {
    public static void main(String[] args) {

        new TestProxy().testJdkProxy();
        System.out.println("--------------");
        new TestProxy().testCglibProxy();
    }

    private void testCglibProxy() {
        CglibProxyExample cpe = new CglibProxyExample();
        HelloWorldImpl2 helloWorldImpl2 = (HelloWorldImpl2) cpe.getProxy(HelloWorldImpl2.class);
        helloWorldImpl2.sayHelloWorld();
    }

    private void testJdkProxy() {
        JdkProxyExample jdkProxyExample = new JdkProxyExample();
        HelloWorld proxy = (HelloWorld) jdkProxyExample.bind(new HelloWorldImpl());
        proxy.sayHelloWorld();
    }


}
