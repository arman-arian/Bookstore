package com.tosan.bookstore.utils.dates;

import org.jetbrains.annotations.NotNull;

public class PersianDateFormat {
    public static String Format(int[] jDate)
    {
        return Format(jDate[0], jDate[1], jDate[2], "", "", "");
    }

    public static String Format(int year, int month, int day, String dayOfWeek, String monthName, @NotNull String format)
    {
        return switch (format) {
            case "d" -> String.format("%d/%d/%d", year, month, day);
            case "D" -> String.format("%s %d %s %d", dayOfWeek, day, monthName, year);
            case "is" -> String.format("%02d/%02d/%02d", year, month, day);
            default -> String.format("%04d%02d%02d", year, month, day);
        };
    }
}
