package com.jaecoding.keep.coding.util.amazon;

import java.beans.ConstructorProperties;
import java.util.List;
import java.util.Map;
import lombok.Generated;

public class QueryUnderstandingBlock {
    private String type;
    private Map<String, String> meta;
    private long id;
    private String level;
    private List<Long> group;

    @Generated
    public static QueryUnderstandingBlock.QueryUnderstandingBlockBuilder builder() {
        return new QueryUnderstandingBlock.QueryUnderstandingBlockBuilder();
    }

    @Generated
    public QueryUnderstandingBlock() {
    }

    @ConstructorProperties({"type", "meta", "id", "level", "group"})
    @Generated
    public QueryUnderstandingBlock(String type, Map<String, String> meta, long id, String level, List<Long> group) {
        this.type = type;
        this.meta = meta;
        this.id = id;
        this.level = level;
        this.group = group;
    }

    @Generated
    public String getType() {
        return this.type;
    }

    @Generated
    public Map<String, String> getMeta() {
        return this.meta;
    }

    @Generated
    public long getId() {
        return this.id;
    }

    @Generated
    public String getLevel() {
        return this.level;
    }

    @Generated
    public List<Long> getGroup() {
        return this.group;
    }

    @Generated
    public static class QueryUnderstandingBlockBuilder {
        @Generated
        private String type;
        @Generated
        private Map<String, String> meta;
        @Generated
        private long id;
        @Generated
        private String level;
        @Generated
        private List<Long> group;

        @Generated
        QueryUnderstandingBlockBuilder() {
        }

        @Generated
        public QueryUnderstandingBlock.QueryUnderstandingBlockBuilder type(String type) {
            this.type = type;
            return this;
        }

        @Generated
        public QueryUnderstandingBlock.QueryUnderstandingBlockBuilder meta(Map<String, String> meta) {
            this.meta = meta;
            return this;
        }

        @Generated
        public QueryUnderstandingBlock.QueryUnderstandingBlockBuilder id(long id) {
            this.id = id;
            return this;
        }

        @Generated
        public QueryUnderstandingBlock.QueryUnderstandingBlockBuilder level(String level) {
            this.level = level;
            return this;
        }

        @Generated
        public QueryUnderstandingBlock.QueryUnderstandingBlockBuilder group(List<Long> group) {
            this.group = group;
            return this;
        }

        @Generated
        public QueryUnderstandingBlock build() {
            return new QueryUnderstandingBlock(this.type, this.meta, this.id, this.level, this.group);
        }

        @Generated
        public String toString() {
            return "QueryUnderstandingBlock.QueryUnderstandingBlockBuilder(type=" + this.type + ", meta=" + this.meta + ", id=" + this.id + ", level=" + this.level + ", group=" + this.group + ")";
        }
    }
}

