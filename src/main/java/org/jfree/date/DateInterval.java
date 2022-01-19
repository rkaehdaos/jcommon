package org.jfree.date;

public enum DateInterval {
    CLOSED(0) {
        @Override
        public boolean isIn(int d, int left, int right) {
            return false;
        }
    },
    CLOSED_LEFT(1) {
        @Override
        public boolean isIn(int d, int left, int right) {
            return false;
        }
    },
    CLOSED_RIGHT(2) {
        @Override
        public boolean isIn(int d, int left, int right) {
            return false;
        }
    },
    OPEN(3) {
        @Override
        public boolean isIn(int d, int left, int right) {
            return false;
        }
    };

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

    public abstract boolean isIn(int d, int left, int right);
}
