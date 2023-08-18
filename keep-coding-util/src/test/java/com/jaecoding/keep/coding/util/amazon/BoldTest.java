package com.jaecoding.keep.coding.util.amazon;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

public class BoldTest {


    public static class BoldTitle {
        private final String title;
        private final boolean shouldBold;

        public BoldTitle(String title, boolean shouldBold) {
            this.title = title;
            this.shouldBold = shouldBold;
        }

        public String getTitle() {
            return title;
        }

        public boolean getShouldBold() {
            return shouldBold;
        }
    }

    public static class QueryParsingAttribute {
        private String productAttributeName;
        private String productAttributeValue;

        public QueryParsingAttribute(String productAttributeName, String productAttributeValue) {
            this.productAttributeName = productAttributeName;
            this.productAttributeValue = productAttributeValue;
        }

        public String getProductAttributeName() {
            return productAttributeName;
        }

        public String getProductAttributeValue() {
            return productAttributeValue;
        }
    }

    public static List<BoldTitle> getBoldList2(List<QueryParsingAttribute> queryParsingAttributes, String titleTextValue) {
        // match set
        Set<String> attributeValues = new HashSet<>();
        for (QueryParsingAttribute attribute : queryParsingAttributes) {
            attributeValues.add(attribute.getProductAttributeValue());
        }

        List<BoldTitle> boldTitleList = new ArrayList<>();
        StringBuilder currentPartTitleText = new StringBuilder();
        boolean isFirstWord = true;

        for (String word : titleTextValue.split(" ")) {
            // create a new text for un-bold part
            if (currentPartTitleText == null) {
                currentPartTitleText = new StringBuilder();
            }
            // First word not need add black
            if (!isFirstWord) {
                currentPartTitleText.append(" ");
            }
            isFirstWord = false;

            if (attributeValues.contains(word)) {
                boldTitleList.add(new BoldTitle(currentPartTitleText.toString(), false));
                boldTitleList.add(new BoldTitle(word, true));
                // settle the currentPartTitleText
                currentPartTitleText = null;
            } else {
                currentPartTitleText.append(word);
            }
        }
        if (currentPartTitleText != null) {
            boldTitleList.add(new BoldTitle(currentPartTitleText.toString(), false));
        }

        return boldTitleList;
    }

    public static void main(String[] args) {
        List<QueryParsingAttribute> queryParsingAttributes = new ArrayList<>();
        queryParsingAttributes.add(new QueryParsingAttribute("name", "harry potter"));
        queryParsingAttributes.add(new QueryParsingAttribute("name", "toys"));
        String titleTextValue = "Wizarding World Harry Potter, 13-inch Hermione Granger Patronus Spell Wand with Otter Figure, Lights and Sounds, Kids Toys for Ages 6 and up";
        List<Title.TitleSpan> titleSpanList = getBoldList(queryParsingAttributes, titleTextValue);
        System.out.println(titleSpanList);
    }



    public static List<Title.TitleSpan> getBoldList(List<QueryParsingAttribute> queryParsingAttributes, String titleTextValue) {
        // match set
        if (CollectionUtils.isEmpty(queryParsingAttributes)) {
            return null;
        }
        Set<String> splitAttributeValuesSet = queryParsingAttributes.stream()
                .map(QueryParsingAttribute::getProductAttributeValue)
                .map(tokens -> tokens.toLowerCase(Locale.ROOT))
                .flatMap(queryParsingAttributeValue -> Arrays.stream(queryParsingAttributeValue.split(" ")))
                .filter(StringUtils::isNotBlank)
                .collect(Collectors.toSet());

        List<Title.TitleSpan> titleSpanList = new ArrayList<>();
        List<String> splitWordList = getSplitWordListByBlankAndPunctuation(titleTextValue);
        StringBuilder builder = new StringBuilder();
        for (String word : splitWordList) {
            if (splitAttributeValuesSet.contains(word.toLowerCase(Locale.ROOT))) {
                // Settle the current Part TitleText
                String text = builder.toString();
                if (StringUtils.isNotEmpty(text)) {
                    titleSpanList.add(new Title.TitleSpan(text, false));
                }
                titleSpanList.add(new Title.TitleSpan(word, true));
                // Create a new builder
                builder = new StringBuilder();
            } else {
                builder.append(word);
            }
        }
        String text = builder.toString();
        if (StringUtils.isNotBlank(text)) {
            titleSpanList.add(new Title.TitleSpan(text, false));
        }

        return titleSpanList;
    }

    private static List<String> getSplitWordListByBlankAndPunctuation(String titleTextValue) {
        List<String> splitList = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\s+|\\p{Punct}");

        Matcher matcher = pattern.matcher(titleTextValue);
        int index = 0;
        while (matcher.find()) {
            String match = matcher.group();
            if (index != matcher.start()) {
                String word = titleTextValue.substring(index, matcher.start());
                splitList.add(word);
            }
            splitList.add(match);
            index = matcher.end();
        }
        if (index < titleTextValue.length()) {
            String word = titleTextValue.substring(index);
            splitList.add(word);
        }
        return splitList;
    }

}


