package com.jaecoding.keep.coding.util;

import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;

/**
 * Model
 *
 * @author pengwenjie3
 * @date 2020/3/2
 * @since 1.8
 */
@JSONType(naming = PropertyNamingStrategy.SnakeCase)
public class Model {
    public int userId;

    // 会在下划线上另加上驼峰字段
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
