package org.jfree.date;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Locale;

public enum Month {
    JANUARY(1),
    FEBRUARY(2),
    MARCH(3),
    APRIL(4),
    MAY(5),
    JUNE(6),
    JULY(7),
    AUGUST(8),
    SEPTEMBER(9),
    OCTOBER(10),
    NOVEMBER(11),
    DECEMBER(12);
    /** Date format symbols. */
    public static final DateFormatSymbols
            DATE_FORMAT_SYMBOLS = new SimpleDateFormat("", Locale.US).getDateFormatSymbols();
    static int[] LAST_DAY_OF_MONTH =
            {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public final int index;

    Month(int index) {
        this.index = index;
    }

    public static Month fromInt(int monthIndex) {
        for (Month m : Month.values()) {
            if (m.index == monthIndex)
                return m;
        }
        throw new IllegalArgumentException("Invalid month index " + monthIndex);
    }

    public static Month parse(String s) {
        s = s.trim();
        for (Month m : Month.values()) {
            if (m.matches(s)) return m;
        }
        try {
            return fromInt(Integer.parseInt(s));
        } catch (NumberFormatException e) {
        }
        throw new IllegalArgumentException("Invalid Month : " + s);

    }

    public static int lastDayOfMonth(Month month, int year) {
        int result = month.lastDay();
        if (month != FEBRUARY) {
            return result;
        } else if (DayDate.isLeapYear(year)) {
            return result + 1;
        } else {
            return result;
        }
    }

    private int lastDay() {
        return LAST_DAY_OF_MONTH[index];
    }

    private boolean matches(String s) {
        return s.equalsIgnoreCase(toString()) ||
                s.equalsIgnoreCase(toShortString());
    }


    @Override
    public String toString() {
        return DATE_FORMAT_SYMBOLS.getMonths()[index - 1];
    }

    public String toShortString() {
        return DATE_FORMAT_SYMBOLS.getShortMonths()[index - 1];
    }

    public int toInt(){
        return index;
    }

}
