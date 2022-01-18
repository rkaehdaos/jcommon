package org.jfree.date;

public enum DateInterval {
    CLOSED(0),
    CLOSED_LEFT(1),
    CLOSED_RIGHT(2),
    OPEN(3);

    public final int index;

    DateInterval(int index) {
        this.index = index;
    }

    public static DateInterval fromInt(int index) {
        for (DateInterval dateInterval : DateInterval.values()) {
            if (dateInterval.index == index)
                return dateInterval;
        }
        throw new IllegalArgumentException(
                String.format("Invalid arg : %d", index)
        );
    }
}
