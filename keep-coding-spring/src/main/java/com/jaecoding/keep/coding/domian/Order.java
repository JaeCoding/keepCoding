package com.jaecoding.keep.coding.domian;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Order
 *
 * @author pengwenjie3
 * @date 2020/7/9
 * @since 1.8
 */
@Data
@NoArgsConstructor
public class Order {


    private int id;
    private OrderStatus status;
}
