//package com.jaecoding.keep.coding.util.java8.future;
//
//import java.util.concurrent.Future;
//
//public class Test {
//
//    public static void main(String[] args) {
//        test2();
//
//    }
//
//
//
//    /**
//     * Future入门，最简单的测试
//     */
//    public static void test1() {
//        long start = System.nanoTime();
//
//        Shop shop = new Shop("BestShop");
//        // 开始异步计算
//        Future<Double> futurePrice = shop.getPriceAsync("my favorite product");
//        Function.calTime(start, "Invocation returned after ");
//
//        // 干其他的活，比如查询其他商店
//        // doSomethingElse();
//        // 在计算商品价格的同时
//
//        //get有可能get到一个异常，所以要包住
//        try {
//            if (futurePrice.isDone()) {
//                //做完其他事，需要get耗时结果时，再来get
//                double price = futurePrice.get();
//                System.out.printf("Price is %.2f%n", price);
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        Function.calTime(start, "Price returned after ");
//    }
//
//    /**
//     * 三种查找商品价格API 的时间测试
//     */
//    public static void test2() {
//        long start = System.nanoTime();
//        System.out.println(Function.findPricesWithDiscount("myPhone27S"));
//        Function.calTime(start, "Done in ");
//    }
//
//
//
//}
