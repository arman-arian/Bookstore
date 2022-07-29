package com.tosan.bookstore.utils;

import org.jetbrains.annotations.NotNull;

public class PersianDateFormat {

    public static String Format(int[] jDate)
    {
        return Format(jDate[0], jDate[1], jDate[2], "", "", "");
    }

    public static String Format(int year, int month, int day, String dayOfWeek, String monthName, @NotNull String format)
    {
        if (format.equals("d"))
        {
            return String.format("%d/%d/%d", year, month, day);
        }
        else if(format.equals("D"))
        {
            return String.format("%s %d %s %d", dayOfWeek, day, monthName, year);
        }
        else if (format == "is")
        {
            return String.format("%02d/%02d/%02d", year, month, day);
        }
        else
        {
            return String.format("%04d%02d%02d", year, month, day);
        }
    }
}
