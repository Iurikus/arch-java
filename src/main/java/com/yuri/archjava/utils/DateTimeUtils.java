package com.yuri.archjava.utils;

import org.joda.time.LocalDateTime;

/**
 * Created by yuri on 19.03.2015.
 */
public class DateTimeUtils {
    public static LocalDateTime getCurrentLocalDateTimeWithoutMillis() {
        LocalDateTime date = LocalDateTime.now();
        return date.minusMillis(date.getMillisOfSecond());
    }
}
