/* Copyright 2017 Amazon.com, Inc. or its affiliates. All Rights Reserved. */
package com.jaecoding.keep.coding.util.amazon.date;

import com.google.common.collect.ImmutableMap;
import com.ibm.icu.text.MessageFormat;
import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

/**
 * Provides the locale-specific date-formats
 */
public class DateUtil {

    // Date formats for RAFN & AGS programs
    private static final String DEFAULT_RANGE_DATE_FORMAT = "{date,date,::MMMd}";

    private static final String DEFAULT_DELIVERY_DATE_FORMAT = "{date,date,::EEEEMMMMd}";
    private static final Map<Locale, String> DELIVERY_DATE_FORMAT_MAP = new ImmutableMap.Builder<Locale, String>()
            .put(Locale.CANADA, "{date,date,::EEEEMMMd}")
            .build();

    // Date formats for fast-track
    // TODO: The deprecated date format should be removed after Global Store migrated off the old date format map
    // Tracking ticket: https://t.corp.amazon.com/D73647835
    private static final String DEFAULT_FAST_TRACK_DATE_FORMAT_DEPRECATED = "EEEE, MMMM d";
    private static final Map<Locale, String> FAST_TRACK_DATE_FORMAT_MAP_DEPRECATED = new ImmutableMap.Builder<Locale, String>()
            .put(Locale.US, "EEEE, MMM d")
            .put(Locale.CANADA, "EEEE, MMM d")
            .put(new Locale("pt", "BR"), "EEEE, d 'de' MMM")
            .put(Locale.UK, "EEEE, MMM d")
            .put(new Locale("en", "JP"), "EEEE, MMM d")
            .put(Locale.GERMANY, "EEEE, d. MMMM")
            .put(Locale.JAPAN, "yyyy/M/d EEEE")
            .put(Locale.FRANCE, "EEEE d MMMM")
            .put(Locale.ITALY, "EEEE d MMMM")
            .put(new Locale("fr", "CA"), "EEEE d MMMM")
            .put(new Locale("es", "ES"), "EEEE, d 'de' MMMM")
            .put(Locale.CHINA, "EEEE(M\u6708d\u65e5)")
            .put(new Locale("es", "MX"), "EEEE, d 'de' MMMM")
            .put(new Locale("es", "US"), "EEEE, d 'de' MMMM")
            .put(new Locale("tr", "TR"), "d MMMM EEEE")
            .put(new Locale("ar", "AE"), "EEEE, d MMMM")
            .put(new Locale("ar", "SA"), "EEEE, d MMMM")
            .put(new Locale("ar", "EG"), "EEEE, d MMMM")
            .put(new Locale("en", "SG"), "EEE, d MMM")
            .put(new Locale("en", "IN"), "EEEE, MMMM d")
            .put(new Locale("nl", "NL"), "EEEE, d MMM.")
            .put(new Locale("sv", "SE"), "EEEE, d MMMM")
            .put(new Locale("pt", "PT"), "EEEE, d 'de' MMMM")
            .put(new Locale("pl", "PL"), "EEEE, d MMMM")
            .put(new Locale("nl", "BE"), "EEEE d MMM.")
            .put(new Locale("fr", "BE"), "EEEE d MMMM")
            .put(new Locale("es", "CO"), "EEEE, d 'de' MMMM")
            .put(new Locale("es", "CL"), "EEEE, d 'de' MMMM")
            .build();

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

    // Date formats for pre-order
    private static final String DEFAULT_PRE_ORDER_DATE_FORMAT = "{date,date,::yMMMMd}";
    private static final Map<Locale, String[]> PRE_ORDER_DATE_FORMAT_MAP = new ImmutableMap.Builder<Locale, String[]>()
            .put(Locale.US, new String[]{"{date,date,::y}", "{date,date,::yMMMM}", "{date,date,::yMMMMd}"})
            .put(Locale.CANADA, new String[]{"{date,date,::y}", "{date,date,::yMMMM}", "{date,date,::yMMMMd}" })
            .put(new Locale("pt", "BR"), new String[]{"{date,date,::y}", "{date,date,::yMMMM}", "{date,date,::yMMMMd}" })
            .put(Locale.UK, new String[]{"{date,date,::y}", "{date,date,::yMMMM}", "{date,date,::yMMMMd}" })
            .put(new Locale("en", "JP"), new String[]{"{date,date,::y}", "{date,date,::yMMMM}", "{date,date,::yMMMMd}" })
            .put(Locale.GERMANY, new String[]{"{date,date,::y}", "{date,date,::yMMMM}", "{date,date,::yMMMMd}"})
            .put(Locale.JAPAN, new String[]{"{date,date,::y}", "{date,date,yyyy/M}"   , "{date,date,::yMd}"    })
            .put(Locale.FRANCE, new String[]{"{date,date,::y}", "{date,date,::yMMMM}", "{date,date,::yMMMMd}" })
            .put(Locale.ITALY, new String[]{"{date,date,::y}", "{date,date,::yMMMM}", "{date,date,::yMMMMd}" })
            .put(new Locale("fr", "CA"), new String[]{"{date,date,::y}", "{date,date,::yMMMM}", "{date,date,::yMMMMd}" })
            .put(new Locale("ar", "AE"), new String[]{"{date,date,::y}", "{date,date,::yMMMM}", "{date,date,::yMMMMd}" })
            .put(new Locale("ar", "SA"), new String[]{"{date,date,::y}", "{date,date,::yMMMM}", "{date,date,::yMMMMd}" })
            .put(new Locale("ar", "EG"), new String[]{"{date,date,::y}", "{date,date,::yMMMM}", "{date,date,::yMMMMd}" })
            .put(new Locale("fr", "BE"), new String[]{"{date,date,::y}", "{date,date,::yMMMM}", "{date,date,::yMMMMd}" })
            .build();

    // Date formats for fast track delivery day: "Today"/"Tomorrow"
    // For Arabic locale like (AE, SA and EG), extra space added before date " d MMMM" to support BiDi.
    // All detail added to this SIM https://issues.amazon.com/issues/D9909787
    private static final String DEFAULT_DELIVERY_DAY_FAST_TRACK_DATE_FORMAT = "{date,date,::MMMd}";
    private static final Map<Locale, String> DELIVERY_DAY_FAST_TRACK_DATE_FORMAT_MAP = new ImmutableMap.Builder<Locale, String>()
            .put(new Locale("es", "US"), "{date,date,::MMMMd}")
            .put(new Locale("es", "MX"), "{date,date,::MMMMd}")
            .put(new Locale("es", "ES"), "{date,date,::MMMMd}")
            .put(Locale.GERMANY, "{date,date,::MMMMd}")
            .put(Locale.CHINA, "{date,date,(M\u6708d\u65e5)}")
            .put(Locale.CANADA_FRENCH, "{date,date,'le' d MMMM}")
            .put(Locale.FRANCE, "{date,date,'le' d MMMM}")
            .put(Locale.ITALY, "{date,date,::MMMMd}") // to be in sync with other deliveryPromise CX(FAST_TRACK_DATE_FORMAT_MAP)
            .put(Locale.JAPAN, "{date,date,MMM/d}")
            .put(new Locale("tr", "TR"), "{date,date,::MMMMd}")
            .put(new Locale("ar", "AE"), "{date,date,::MMMMd}")
            .put(new Locale("ar", "SA"), "{date,date,::MMMMd}")
            .put(new Locale("ar", "EG"), "{date,date,::MMMMd}")
            .put(new Locale("en", "IN"), "{date,date,::MMMMd}")
            .put(new Locale("pt", "PT"), "{date,date,::MMMMd}")
            .put(new Locale("fr", "BE"), "{date,date,'le' d MMMM}")
            .put(new Locale("es", "CO"), "{date,date,::MMMMd}")
            .put(new Locale("es", "CL"), "{date,date,::MMMMd}")
            .build();

    private static final String DEFAULT_HOUR_GRANULARITY_DATE_FORMAT = "{date,date,::j}";
    private static final Map<Locale, String> DEFAULT_HOUR_GRANULARITY_DATE_FORMAT_MAP = new ImmutableMap.Builder<Locale, String>()
            .put(Locale.US, "{date,date,ha}")
            .put(new Locale("es", "US"), "{date,date,ha}")
            .put(new Locale("es", "ES"), "{date,date,H:mm}") // ES use 24 hours systems
            .put(new Locale("it", "IT"), "{date,date,H:mm}") // IT use 24 hours systems
            .put(new Locale("pt", "PT"), "{date,date,H:mm}") // PT use 24 hours systems
            .put(new Locale("de", "DE"), "{date,date,H' Uhr'}") // DE use 24 hours systems
            .put(new Locale("fr", "FR"), "{date,date,H'h'}") // FR use 24 hours systems
            .put(new Locale("pl", "PL"), "{date,date,H:mm}") // PL use 24 hours systems
            .put(new Locale("nl", "NL"), "{date,date,H:mm}") // NL use 24 hours systems
            .put(new Locale("tr", "TR"), "{date,date,H:mm}") // TR use 24 hours systems
            .put(new Locale("cs", "CZ"), "{date,date,H:mm}") // CZ use 24 hours systems
            .put(new Locale("en", "GB"), "{date,date,ha}")
            .put(new Locale("nl", "BE"), "{date,date,H:mm}") // NL use 24 hours systems
            .put(new Locale("fr", "BE"), "{date,date,H'h'}") // FR use 24 hours systems
            .put(new Locale("es", "CO"), "{date,date,H:mm}") // ES use 24 hours systems
            .put(new Locale("es", "CL"), "{date,date,H:mm}") // ES use 24 hours systems
            .build();

    private static final String HOUR_GRANULARITY_DATE_FORMAT_FOR_DELIVERY_WINDOW = "{date,date,::j}";
    private static final Map<Locale, String> HOUR_GRANULARITY_DATE_FORMAT_FOR_DELIVERY_WINDOW_MAP = new ImmutableMap.Builder<Locale, String>()
            .put(Locale.US, "{date,date,h a}")
            .put(new Locale("es", "US"), "{date,date,h a}")
            .put(new Locale("es", "ES"), "{date,date,H:mm}") // ES use 24 hours systems
            .put(new Locale("it", "IT"), "{date,date,H:mm}") // IT use 24 hours systems
            .put(new Locale("pt", "PT"), "{date,date,H:mm}") // PT use 24 hours systems
            .put(new Locale("de", "DE"), "{date,date,H' Uhr'}") // DE use 24 hours systems
            .put(new Locale("fr", "FR"), "{date,date,H'h'}") // FR use 24 hours systems
            .put(new Locale("pl", "PL"), "{date,date,H:mm}") // PL use 24 hours systems
            .put(new Locale("nl", "NL"), "{date,date,H:mm}") // NL use 24 hours systems
            .put(new Locale("tr", "TR"), "{date,date,H:mm}") // TR use 24 hours systems
            .put(new Locale("cs", "CZ"), "{date,date,H:mm}") // CZ use 24 hours systems
            .put(new Locale("en", "GB"), "{date,date,h a}")
            .put(new Locale("nl", "BE"), "{date,date,H:mm}") // NL use 24 hours systems
            .put(new Locale("fr", "BE"), "{date,date,H'h'}") // FR use 24 hours systems
            .put(new Locale("es", "CO"), "{date,date,H:mm}") // ES use 24 hours systems
            .put(new Locale("es", "CL"), "{date,date,H:mm}") // ES use 24 hours systems
            .put(new Locale("en", "IN"), "{date,date,h a}")
            .build();

    private static final String MILITARY_TIME_FORMAT = "{date,date,::jm}";
    private static final Map<Locale, String> MILITARY_TIME_FORMAT_MAP = new ImmutableMap.Builder<Locale, String>()
            .put(Locale.US, "{date,date,H:mm}")
            .put(Locale.SIMPLIFIED_CHINESE, "{date,date,H:mm}")
            .put(Locale.JAPAN, "{date,date,H:mm}")
            .put(Locale.JAPANESE, "{date,date,H:mm}")
            .build();

    /**
     * Gets the date format for fast-track for the specified locale.
     * The format is extracted from a static map
     * TODO: The deprecated date format should be removed after Global Store migrated off the old date format map
     * Tracking ticket: https://t.corp.amazon.com/D73647835
     * @param locale the locale
     * @return the date format (for use with SimpleDateFormat class)
     */
    @Deprecated
    public static String getFastTrackDateFormatDeprecated(Locale locale) {
        String fastTrackDateFormat =  FAST_TRACK_DATE_FORMAT_MAP_DEPRECATED.get(locale);

        if (StringUtils.isNotEmpty(fastTrackDateFormat)) {
            return fastTrackDateFormat;
        }

        return DEFAULT_FAST_TRACK_DATE_FORMAT_DEPRECATED;
    }

    public static String getFastTrackDateFormat(Locale locale) {
        String fastTrackDateFormat =  FAST_TRACK_DATE_FORMAT_MAP.get(locale);

        if (StringUtils.isNotEmpty(fastTrackDateFormat)) {
            return fastTrackDateFormat;
        }

        return DEFAULT_FAST_TRACK_DATE_FORMAT;
    }

    /**
     * Gets the date format for pre-order for the specified locale. The format is extracted from a static map.
     * The format is based on the number of parts specified.
     * - If parts == 1, we show only year.
     * - If parts == 2, we show month and year.
     * - If parts == 3, we show date, month and year.
     * - If parts > 3, we will show the same as when parts == 3.
     *
     * @param locale the locale
     * @param parts the number of parts of date/time that is valid or specified
     * @return the date format (for use with SimpleDateFormat class)
     */
    public static String getPreOrderDateFormat(Locale locale, int parts) {
        if (parts <= 0) {
            return "";
        }
        String[] preOrderDateFormat = PRE_ORDER_DATE_FORMAT_MAP.get(locale);
        if (preOrderDateFormat != null) {
            if (parts > preOrderDateFormat.length) {
                parts = preOrderDateFormat.length;
            }
            return preOrderDateFormat[parts - 1];
        }
        return DEFAULT_PRE_ORDER_DATE_FORMAT;
    }

    /**
     * Gets the date format for fast-track for the specified locale.
     * The format is extracted from a static map
     *
     * @param locale the locale
     * @return the date format (for use with SimpleDateFormat class)
     */
    public static String getDeliveryDayFastTrackDateFormat(Locale locale) {
        String fastTrackDateFormat =  DELIVERY_DAY_FAST_TRACK_DATE_FORMAT_MAP.get(locale);
        if (StringUtils.isNotEmpty(fastTrackDateFormat)) {
            return fastTrackDateFormat;
        }
        return DEFAULT_DELIVERY_DAY_FAST_TRACK_DATE_FORMAT;
    }

    /**
     * Gets the date format for showing hourly granularities for the specified locale.
     * The format is extracted from a static map
     *
     * @param locale the locale
     * @return the date format (for use with SimpleDateFormat class)
     */
    public static String getHourGranularityDateFormat(Locale locale) {
        String hourGranularityDateFormat =  DEFAULT_HOUR_GRANULARITY_DATE_FORMAT_MAP.get(locale);
        if (StringUtils.isNotEmpty(hourGranularityDateFormat)) {
            return hourGranularityDateFormat;
        }
        return DEFAULT_HOUR_GRANULARITY_DATE_FORMAT;
    }

    /**
     * Gets the date format for showing hourly granularities for the specified locale.
     * The format is extracted from a static map
     *
     * @param locale the locale
     * @return the date format (for use with SimpleDateFormat class)
     */
    public static String getHourGranularityDateFormatWithSpace(Locale locale) {
        String hourGranularityDateFormat =  HOUR_GRANULARITY_DATE_FORMAT_FOR_DELIVERY_WINDOW_MAP.get(locale);
        if (StringUtils.isNotEmpty(hourGranularityDateFormat)) {
            return hourGranularityDateFormat;
        }
        return HOUR_GRANULARITY_DATE_FORMAT_FOR_DELIVERY_WINDOW;
    }

    /**
     * Gets the date format for showing time in military format.
     * The format is extracted from a static map
     *
     * @param locale the locale
     * @return the date format
     */
    public static String getHourGranularityMilitaryTimeDateFormat(Locale locale) {
        String hourGranularityDateFormat =  MILITARY_TIME_FORMAT_MAP.get(locale);
        if (StringUtils.isNotEmpty(hourGranularityDateFormat)) {
            return hourGranularityDateFormat;
        }
        return MILITARY_TIME_FORMAT;
    }

    /**
     * Translate Promise into hour granularity string, this is especially useful for sub same day delivery
     * e.g. 1AM
     *
     * @param promise promise delivery time
     * @param localeOpt target local for displaying the time
     * @return an hour string based on the locale
     */
    public static String getDeliveryPromiseHourString(ZonedDateTime promise, Optional<Locale> localeOpt) {
        if (localeOpt.isPresent()) {
            return new MessageFormat(getHourGranularityDateFormat(localeOpt.get()), localeOpt.get()).format(ImmutableMap.of("date", promise));
        } else {
            return null;
        }
    }

    /**
     * Translate Promise into hour granularity string, this is especially useful for Sub Same Day - Multiple Delivery Window
     * e.g. 1 AM
     *
     * @param promise promise delivery time
     * @param localeOpt target local for displaying the time
     * @return an hour string based on the locale
     */
    public static String getDeliveryPromiseHourStringForDeliveryWindow(ZonedDateTime promise, Optional<Locale> localeOpt) {
        if (localeOpt.isPresent()) {
            return new MessageFormat(getHourGranularityDateFormatWithSpace(localeOpt.get()), localeOpt.get()).format(ImmutableMap.of("date", promise));
        } else {
            return null;
        }
    }

    /**
     * Translate Promise into military format string
     *
     * @param promise promise delivery time
     * @param localeOpt target local for displaying the time
     * @return a military time format string based on the locale
     */
    public static String getDeliveryPromiseMilitaryTimeHourString(ZonedDateTime promise, Optional<Locale> localeOpt) {
        if (localeOpt.isPresent()) {
            return new MessageFormat(getHourGranularityMilitaryTimeDateFormat(localeOpt.get()), localeOpt.get()).format(ImmutableMap.of("date", promise));
        } else {
            return null;
        }
    }

    /**
     * Get the boolean flag to indicate the promise date is today or not.
     *
     * @param promiseDate the promise date from AAPI in zoned date time format.("2018-05-16T20:00:00-07:00")
     * @return boolean flag to indicate the date is today or not
     */
    public static boolean isToday(ZonedDateTime promiseDate) {
        // if promise date is either null, return directly
        if (promiseDate == null) {
            return false;
        }

        // promiseDate.getZone() never return null
        ZonedDateTime now = ZonedDateTime.now(promiseDate.getZone());
        boolean sameYear = promiseDate.getYear() == now.getYear();
        boolean sameMonth = promiseDate.getMonthValue() == now.getMonthValue();
        boolean sameDay = promiseDate.getDayOfMonth() == now.getDayOfMonth();
        return sameYear && sameMonth && sameDay;
    }

    /**
     * Get the boolean flag to indicate the promise date is tomorrow or not.
     *
     * @param promiseDate the promise date from AAPI in zoned date time format.("2018-05-16T20:00:00-07:00")
     * @return boolean flag to indicate the date is tomorrow or not
     */
    public static boolean isTomorrow(ZonedDateTime promiseDate) {
        // if promise date is null, return directly
        if (promiseDate == null) {
            return false;
        }

        // promiseDate.getZone() never return null
        ZonedDateTime tomorrow = ZonedDateTime.now(promiseDate.getZone()).plusDays(1);
        boolean sameYear = promiseDate.getYear() == tomorrow.getYear();
        boolean sameMonth = promiseDate.getMonthValue() == tomorrow.getMonthValue();
        boolean sameDay = promiseDate.getDayOfMonth() == tomorrow.getDayOfMonth();
        return sameYear && sameMonth && sameDay;
    }

    /**
     * Checks if two ZonedDateTime objects fall on the same day
     * @param from
     * @param to
     * @return true if the two ZonedDateTime objects fall on the same day
     */
    public static boolean isSameDay(ZonedDateTime from, ZonedDateTime to) {
        if (from == null || to == null) {
            return false;
        }

        GregorianCalendar fromCalendar = GregorianCalendar.from(from);
        GregorianCalendar toCalendar = GregorianCalendar.from(to);
        return DateUtils.isSameDay(fromCalendar, toCalendar);
    }

    public static String getDeliveryDateFormat(Locale locale) {
        String deliveryDateFormat =  DELIVERY_DATE_FORMAT_MAP.get(locale);

        if (StringUtils.isNotEmpty(deliveryDateFormat)) {
            return deliveryDateFormat;
        }

        return DEFAULT_DELIVERY_DATE_FORMAT;
    }

    public static String getRangeDateFormat(Locale locale) {
        return DEFAULT_RANGE_DATE_FORMAT;
    }

    /**
     * Return the hours difference between now and given time.
     *
     * @param zonedDateTime input time
     * @return hours difference from now and given time
     */
    public static int hoursDiffFromNow(final ZonedDateTime zonedDateTime) {
        final long secondsInAnHour = 3600;
        final double secondsDiffFromNow =  (double) Duration.between(ZonedDateTime.now(zonedDateTime.getZone()), zonedDateTime).getSeconds();
        return (int) Math.ceil(secondsDiffFromNow / secondsInAnHour);
    }

    @AllArgsConstructor
    @Getter
    public enum DateFormat {
        HOUR(DateUtil::getHourGranularityDateFormat),
        HOUR_WITH_SPACE(DateUtil::getHourGranularityDateFormatWithSpace),
        HOUR_MILITARY(DateUtil::getHourGranularityMilitaryTimeDateFormat),
        FAST_TRACK(DateUtil::getFastTrackDateFormat),
        DELIVERY_DAY_FAST_TRACK(DateUtil::getDeliveryDayFastTrackDateFormat);
        private final Function<Locale, String> formatter;
    }
}
