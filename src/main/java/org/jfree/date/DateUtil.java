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
        if (month == Month.FEBRUARY && isLeapYear(year))
            return lastDay + 1;
        else
            return lastDay;
    }

    public static boolean isLeapYear(int year) {
        boolean fourth = year % 4 == 0;
        boolean hundredth = year % 100 == 0;
        boolean fourHundredth = year % 400 == 0;
        return fourth && (!hundredth || fourHundredth);
    }
}
