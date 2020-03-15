package com.jaecoding.keep.coding.util.threadlock;

public class HelloWorld {
    public static void main(String[] args) throws InterruptedException {
        Thread myThread = new Thread(() -> System.out.println("hello from my thread"));
        myThread.start();
//        Thread.yield();
//        Thread.sleep(1);
        System.out.println("main");
        //main会等待子线程结束后再继续运行
        myThread.join();

    }
}
