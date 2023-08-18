package com.jaecoding.keep.coding.util.amazon.date;


import com.google.common.collect.ImmutableMap;
import com.ibm.icu.text.DateFormat;
import com.ibm.icu.text.MessageFormat;
import com.ibm.icu.util.TimeZone;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class DateTest {
    private static final String DEFAULT_FAST_TRACK_DATE_FORMAT = "{date,date,::EEEEMMMMd}";
    private static final Map<Locale, String> FAST_TRACK_DATE_FORMAT_MAP = new ImmutableMap.Builder<Locale, String>()
            .put(Locale.US, "{date,date,::EEEEMMMd}")
            .put(Locale.CANADA, "{date,date,::EEEEMMMd}")
            .put(new Locale("pt", "BR"), "{date,date,::EEEEMMMd}")
            .put(Locale.UK, "{date,date,::EEEEMMMd}")
            .put(new Locale("en", "JP"), "{date,date,::EEEEMMMd}")
            .put(Locale.JAPAN, "{date,date,::EEEEyMd}")
            .put(Locale.CHINA, "{date,date,EEEE(M\u6708d\u65e5)}")
            .put(new Locale("en", "SG"), "{date,date,::EEEMMMd}")
            .put(new Locale("nl", "NL"), "{date,date,::EEEEMMMd}")
            .put(new Locale("nl", "BE"), "{date,date,::EEEEMMMd}")
            .build();

    public static void main(String[] args) {
        String formattedDate = getFormattedDate(Locale.JAPANESE);
    }

    private static final LocalDateTime MAY_12TH = LocalDateTime.of(2021, 5, 12, 0, 0);
    private static final LocalDateTime MAY_15TH = LocalDateTime.of(2021, 5, 15, 0, 0);
    private static final LocalDateTime MAY_18TH = LocalDateTime.of(2021, 5, 18, 0, 0);
    private static final LocalDateTime MAY_20TH = LocalDateTime.of(2021, 5, 20, 20, 0);
    private static final String ZONE_ID_US_PACIFIC = "US/Pacific";
    private static final String ZONE_ID_ASIA_TOKYO = "Asia/Tokyo";

    @Test
    public void test3() {


        assertEquals(DeliveryComponentUtils.getFormattedDate(buildZoneAwareDateTime(MAY_12TH, ZONE_ID_US_PACIFIC), Locale.US),
                "Tue, May 11");

        assertEquals(DeliveryComponentUtils.getFormattedDate(buildZoneAwareDateTime(MAY_18TH, ZONE_ID_ASIA_TOKYO), Locale.UK),
                "Tuesday, 18 May");

        assertEquals(DeliveryComponentUtils.getFormattedDate(buildZoneAwareDateTime(MAY_20TH, ZONE_ID_ASIA_TOKYO), Locale.US),
                "Fri, May 21");
    }

    private ZoneAwareDateTime buildZoneAwareDateTime(final LocalDateTime dateTime, final String zoneId) {
        return new ZoneAwareDateTime.Builder()
                .dateTime(ZonedDateTime.of(dateTime, ZoneId.of("UTC")))
                .zoneId(ZoneId.of(zoneId))
                .build();
    }

    public static String getFormattedDate(final Locale locale) {
        // Refer Fasttrack component for delivery message dateformat - https://tiny.amazon.com/88vz2q3q
        final String fastTrackDateFormat = FAST_TRACK_DATE_FORMAT_MAP.get(locale);

        final ZonedDateTime zoneAwarePromiseDate = ZonedDateTime.now();
        zoneAwarePromiseDate.withZoneSameInstant(ZoneId.of("Asia/Tokyo"));
        MessageFormat messageFormat = new MessageFormat(fastTrackDateFormat, locale);
        return messageFormat.format(ImmutableMap.of("date", zoneAwarePromiseDate));
    }



    public static String getFastTrackDateFormat(Locale locale) {
        String fastTrackDateFormat =  FAST_TRACK_DATE_FORMAT_MAP.get(locale);

        if (StringUtils.isNotEmpty(fastTrackDateFormat)) {
            return fastTrackDateFormat;
        }

        return DEFAULT_FAST_TRACK_DATE_FORMAT;
    }

    private static void test1() {
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now.toString());
        DateFormat dateFormat = DateFormat.getInstanceForSkeleton(DateFormat.ABBR_MONTH_DAY, Locale.US); // e.g. Apr 25

        dateFormat.setTimeZone(TimeZone.getTimeZone(now.getZone().getId()));
        String displayDate = dateFormat.format(Date.from(now.toInstant()));
        System.out.println(displayDate);
    }
}
