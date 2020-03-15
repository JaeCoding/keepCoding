package com.jaecoding.keep.coding.util;


import com.alibaba.fastjson.JSONObject;

/**
 * TODO
 *
 * @author pengwenjie3
 * @date 2020/2/18
 * @since 1.8
 */
public class Test {
    public static void main(String[] args) {

        String messageJson = "{\n" +
                "    \"timestamp\": 1532922802654,\n" +
                "    \"id\": \"adb9d862-9a97-419e-99d0-d404f57f1aa2\",\n" +
                "    \"to\": {\n" +
                "        \"app\": \"im.waiter\",\n" +
                "        \"pin\": \"星朗服饰专营店\"\n" +
                "    },\n" +
                "    \"body\": {\n" +
                "        \"riskContent\": \"你看嘛\",\n" +
                "        \"content\": \"你看嘛\",\n" +
                "        \"sid\": \"00710b307cbef873a3d7fa740a4351ad\",\n" +
                "        \"chatinfo\": {\n" +
                "            \"sid\": \"00710b307cbef873a3d7fa740a4351ad\",\n" +
                "            \"appId\": \"im.waiter\",\n" +
                "            \"riskCode\": \"0\",\n" +
                "            \"venderId\": \"75653\",\n" +
                "            \"sessionType\": \"im\",\n" +
                "            \"label\": 1,\n" +
                "            \"aid\": \"yZGxJt8D\",\n" +
                "            \"orderTime\": \"2018-07-2922:21\",\n" +
                "            \"customerAppId\": \"im.customer\",\n" +
                "            \"entrance\": \"123\",\n" +
                "            \"proVer\": \"sm2.0\",\n" +
                "            \"mType\": \"m_wx\",\n" +
                "            \"groupId\": 180430,\n" +
                "            \"jimiPin\": \"jimi_vender_75653\",\n" +
                "            \"source\": \"jimitwo_service_shop_m\",\n" +
                "            \"pin\": \"wdRVgtrbvTwXKO\",\n" +
                "            \"shopId\": \"72092\",\n" +
                "            \"entry\": \"wx_order_sj\",\n" +
                "            \"action\": 1,\n" +
                "            \"orderPrice\": \"103.00\",\n" +
                "            \"IMService\": false,\n" +
                "            \"orderId\": \"77913755660\",\n" +
                "            \"venderName\": \"星朗服饰专营店\",\n" +
                "            \"clientType\": \"m\"\n" +
                "        },\n" +
                "        \"style\": {\n" +
                "            \"bold\": false,\n" +
                "            \"color\": \"#000000\",\n" +
                "            \"font\": \"微软雅黑\",\n" +
                "            \"italic\": false,\n" +
                "            \"size\": 14,\n" +
                "            \"underline\": false\n" +
                "        },\n" +
                "        \"type\": \"text\",\n" +
                "        \"urlPrompt\": {}\n" +
                "    },\n" +
                "    \"mid\": 143213697,\n" +
                "    \"len\": 0,\n" +
                "    \"from\": {\n" +
                "        \"app\": \"im.customer\",\n" +
                "        \"pin\": \"wdrvgtrbvtwxko\",\n" +
                "        \"clientType\": \"m\"\n" +
                "    },\n" +
                "    \"ver\": \"4.0\",\n" +
                "    \"datetime\": 1532922802654,\n" +
                "    \"type\": \"chat_message\",\n" +
                "    \"fromChannelId\": -1\n" +
                "}";

        String a = "{\n" +
                "    \"timestamp\":1532922802654,\n" +
                "    \"id\":\"adb9d862-9a97-419e-99d0-d404f57f1aa2\",\n" +
                "    \"to\":{\n" +
                "        \"app\":\"im.customer\",\n" +
                "        \"pin\":\"pengwenjie3\",\n" +
                "        \"clientType\":\"m\" \n" +
                "    },\n" +
                "    \"body\":{\n" +
                "        \"riskContent\":\"你看嘛\",\n" +
                "        \"content\":\"你看嘛\", \n" +
                "        \"sid\":\"00710b307cbef873a3d7fa740a4351ad\",\n" +
                "        \"chatinfo\":{\n" +
                "            \"sid\":\"00710b307cbef873a3d7fa740a4351ad\",\n" +
                "            \"appId\":\"im.waiter\", \n" +
                "            \"riskCode\":\"0\",\n" +
                "            \"venderId\":\"75653\", \n" +
                "            \"sessionType\":\"im\",\n" +
                "            \"label\":1,\n" +
                "            \"aid\":\"yZGxJt8D\",\n" +
                "            \"orderTime\":\"2018-07-29 22:21\",\n" +
                "            \"customerAppId\":\"open.1e7f4bd0a0eea6a530d00100e0.customer\",\n" +
                "            \"entrance\":\"123\",\n" +
                "            \"proVer\":\"sm2.0\",\n" +
                "            \"mType\":\"m_wx\",\n" +
                "            \"groupId\":180430,\n" +
                "            \"jimiPin\":\"jimi_vender_75653\",\n" +
                "            \"source\":\"jimitwo_service_shop_m\",\n" +
                "            \"pin\":\"wdRVgtrbvTwXKO\",\n" +
                "            \"shopId\":\"72092\",\n" +
                "            \"entry\":\"orderEntryTest\",\n" +
                "            \"action\":1,\n" +
                "            \"orderPrice\":\"103.00\",\n" +
                "            \"IMService\":false,\n" +
                "            \"orderId\":\"77913755660\",\n" +
                "            \"venderName\":\"星朗服饰专营店\",\n" +
                "            \"clientType\":\"m\"\n" +
                "        },\n" +
                "        \"style\":\"{\"bold\":false,\"color\":\"#000000\",\"font\":\"微软雅黑\",\"italic\":false,\"size\":14,\"underline\":false}\",\n" +
                "        \"type\":\"text\",\n" +
                "        \"urlPrompt\":{\n" +
                " \n" +
                "        }\n" +
                "    },\n" +
                "    \"mid\":143213697,\n" +
                "    \"len\":0,\n" +
                "    \"from\":{\n" +
                "\t\t\"app\":\"im.waiter\",\n" +
                "        \"pin\":\"星朗服饰专营店\"\n" +
                "    },\n" +
                "    \"ver\":\"4.0\",\n" +
                "    \"datetime\":1532922802654,\n" +
                "    \"type\":\"chat_message\",\n" +
                "    \"fromChannelId\":-1\n" +
                "}";

        JSONObject jsonObject = JSONObject.parseObject(messageJson);

        String body = jsonObject.getString("body");

        System.out.println("consult:open.vop.test.customer:测试3:browseWareIds".toLowerCase());
    }
}
