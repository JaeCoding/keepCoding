package com.jaecoding.keep.coding.util.amazon;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Objects;

@JsonDeserialize(
        builder = QueryParsingAttribute.Builder.class
)
public class QueryParsingAttribute {
    private String productAttributeName;
    private String productAttributeValue;

    public QueryParsingAttribute(QueryParsingAttribute.Builder builder) {
        this.productAttributeName = builder.productAttributeName;
        this.productAttributeValue = builder.productAttributeValue;
    }

    public String getProductAttributeName() {
        return this.productAttributeName;
    }

    public String getProductAttributeValue() {
        return this.productAttributeValue;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            QueryParsingAttribute that = (QueryParsingAttribute)o;
            return Objects.equals(this.productAttributeName, that.productAttributeName) && Objects.equals(this.productAttributeValue, that.productAttributeValue);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.productAttributeName, this.productAttributeValue});
    }

    public static class Builder {
        @JsonProperty("productAttributeName")
        private String productAttributeName;
        @JsonProperty("productAttributeValue")
        private String productAttributeValue;

        public Builder() {
        }

        public QueryParsingAttribute.Builder productAttributeName(String productAttributeName) {
            this.productAttributeName = productAttributeName;
            return this;
        }

        public QueryParsingAttribute.Builder productAttributeValue(String productAttributeValue) {
            this.productAttributeValue = productAttributeValue;
            return this;
        }

        public QueryParsingAttribute build() {
            return new QueryParsingAttribute(this);
        }
    }
}
