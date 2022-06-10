package com.imcd.evaluation.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CommonUtils {

    public static LocalDate convertStringToLocalDateTime(String str) {
        return LocalDate.parse(str, DateTimeFormatter.ISO_LOCAL_DATE);
    }
}
