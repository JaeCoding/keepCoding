package com.jaecoding.keep.coding.util.amazon;

/* Copyright 2017 Amazon.com, Inc. or its affiliates. All Rights Reserved. */

import java.util.List;
import lombok.Data;
import lombok.Getter;

/**
 * Title information of product.
 *
 * @author zytan
 */
@Data
public class Title {
    private String asin;
    private boolean shouldLog;
    /**
     * The title description of product.
     */
    private String title;
    /**
     * Secondary title.
     */
    private String secondaryTitle;
    /**
     * The detail page url
     */
    private String url;
    /**
     * The product type of the asin. It is used only for logging purpose.
     */
    private String productType;
    /**
     * Just used for logging purpose.
     */
    private String productGroupDescription;


    /**
     * Used for bold the word in title by the QU attribute
     */
    private List<TitleSpan> titleSpanList;


    /**
     * Constructor.
     */
    public Title() {

    }

    public static class TitleSpan {
        @Getter
        private final String title;
        @Getter
        private final boolean shouldBold;

        TitleSpan(String title, boolean shouldBold) {
            this.title = title;
            this.shouldBold = shouldBold;
        }
    }
}

