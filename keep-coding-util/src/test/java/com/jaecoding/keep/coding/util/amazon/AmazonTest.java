package com.jaecoding.keep.coding.util.amazon;

import com.google.common.collect.ImmutableMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * BoolTest
 *
 * @author pengwenjie3
 * @date 2020/3/3
 * @since 1.8
 */
public class AmazonTest {
    public static void main(String[] args) {
        ImmutableMap<String, String> map = ImmutableMap.of(
                "start", "19",
                "end", "20",
                "attribute", "number_of_players",
                "source", "dl-tail-attribute",
                "canonicalForm", "2");


        QueryUnderstandingBlock span = QueryUnderstandingBlock.builder()
                .id(9)
                .level("span")
                .type(QueryUnderstandingParser.METIS)
                .meta(map)
                .build();

        QueryParsingAttribute queryParsingAttribute = QueryUnderstandingParser.parseMetisBlock(span);

        System.out.println(queryParsingAttribute);


    }
}
