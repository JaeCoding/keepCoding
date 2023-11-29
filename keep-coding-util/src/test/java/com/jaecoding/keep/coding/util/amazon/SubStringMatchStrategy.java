package com.jaecoding.keep.coding.util.amazon;

import com.google.inject.internal.util.ImmutableSet;
import com.google.inject.internal.util.Sets;
import com.jaecoding.keep.coding.util.JsonUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class SubStringMatchStrategy {
    public static List<Title.TitleSpan> getBoldSplitTitleList(Set<String> splitAttributeValuesSet, String titleText) {

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

        if (indexList.isEmpty()) {
            // no items need to be bolded, return a list containing the original titleText
            return Collections.singletonList(new Title.TitleSpan(titleText, false));
        }
        // sort the index ranges by their start index
        indexList.sort(Comparator.comparingInt(a -> a[0]));

        List<int[]> mergedIndexList = new ArrayList<>();
        for (int[] ints : indexList) {
            int leftIndex = ints[0];
            int rightIndex = ints[1];
            // If mergedIndexList is empty, or last item in mergedIndexList doesn't intersect with the current item.(last rightIndex < current leftIndex)
            if (mergedIndexList.size() == 0 || mergedIndexList.get(mergedIndexList.size() - 1)[1] < leftIndex) {
                mergedIndexList.add(new int[]{leftIndex, rightIndex});
            } else {
                // Change the rightIndex to the maximum of two items.
                mergedIndexList.get(mergedIndexList.size() - 1)[1] = Math.max(mergedIndexList.get(mergedIndexList.size() - 1)[1], rightIndex);
            }
        }

        // split the titleText into bolded and non-bolded parts based on the merged index ranges
        List<Title.TitleSpan> result = new ArrayList<>();
        int startIndex = 0;
        for (int[] indexes : mergedIndexList) {
            if (startIndex < indexes[0]) {
                result.add(new Title.TitleSpan(titleText.substring(startIndex, indexes[0]), false));
            }
            result.add(new Title.TitleSpan(titleText.substring(indexes[0], indexes[1]), true));
            startIndex = indexes[1];
        }
        if (startIndex < titleText.length()) {
            result.add(new Title.TitleSpan(titleText.substring(startIndex), false));
        }

        return result;
    }


    public static void main(String[] args) throws Exception {


//        ImmutableSet<String> set = ImmutableSet.of("セット", "<新装版>ハリ");
        ImmutableSet<String> set = ImmutableSet.of("夏", "女性", "スカート");
        ImmutableSet<String> set2 = ImmutableSet.of("ドライ", "ドライダー");
        ImmutableSet<String> set3 = ImmutableSet.of("妄想パズル", "パズル");

        String title = "ロング 女性スカート レディース ハイウエスト ゴム リボン付け レース プリーツ 春夏秋 チュー夏天ル マキシ丈 黒ブルーピンク";
        String title2 = "ドライヤー 大風量 速乾 人気 ランキング 2023新登場 1300W マイナスイオン 軽量 折りたたみ式 ヘアドライヤー 恒温ヘアケア 3段階調節 どらいやー ノズル付き コンパクト 軽い ドライヤー 旅行用 家庭用 業務用 携帯ドライヤー";
//        String title = "<新装版>ハリー・ポッター 全11巻セット";
        String title3 = "妄想パズル =1=";

        List<Title.TitleSpan> boldSplitTitleList = getBoldSplitTitleList(set3, title3);

        String json = JsonUtil.toJson(boldSplitTitleList);
        System.out.println(json);

    }
}
