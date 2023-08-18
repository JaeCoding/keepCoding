package com.jaecoding.keep.coding.util.amazon.date;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Optional;

public class ZoneAwareDateTime {
    private final ZoneId zoneId;
    private final ZonedDateTime dateTime;


    private ZoneAwareDateTime(Builder builder) {
        this.zoneId = builder.zoneId;
        this.dateTime = builder.dateTime;
    }


    public ZoneId zoneId() {
        return this.zoneId;
    }

    public ZonedDateTime dateTime() {
        return this.dateTime;
    }

    public static class Builder {
        private ZoneId zoneId;
        private ZonedDateTime dateTime;

        public Builder() {
        }

        public ZoneAwareDateTime build() {
            return new ZoneAwareDateTime(this);
        }

        public Builder zoneId(ZoneId zoneId) {
            this.zoneId = zoneId;
            return this;
        }

        public Builder dateTime(ZonedDateTime dateTime) {
            this.dateTime = dateTime;
            return this;
        }
    }
}
