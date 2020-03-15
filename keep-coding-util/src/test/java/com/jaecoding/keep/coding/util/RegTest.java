package com.jaecoding.keep.coding.util;

import java.util.stream.Stream;

/**
 * RegTest
 *
 * @author pengwenjie3
 * @date 2020/3/3
 * @since 1.8
 */
public class RegTest {
    public static void main(String[] args) {

        String s = "afs_service_id\n" +
                "--\n" +
                "int(11)\n" +
                "是\n" +
                "是\n" +
                "否\n" +
                "afs_apply_id\n" +
                "申请单id\n" +
                "int(11)\n" +
                "否\n" +
                "否\n" +
                "否\n" +
                "afs_apply_time\n" +
                "申请时间\n" +
                "datetime\n" +
                "否\n" +
                "否\n" +
                "否\n" +
                "afs_category_id\n" +
                "售后分类id\n" +
                "int(11)\n" +
                "否\n" +
                "否\n" +
                "否\n" +
                "afs_service_step\n" +
                "处理环节申请阶段10客服审核21商家审核22京东收货31商家收货32用户确认40完成50\n" +
                "smallint(6)\n" +
                "否\n" +
                "否\n" +
                "否\n" +
                "afs_service_state\n" +
                "待审核审核通过处理中不通过取消待客户反馈待客户确认完成状态\n" +
                "smallint(6)\n" +
                "否\n" +
                "否\n" +
                "否\n" +
                "platform_src\n" +
                "京东网站101360top102好药师103团购104迷你挑105后台crm201后台erp202后台自提点203\n" +
                "smallint(6)\n" +
                "否\n" +
                "否\n" +
                "否\n" +
                "order_id\n" +
                "--\n" +
                "bigint(20)\n" +
                "否\n" +
                "否\n" +
                "否\n" +
                "order_type\n" +
                "订单类型\n" +
                "smallint(6)\n" +
                "否\n" +
                "否\n" +
                "否\n" +
                "order_remark\n" +
                "订单备注\n" +
                "varchar(500)\n" +
                "否\n" +
                "否\n" +
                "否\n" +
                "is_has_invoice\n" +
                "是否有发票\n" +
                "tinyint(1)\n" +
                "否\n" +
                "否\n" +
                "否\n" +
                "invoice_code\n" +
                "发票号\n" +
                "varchar(50)\n" +
                "否\n" +
                "否\n" +
                "否\n" +
                "time_type_title\n" +
                "时间类型\n" +
                "tinyint(4)\n" +
                "否\n" +
                "否\n" +
                "否\n" +
                "invoice_time\n" +
                "开票时间\n" +
                "datetime\n" +
                "否\n" +
                "否\n" +
                "否\n" +
                "time_priority\n" +
                "处理时间优先级售后申请时间订单下单时间单位分钟\n" +
                "int(11)\n" +
                "否\n" +
                "否\n" +
                "否\n" +
                "customer_expect\n" +
                "退10换20修30\n" +
                "tinyint(4)\n" +
                "否\n" +
                "否\n" +
                "否\n" +
                "refund_type\n" +
                "退款方式余额10原返20银行卡30\n" +
                "tinyint(4)\n" +
                "否\n" +
                "否\n" +
                "否\n" +
                "change_sku\n" +
                "--\n" +
                "bigint(20)\n" +
                "否\n" +
                "否\n" +
                "否\n" +
                "question_type_cid1\n" +
                "一级问题类型\n" +
                "int(11)\n" +
                "否\n" +
                "否\n" +
                "否\n" +
                "question_type_cid2\n" +
                "二级问题类型\n" +
                "int(11)\n" +
                "否\n" +
                "否\n" +
                "否\n" +
                "question_desc\n" +
                "问题描述文字\n" +
                "varchar(1000)\n" +
                "否\n" +
                "否\n" +
                "否\n" +
                "is_need_detection_report\n" +
                "是否需要检测报告\n" +
                "tinyint(1)\n" +
                "否\n" +
                "否\n" +
                "否\n" +
                "is_customer_uploade\n" +
                "是否用户网站上传\n" +
                "tinyint(1)\n" +
                "否\n" +
                "否\n" +
                "否\n" +
                "question_pic\n" +
                "问题描述图片\n" +
                "varchar(2000)\n" +
                "否\n" +
                "否\n" +
                "否\n" +
                "is_has_package\n" +
                "是否有包装\n" +
                "tinyint(1)\n" +
                "否\n" +
                "否\n" +
                "否\n" +
                "package_desc\n" +
                "包装描述\n" +
                "tinyint(4)\n" +
                "否\n" +
                "否\n" +
                "否\n" +
                "customer_pin\n" +
                "用户账号\n" +
                "varchar(50)\n" +
                "否\n" +
                "否\n" +
                "否\n" +
                "customer_name\n" +
                "用户名\n" +
                "varchar(50)\n" +
                "否\n" +
                "否\n" +
                "否\n" +
                "customer_grade\n" +
                "用户等级\n" +
                "tinyint(4)\n" +
                "否\n" +
                "否\n" +
                "否\n" +
                "customer_contact_name\n" +
                "联系人\n" +
                "varchar(50)\n" +
                "否\n" +
                "否\n" +
                "是\n" +
                "customer_tel\n" +
                "联系电话\n" +
                "varchar(20)\n" +
                "否\n" +
                "否\n" +
                "是\n" +
                "customer_mobile_phone\n" +
                "手机号\n" +
                "varchar(20)\n" +
                "否\n" +
                "否\n" +
                "是\n" +
                "customer_email\n" +
                "email\n" +
                "varchar(50)\n" +
                "否\n" +
                "否\n" +
                "是\n" +
                "pickware_type\n" +
                "取件方式\n" +
                "smallint(6)\n" +
                "否\n" +
                "否\n" +
                "否\n" +
                "pickware_province\n" +
                "取件省\n" +
                "int(11)\n" +
                "否\n" +
                "否\n" +
                "否\n" +
                "pickware_city\n" +
                "取件市\n" +
                "int(11)\n" +
                "否\n" +
                "否\n" +
                "否\n" +
                "pickware_county\n" +
                "取件县\n" +
                "int(11)\n" +
                "否\n" +
                "否\n" +
                "否\n" +
                "pickware_village\n" +
                "取件乡镇\n" +
                "int(11)\n" +
                "否\n" +
                "否\n" +
                "否\n" +
                "pickware_address\n" +
                "取件街道地址\n" +
                "varchar(500)\n" +
                "否\n" +
                "否\n" +
                "是\n" +
                "reserve_date\n" +
                "预约取件时间\n" +
                "datetime\n" +
                "否\n" +
                "否\n" +
                "否\n" +
                "company_id\n" +
                "处理机构\n" +
                "int(11)\n" +
                "否\n" +
                "否\n" +
                "否\n" +
                "returnware_type\n" +
                "返件方式\n" +
                "tinyint(4)\n" +
                "否\n" +
                "否\n" +
                "否\n" +
                "returnware_province\n" +
                "返件省\n" +
                "int(11)\n" +
                "否\n" +
                "否\n" +
                "否\n" +
                "returnware_city\n" +
                "返件市\n" +
                "int(11)\n" +
                "否\n" +
                "否\n" +
                "否\n" +
                "returnware_county\n" +
                "返件县\n" +
                "int(11)\n" +
                "否\n" +
                "否\n" +
                "否\n" +
                "returnware_village\n" +
                "返件乡镇\n" +
                "int(11)\n" +
                "否\n" +
                "否\n" +
                "否\n" +
                "returnware_address\n" +
                "返件街道地址\n" +
                "varchar(500)\n" +
                "否\n" +
                "否\n" +
                "是\n" +
                "approve_pin\n" +
                "审核人账号\n" +
                "varchar(50)\n" +
                "否\n" +
                "否\n" +
                "否\n" +
                "approve_name\n" +
                "--\n" +
                "varchar(50)\n" +
                "否\n" +
                "否\n" +
                "否\n" +
                "approve_result\n" +
                "审核结果\n" +
                "smallint(4)\n" +
                "否\n" +
                "否\n" +
                "否\n" +
                "approve_reson_cid1\n" +
                "审核一级原因\n" +
                "tinyint(4) unsigned\n" +
                "否\n" +
                "否\n" +
                "否\n" +
                "approve_reson_cid2\n" +
                "审核二级原因\n" +
                "tinyint(4)\n" +
                "否\n" +
                "否\n" +
                "否\n" +
                "approved_date\n" +
                "审核时间\n" +
                "datetime\n" +
                "否\n" +
                "否\n" +
                "否\n" +
                "approve_notes\n" +
                "审核意见\n" +
                "varchar(1024)\n" +
                "否\n" +
                "否\n" +
                "否\n" +
                "process_pin\n" +
                "处理人账号\n" +
                "varchar(50)\n" +
                "否\n" +
                "否\n" +
                "否\n" +
                "process_name\n" +
                "--\n" +
                "varchar(50)\n" +
                "否\n" +
                "否\n" +
                "否\n" +
                "process_result\n" +
                "处理结果\n" +
                "smallint(6)\n" +
                "否\n" +
                "否\n" +
                "否\n" +
                "process_notes\n" +
                "处理意见\n" +
                "varchar(500)\n" +
                "否\n" +
                "否\n" +
                "否\n" +
                "processed_date\n" +
                "处理时间\n" +
                "datetime\n" +
                "否\n" +
                "否\n" +
                "否\n" +
                "create_date\n" +
                "创建时间\n" +
                "datetime\n" +
                "否\n" +
                "否\n" +
                "否\n" +
                "create_name\n" +
                "创建者\n" +
                "varchar(20)\n" +
                "否\n" +
                "否\n" +
                "否\n" +
                "update_date\n" +
                "修改时间\n" +
                "datetime\n" +
                "否\n" +
                "否\n" +
                "否\n" +
                "update_name\n" +
                "最后更新者\n" +
                "varchar(20)\n" +
                "否\n" +
                "否\n" +
                "否\n" +
                "sys_version\n" +
                "版本号\n" +
                "int(11)\n" +
                "否\n" +
                "否\n" +
                "否\n" +
                "yn\n" +
                "删除标识\n" +
                "tinyint(1)\n" +
                "否\n" +
                "否\n" +
                "否\n" +
                "fetch_date\n" +
                "取领时间\n" +
                "datetime\n" +
                "否\n" +
                "否\n" +
                "否\n" +
                "receive_date\n" +
                "收货时间\n" +
                "datetime\n" +
                "否\n" +
                "否\n" +
                "否\n" +
                "neworder_id\n" +
                "--\n" +
                "bigint(20)\n" +
                "否\n" +
                "否\n" +
                "否\n" +
                "buid\n" +
                "商家id\n" +
                "varchar(50)\n" +
                "否\n" +
                "否\n" +
                "否\n" +
                "ware_id\n" +
                "--\n" +
                "bigint(20)\n" +
                "否\n" +
                "否\n" +
                "否\n" +
                "crm_case_id\n" +
                "事件id\n" +
                "bigint(20)\n" +
                "否\n" +
                "否\n" +
                "否\n" +
                "ts\n" +
                "--\n" +
                "timestamp\n" +
                "否\n" +
                "否\n" +
                "否\n" +
                "parent_service\n" +
                "未拆分前父单id\n" +
                "bigint(20)\n" +
                "否\n" +
                "否\n" +
                "否\n" +
                "service_count\n" +
                "服务单售后数量\n" +
                "int(11)\n" +
                "否\n" +
                "否\n" +
                "否\n" +
                "category_source\n" +
                "分类所属\n" +
                "tinyint(4)\n" +
                "否\n" +
                "否\n" +
                "否";

        String[] split = s.split("\n");
        for (int i = 0; i < split.length; i++) {
            if (i % 6 == 0) {
                System.out.println(split[i]);
            }
        }

    }



}
