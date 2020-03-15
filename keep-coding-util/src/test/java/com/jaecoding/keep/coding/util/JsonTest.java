package com.jaecoding.keep.coding.util;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import javax.xml.ws.Service;

import java.beans.FeatureDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * JsonTest
 *
 * @author pengwenjie3
 * @date 2020/3/2
 * @since 1.8
 */
public class JsonTest {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        String json = "{\n" +
                "        \"bu_id\": \"627554\",\n" +
                "        \"ts\": \"2020-03-02 13:46:29\",\n" +
                "        \"create_name\": \"jd_yLmDjonTKZaB\",\n" +
                "        \"create_date\": \"2020-03-02 13:46:29\",\n" +
                "        \"ware_id\": \"58010267562\",\n" +
                "        \"afs_service_detail_id\": \"1016412853\",\n" +
                "        \"ware_cid1\": \"16750\",\n" +
                "        \"ware_cid2\": \"16751\",\n" +
                "        \"ware_cid3\": \"16756\",\n" +
                "        \"shelf_life\": null,\n" +
                "        \"sku_type\": \"3\",\n" +
                "        \"valid_num_flag\": \"1\",\n" +
                "        \"bu_name\": \"湖南奇迹人生科技发展有限公司\",\n" +
                "        \"ware_brand\": \"阿道夫(ADOLPH)\",\n" +
                "        \"ware_describe\": null,\n" +
                "        \"afs_service_id\": \"743327997\",\n" +
                "        \"sys_version\": \"1\",\n" +
                "        \"ware_name\": \"阿道夫(ADOLPH)洗发水生姜洗发露控油去屑洗头膏持久留香 赠品勿拍赠送运费险\",\n" +
                "        \"actual_pay_price\": \"0.0\",\n" +
                "        \"update_name\": null,\n" +
                "        \"ware_type\": \"10\",\n" +
                "        \"update_date\": null,\n" +
                "        \"yn\": \"1\",\n" +
                "        \"is_apply\": \"1\",\n" +
                "        \"WARE_NUM\": \"1\",\n" +
                "        \"sku_uuid\": \"41_33422825942_627554_58010267562_4_1\",\n" +
                "        \"pay_price\": \"0.0\"\n" +
                "    }";

        String to = "{\n" +
                "        \"update_name\":\"AfsServiceWorker\",\n" +
                "        \"afs_service_step\":\"50\",\n" +
                "        \"update_date\":\"2020-03-02 13:43:19\",\n" +
                "        \"afs_service_id\":\"734968492\",\n" +
                "        \"createName\":\"hahahahahah\",\n" +
                "        \"sys_version\":\"10\",\n" +
                "        \"ts\":\"2020-03-02 13:43:19\",\n" +
                "        \"afs_service_state\":\"9000\"\n" +
                "    }";

//        String a = "1234";
//
//        String substring = StringUtils.substring(a, 2, 3);
//        System.out.println(substring);


        ServiceDto dto = JSON.parseObject(json, ServiceDto.class);
        ServiceDto to2 = JSON.parseObject(to, ServiceDto.class);

        BeanUtils.copyProperties(to2, dto, getNullPropertyNames(to2));
        BeanUtils.copyProperties(to2, dto);
//
//
//        System.out.println(dto);



    }

    private static String[] getNullPropertyNames(Object source) {
        final BeanWrapper wrappedSource = new BeanWrapperImpl(source);
        String[] strings = Stream.of(wrappedSource.getPropertyDescriptors())
                .map(FeatureDescriptor::getName)
                .filter(propertyName -> wrappedSource.getPropertyValue(propertyName) == null)
                .toArray(String[]::new);
        return strings;
    }

    @Test
    public void test_for_issue() throws Exception {
        Model model = new Model();
        model.userId = 1001;
        model.userName = "test";
        String text = JSON.toJSONString(model);
//        assertEquals("{\"userName\":\"test\",\"user_id\":1001}", text);
//  actual   {"userName":"test","user_id":1001,"user_name":"test"}
        Model model2 = JSON.parseObject(text, Model.class);

        assertEquals(1001, model2.userId);
        assertEquals("test", model2.userName);
    }

    /**
     * 当某个字段有JSONField注解，JSONField中name属性不存在，并且类上有属性转换策略，
     * json属性名也要用类上的属性名转换策略为为准
     *
     * @throws Exception
     */
    @Test
    public void test_when_JSONField_have_not_name_attr() throws Exception {
        ModelTwo modelTwo = new ModelTwo();
        modelTwo.userId = 1001;
        modelTwo.userName = "test";
        String text = JSON.toJSONString(modelTwo);
        assertEquals("{\"userName\":\"test\",\"user_id\":\"1001\"}", text);

        Model model2 = JSON.parseObject(text, Model.class);

        assertEquals(1001, model2.userId);
        assertEquals("test", model2.userName);
    }


}
