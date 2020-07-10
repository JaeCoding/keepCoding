package com.jaecoding.keep.coding.util.json;

import com.google.common.collect.Sets;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * JsonCompare
 *
 * @author pengwenjie3
 * @date 2020/5/6
 * @since 1.8
 */
public class JsonCompare {

    /**
     * 比较
     *
     * @param base   基地
     * @param old 目标 待查询的json
     */
    void  compare(String base, String old) {
        Map<String, String> base1 = getFiledSet(base, "base");
        Map<String, String> old1 = getFiledSet(old, "old");

        // 将
        base1.forEach((key, value) -> {
            old1.remove(key);
        });

        System.out.println("old不包含于base中的字段有");
        old1.forEach((key, value) -> System.out.println(key));

    }

    private Map<String, String> getFiledSet(String base, String name) {
        return Arrays.stream(base.replace("{", "").replace("}", "").split(","))
                .map(s -> s.split(":")[0])
                .map(String::trim)
                .map(s -> s.replaceAll("\"", ""))
                .collect(Collectors.toMap((s) ->s, (s) ->name));
    }


    public static void main(String[] args) {
        String base = "{\n" +
                "        \"orderRemark\": \"\",\n" +
                "        \"isHasInvoice\": false,\n" +
                "        \"invoiceCode\": \"\",\n" +
                "        \"timeTypeTitle\": 0,\n" +
                "        \"invoiceTime\": \"2020-04-27 09:05:35\",\n" +
                "        \"timePriority\": 0,\n" +
                "        \"customerExpect\": 0,\n" +
                "        \"customerExpectName\": \"\",\n" +
                "        \"refundType\": 0,\n" +
                "        \"refundTypeName\": \"\",\n" +
                "        \"changeSku\": 0,\n" +
                "        \"isNeedDetectionReport\": false,\n" +
                "        \"isCustomerUploade\": false,\n" +
                "        \"isHasPackage\": false,\n" +
                "        \"packageDesc\": 0,\n" +
                "        \"afsServiceStepName\": \"\"," +
                "        \"serialVersionUID\": 0,\n" +
                "        \"afsServiceId\": 0,\n" +
                "        \"afsApplyId\": 0,\n" +
                "        \"afsApplyTime\": \"2020-04-27 09:05:35\",\n" +
                "        \"afsCategoryId\": 0,\n" +
                "        \"afsServiceStep\": 0,\n" +
                "        \"afsServiceState\": 0,\n" +
                "        \"afsServiceStateString\": \"\",\n" +
                "        \"platformSrc\": 0,\n" +
                "        \"orderId\": 0,\n" +
                "        \"orderType\": 0,\n" +
                "        \"questionTypeCid1\": 0,\n" +
                "        \"questionTypeCid2\": 0,\n" +
                "        \"questionDesc\": \"\",\n" +
                "        \"questionPic\": \"\",\n" +
                "        \"customerPin\": \"\",\n" +
                "        \"customerName\": \"\",\n" +
                "        \"customerGrade\": 0,\n" +
                "        \"customerContactName\": \"\",\n" +
                "        \"customerTel\": \"\",\n" +
                "        \"customerMobilePhone\": \"\",\n" +
                "        \"customerEmail\": \"\",\n" +
                "        \"pickwareType\": 0,\n" +
                "        \"pickwareTypeName\": \"\",\n" +
                "        \"pickwareProvince\": 0,\n" +
                "        \"pickwareCity\": 0,\n" +
                "        \"pickwareCounty\": 0,\n" +
                "        \"pickwareVillage\": 0,\n" +
                "        \"pickwareAddress\": \"\",\n" +
                "        \"reserveDate\": \"2020-04-27 09:05:35\",\n" +
                "        \"companyId\": 0,\n" +
                "        \"returnwareType\": 0,\n" +
                "        \"returnwareProvince\": 0,\n" +
                "        \"returnwareCity\": 0,\n" +
                "        \"returnwareCounty\": 0,\n" +
                "        \"returnwareVillage\": 0,\n" +
                "        \"returnwareAddress\": \"\",\n" +
                "        \"approvePin\": \"\",\n" +
                "        \"approveName\": \"\",\n" +
                "        \"approveResult\": 0,\n" +
                "        \"approveResultName\": \"\",\n" +
                "        \"approveResonCid1\": 0,\n" +
                "        \"approveResonCid2\": 0,\n" +
                "        \"approvedDate\": \"2020-04-27 09:05:35\",\n" +
                "        \"approveNotes\": \"\",\n" +
                "        \"processPin\": \"\",\n" +
                "        \"processName\": \"\",\n" +
                "        \"processResult\": 0,\n" +
                "        \"processResultName\": \"\",\n" +
                "        \"processNotes\": \"\",\n" +
                "        \"processedDate\": \"2020-04-27 09:05:35\",\n" +
                "        \"createDate\": \"2020-04-27 09:05:35\",\n" +
                "        \"createName\": \"\",\n" +
                "        \"updateDate\": \"2020-04-27 09:05:35\",\n" +
                "        \"updateName\": \"\",\n" +
                "        \"sysVersion\": 0,\n" +
                "        \"fetchDate\": \"2020-04-27 09:05:35\",\n" +
                "        \"receiveDate\": \"2020-04-27 09:05:35\",\n" +
                "        \"neworderId\": 0,\n" +
                "        \"buid\": \"\",\n" +
                "        \"wareId\": 0,\n" +
                "        \"crmCaseId\": 0,\n" +
                "        \"parentService\": 0,\n" +
                "        \"serviceCount\": 0,\n" +
                "        \"categorySource\": 0" +
                "}";

        String old = "{\n" +
                "\"serialVersionUID\": 0,\n" +
                "\"afsServiceId\": 0,\n" +
                "\"afsApplyId\": 0,\n" +
                "\"afsApplyTime\": \"2020-04-27 09:05:35\",\n" +
                "\"afsCategoryId\": 0,\n" +
                "\"afsServiceStep\": 0,\n" +
                "\"afsServiceState\": 0,\n" +
                "\"platformSrc\": 0,\n" +
                "\"orderId\": 0,\n" +
                "\"orderType\": 0,\n" +
                "\"questionTypeCid1\": 0,\n" +
                "\"questionTypeCid2\": 0,\n" +
                "\"questionDesc\": \"\",\n" +
                "\"questionPic\": \"\",\n" +
                "\"customerPin\": \"\",\n" +
                "\"customerName\": \"\",\n" +
                "\"customerGrade\": 0,\n" +
                "\"customerContactName\": \"\",\n" +
                "\"customerTel\": \"\",\n" +
                "\"customerMobilePhone\": \"\",\n" +
                "\"customerPostcode\": \"\",\n" +
                "\"pickwareProvince\": 0,\n" +
                "\"pickwareCity\": 0,\n" +
                "\"pickwareCounty\": 0,\n" +
                "\"pickwareVillage\": 0,\n" +
                "\"pickwareAddress\": \"\",\n" +
                "\"companyId\": 0,\n" +
                "\"returnwareProvince\": 0,\n" +
                "\"returnwareCity\": 0,\n" +
                "\"returnwareCounty\": 0,\n" +
                "\"returnwareVillage\": 0,\n" +
                "\"returnwareAddress\": \"\",\n" +
                "\"approvePin\": \"\",\n" +
                "\"approveName\": \"\",\n" +
                "\"afsServiceApprovedResult\": 0,\n" +
                "\"approveNotes\": \"\",\n" +
                "\"approvedDate\": \"2020-04-27 09:05:35\",\n" +
                "\"processPin\": \"\",\n" +
                "\"processName\": \"\",\n" +
                "\"processNotes\": \"\",\n" +
                "\"afsServiceProcessResult\": 0,\n" +
                "\"processedDate\": \"2020-04-27 09:05:35\",\n" +
                "\"newOrderId\": 0,\n" +
                "\"CustomerExpect\": 0,\n" +
                "\"receiveDate\": \"2020-04-27 09:05:35\",\n" +
                "\"serviceApprovedResultName\": \"\",\n" +
                "\"serviceProcessResultName\": \"\",\n" +
                "\"afsServiceStepName\": \"\",\n" +
                "\"afsServiceStatus\": 0,\n" +
                "\"afsServiceStatusName\": \"\",\n" +
                "\"updateName\": \"\",\n" +
                "\"updateDate\": \"2020-04-27 09:05:35\",\n" +
                "\"pickwareType\": 0,\n" +
                "\"refundType\": 0,\n" +
                "\"refundTypeName\": \"\",\n" +
                "\"buId\": \"\",\n" +
                "\"expandMap\": {},\n" +
                "\"afsServiceIds\": \"\",\n" +
                "\"sysVersion\": 0,\n" +
                "\"pickwareTypeName\": \"\",\n" +
                "\"customerExpectName\": \"\",\n" +
                "\"applyReasonLevelOne\": \"\",\n" +
                "\"applyReasonLevelTwo\": \"\",\n" +
                "\"afsTagStr\": \"\",\n" +
                "\"canClickWhetherResolved\": false,\n" +
                "\"noReasonReturnPolicy\": \"\",\n" +
                "\"serviceCount\": 0,\n" +
                "\"wareId\": 0\n" +
                "}";

        String afsFreights = "{\n" +
                "                \"serialVersionUID\": 0,\n" +
                "                \"afsFreightId\": 0,\n" +
                "                \"freightCode\": \"\",\n" +
                "                \"afsServiceId\": 0,\n" +
                "                \"partReceiveId\": 0,\n" +
                "                \"freightMoney\": 0,\n" +
                "                \"modifiedMoney\": 0,\n" +
                "                \"afsOrderId\": 0,\n" +
                "                \"expressCompany\": \"\",\n" +
                "                \"expressCode\": \"\",\n" +
                "                \"shipWay\": 0,\n" +
                "                \"deliverDate\": \"2020-04-27 09:05:35\",\n" +
                "                \"freightState\": 0,\n" +
                "                \"approveNotes\": \"\",\n" +
                "                \"compensationState\": 0,\n" +
                "                \"remark\": \"\",\n" +
                "                \"buId\": \"\",\n" +
                "                \"ifBizPay\": false,\n" +
                "                \"customerPin\": \"\",\n" +
                "                \"customerName\": \"\",\n" +
                "                \"createDate\": \"2020-04-27 09:05:35\",\n" +
                "                \"createName\": \"\",\n" +
                "                \"updateDate\": \"2020-04-27 09:05:35\",\n" +
                "                \"updateName\": \"\",\n" +
                "                \"sysVersion\": 0,\n" +
                "                \"ifSendMsg\": 0,\n" +
                "                \"freightType\": 0\n" +
                "            }";
        String afsInvoices = "{\n" +
                "                \"serialVersionUID\": 0,\n" +
                "                \"afsInvoiceId\": 0,\n" +
                "                \"invoiceCode\": \"\",\n" +
                "                \"afsServiceId\": 0,\n" +
                "                \"orderId\": 0,\n" +
                "                \"partReceiveId\": 0,\n" +
                "                \"invoiceState\": 0,\n" +
                "                \"createSrc\": 0,\n" +
                "                \"buId\": \"\",\n" +
                "                \"lendUserCode\": \"\",\n" +
                "                \"outPartId\": 0,\n" +
                "                \"companyId\": 0,\n" +
                "                \"ineCode\": \"\",\n" +
                "                \"repeatInvoiceCode\": \"\",\n" +
                "                \"repeatInvoiceType\": 0,\n" +
                "                \"invoiceSelfCode\": \"\",\n" +
                "                \"isErrorInvoice\": false,\n" +
                "                \"isFinanceVoid\": false,\n" +
                "                \"remark\": \"\",\n" +
                "                \"createDate\": \"2020-04-27 09:05:35\",\n" +
                "                \"createName\": \"\",\n" +
                "                \"updateDate\": \"2020-04-27 09:05:35\",\n" +
                "                \"updateName\": \"\",\n" +
                "                \"sysVersion\": 0,\n" +
                "                \"customerPin\": \"\",\n" +
                "                \"customerName\": \"\",\n" +
                "                \"shipWay\": 0,\n" +
                "                \"waybill\": \"\"\n" +
                "            }";

        String afsLogServices = "{\n" +
                "                \"serialVersionUID\": 0,\n" +
                "                \"afsLogId\": 0,\n" +
                "                \"relationId\": 0,\n" +
                "                \"relationType\": 0,\n" +
                "                \"operateType\": 0,\n" +
                "                \"operateRemark\": \"\",\n" +
                "                \"operatePin\": \"\",\n" +
                "                \"operateName\": \"\",\n" +
                "                \"operateDate\": \"2020-04-27 09:05:35\",\n" +
                "                \"relationTypeName\": \"\"\n" +
                "            }";

        String afsMessages = "{\n" +
                "                \"serialVersionUID\": 0,\n" +
                "                \"afsMessageId\": 0,\n" +
                "                \"afsServiceId\": 0,\n" +
                "                \"relativeNumber\": \"\",\n" +
                "                \"msgType\": 0,\n" +
                "                \"title\": \"\",\n" +
                "                \"context\": \"\",\n" +
                "                \"operationType\": 0,\n" +
                "                \"systemType\": 0,\n" +
                "                \"createPin\": \"\",\n" +
                "                \"createName\": \"\",\n" +
                "                \"createDate\": \"2020-04-27 09:05:35\",\n" +
                "                \"updateDate\": \"2020-04-27 09:05:35\",\n" +
                "                \"updateName\": \"\",\n" +
                "                \"sysVersion\": 0\n" +
                "            }";
        String afsNewRefunds = "\"serialVersionUID\": 0,\n" +
                "                \"id\": 0,\n" +
                "                \"afsServiceId\": 0,\n" +
                "                \"orderId\": 0,\n" +
                "                \"operType\": 0,\n" +
                "                \"refundType\": 0,\n" +
                "                \"wareId\": 0,\n" +
                "                \"refundMoney\": 0,\n" +
                "                \"refundId\": 0,\n" +
                "                \"createDate\": \"2020-04-27 09:05:35\",\n" +
                "                \"createName\": \"\",\n" +
                "                \"updateName\": \"\",\n" +
                "                \"updateDate\": \"2020-04-27 09:05:35\",\n" +
                "                \"sysVersion\": 0,\n" +
                "                \"createPin\": \"\",\n" +
                "                \"updatePin\": \"\",\n" +
                "                \"isCount\": 0,\n" +
                "                \"newOrderId\": 0";
        String afsOrderApplies = "{\n" +
                "                \"serialVersionUID\": 0,\n" +
                "                \"afsOrderApplyId\": 0,\n" +
                "                \"afsServiceId\": 0,\n" +
                "                \"customerPin\": \"\",\n" +
                "                \"customerName\": \"\",\n" +
                "                \"receiptName\": \"\",\n" +
                "                \"receiptAddress\": \"\",\n" +
                "                \"zipcode\": \"\",\n" +
                "                \"province\": 0,\n" +
                "                \"city\": 0,\n" +
                "                \"county\": 0,\n" +
                "                \"village\": 0,\n" +
                "                \"tel\": \"\",\n" +
                "                \"phone\": \"\",\n" +
                "                \"payment\": 0,\n" +
                "                \"applyDescription\": \"\",\n" +
                "                \"orderRemark\": \"\",\n" +
                "                \"deliveryCenterId\": 0,\n" +
                "                \"approveName\": \"\",\n" +
                "                \"approveNotes\": \"\",\n" +
                "                \"approveDate\": \"2020-04-27 09:05:35\",\n" +
                "                \"isPickFreight\": false,\n" +
                "                \"pickwareFreight\": 0,\n" +
                "                \"isNeedInvoice\": false,\n" +
                "                \"neworderId\": 0,\n" +
                "                \"neworderType\": 0,\n" +
                "                \"neworderState\": \"\",\n" +
                "                \"orderApplyState\": 0,\n" +
                "                \"orderApplyType\": 0,\n" +
                "                \"companyId\": 0,\n" +
                "                \"relationOrderId\": 0,\n" +
                "                \"afsApplyId\": 0,\n" +
                "                \"relationOrderState\": 0,\n" +
                "                \"appointmentSendTime\": \"2020-04-27 09:05:35\",\n" +
                "                \"relationOrderType\": 0,\n" +
                "                \"neworderStatename\": \"\",\n" +
                "                \"neworderVersion\": 0,\n" +
                "                \"createDate\": \"2020-04-27 09:05:35\",\n" +
                "                \"createName\": \"\",\n" +
                "                \"updateName\": \"\",\n" +
                "                \"updateDate\": \"2020-04-27 09:05:35\",\n" +
                "                \"sysVersion\": 0,\n" +
                "                \"deliveryCenterName\": \"\",\n" +
                "                \"neworderCompanyId\": 0,\n" +
                "                \"buid\": \"\",\n" +
                "                \"categoryBuid\": \"\",\n" +
                "                \"categorySource\": 0,\n" +
                "                \"timeRange\": \"\",\n" +
                "                \"selfPickwareId\": 0,\n" +
                "                \"sendPay\": \"\",\n" +
                "                \"skumark\": 0\n" +
                "            }";

        String afsPickwares = "{\n" +
                "                \"serialVersionUID\": 0,\n" +
                "                \"afsPickwareId\": 0,\n" +
                "                \"pickwareCode\": \"\",\n" +
                "                \"pickCharge\": 0,\n" +
                "                \"customerAccount\": \"\",\n" +
                "                \"customerName\": \"\",\n" +
                "                \"customerTel\": \"\",\n" +
                "                \"customerPhone\": \"\",\n" +
                "                \"pickProvince\": 0,\n" +
                "                \"pickCity\": 0,\n" +
                "                \"pickCounty\": 0,\n" +
                "                \"pickVillage\": 0,\n" +
                "                \"pickAddr\": \"\",\n" +
                "                \"afterserviceProvince\": 0,\n" +
                "                \"afterserviceCity\": 0,\n" +
                "                \"afterserviceCounty\": 0,\n" +
                "                \"afterserviceVillage\": 0,\n" +
                "                \"afterserviceAddress\": \"\",\n" +
                "                \"afterserviceReceiver\": \"\",\n" +
                "                \"afterserviceTel\": \"\",\n" +
                "                \"afterserviceZipcode\": \"\",\n" +
                "                \"reserveDate\": \"2020-04-27 09:05:35\",\n" +
                "                \"reserveTime\": 0,\n" +
                "                \"remark\": \"\",\n" +
                "                \"pickwareState\": 0,\n" +
                "                \"returnwareState\": 0,\n" +
                "                \"cancelReason\": 0,\n" +
                "                \"cancelReasonDesc\": \"\",\n" +
                "                \"afterserviceType\": 0,\n" +
                "                \"pickwareType\": 0,\n" +
                "                \"pickwareMethod\": 0,\n" +
                "                \"distributionName\": \"\",\n" +
                "                \"distributionAccount\": \"\",\n" +
                "                \"distributionTime\": \"2020-04-27 09:05:35\",\n" +
                "                \"pickupStandard\": \"\",\n" +
                "                \"sendCode\": \"\",\n" +
                "                \"createDate\": \"2020-04-27 09:05:35\",\n" +
                "                \"createName\": \"\",\n" +
                "                \"updateDate\": \"2020-04-27 09:05:35\",\n" +
                "                \"updateName\": \"\",\n" +
                "                \"sysVersion\": 0,\n" +
                "                \"companyId\": 0,\n" +
                "                \"companyName\": \"\",\n" +
                "                \"siteId\": 0,\n" +
                "                \"siteName\": \"\",\n" +
                "                \"orderId\": 0,\n" +
                "                \"newOrderId\": 0,\n" +
                "                \"afsServiceId\": 0,\n" +
                "                \"beforeOpenState\": 0,\n" +
                "                \"joinTime\": \"2020-04-27 09:05:35\",\n" +
                "                \"customerPayFreight\": 0,\n" +
                "                \"afterservicePhone\": \"\"\n" +
                "            }";

        String afsPlatExpands = "{\n" +
                "                \"serialVersionUID\": 0,\n" +
                "                \"afsPlatExpandId\": 0,\n" +
                "                \"afsServiceId\": 0,\n" +
                "                \"smartRefundState\": 0,\n" +
                "                \"pickwareState\": 0,\n" +
                "                \"customerPin\": \"\",\n" +
                "                \"platExpandType\": 0,\n" +
                "                \"orderId\": 0,\n" +
                "                \"approveInfo\": \"\",\n" +
                "                \"pickwareType\": 0,\n" +
                "                \"createDate\": \"2020-04-27 09:05:35\",\n" +
                "                \"createName\": \"\",\n" +
                "                \"updateDate\": \"2020-04-27 09:05:35\",\n" +
                "                \"updateName\": \"\",\n" +
                "                \"sysVersion\": 0,\n" +
                "                \"baiScore\": 0,\n" +
                "                \"rejectType\": 0,\n" +
                "                \"categoryId\": 0,\n" +
                "                \"categorySource\": 0,\n" +
                "                \"newRefundState\": 0,\n" +
                "                \"packState\": 0,\n" +
                "                \"invoiceState\": 0,\n" +
                "                \"determinedType\": 0,\n" +
                "                \"determinedDesc\": \"\"\n" +
                "            }";
        String afsReturnBills = "{\n" +
                "                \"serialVersionUID\": 0,\n" +
                "                \"afsReturnBillId\": 0,\n" +
                "                \"afsReturnBillCode\": \"\",\n" +
                "                \"afsServiceId\": 0,\n" +
                "                \"applayName\": \"\",\n" +
                "                \"applayPin\": \"\",\n" +
                "                \"applayDate\": \"2020-04-27 09:05:35\",\n" +
                "                \"applayRemark\": \"\",\n" +
                "                \"applyState\": 0,\n" +
                "                \"consigneeName\": \"\",\n" +
                "                \"consigneeTel\": \"\",\n" +
                "                \"zipCode\": \"\",\n" +
                "                \"province\": 0,\n" +
                "                \"city\": 0,\n" +
                "                \"county\": 0,\n" +
                "                \"village\": 0,\n" +
                "                \"address\": \"\",\n" +
                "                \"repairState\": 0,\n" +
                "                \"createDate\": \"2020-04-27 09:05:35\",\n" +
                "                \"createName\": \"\",\n" +
                "                \"updateDate\": \"2020-04-27 09:05:35\",\n" +
                "                \"updateName\": \"\",\n" +
                "                \"sysVersion\": 0,\n" +
                "                \"giftFlag\": 0\n" +
                "            }";

        String afsServiceDetails = "{\n" +
                "                \"serialVersionUID\": 0,\n" +
                "                \"afsServiceDetailId\": 0,\n" +
                "                \"afsServiceId\": 0,\n" +
                "                \"wareId\": 0,\n" +
                "                \"wareName\": \"\",\n" +
                "                \"wareType\": 0,\n" +
                "                \"wareBrand\": \"\",\n" +
                "                \"wareNum\": 0,\n" +
                "                \"skuUuid\": \"\",\n" +
                "                \"skuType\": 0,\n" +
                "                \"payPrice\": 0,\n" +
                "                \"wareCid1\": 0,\n" +
                "                \"wareCid2\": 0,\n" +
                "                \"wareCid3\": 0,\n" +
                "                \"shelfLife\": \"\",\n" +
                "                \"buId\": \"\",\n" +
                "                \"buName\": \"\",\n" +
                "                \"isApply\": false,\n" +
                "                \"createDate\": \"2020-04-27 09:05:35\",\n" +
                "                \"createName\": \"\",\n" +
                "                \"updateDate\": \"2020-04-27 09:05:35\",\n" +
                "                \"updateName\": \"\",\n" +
                "                \"sysVersion\": 0,\n" +
                "                \"actualPayPrice\": 0,\n" +
                "                \"validNumFlag\": 0,\n" +
                "                \"wareDescribe\": \"\"\n" +
                "            }";

        String afsSpecialProperties = "{\n" +
                "                \"serialVersionUID\": 0,\n" +
                "                \"afsSpecialPropertyId\": 0,\n" +
                "                \"afsApplyId\": 0,\n" +
                "                \"afsServiceId\": 0,\n" +
                "                \"wareId\": 0,\n" +
                "                \"specialPropertyType\": \"\",\n" +
                "                \"specialPropertyValue\": \"\",\n" +
                "                \"createDate\": \"2020-04-27 09:05:35\",\n" +
                "                \"createName\": \"\",\n" +
                "                \"updateDate\": \"2020-04-27 09:05:35\",\n" +
                "                \"updateName\": \"\",\n" +
                "                \"sysVersion\": 0\n" +
                "            }";

        String afsUnresolvedMessages = "{\n" +
                "                \"serialVersionUID\": 0,\n" +
                "                \"afsUnresolvedMessageId\": 0,\n" +
                "                \"afsServiceId\": 0,\n" +
                "                \"parentId\": 0,\n" +
                "                \"unresolvedMessageState\": 0,\n" +
                "                \"context\": \"\",\n" +
                "                \"createDate\": \"2020-04-27 09:05:35\",\n" +
                "                \"createName\": \"\",\n" +
                "                \"createPin\": \"\",\n" +
                "                \"unresolvedMessageType\": 0\n" +
                "            }";

        String partReceives = "{\n" +
                "                \"serialVersionUID\": 0,\n" +
                "                \"partReceiveId\": 0,\n" +
                "                \"receivePin\": \"\",\n" +
                "                \"receiveName\": \"\",\n" +
                "                \"afsServiceId\": 0,\n" +
                "                \"afsTraceDetailId\": 0,\n" +
                "                \"orderId\": 0,\n" +
                "                \"orderType\": 0,\n" +
                "                \"companyId\": 0,\n" +
                "                \"afsPickwareId\": 0,\n" +
                "                \"skuUuid\": \"\",\n" +
                "                \"skuType\": 0,\n" +
                "                \"afsApplyTime\": \"2020-04-27 09:05:35\",\n" +
                "                \"partLogo\": \"\",\n" +
                "                \"partCode\": \"\",\n" +
                "                \"waybill\": \"\",\n" +
                "                \"pickwareMethod\": 0,\n" +
                "                \"receiveJudgment\": 0,\n" +
                "                \"partQuality\": 0,\n" +
                "                \"wareId\": 0,\n" +
                "                \"wareType\": 0,\n" +
                "                \"wareName\": \"\",\n" +
                "                \"wareSn\": \"\",\n" +
                "                \"wareNum\": 0,\n" +
                "                \"accessoryIsIntact\": false,\n" +
                "                \"wareBrand\": \"\",\n" +
                "                \"partReceiveState\": 0,\n" +
                "                \"partReceiveType\": 0,\n" +
                "                \"abnormalFlag\": false,\n" +
                "                \"abnormalIsProcessed\": 0,\n" +
                "                \"snIsInOrder\": false,\n" +
                "                \"shelfNumber\": \"\",\n" +
                "                \"lossPreventionTagFlag\": 0,\n" +
                "                \"partAppearance\": 0,\n" +
                "                \"partPacking\": 0,\n" +
                "                \"needRepairFlag\": false,\n" +
                "                \"hasTestreportFlag\": false,\n" +
                "                \"detectResult\": 0,\n" +
                "                \"detectDescription\": \"\",\n" +
                "                \"remark\": \"\",\n" +
                "                \"customerAccount\": \"\",\n" +
                "                \"customerName\": \"\",\n" +
                "                \"customerTel\": \"\",\n" +
                "                \"customerPhone\": \"\",\n" +
                "                \"transferInId\": 0,\n" +
                "                \"costPrice\": 0,\n" +
                "                \"wareCid1\": 0,\n" +
                "                \"wareCid2\": 0,\n" +
                "                \"wareCid3\": 0,\n" +
                "                \"buId\": \"\",\n" +
                "                \"buName\": \"\",\n" +
                "                \"handleResult\": 0,\n" +
                "                \"handleResultRemark\": \"\",\n" +
                "                \"createDate\": \"2020-04-27 09:05:35\",\n" +
                "                \"createName\": \"\",\n" +
                "                \"updateDate\": \"2020-04-27 09:05:35\",\n" +
                "                \"updateName\": \"\",\n" +
                "                \"sysVersion\": 0,\n" +
                "                \"wareAttachment\": \"\"\n" +
                "            }";
        String afsApply = "{\n" +
                "            \"afsApplyId\": 0,\n" +
                "            \"afsApplyState\": 0,\n" +
                "            \"afsApplyTime\": \"2020-04-27 09:05:35\",\n" +
                "            \"platformSrc\": 0,\n" +
                "            \"orderId\": 0,\n" +
                "            \"orderType\": 0,\n" +
                "            \"orderRemark\": \"\",\n" +
                "            \"preprocessCount\": 0,\n" +
                "            \"isHasInvoice\": false,\n" +
                "            \"invoiceCode\": \"\",\n" +
                "            \"timeTypeTitle\": 0,\n" +
                "            \"invoiceTime\": \"2020-04-27 09:05:35\",\n" +
                "            \"platformSrcRfid\": \"\",\n" +
                "            \"customerExpect\": 0,\n" +
                "            \"refundType\": 0,\n" +
                "            \"changeSku\": 0,\n" +
                "            \"questionTypeCid1\": 0,\n" +
                "            \"questionTypeCid2\": 0,\n" +
                "            \"questionDesc\": \"\",\n" +
                "            \"isNeedDetectionReport\": false,\n" +
                "            \"isCustomerUploade\": false,\n" +
                "            \"questionPic\": \"\",\n" +
                "            \"isHasPackage\": false,\n" +
                "            \"packageDesc\": 0,\n" +
                "            \"customerPin\": \"\",\n" +
                "            \"customerName\": \"\",\n" +
                "            \"customerGrade\": 0,\n" +
                "            \"customerContactName\": \"\",\n" +
                "            \"customerTel\": \"\",\n" +
                "            \"customerMobilePhone\": \"\",\n" +
                "            \"customerEmail\": \"\",\n" +
                "            \"customerPostcode\": \"\",\n" +
                "            \"pickwareType\": 0,\n" +
                "            \"pickwareProvince\": 0,\n" +
                "            \"pickwareCity\": 0,\n" +
                "            \"pickwareCounty\": 0,\n" +
                "            \"pickwareVillage\": 0,\n" +
                "            \"pickwareAddress\": \"\",\n" +
                "            \"reserveDate\": \"2020-04-27 09:05:35\",\n" +
                "            \"companyId\": 0,\n" +
                "            \"returnwareType\": 0,\n" +
                "            \"returnwareProvince\": 0,\n" +
                "            \"returnwareCity\": 0,\n" +
                "            \"returnwareCounty\": 0,\n" +
                "            \"returnwareVillage\": 0,\n" +
                "            \"returnwareAddress\": \"\",\n" +
                "            \"createDate\": \"2020-04-27 09:05:35\",\n" +
                "            \"createName\": \"\",\n" +
                "            \"updateDate\": \"2020-04-27 09:05:35\",\n" +
                "            \"updateName\": \"\",\n" +
                "            \"sysVersion\": 0,\n" +
                "            \"yn\": false,\n" +
                "            \"afsCategoryId\": 0,\n" +
                "            \"isFetched\": 0,\n" +
                "            \"fetchPin\": \"\",\n" +
                "            \"fetchName\": \"\",\n" +
                "            \"fetchDate\": \"2020-04-27 09:05:35\",\n" +
                "            \"wareId\": 0,\n" +
                "            \"fetchYn\": 0,\n" +
                "            \"ts\": \"2020-04-27 09:05:35\",\n" +
                "            \"afsBatchApplyId\": 0,\n" +
                "            \"serialVersionUID\": 0\n" +
                "        }";

        Set<String> contain = Sets.newHashSet(base, afsFreights, afsInvoices, afsLogServices, afsMessages, afsNewRefunds,
                afsOrderApplies, afsPickwares, afsPlatExpands, afsReturnBills, afsServiceDetails, afsSpecialProperties,
                afsUnresolvedMessages, partReceives, afsApply);


        new JsonCompare().compare(base, old);
    }
}

