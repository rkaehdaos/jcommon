package org.jfree.date;

import junit.framework.TestCase;

import java.util.GregorianCalendar;

import static org.jfree.date.Day.*;
import static org.jfree.date.DayDate.*;
import static org.jfree.date.Month.*;
import static org.jfree.date.WeekInMonth.*;

public class BobsDayDateTest extends TestCase {

    public void testGetMonths() throws Exception {
        assertEquals(13, getMonths().length);
    }

    public void testDayParse() throws Exception {

        assertEquals(MONDAY, Day.parse("Monday"));
        assertEquals(MONDAY, Day.parse("Mon"));
        assertEquals(MONDAY, Day.parse("monday"));
        assertEquals(MONDAY, Day.parse("MONDAY"));
        assertEquals(MONDAY, Day.parse("mon"));

        assertEquals(TUESDAY, Day.parse("Tuesday"));
        assertEquals(TUESDAY, Day.parse("Tue"));
        assertEquals(TUESDAY, Day.parse("tuesday"));
        assertEquals(TUESDAY, Day.parse("TUESDAY"));
        assertEquals(TUESDAY, Day.parse("tue"));
//            assertEquals(TUESDAY, stringToWeekdayCode("tues"));

        assertEquals(WEDNESDAY, Day.parse("Wednesday"));
        assertEquals(WEDNESDAY, Day.parse("Wed"));
        assertEquals(WEDNESDAY, Day.parse("wednesday"));
        assertEquals(WEDNESDAY, Day.parse("WEDNESDAY"));
        assertEquals(WEDNESDAY, Day.parse("wed"));

        assertEquals(THURSDAY, Day.parse("Thursday"));
        assertEquals(THURSDAY, Day.parse("Thu"));
        assertEquals(THURSDAY, Day.parse("thursday"));
        assertEquals(THURSDAY, Day.parse("THURSDAY"));
        assertEquals(THURSDAY, Day.parse("thu"));
//            assertEquals(THURSDAY, stringToWeekdayCode("thurs"));

        assertEquals(FRIDAY, Day.parse("Friday"));
        assertEquals(FRIDAY, Day.parse("Fri"));
        assertEquals(FRIDAY, Day.parse("friday"));
        assertEquals(FRIDAY, Day.parse("FRIDAY"));
        assertEquals(FRIDAY, Day.parse("fri"));

        assertEquals(SATURDAY, Day.parse("Saturday"));
        assertEquals(SATURDAY, Day.parse("Sat"));
        assertEquals(SATURDAY, Day.parse("saturday"));
        assertEquals(SATURDAY, Day.parse("SATURDAY"));
        assertEquals(SATURDAY, Day.parse("sat"));

        assertEquals(SUNDAY, Day.parse("Sunday"));
        assertEquals(SUNDAY, Day.parse("Sun"));
        assertEquals(SUNDAY, Day.parse("sunday"));
        assertEquals(SUNDAY, Day.parse("SUNDAY"));
        assertEquals(SUNDAY, Day.parse("sun"));

        try {
            Day.parse("Hello");
            fail("실패해야함");
        } catch (IllegalArgumentException e) {}

    }

    public void testWeekdayCodeToString() throws Exception {
        assertEquals("Sunday", weekdayEnumToString(SUNDAY));
        assertEquals("Monday", weekdayEnumToString(MONDAY));
        assertEquals("Tuesday", weekdayEnumToString(TUESDAY));
        assertEquals("Wednesday", weekdayEnumToString(WEDNESDAY));
        assertEquals("Thursday", weekdayEnumToString(THURSDAY));
        assertEquals("Friday", weekdayEnumToString(FRIDAY));
        assertEquals("Saturday", weekdayEnumToString(SATURDAY));
    }

     public void testMonthCodeToString() throws Exception {
        assertEquals("January", JANUARY.toString());
        assertEquals("February", FEBRUARY.toString());
        assertEquals("March", MARCH.toString());
        assertEquals("April",APRIL.toString());
        assertEquals("May", MAY.toString());
        assertEquals("June", JUNE.toString());
        assertEquals("July", JULY.toString());
        assertEquals("August", AUGUST.toString());
        assertEquals("September", SEPTEMBER.toString());
        assertEquals("October", OCTOBER.toString());
        assertEquals("November", NOVEMBER.toString());
        assertEquals("December", DECEMBER.toString());



         assertEquals("Jan", JANUARY.toShortString());
         assertEquals("Feb", FEBRUARY.toShortString());
         assertEquals("Mar", MARCH.toShortString());
         assertEquals("Apr",APRIL.toShortString());
         assertEquals("May", MAY.toShortString());
         assertEquals("Jun", JUNE.toShortString());
         assertEquals("Jul", JULY.toShortString());
         assertEquals("Aug", AUGUST.toShortString());
         assertEquals("Sep", SEPTEMBER.toShortString());
         assertEquals("Oct", OCTOBER.toShortString());
         assertEquals("Nov", NOVEMBER.toShortString());
         assertEquals("Dec", DECEMBER.toShortString());


        try {
            Month.fromInt(-1).toString();
            fail("Invalid month code should throw exception");
        } catch (IllegalArgumentException e) {
        }

    }

    public void testStringToMonthCode() throws Exception {
        assertEquals(JANUARY, Month.parse("1"));
        assertEquals(FEBRUARY, Month.parse("2"));
        assertEquals(MARCH, Month.parse("3"));
        assertEquals(APRIL, Month.parse("4"));
        assertEquals(MAY, Month.parse("5"));
        assertEquals(JUNE, Month.parse("6"));
        assertEquals(JULY, Month.parse("7"));
        assertEquals(AUGUST, Month.parse("8"));
        assertEquals(SEPTEMBER, Month.parse("9"));
        assertEquals(OCTOBER, Month.parse("10"));
        assertEquals(NOVEMBER, Month.parse("11"));
        assertEquals(DECEMBER, Month.parse("12"));

        try {
            assertEquals(-1, Month.parse("0"));
            fail("실패해야함");
        } catch (IllegalArgumentException e) {}

        try {
            assertEquals(-1, Month.parse("13"));
            fail("실패해야함");

        } catch (IllegalArgumentException e) {}

        try {
            assertEquals(-1, Month.parse("Hello"));
            fail("실패해야함");

        } catch (IllegalArgumentException e) {}


        for (Month m : Month.values()) {
            assertEquals(m, Month.parse(m.toString()));
            assertEquals(m, Month.parse(m.toShortString()));
        }

        assertEquals(JANUARY, Month.parse("jan"));
        assertEquals(FEBRUARY, Month.parse("feb"));
        assertEquals(MARCH, Month.parse("mar"));
        assertEquals(APRIL, Month.parse("apr"));
        assertEquals(MAY, Month.parse("may"));
        assertEquals(JUNE, Month.parse("jun"));
        assertEquals(JULY, Month.parse("jul"));
        assertEquals(AUGUST, Month.parse("aug"));
        assertEquals(SEPTEMBER, Month.parse("sep"));
        assertEquals(OCTOBER, Month.parse("oct"));
        assertEquals(NOVEMBER, Month.parse("nov"));
        assertEquals(DECEMBER, Month.parse("dec"));

        assertEquals(JANUARY, Month.parse("JAN"));
        assertEquals(FEBRUARY, Month.parse("FEB"));
        assertEquals(MARCH, Month.parse("MAR"));
        assertEquals(APRIL, Month.parse("APR"));
        assertEquals(MAY, Month.parse("MAY"));
        assertEquals(JUNE, Month.parse("JUN"));
        assertEquals(JULY, Month.parse("JUL"));
        assertEquals(AUGUST, Month.parse("AUG"));
        assertEquals(SEPTEMBER, Month.parse("SEP"));
        assertEquals(OCTOBER, Month.parse("OCT"));
        assertEquals(NOVEMBER, Month.parse("NOV"));
        assertEquals(DECEMBER, Month.parse("DEC"));

        assertEquals(JANUARY, Month.parse("january"));
        assertEquals(FEBRUARY, Month.parse("february"));
        assertEquals(MARCH, Month.parse("march"));
        assertEquals(APRIL, Month.parse("april"));
        assertEquals(MAY, Month.parse("may"));
        assertEquals(JUNE, Month.parse("june"));
        assertEquals(JULY, Month.parse("july"));
        assertEquals(AUGUST, Month.parse("august"));
        assertEquals(SEPTEMBER, Month.parse("september"));
        assertEquals(OCTOBER, Month.parse("october"));
        assertEquals(NOVEMBER, Month.parse("november"));
        assertEquals(DECEMBER, Month.parse("december"));

        assertEquals(JANUARY, Month.parse("JANUARY"));
        assertEquals(FEBRUARY, Month.parse("FEBRUARY"));
        assertEquals(MARCH, Month.parse("MAR"));
        assertEquals(APRIL, Month.parse("APRIL"));
        assertEquals(MAY, Month.parse("MAY"));
        assertEquals(JUNE, Month.parse("JUNE"));
        assertEquals(JULY, Month.parse("JULY"));
        assertEquals(AUGUST, Month.parse("AUGUST"));
        assertEquals(SEPTEMBER, Month.parse("SEPTEMBER"));
        assertEquals(OCTOBER, Month.parse("OCTOBER"));
        assertEquals(NOVEMBER, Month.parse("NOVEMBER"));
        assertEquals(DECEMBER, Month.parse("DECEMBER"));

    }

    public void testIsLeapYear() throws Exception {
        assertFalse(isLeapYear(1900));
        assertFalse(isLeapYear(1901));
        assertFalse(isLeapYear(1902));
        assertFalse(isLeapYear(1903));
        assertTrue(isLeapYear(1904));
        assertTrue(isLeapYear(1908));
        assertFalse(isLeapYear(1955));
        assertTrue(isLeapYear(1964));
        assertTrue(isLeapYear(1980));
        assertTrue(isLeapYear(2000));
        assertFalse(isLeapYear(2001));
        assertFalse(isLeapYear(2100));
    }

    public void testLeapYearCount() throws Exception {
        assertEquals(0, SpreadsheetDate.leapYearCount(1900));
        assertEquals(0, SpreadsheetDate.leapYearCount(1901));
        assertEquals(0, SpreadsheetDate.leapYearCount(1902));
        assertEquals(0, SpreadsheetDate.leapYearCount(1903));
        assertEquals(1, SpreadsheetDate.leapYearCount(1904));
        assertEquals(1, SpreadsheetDate.leapYearCount(1905));
        assertEquals(1, SpreadsheetDate.leapYearCount(1906));
        assertEquals(1, SpreadsheetDate.leapYearCount(1907));
        assertEquals(2, SpreadsheetDate.leapYearCount(1908));
        assertEquals(24, SpreadsheetDate.leapYearCount(1999));
        assertEquals(25, SpreadsheetDate.leapYearCount(2001));
        assertEquals(49, SpreadsheetDate.leapYearCount(2101));
        assertEquals(73, SpreadsheetDate.leapYearCount(2201));
        assertEquals(97, SpreadsheetDate.leapYearCount(2301));
        assertEquals(122, SpreadsheetDate.leapYearCount(2401));
    }

    public void testLastDayOfMonth() throws Exception {
        assertEquals(31, lastDayOfMonth(JANUARY, 1901));
        assertEquals(28, lastDayOfMonth(FEBRUARY, 1901));
        assertEquals(31, lastDayOfMonth(MARCH, 1901));
        assertEquals(30, lastDayOfMonth(APRIL, 1901));
        assertEquals(31, lastDayOfMonth(MAY, 1901));
        assertEquals(30, lastDayOfMonth(JUNE, 1901));
        assertEquals(31, lastDayOfMonth(JULY, 1901));
        assertEquals(31, lastDayOfMonth(AUGUST, 1901));
        assertEquals(30, lastDayOfMonth(SEPTEMBER, 1901));
        assertEquals(31, lastDayOfMonth(OCTOBER, 1901));
        assertEquals(30, lastDayOfMonth(NOVEMBER, 1901));
        assertEquals(31, lastDayOfMonth(DECEMBER, 1901));
        assertEquals(29, lastDayOfMonth(FEBRUARY, 1904));
    }

    public void testAddDays() throws Exception {
        DayDate newYears = d(1, JANUARY, 1900);
        assertEquals(d(2, JANUARY, 1900), newYears.addDays(1));
        assertEquals(d(1, FEBRUARY, 1900), newYears.addDays(31));
        assertEquals(d(1, JANUARY, 1901), newYears.addDays(365));
        assertEquals(d(31, DECEMBER, 1904), newYears.addDays(5 * 365));
    }

    private static SpreadsheetDate d(int day, Month month, int year) {
        return new SpreadsheetDate(day, month, year);
    }

    public void testAddMonths() throws Exception {
        assertEquals(d(1, FEBRUARY, 1900), d(1, JANUARY, 1900).addMonths(1));
        assertEquals(d(28, FEBRUARY, 1900), d(31, JANUARY, 1900).addMonths(1));
        assertEquals(d(28, FEBRUARY, 1900), d(30, JANUARY, 1900).addMonths(1));
        assertEquals(d(28, FEBRUARY, 1900), d(29, JANUARY, 1900).addMonths(1));
        assertEquals(d(28, FEBRUARY, 1900), d(28, JANUARY, 1900).addMonths(1));
        assertEquals(d(27, FEBRUARY, 1900), d(27, JANUARY, 1900).addMonths(1));

        assertEquals(d(30, JUNE, 1900), d(31, JANUARY, 1900).addMonths(5));
        assertEquals(d(30, JUNE, 1901), d(31, JANUARY, 1900).addMonths(17));

        assertEquals(d(29, FEBRUARY, 1904), d(31, JANUARY, 1900).addMonths(49));

    }

    public void testAddYears() throws Exception {
        assertEquals(d(1, JANUARY, 1901), addYears(1, d(1, JANUARY, 1900)));
        assertEquals(d(28, FEBRUARY, 1905), addYears(1, d(29, FEBRUARY, 1904)));
        assertEquals(d(28, FEBRUARY, 1905), addYears(1, d(28, FEBRUARY, 1904)));
        assertEquals(d(28, FEBRUARY, 1904), addYears(1, d(28, FEBRUARY, 1903)));
    }

    public void testGetPreviousDayOfWeek() throws Exception {
        assertEquals(d(24, FEBRUARY, 2006), getPreviousDayOfWeek(FRIDAY, d(1, MARCH, 2006)));
        assertEquals(d(22, FEBRUARY, 2006), getPreviousDayOfWeek(WEDNESDAY, d(1, MARCH, 2006)));
        assertEquals(d(29, FEBRUARY, 2004), getPreviousDayOfWeek(SUNDAY, d(3, MARCH, 2004)));
        assertEquals(d(29, DECEMBER, 2004), getPreviousDayOfWeek(WEDNESDAY, d(5, JANUARY, 2005)));

        try {
            getPreviousDayOfWeek(Day.fromInt(-1), d(1, JANUARY, 2006));
            fail("Invalid day of week code should throw exception");
        } catch (IllegalArgumentException e) {
        }
    }

    public void testGetFollowingDayOfWeek() throws Exception {
        assertEquals(d(1, JANUARY, 2005), getFollowingDayOfWeek(SATURDAY, d(25, DECEMBER, 2004)));
        assertEquals(d(1, JANUARY, 2005), getFollowingDayOfWeek(SATURDAY, d(26, DECEMBER, 2004)));
        assertEquals(d(3, MARCH, 2004), getFollowingDayOfWeek(WEDNESDAY, d(28, FEBRUARY, 2004)));

        try {
            getFollowingDayOfWeek(Day.fromInt(-1), d(1, JANUARY, 2006));
            fail("Invalid day of week code should throw exception");
        } catch (IllegalArgumentException e) {
        }
    }

    public void testGetNearestDayOfWeek() throws Exception {
        assertEquals(d(16, APRIL, 2006), getNearestDayOfWeek(SUNDAY, d(16, APRIL, 2006)));
        assertEquals(d(16, APRIL, 2006), getNearestDayOfWeek(SUNDAY, d(17, APRIL, 2006)));
        assertEquals(d(16, APRIL, 2006), getNearestDayOfWeek(SUNDAY, d(18, APRIL, 2006)));
        assertEquals(d(16, APRIL, 2006), getNearestDayOfWeek(SUNDAY, d(19, APRIL, 2006)));
        assertEquals(d(23, APRIL, 2006), getNearestDayOfWeek(SUNDAY, d(20, APRIL, 2006)));
        assertEquals(d(23, APRIL, 2006), getNearestDayOfWeek(SUNDAY, d(21, APRIL, 2006)));
        assertEquals(d(23, APRIL, 2006), getNearestDayOfWeek(SUNDAY, d(22, APRIL, 2006)));

        assertEquals(d(17, APRIL, 2006), getNearestDayOfWeek(MONDAY, d(16, APRIL, 2006)));
        assertEquals(d(17, APRIL, 2006), getNearestDayOfWeek(MONDAY, d(17, APRIL, 2006)));
        assertEquals(d(17, APRIL, 2006), getNearestDayOfWeek(MONDAY, d(18, APRIL, 2006)));
        assertEquals(d(17, APRIL, 2006), getNearestDayOfWeek(MONDAY, d(19, APRIL, 2006)));
        assertEquals(d(17, APRIL, 2006), getNearestDayOfWeek(MONDAY, d(20, APRIL, 2006)));
        assertEquals(d(24, APRIL, 2006), getNearestDayOfWeek(MONDAY, d(21, APRIL, 2006)));
        assertEquals(d(24, APRIL, 2006), getNearestDayOfWeek(MONDAY, d(22, APRIL, 2006)));

        assertEquals(d(18, APRIL, 2006), getNearestDayOfWeek(TUESDAY, d(16, APRIL, 2006)));
        assertEquals(d(18, APRIL, 2006), getNearestDayOfWeek(TUESDAY, d(17, APRIL, 2006)));
        assertEquals(d(18, APRIL, 2006), getNearestDayOfWeek(TUESDAY, d(18, APRIL, 2006)));
        assertEquals(d(18, APRIL, 2006), getNearestDayOfWeek(TUESDAY, d(19, APRIL, 2006)));
        assertEquals(d(18, APRIL, 2006), getNearestDayOfWeek(TUESDAY, d(20, APRIL, 2006)));
        assertEquals(d(18, APRIL, 2006), getNearestDayOfWeek(TUESDAY, d(21, APRIL, 2006)));
        assertEquals(d(25, APRIL, 2006), getNearestDayOfWeek(TUESDAY, d(22, APRIL, 2006)));

        assertEquals(d(19, APRIL, 2006), getNearestDayOfWeek(WEDNESDAY, d(16, APRIL, 2006)));
        assertEquals(d(19, APRIL, 2006), getNearestDayOfWeek(WEDNESDAY, d(17, APRIL, 2006)));
        assertEquals(d(19, APRIL, 2006), getNearestDayOfWeek(WEDNESDAY, d(18, APRIL, 2006)));
        assertEquals(d(19, APRIL, 2006), getNearestDayOfWeek(WEDNESDAY, d(19, APRIL, 2006)));
        assertEquals(d(19, APRIL, 2006), getNearestDayOfWeek(WEDNESDAY, d(20, APRIL, 2006)));
        assertEquals(d(19, APRIL, 2006), getNearestDayOfWeek(WEDNESDAY, d(21, APRIL, 2006)));
        assertEquals(d(19, APRIL, 2006), getNearestDayOfWeek(WEDNESDAY, d(22, APRIL, 2006)));

        assertEquals(d(13, APRIL, 2006), getNearestDayOfWeek(THURSDAY, d(16, APRIL, 2006)));
        assertEquals(d(20, APRIL, 2006), getNearestDayOfWeek(THURSDAY, d(17, APRIL, 2006)));
        assertEquals(d(20, APRIL, 2006), getNearestDayOfWeek(THURSDAY, d(18, APRIL, 2006)));
        assertEquals(d(20, APRIL, 2006), getNearestDayOfWeek(THURSDAY, d(19, APRIL, 2006)));
        assertEquals(d(20, APRIL, 2006), getNearestDayOfWeek(THURSDAY, d(20, APRIL, 2006)));
        assertEquals(d(20, APRIL, 2006), getNearestDayOfWeek(THURSDAY, d(21, APRIL, 2006)));
        assertEquals(d(20, APRIL, 2006), getNearestDayOfWeek(THURSDAY, d(22, APRIL, 2006)));

        assertEquals(d(14, APRIL, 2006), getNearestDayOfWeek(FRIDAY, d(16, APRIL, 2006)));
        assertEquals(d(14, APRIL, 2006), getNearestDayOfWeek(FRIDAY, d(17, APRIL, 2006)));
        assertEquals(d(21, APRIL, 2006), getNearestDayOfWeek(FRIDAY, d(18, APRIL, 2006)));
        assertEquals(d(21, APRIL, 2006), getNearestDayOfWeek(FRIDAY, d(19, APRIL, 2006)));
        assertEquals(d(21, APRIL, 2006), getNearestDayOfWeek(FRIDAY, d(20, APRIL, 2006)));
        assertEquals(d(21, APRIL, 2006), getNearestDayOfWeek(FRIDAY, d(21, APRIL, 2006)));
        assertEquals(d(21, APRIL, 2006), getNearestDayOfWeek(FRIDAY, d(22, APRIL, 2006)));

        assertEquals(d(15, APRIL, 2006), getNearestDayOfWeek(SATURDAY, d(16, APRIL, 2006)));
        assertEquals(d(15, APRIL, 2006), getNearestDayOfWeek(SATURDAY, d(17, APRIL, 2006)));
        assertEquals(d(15, APRIL, 2006), getNearestDayOfWeek(SATURDAY, d(18, APRIL, 2006)));
        assertEquals(d(22, APRIL, 2006), getNearestDayOfWeek(SATURDAY, d(19, APRIL, 2006)));
        assertEquals(d(22, APRIL, 2006), getNearestDayOfWeek(SATURDAY, d(20, APRIL, 2006)));
        assertEquals(d(22, APRIL, 2006), getNearestDayOfWeek(SATURDAY, d(21, APRIL, 2006)));
        assertEquals(d(22, APRIL, 2006), getNearestDayOfWeek(SATURDAY, d(22, APRIL, 2006)));

        try {
            getNearestDayOfWeek(Day.fromInt(-1), d(1, JANUARY, 2006));
            fail("Invalid day of week code should throw exception");
        } catch (IllegalArgumentException e) {
        }
    }

    public void testEndOfCurrentMonth() throws Exception {
        DayDate d = createInstance(2);
        assertEquals(d(31, JANUARY, 2006), d.getEndOfCurrentMonth(d(1, JANUARY, 2006)));
        assertEquals(d(28, FEBRUARY, 2006), d.getEndOfCurrentMonth(d(1, FEBRUARY, 2006)));
        assertEquals(d(31, MARCH, 2006), d.getEndOfCurrentMonth(d(1, MARCH, 2006)));
        assertEquals(d(30, APRIL, 2006), d.getEndOfCurrentMonth(d(1, APRIL, 2006)));
        assertEquals(d(31, MAY, 2006), d.getEndOfCurrentMonth(d(1, MAY, 2006)));
        assertEquals(d(30, JUNE, 2006), d.getEndOfCurrentMonth(d(1, JUNE, 2006)));
        assertEquals(d(31, JULY, 2006), d.getEndOfCurrentMonth(d(1, JULY, 2006)));
        assertEquals(d(31, AUGUST, 2006), d.getEndOfCurrentMonth(d(1, AUGUST, 2006)));
        assertEquals(d(30, SEPTEMBER, 2006), d.getEndOfCurrentMonth(d(1, SEPTEMBER, 2006)));
        assertEquals(d(31, OCTOBER, 2006), d.getEndOfCurrentMonth(d(1, OCTOBER, 2006)));
        assertEquals(d(30, NOVEMBER, 2006), d.getEndOfCurrentMonth(d(1, NOVEMBER, 2006)));
        assertEquals(d(31, DECEMBER, 2006), d.getEndOfCurrentMonth(d(1, DECEMBER, 2006)));
        assertEquals(d(29, FEBRUARY, 2008), d.getEndOfCurrentMonth(d(1, FEBRUARY, 2008)));
    }

    public void testWeekInMonthToString() throws Exception {
        assertEquals("First", weekInMonthToString(FIRST));
        assertEquals("Second", weekInMonthToString(SECOND));
        assertEquals("Third", weekInMonthToString(THIRD));
        assertEquals("Fourth", weekInMonthToString(FOURTH));
        assertEquals("Last", weekInMonthToString(LAST));

        try {
            weekInMonthToString(WeekInMonth.fromInt(-1));
            fail("Invalid week code should throw exception");
        } catch (IllegalArgumentException e) {
        }
    }

    public void testRelativeToString() throws Exception {
        assertEquals("Last", relativeToString(WeekDayRange.LAST));
        assertEquals("Next", relativeToString(WeekDayRange.NEXT));
        assertEquals("Nearest", relativeToString(WeekDayRange.NEAREST));
    }

    public void testCreateInstanceFromDDMMYYY() throws Exception {
        DayDate date = createInstance(1, JANUARY, 1900);
        assertEquals(1, date.getDayOfMonth());
        assertEquals(JANUARY, date.getMonth());
        assertEquals(1900, date.getYear());
        assertEquals(2, date.toOrdinal());
    }

    public void testCreateInstanceFromSerial() throws Exception {
        assertEquals(d(1, JANUARY, 1900), createInstance(2));
        assertEquals(d(1, JANUARY, 1901), createInstance(367));
    }

    public void testCreateInstanceFromJavaDate() throws Exception {
        assertEquals(d(1, JANUARY, 1900), createInstance(new GregorianCalendar(1900, 0, 1).getTime()));
        assertEquals(d(1, JANUARY, 2006), createInstance(new GregorianCalendar(2006, 0, 1).getTime()));
    }

  public static void main(String[] args) {
    junit.textui.TestRunner.run(BobsDayDateTest.class);
  }
}
