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

    public static Month stringToMonthEnum(String s) {

        String[] shortMonthNames = DayDate.dateFormatSymbols.getShortMonths();
        String[] monthNames = DayDate.dateFormatSymbols.getMonths();

        int result = -1;
        s = s.trim();

        // first try parsing the string as an integer (1-12)...
        try {
            result = Integer.parseInt(s);
        }
        catch (NumberFormatException e) {
            // suppress
        }

        // now search through the month names...
        if ((result < 1) || (result > 12)) {
            result = -1;
            for (int i = 0; i < monthNames.length; i++) {
                if (s.equalsIgnoreCase(shortMonthNames[i])) {
                    result = i + 1;
                    break;
                }
                if (s.equalsIgnoreCase(monthNames[i])) {
                    result = i + 1;
                    break;
                }
            }
        }
        return Month.fromInt(result);

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
