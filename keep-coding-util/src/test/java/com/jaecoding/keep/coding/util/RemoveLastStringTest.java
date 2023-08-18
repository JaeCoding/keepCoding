package com.jaecoding.keep.coding.util;

import java.util.Arrays;
import org.apache.commons.lang3.StringUtils;

/**
 * BoolTest
 *
 * @author pengwenjie3
 * @date 2020/3/3
 * @since 1.8
 */
public class RemoveLastStringTest {
    private static final String ZEROS_WITH_COMMA = ",00";
    private static final String ZEROS_WITH_COMMA_REVERSE = "00,";
    private static final String ZEROS_WITH_DECIMAL = ".00";
    private static final String ZEROS_WITH_DECIMAL_REVERSE = "00.";
    private static final String EMPTY = "";

    public static void main(String[] args) {
        Arrays.asList(
                "1.000,00 TL",
                "800,00 TL",
                "1.000.000,00 TL",
                "1,000,000,00 TL",
                "758,444.000CNY",
                "$ 1,000.00",
                "$1,010.00",
                "$1,000,000.00"
        )
                .forEach(value -> {
                    String a = removeTrailingZeroes2(value);
                    String b = removeTrailingZeroes(value);
                    if (!a.equals(b)){
                        System.out.println(a + "-" + b);
                    }
                });

    }

    public static String removeTrailingZeroes(final String displayPrice) {
        int indexComma = displayPrice.lastIndexOf(ZEROS_WITH_COMMA);//5   1.000,00 TL
        int indexDecimal = displayPrice.lastIndexOf(ZEROS_WITH_DECIMAL);//1
        if (indexComma != -1) {
            if (indexComma + 3 == displayPrice.length() ||
                    (indexComma + 3 < displayPrice.length() && !StringUtils.isNumeric(displayPrice.substring(indexComma + 3, indexComma + 4)))) {
                return removeLastGivenString(displayPrice, ZEROS_WITH_COMMA, EMPTY);
            }
        }

        if (indexDecimal != -1) {
            if (indexDecimal + 3 == displayPrice.length() ||
                    (indexDecimal + 3 < displayPrice.length() && !StringUtils.isNumeric(displayPrice.substring(indexDecimal + 3, indexDecimal + 4)))) {
                return removeLastGivenString(displayPrice, ZEROS_WITH_DECIMAL, EMPTY);
            }
        }
        return displayPrice;
    }

    private static String removeLastGivenString(String displayPrice, String removeText, String empty) {
        String reverse = new StringBuffer(displayPrice).reverse().toString();
        String removeTextAfterReverse = new StringBuffer(removeText).reverse().toString();
        reverse = reverse.replaceFirst(removeTextAfterReverse, empty);
        return new StringBuffer(reverse).reverse().toString();
    }



    public static String removeTrailingZeroes2(final String displayPrice) {
        int indexComma = displayPrice.lastIndexOf(ZEROS_WITH_COMMA);
        int indexDecimal = displayPrice.lastIndexOf(ZEROS_WITH_DECIMAL);
        if (indexComma != -1 && (indexComma + 3) < displayPrice.length()) {
            if (StringUtils.isNumeric(displayPrice.substring(indexComma+3, indexComma+4))) {
                return displayPrice.replace(ZEROS_WITH_DECIMAL, EMPTY);
            }
        }
        if (indexDecimal != -1 && (indexDecimal + 3) < displayPrice.length()) {
            if (StringUtils.isNumeric(displayPrice.substring(indexDecimal+3, indexDecimal+4))) {
                return displayPrice.replace(ZEROS_WITH_COMMA, EMPTY);
            }
        }
        return StringUtils.removeEnd(displayPrice, ZEROS_WITH_DECIMAL).replace(ZEROS_WITH_COMMA, EMPTY);
    }
}
