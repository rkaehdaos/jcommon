package org.jfree.date;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class DateUtil {

    public static DateFormatSymbols dateFormatSymbols =
            new SimpleDateFormat("", Locale.US).getDateFormatSymbols();

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

    public static int leapYearCount(int year) {
        int leap4 = (year - 1896) / 4;
        int leap100 = (year - 1800) / 100;
        int leap400 = (year - 1600) / 400;
        return leap4 - leap100 + leap400;
    }
}
