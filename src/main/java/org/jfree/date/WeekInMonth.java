package org.jfree.date;

public enum WeekInMonth {
    FIRST(1), SECOND(2), THIRD(3), FOURTH(4), LAST(0);
    public final int index;

    WeekInMonth(int index) {
        this.index = index;
    }

    public static WeekInMonth fromInt(int index) {
        for (WeekInMonth w : WeekInMonth.values()) {
            if (w.index == index)
                return w;
        }
        throw new IllegalArgumentException(
                String.format("Invalid arg : %d", index)
        );

    }

    public static String toString(WeekInMonth weekInMonth) {

        switch (weekInMonth) {
            case FIRST:  return "First";
            case SECOND: return "Second";
            case THIRD:  return "Third";
            case FOURTH: return "Fourth";
            case LAST: return "Last";
            default :
                throw new IllegalArgumentException("SerialDate.weekInMonthToString(): invalid code.");
        }
    }
}
