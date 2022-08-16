package com.tosan.bookstore.utils.dates;

import org.jetbrains.annotations.NotNull;

import java.time.DayOfWeek;

public class PersianDateResource {
    private static final String[] dayNames = {"دوشنبه", "سه‌شنبه", "چهارشنبه", "پنج‌شنبه", "جمعه", "شنبه", "یک‌شنبه"};

    private static final String[] monthNames = {
            "فروردین", "اردیبهشت", "خرداد",
            "تیر", "مرداد", "شهریور",
            "مهر", "آبان", "آذر",
            "دی", "بهمن", "اسفند"};

    public static String GetMonthName(int month)
    {
        if (month < 1 || month > 12)
            throw new IllegalArgumentException("month has invalid month");

        return monthNames[month - 1];
    }

    public static int GetMonthNumber(@NotNull String monthName)
    {
        for (var i = 0; i < monthNames.length; i++)
        {
            if (monthNames[i].equals(monthName))
                return i + 1;
        }

        throw new IllegalArgumentException("monthName has invalid month name");
    }

    public static String GetWeekDayName(@NotNull DayOfWeek dayOfWeek)
    {
        return dayNames[dayOfWeek.getValue()-1];
    }
}
