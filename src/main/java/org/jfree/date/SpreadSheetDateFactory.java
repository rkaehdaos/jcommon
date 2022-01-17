package org.jfree.date;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class SpreadSheetDateFactory extends DayDateFactory {
    @Override
    protected DayDate _makeDate(int ordinal) {
        return new SpreadsheetDate(ordinal);
    }

    @Override
    protected DayDate _makeDate(int day, Month month, int year) {
        return new SpreadsheetDate(day, month, year);
    }

    @Override
    protected DayDate _makeDate(int day, int month, int year) {
        return new SpreadsheetDate(day, month, year);
    }

    @Override
    protected DayDate _makeDate(Date date) {
        final GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        return new SpreadsheetDate(
                calendar.get(Calendar.DATE),
                Month.fromInt(calendar.get(Calendar.MONDAY) + 1),
                calendar.get(Calendar.YEAR));
    }

    @Override
    protected int _getMiniMumYear() {
        return SpreadsheetDate.MINIMUM_YEAR_SUPPORTED;
    }

    @Override
    protected int _getMaximumYear() {
        return SpreadsheetDate.MAXIMUM_YEAR_SUPPORTED;
    }
}
