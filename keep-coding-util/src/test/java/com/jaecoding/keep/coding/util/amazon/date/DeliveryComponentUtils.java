package com.jaecoding.keep.coding.util.amazon.date;

import com.google.common.collect.ImmutableMap;
import com.ibm.icu.text.MessageFormat;
import java.time.ZonedDateTime;
import java.util.Locale;

/**
 * Utility class that encapsulates common logic used across delivery components
 */
public class DeliveryComponentUtils {
  // Based on metric prefix used here : https://tiny.amazon.com/ejqs7iti
  private static final String METRIC_PREFIX = "AFS:";
  private static final String ALWAYS_PAID_SUB_TYPE = "ALWAYS_PAID";
  private static final String EMPTY_SUB_TYPE = "";





  /**
   * Utility to format date adhering to FastTrack date formatting
   *
   * @param date
   * @param locale
   * @return formattedDate
   */
  public static String getFormattedDate(final ZoneAwareDateTime date, final Locale locale) {
    // Refer Fasttrack component for delivery message dateformat - https://tiny.amazon.com/88vz2q3q
    final String fastTrackDateFormat = Locale.US.equals(locale) ? "{date,date,::EEEMMMd}" : DateUtil.getFastTrackDateFormat(locale);

    final ZonedDateTime zoneAwarePromiseDate = date.dateTime().withZoneSameInstant(date.zoneId());
    MessageFormat messageFormat = new MessageFormat(fastTrackDateFormat, locale);
    return messageFormat.format(ImmutableMap.of("date", zoneAwarePromiseDate));
  }

}
