package com.ramcharans.central.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class DateTimeUtils {
    public static String convertLocalDateTimeToString(LocalDateTime datetime) {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        return datetime.format(formatter);
    }

    public static LocalDateTime convertStringToLocalDateTime(String datetime) {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        return LocalDateTime.parse(datetime, formatter);
    }
}