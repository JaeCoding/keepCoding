package com.jaecoding.keep.coding.util.amazon;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

public class SubStringBoldTest {


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


    public static void main(String[] args) {
        List<BoldTitle> boldTitleList = TestEnglish();
        boldTitleList.forEach(item -> System.out.println(item.getTitle() + '-' + item.getShouldBold()));
        System.out.println("----------");
        List<BoldTitle> japan = TestJapan();
        japan.forEach(item -> System.out.println(item.getTitle() + '-' + item.getShouldBold()));
    }

    private static List<BoldTitle> TestEnglish() {
        List<QueryParsingAttribute> queryParsingAttributes = new ArrayList<>();
        queryParsingAttributes.add(new QueryParsingAttribute("name", "harry potter"));
        queryParsingAttributes.add(new QueryParsingAttribute("name", "Toys"));
        String titleTextValue = "Wizarding World Harry Potter, 13-inch Hermione Granger Patronus Spell Wand with Otter Figure, Lights and Sounds, Kids Toys for Ages 6 and up";

        List<BoldTitle> boldTitleList = getBoldList(queryParsingAttributes, titleTextValue);
        return boldTitleList;
    }

    private static List<BoldTitle> TestJapan() {
        List<QueryParsingAttribute> queryParsingAttributes = new ArrayList<>();
        queryParsingAttributes.add(new QueryParsingAttribute("name", "セット"));
        queryParsingAttributes.add(new QueryParsingAttribute("name", "<新装版>ハリ"));
        String titleTextValue = "<新装版>ハリー・ポッター 全11巻セット";

        List<BoldTitle> boldTitleList = getBoldList(queryParsingAttributes, titleTextValue);
        return boldTitleList;
    }


    public static List<BoldTitle> getBoldList(List<QueryParsingAttribute> queryParsingAttributes, String titleText) {
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

        // convert titleText to lowercase for case-insensitive matching
        String lowercaseTitleText = titleText.toLowerCase(Locale.ROOT);

        List<int[]> indexList = new ArrayList<>();
        // find all index ranges of items to be bolded
        for (String item : splitAttributeValuesSet) {
            // convert item to lowercase for case-insensitive matching
            String lowercaseItem = item.toLowerCase(Locale.ROOT);
            int index = lowercaseTitleText.indexOf(lowercaseItem);
            while (index != -1) {
                indexList.add(new int[]{index, index + item.length()});
                index = lowercaseTitleText.indexOf(lowercaseItem, index + 1);
            }
        }

        // sort the index ranges by their start index
        indexList.sort(Comparator.comparingInt(a -> a[0]));

        if (indexList.isEmpty()) {
            // no items need to be bolded, return a list containing the original titleText
            return Collections.singletonList(new BoldTitle(titleText, false));
        }

        // merge the overlapping index ranges
        List<int[]> mergedIndexList = new ArrayList<>();
        int[] previous = indexList.get(0);
        for (int i = 1; i < indexList.size(); i++) {
            int[] current = indexList.get(i);
            while (previous[1] >= current[0]) {
                // overlapping, merge current index range into previous index range
                previous[1] = Math.max(previous[1], current[1]);
                if (i == indexList.size() - 1) {
                    // current is the last index range, merge is done
                    break;
                }
                // move on to the next index range
                i++;
                current = indexList.get(i);
            }
            mergedIndexList.add(previous);
            previous = current;
        }
        mergedIndexList.add(previous);

        // split the titleText into bolded and non-bolded parts based on the merged index ranges
        List<BoldTitle> result = new ArrayList<>();
        int startIndex = 0;
        for (int[] indexes : mergedIndexList) {
            if (startIndex < indexes[0]) {
                result.add(new BoldTitle(titleText.substring(startIndex, indexes[0]), false));
            }
            result.add(new BoldTitle(titleText.substring(indexes[0], indexes[1]), true));
            startIndex = indexes[1];
        }
        if (startIndex < titleText.length()) {
            result.add(new BoldTitle(titleText.substring(startIndex), false));
        }

        return result;
    }
}


