package java8.test;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>客户期望</p>
 *
 * @author wanghanzhe
 * @version 1.0.0
 * @date 2018.8.13
 */
@AllArgsConstructor
public enum AfsCustomerExpectEnum {

    /**
     * 退货
     */
    RETURN(10, "退货"),
    /**
     * 换货
     */
    EXCHANGE(20, "换货"),
    /**
     * 维修
     */
    REPAIR(30, "维修"),
    /**
     * 安装
     */
    INSTALL(40, "安装"),
    /**
     * 移机
     */
    RELOCATION(50, "移机"),
    /**
     * 其他服务
     */
    OTHER_SERVICE(60, "其他服务"),
    /**
     * 上门维修
     */
    HOME_REPAIR(70, "上门维修"),
    /**
     * 优鲜赔
     */
    FRESH_UPGRADE(90, "优鲜赔"),
    /**
     * 补发商品
     */
    REISSUE_WARE(80, "补发商品"),
    /**
     * 试用回收
     */
    TRIAL_RECYCLING(100, "试用回收"),
    /**
     * 还货
     */
    RETURN_WARE(110, "还货"),
    ;

    /**
     * 编号
     */
    @Getter
    private Integer code;

    /**
     * 描述
     */
    @Getter
    private String desc;

    /**
     * 转译客户期望枚举
     *
     * @param code
     * @return
     */
    public static AfsCustomerExpectEnum findByCode(Integer code) {
        if (null != code) {
            AfsCustomerExpectEnum[] enums = AfsCustomerExpectEnum.values();
            for (AfsCustomerExpectEnum expect : enums) {
                if (expect.getCode().intValue() == code.intValue()) {
                    return expect;
                }
            }
        }
        return null;
    }
}
