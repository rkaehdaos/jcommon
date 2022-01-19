package org.jfree.date;


import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class DateUtil {


    public static DateFormatSymbols
            dateFormatSymbols = new SimpleDateFormat("", Locale.US).getDateFormatSymbols();

    public static String[] getMonthNames() {
        return dateFormatSymbols.getMonths();

    }

    public static int lastDayOfMonth(Month month, int year) {
        int lastDay = month.lastDay();
        if (month == Month.FEBRUARY && DayDate.isLeapYear(year)) {
            return lastDay + 1;
        } else {
            return lastDay;
        }
    }
}
