package com.jaecoding.keep.coding;

import com.jaecoding.keep.coding.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class KeepCodingSpringApplicationTests {



    @Test
    void contextLoads() {

    }

    @Autowired
    private OrderService orderService;

    @Test
    public void testMultThread(){
        orderService.creat();
        orderService.creat();

        orderService.pay(1);


        System.out.println(orderService.getOrders());
    }

}
