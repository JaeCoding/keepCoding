package com.jaecoding.keep.coding.util.amazon;

import com.google.common.collect.ImmutableMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TemperTest {

    static final Map<String, Boolean> WOMEN_DRESS_EXPECT_TITLE_SPAN = ImmutableMap.of(
            "Women", true,
            "'s Summer Short Sleeve Casual Dresses V-Neck Floral Party ", false,
            "Dress", true,
            " with Pockets", false
    );
    public static void main(String[] args) {
        List<Title.TitleSpan> exceptTitleSpanList = WOMEN_DRESS_EXPECT_TITLE_SPAN.entrySet().stream()
                .map(entry -> new Title.TitleSpan(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
        exceptTitleSpanList.forEach(entry -> {
            System.out.println(entry.getTitle() + entry.isShouldBold());
        });
    }
}
