package com.jaecoding.keep.coding.util;

/**
 * @Author: 彭文杰
 * @Date: Created in 2018/8/23 17:09
 * @Description : 将类名转化为 适合数据库的 字段名
 */
public class ClassNameToDBName {

    public static void main(String[] args) {
        String[] strings = {"useSingleRepayAccount", "useBankAccountAsRepayAccount",
                "singleRepayBankAccountName", "singleRepayBankAccountNumber", "singleRepayBankAbbr",
                "singleRepayBankIssuer", "singleRepayDepositoryAccountId", "canRedeem", "useSingleRedeemAccount",
                "useBankAccountAsRedeemAccount", "singleRedeemBankAccountName", "singleRedeemBankAccountNumber",
                "singleRedeemBankAbbr", "singleRedeemBankIssuer", "singleRedeemDepositoryAccountId"};
        int i = 1;
        for (String str : strings
        ) {
            str = change(str);
            System.out.println(i + "        " + str);
            i++;
        }
    }

    public static String change(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 97 && c <= 122) {
                sb.append(c);
            } else {
                sb.append('_');
                sb.append(Character.toLowerCase(s.charAt(i)));
            }
        }
        s = String.valueOf(sb);
        return s;
    }

}
