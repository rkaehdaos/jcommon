package org.jfree.date;

public enum WeekInterval {
    FIRST(1), SECOND(2), THIRD(3), FOURTH(4), LAST(0);
    public final int index;

    WeekInterval(int index) {
        this.index = index;
    }

    public static WeekInterval fromInt(int index) {
        for (WeekInterval w : WeekInterval.values()) {
            if (w.index == index)
                return w;
        }
        throw new IllegalArgumentException(
                String.format("Invalid arg : %d", index)
        );

    }

}
