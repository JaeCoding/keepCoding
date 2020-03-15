package com.jaecoding.keep.coding.util;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * ServiceDto
 *
 * @author pengwenjie3
 * @date 2020/3/2
 * @since 1.8
 */
@Data
public class ServiceDto {

    private String createName;

    private Date createDate;

    private BigDecimal actualPayPrice;
}
