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
}
