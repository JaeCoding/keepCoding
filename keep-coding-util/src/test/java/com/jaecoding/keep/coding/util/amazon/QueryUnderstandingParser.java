package com.jaecoding.keep.coding.util.amazon;

import com.fasterxml.jackson.core.io.JsonStringEncoder;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.inject.Named;
import javax.inject.Singleton;
import org.apache.commons.lang3.StringUtils;

@Named
@Singleton
public class QueryUnderstandingParser {
    public static final String METIS = "metis";
    public static final String ATTRIBUTE = "attribute";
    public static final String ATTRIBUTE_GROUP = "attributeGroup";
    public static final String CANONICAL_FORM = "canonicalForm";
    public static final String SPAN_TEXT = "spanText";

    public static final List<String> TAIL_ATTRIBUTE_LIST = ImmutableList.of("target_audience",
            "age_range_description",
            "department",
            "material",
            "pg_product_sub_type",
            "compatible_phone_models",
            "lifestyle",
            "item_type_name",
            "item_form",
            "form_factor",
            "target_audience_keyword",
            "special_size_type",
            "sport_type",
            "style",
            "compatible_devices",
            "sleeve.type",
            "shirt_form_type",
            "item_diameter",
            "special_feature");

    /**
     * Parses Q2PT data block
     *
     * @param metisBlock metis block, example: {
     *                  "type": "metis",
     *                  "meta": {
     *                    "start": "0",
     *                    "end": "4",
     *                    "source": "ner-precompute",
     *                    "attribute": "brand",
     *                    "spanText": "nike",
     *                    "canonicalForm": "nike",
     *                    "attributeGroup": "brand"
     *                  },
     *                  "id": 83,
     *                  "level": "query"
     *                  },
     * @return QueryParsingAttribute that are head attributes
     * otherwise an empty list.
     */
    public static QueryParsingAttribute parseMetisBlock(QueryUnderstandingBlock metisBlock) {
        if (metisBlock == null || !METIS.equalsIgnoreCase(metisBlock.getType()) || metisBlock.getMeta() == null
                || (!metisBlock.getMeta().containsKey(ATTRIBUTE_GROUP) && !metisBlock.getMeta().containsKey(ATTRIBUTE))
                || (!metisBlock.getMeta().containsKey(CANONICAL_FORM)) && !metisBlock.getMeta().containsKey(SPAN_TEXT)) {
            return null;
        }

        String attribute = metisBlock.getMeta().get(ATTRIBUTE);
        String attributeGroup = metisBlock.getMeta().get(ATTRIBUTE_GROUP);
        String canonicalForm = metisBlock.getMeta().get(CANONICAL_FORM);
        String spanText = metisBlock.getMeta().get(SPAN_TEXT);

        String attributeValue;

        if (isValidAttributeValue(canonicalForm)) {
            attributeValue = canonicalForm;
        } else if (isValidAttributeValue(spanText)) {
            attributeValue = spanText;
        } else {
            return null;
        }

        if (!StringUtils.isEmpty(attributeGroup)) {
            return new QueryParsingAttribute.Builder().productAttributeName(attributeGroup)
                    .productAttributeValue(attributeValue)
                    .build();
        } else if (!StringUtils.isEmpty(attribute) && TAIL_ATTRIBUTE_LIST.contains(attribute)) {
            return new QueryParsingAttribute.Builder().productAttributeName(attribute)
                    .productAttributeValue(attributeValue)
                    .build();
        } else {
            return null;
        }
    }

    /**
     * verify the string is not empty and that it is json encodable (no invalid surrogate pairs)
     */
    private static boolean isValidAttributeValue(String value) {
        if (StringUtils.isEmpty(value)) {
            return false;
        }

        try {
            JsonStringEncoder.getInstance().encodeAsUTF8(value);
        } catch (Exception e) {
            return false;
        }

        return true;
    }
}
