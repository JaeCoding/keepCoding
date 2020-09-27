package com.jaecoding.keep.coding.ddd.before.domain;

import lombok.Data;

/**
 * User
 *
 * @author pengwenjie3
 * @date 2020/9/25
 * @since 1.8
 */
@Data
public class User {
    /**
     * 用户id
     */
    Long userId;
    /**
     * 的名字
     */
    String name;
    /**
     * 电话
     */
    String phone;
    /**
     * 地址
     */
    String address;
    /**
     * 代表id
     */
    Long repId;
}
