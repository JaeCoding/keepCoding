package com.jaecoding.keep.coding.domain.dto;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;

/**
 * TODO
 *
 * @author pengwenjie3
 * @date 2019/11/26
 * @since 1.8
 */
public class Test {
    private static String regex = "([a-zA-Z0-9\\s(\\.|,)(\\$|£|€)]+/[\\u4e00-\\u9fa5a-zA-Z0-9\\s]+)";
    private static Pattern pattern = Pattern.compile(regex);

    public static void main(String[] args) {
        List<String> cases = Lists.newArrayList("(CNY 288.20/天)", "(CNY 288.20/_)", "(¥ 288.20/天)", "(¥288.20/d)", "(¥3,714.38/100 g)");
        for (String aCase : cases) {
            boolean isMatch = pattern.matcher(aCase).find();
            System.out.println(aCase + " is match pattern: " + isMatch);
        }

    }
}
