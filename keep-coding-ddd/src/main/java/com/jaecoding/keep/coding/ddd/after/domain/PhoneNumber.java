package com.jaecoding.keep.coding.ddd.after.domain;

import lombok.Data;

import javax.validation.ValidationException;
import java.util.Arrays;

/**
 * PhoneNumber
 *
 * @author pengwenjie3
 * @date 2020/9/25
 * @since 1.8
 */
@Data
public class PhoneNumber {

    /**
     * 不变量
     */
    private final String number;


    /**
     * 校验放置于构造方法，确保只要PhoneNumber类被创建出来后，一定是校验通过的
     *
     * @param number 数量
     */
    public PhoneNumber(String number) {
        if (number == null) {
            throw new ValidationException("number不能为空");
        } else if (isValid(number)) {
            throw new ValidationException("number格式错误");
        }
        this.number = number;
    }

    /**
     * 区域代码 是 电话领域对象的一个隐藏属性
     * 突出了areaCode是PhoneNumber的一个计算属性。
     *
     * @return {@link String}
     */
    public String getAreaCode() {
        for (int i = 0; i < number.length(); i++) {
            String prefix = number.substring(0, i);
            if (isAreaCode(prefix)) {
                return prefix;
            }
        }
        return null;
    }

    /**
     * 辅助方法
     *
     * @param prefix 前缀
     * @return boolean
     */
    private static boolean isAreaCode(String prefix) {
        String[] areas = new String[]{"0571", "021", "010"};
        return Arrays.asList(areas).contains(prefix);
    }

    /**
     * 校验
     *
     * @param number 数量
     * @return boolean
     */
    public static boolean isValid(String number) {
        String pattern = "^0?[1-9]{2,3}-?\\d{8}$";
        return number.matches(pattern);
    }
}
