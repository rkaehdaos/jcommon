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
        assertEquals(13, getMonths(false).length);
        assertEquals(13, getMonths(true).length);
    }

    public void testStringToWeekdayEnum() throws Exception {

        assertEquals(MONDAY, stringToWeekdayEnum("Monday"));
        assertEquals(MONDAY, stringToWeekdayEnum("Mon"));
        assertEquals(MONDAY, stringToWeekdayEnum("monday"));
        assertEquals(MONDAY, stringToWeekdayEnum("MONDAY"));
        assertEquals(MONDAY, stringToWeekdayEnum("mon"));

        assertEquals(TUESDAY, stringToWeekdayEnum("Tuesday"));
        assertEquals(TUESDAY, stringToWeekdayEnum("Tue"));
        assertEquals(TUESDAY, stringToWeekdayEnum("tuesday"));
        assertEquals(TUESDAY, stringToWeekdayEnum("TUESDAY"));
        assertEquals(TUESDAY, stringToWeekdayEnum("tue"));
//            assertEquals(TUESDAY, stringToWeekdayCode("tues"));

        assertEquals(WEDNESDAY, stringToWeekdayEnum("Wednesday"));
        assertEquals(WEDNESDAY, stringToWeekdayEnum("Wed"));
        assertEquals(WEDNESDAY, stringToWeekdayEnum("wednesday"));
        assertEquals(WEDNESDAY, stringToWeekdayEnum("WEDNESDAY"));
        assertEquals(WEDNESDAY, stringToWeekdayEnum("wed"));

        assertEquals(THURSDAY, stringToWeekdayEnum("Thursday"));
        assertEquals(THURSDAY, stringToWeekdayEnum("Thu"));
        assertEquals(THURSDAY, stringToWeekdayEnum("thursday"));
        assertEquals(THURSDAY, stringToWeekdayEnum("THURSDAY"));
        assertEquals(THURSDAY, stringToWeekdayEnum("thu"));
//            assertEquals(THURSDAY, stringToWeekdayCode("thurs"));

        assertEquals(FRIDAY, stringToWeekdayEnum("Friday"));
        assertEquals(FRIDAY, stringToWeekdayEnum("Fri"));
        assertEquals(FRIDAY, stringToWeekdayEnum("friday"));
        assertEquals(FRIDAY, stringToWeekdayEnum("FRIDAY"));
        assertEquals(FRIDAY, stringToWeekdayEnum("fri"));

        assertEquals(SATURDAY, stringToWeekdayEnum("Saturday"));
        assertEquals(SATURDAY, stringToWeekdayEnum("Sat"));
        assertEquals(SATURDAY, stringToWeekdayEnum("saturday"));
        assertEquals(SATURDAY, stringToWeekdayEnum("SATURDAY"));
        assertEquals(SATURDAY, stringToWeekdayEnum("sat"));

        assertEquals(SUNDAY, stringToWeekdayEnum("Sunday"));
        assertEquals(SUNDAY, stringToWeekdayEnum("Sun"));
        assertEquals(SUNDAY, stringToWeekdayEnum("sunday"));
        assertEquals(SUNDAY, stringToWeekdayEnum("SUNDAY"));
        assertEquals(SUNDAY, stringToWeekdayEnum("sun"));

        try {
            stringToWeekdayEnum("Hello");
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
        assertEquals("January", monthEnumToString(JANUARY));
        assertEquals("February", monthEnumToString(FEBRUARY));
        assertEquals("March", monthEnumToString(MARCH));
        assertEquals("April", monthEnumToString(APRIL));
        assertEquals("May", monthEnumToString(MAY));
        assertEquals("June", monthEnumToString(JUNE));
        assertEquals("July", monthEnumToString(JULY));
        assertEquals("August", monthEnumToString(AUGUST));
        assertEquals("September", monthEnumToString(SEPTEMBER));
        assertEquals("October", monthEnumToString(OCTOBER));
        assertEquals("November", monthEnumToString(NOVEMBER));
        assertEquals("December", monthEnumToString(DECEMBER));

        assertEquals("Jan", monthEnumToString(JANUARY, true));
        assertEquals("Feb", monthEnumToString(FEBRUARY, true));
        assertEquals("Mar", monthEnumToString(MARCH, true));
        assertEquals("Apr", monthEnumToString(APRIL, true));
        assertEquals("May", monthEnumToString(MAY, true));
        assertEquals("Jun", monthEnumToString(JUNE, true));
        assertEquals("Jul", monthEnumToString(JULY, true));
        assertEquals("Aug", monthEnumToString(AUGUST, true));
        assertEquals("Sep", monthEnumToString(SEPTEMBER, true));
        assertEquals("Oct", monthEnumToString(OCTOBER, true));
        assertEquals("Nov", monthEnumToString(NOVEMBER, true));
        assertEquals("Dec", monthEnumToString(DECEMBER, true));

        try {
            monthEnumToString(Month.fromInt(-1));
            fail("Invalid month code should throw exception");
        } catch (IllegalArgumentException e) {
        }

    }

    public void testStringToMonthCode() throws Exception {
        assertEquals(JANUARY, stringToMonthEnum("1"));
        assertEquals(FEBRUARY, stringToMonthEnum("2"));
        assertEquals(MARCH, stringToMonthEnum("3"));
        assertEquals(APRIL, stringToMonthEnum("4"));
        assertEquals(MAY, stringToMonthEnum("5"));
        assertEquals(JUNE, stringToMonthEnum("6"));
        assertEquals(JULY, stringToMonthEnum("7"));
        assertEquals(AUGUST, stringToMonthEnum("8"));
        assertEquals(SEPTEMBER, stringToMonthEnum("9"));
        assertEquals(OCTOBER, stringToMonthEnum("10"));
        assertEquals(NOVEMBER, stringToMonthEnum("11"));
        assertEquals(DECEMBER, stringToMonthEnum("12"));

        try {
            assertEquals(-1, stringToMonthEnum("0"));
            fail("실패해야함");
        } catch (IllegalArgumentException e) {}

        try {
            assertEquals(-1, stringToMonthEnum("13"));
            fail("실패해야함");

        } catch (IllegalArgumentException e) {}

        try {
            assertEquals(-1, stringToMonthEnum("Hello"));
            fail("실패해야함");

        } catch (IllegalArgumentException e) {}


        for (Month m : Month.values()) {
            assertEquals(m, stringToMonthEnum(monthEnumToString(m, false)));
            assertEquals(m, stringToMonthEnum(monthEnumToString(m, true)));
        }

        assertEquals(JANUARY, stringToMonthEnum("jan"));
        assertEquals(FEBRUARY, stringToMonthEnum("feb"));
        assertEquals(MARCH, stringToMonthEnum("mar"));
        assertEquals(APRIL, stringToMonthEnum("apr"));
        assertEquals(MAY, stringToMonthEnum("may"));
        assertEquals(JUNE, stringToMonthEnum("jun"));
        assertEquals(JULY, stringToMonthEnum("jul"));
        assertEquals(AUGUST, stringToMonthEnum("aug"));
        assertEquals(SEPTEMBER, stringToMonthEnum("sep"));
        assertEquals(OCTOBER, stringToMonthEnum("oct"));
        assertEquals(NOVEMBER, stringToMonthEnum("nov"));
        assertEquals(DECEMBER, stringToMonthEnum("dec"));

        assertEquals(JANUARY, stringToMonthEnum("JAN"));
        assertEquals(FEBRUARY, stringToMonthEnum("FEB"));
        assertEquals(MARCH, stringToMonthEnum("MAR"));
        assertEquals(APRIL, stringToMonthEnum("APR"));
        assertEquals(MAY, stringToMonthEnum("MAY"));
        assertEquals(JUNE, stringToMonthEnum("JUN"));
        assertEquals(JULY, stringToMonthEnum("JUL"));
        assertEquals(AUGUST, stringToMonthEnum("AUG"));
        assertEquals(SEPTEMBER, stringToMonthEnum("SEP"));
        assertEquals(OCTOBER, stringToMonthEnum("OCT"));
        assertEquals(NOVEMBER, stringToMonthEnum("NOV"));
        assertEquals(DECEMBER, stringToMonthEnum("DEC"));

        assertEquals(JANUARY, stringToMonthEnum("january"));
        assertEquals(FEBRUARY, stringToMonthEnum("february"));
        assertEquals(MARCH, stringToMonthEnum("march"));
        assertEquals(APRIL, stringToMonthEnum("april"));
        assertEquals(MAY, stringToMonthEnum("may"));
        assertEquals(JUNE, stringToMonthEnum("june"));
        assertEquals(JULY, stringToMonthEnum("july"));
        assertEquals(AUGUST, stringToMonthEnum("august"));
        assertEquals(SEPTEMBER, stringToMonthEnum("september"));
        assertEquals(OCTOBER, stringToMonthEnum("october"));
        assertEquals(NOVEMBER, stringToMonthEnum("november"));
        assertEquals(DECEMBER, stringToMonthEnum("december"));

        assertEquals(JANUARY, stringToMonthEnum("JANUARY"));
        assertEquals(FEBRUARY, stringToMonthEnum("FEBRUARY"));
        assertEquals(MARCH, stringToMonthEnum("MAR"));
        assertEquals(APRIL, stringToMonthEnum("APRIL"));
        assertEquals(MAY, stringToMonthEnum("MAY"));
        assertEquals(JUNE, stringToMonthEnum("JUNE"));
        assertEquals(JULY, stringToMonthEnum("JULY"));
        assertEquals(AUGUST, stringToMonthEnum("AUGUST"));
        assertEquals(SEPTEMBER, stringToMonthEnum("SEPTEMBER"));
        assertEquals(OCTOBER, stringToMonthEnum("OCTOBER"));
        assertEquals(NOVEMBER, stringToMonthEnum("NOVEMBER"));
        assertEquals(DECEMBER, stringToMonthEnum("DECEMBER"));

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
        assertEquals(0, leapYearCount(1900));
        assertEquals(0, leapYearCount(1901));
        assertEquals(0, leapYearCount(1902));
        assertEquals(0, leapYearCount(1903));
        assertEquals(1, leapYearCount(1904));
        assertEquals(1, leapYearCount(1905));
        assertEquals(1, leapYearCount(1906));
        assertEquals(1, leapYearCount(1907));
        assertEquals(2, leapYearCount(1908));
        assertEquals(24, leapYearCount(1999));
        assertEquals(25, leapYearCount(2001));
        assertEquals(49, leapYearCount(2101));
        assertEquals(73, leapYearCount(2201));
        assertEquals(97, leapYearCount(2301));
        assertEquals(122, leapYearCount(2401));
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
        assertEquals(d(2, JANUARY, 1900), addDays(1, newYears));
        assertEquals(d(1, FEBRUARY, 1900), addDays(31, newYears));
        assertEquals(d(1, JANUARY, 1901), addDays(365, newYears));
        assertEquals(d(31, DECEMBER, 1904), addDays(5 * 365, newYears));
    }

    private static SpreadsheetDate d(int day, Month month, int year) {
        return new SpreadsheetDate(day, month, year);
    }

    public void testAddMonths() throws Exception {
        assertEquals(d(1, FEBRUARY, 1900), addMonths(1, d(1, JANUARY, 1900)));
        assertEquals(d(28, FEBRUARY, 1900), addMonths(1, d(31, JANUARY, 1900)));
        assertEquals(d(28, FEBRUARY, 1900), addMonths(1, d(30, JANUARY, 1900)));
        assertEquals(d(28, FEBRUARY, 1900), addMonths(1, d(29, JANUARY, 1900)));
        assertEquals(d(28, FEBRUARY, 1900), addMonths(1, d(28, JANUARY, 1900)));
        assertEquals(d(27, FEBRUARY, 1900), addMonths(1, d(27, JANUARY, 1900)));

        assertEquals(d(30, JUNE, 1900), addMonths(5, d(31, JANUARY, 1900)));
        assertEquals(d(30, JUNE, 1901), addMonths(17, d(31, JANUARY, 1900)));

        assertEquals(d(29, FEBRUARY, 1904), addMonths(49, d(31, JANUARY, 1900)));

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
        assertEquals(1900, date.getYYYY());
        assertEquals(2, date.toSerial());
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
