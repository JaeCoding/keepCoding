package com.jaecoding.keep.coding.util;

import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.fasterxml.jackson.databind.ser.std.StringSerializer;

/**
 * ModelTow
 *
 * @author pengwenjie3
 * @date 2020/3/2
 * @since 1.8
 */
@JSONType(naming = PropertyNamingStrategy.SnakeCase)
public class ModelTwo {
    /**
     * 此字段准备序列化为字符串类型
     */
//    @JSONField(serializeUsing = StringSerializer.class)
    public int userId;

    @JSONField(name = "userName")
    public String userName;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
