package com.jaecoding.keep.coding.domain.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 用户信息
 * @author binbin.hou
 * @since 0.0.1
 */
@Data
public class User {

    /**
     * 名称
     * @require 是
     * @remark 中文名称，请认真填写
     */
    private String name;

    /**
     * 年龄
     */
    private int age;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 地址
     */
    private List<Address> addressList;

    /**
     * 伴侣
     */
    private User mate;

}
