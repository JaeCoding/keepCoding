package com.jaecoding.keep.coding.util.java8.test;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * <p>客服售后：申请售后申请单退款信息</p>
 *
 * @author wanghanzhe <wanghanzhe@jd.com>
 * @version 1.2.0
 * @date 2018.10.8
 * @since 1.7
 */
@Data
@ToString
@NoArgsConstructor
public class ReqAfsApplyRefundDto implements Serializable {
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -7935444382426322353L;

    /**
     * 退款方式，余额(10),原返(20),银行卡(30)；  退货时必填
     */
    private Integer refundType;
    /**
     * 银行卡号（账号）
     */
    private String bankCode;
    /**
     * 银行名称
     */
    private String bankName;
    /**
     * 开户银行省
     */
    private String bankProvince;
    /**
     * 开户银行市
     */
    private String bankCity;
    /**
     * 开户分行地址
     */
    private String branchBankAddress;
    /**
     * 银行开户姓名
     */
    private String bankAccountHolder;
}