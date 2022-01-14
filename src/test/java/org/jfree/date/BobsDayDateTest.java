package org.jfree.date;

import junit.framework.TestCase;

import java.util.GregorianCalendar;

import static org.jfree.date.DayDate.*;
import static org.jfree.date.Month.*;

public class BobsDayDateTest extends TestCase {

    public void testIsValidWeekdayCode() throws Exception {
        for (int day = 1; day <= 7; day++)
            assertTrue(isValidWeekdayCode(day));
        assertFalse(isValidWeekdayCode(0));
        assertFalse(isValidWeekdayCode(8));
    }

    public void testStringToWeekdayCode() throws Exception {

        assertEquals(-1, stringToWeekdayCode("Hello"));
        assertEquals(MONDAY, stringToWeekdayCode("Monday"));
        assertEquals(MONDAY, stringToWeekdayCode("Mon"));
        assertEquals(MONDAY, stringToWeekdayCode("monday"));
        assertEquals(MONDAY, stringToWeekdayCode("MONDAY"));
        assertEquals(MONDAY, stringToWeekdayCode("mon"));

        assertEquals(TUESDAY, stringToWeekdayCode("Tuesday"));
        assertEquals(TUESDAY, stringToWeekdayCode("Tue"));
        assertEquals(TUESDAY, stringToWeekdayCode("tuesday"));
        assertEquals(TUESDAY, stringToWeekdayCode("TUESDAY"));
        assertEquals(TUESDAY, stringToWeekdayCode("tue"));
//            assertEquals(TUESDAY, stringToWeekdayCode("tues"));

        assertEquals(WEDNESDAY, stringToWeekdayCode("Wednesday"));
        assertEquals(WEDNESDAY, stringToWeekdayCode("Wed"));
        assertEquals(WEDNESDAY, stringToWeekdayCode("wednesday"));
        assertEquals(WEDNESDAY, stringToWeekdayCode("WEDNESDAY"));
        assertEquals(WEDNESDAY, stringToWeekdayCode("wed"));

        assertEquals(THURSDAY, stringToWeekdayCode("Thursday"));
        assertEquals(THURSDAY, stringToWeekdayCode("Thu"));
        assertEquals(THURSDAY, stringToWeekdayCode("thursday"));
        assertEquals(THURSDAY, stringToWeekdayCode("THURSDAY"));
        assertEquals(THURSDAY, stringToWeekdayCode("thu"));
//            assertEquals(THURSDAY, stringToWeekdayCode("thurs"));

        assertEquals(FRIDAY, stringToWeekdayCode("Friday"));
        assertEquals(FRIDAY, stringToWeekdayCode("Fri"));
        assertEquals(FRIDAY, stringToWeekdayCode("friday"));
        assertEquals(FRIDAY, stringToWeekdayCode("FRIDAY"));
        assertEquals(FRIDAY, stringToWeekdayCode("fri"));

        assertEquals(SATURDAY, stringToWeekdayCode("Saturday"));
        assertEquals(SATURDAY, stringToWeekdayCode("Sat"));
        assertEquals(SATURDAY, stringToWeekdayCode("saturday"));
        assertEquals(SATURDAY, stringToWeekdayCode("SATURDAY"));
        assertEquals(SATURDAY, stringToWeekdayCode("sat"));

        assertEquals(SUNDAY, stringToWeekdayCode("Sunday"));
        assertEquals(SUNDAY, stringToWeekdayCode("Sun"));
        assertEquals(SUNDAY, stringToWeekdayCode("sunday"));
        assertEquals(SUNDAY, stringToWeekdayCode("SUNDAY"));
        assertEquals(SUNDAY, stringToWeekdayCode("sun"));
    }

    public void testWeekdayCodeToString() throws Exception {
        assertEquals("Sunday", weekdayCodeToString(SUNDAY));
        assertEquals("Monday", weekdayCodeToString(MONDAY));
        assertEquals("Tuesday", weekdayCodeToString(TUESDAY));
        assertEquals("Wednesday", weekdayCodeToString(WEDNESDAY));
        assertEquals("Thursday", weekdayCodeToString(THURSDAY));
        assertEquals("Friday", weekdayCodeToString(FRIDAY));
        assertEquals("Saturday", weekdayCodeToString(SATURDAY));
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


        for (Month m : values()) {
            assertEquals(m, stringToMonthEnum(monthEnumToString(m, false)));
            assertEquals(m, stringToMonthEnum(monthEnumToString(m, true)));
        }


        //    assertEquals(1,stringToMonthCode("jan"));
        //    assertEquals(2,stringToMonthCode("feb"));
        //    assertEquals(3,stringToMonthCode("mar"));
        //    assertEquals(4,stringToMonthCode("apr"));
        //    assertEquals(5,stringToMonthCode("may"));
        //    assertEquals(6,stringToMonthCode("jun"));
        //    assertEquals(7,stringToMonthCode("jul"));
        //    assertEquals(8,stringToMonthCode("aug"));
        //    assertEquals(9,stringToMonthCode("sep"));
        //    assertEquals(10,stringToMonthCode("oct"));
        //    assertEquals(11,stringToMonthCode("nov"));
        //    assertEquals(12,stringToMonthCode("dec"));

        //    assertEquals(1,stringToMonthCode("JAN"));
        //    assertEquals(2,stringToMonthCode("FEB"));
        //    assertEquals(3,stringToMonthCode("MAR"));
        //    assertEquals(4,stringToMonthCode("APR"));
        //    assertEquals(5,stringToMonthCode("MAY"));
        //    assertEquals(6,stringToMonthCode("JUN"));
        //    assertEquals(7,stringToMonthCode("JUL"));
        //    assertEquals(8,stringToMonthCode("AUG"));
        //    assertEquals(9,stringToMonthCode("SEP"));
        //    assertEquals(10,stringToMonthCode("OCT"));
        //    assertEquals(11,stringToMonthCode("NOV"));
        //    assertEquals(12,stringToMonthCode("DEC"));

        //    assertEquals(1,stringToMonthCode("january"));
        //    assertEquals(2,stringToMonthCode("february"));
        //    assertEquals(3,stringToMonthCode("march"));
        //    assertEquals(4,stringToMonthCode("april"));
        //    assertEquals(5,stringToMonthCode("may"));
        //    assertEquals(6,stringToMonthCode("june"));
        //    assertEquals(7,stringToMonthCode("july"));
        //    assertEquals(8,stringToMonthCode("august"));
        //    assertEquals(9,stringToMonthCode("september"));
        //    assertEquals(10,stringToMonthCode("october"));
        //    assertEquals(11,stringToMonthCode("november"));
        //    assertEquals(12,stringToMonthCode("december"));

        //    assertEquals(1,stringToMonthCode("JANUARY"));
        //    assertEquals(2,stringToMonthCode("FEBRUARY"));
        //    assertEquals(3,stringToMonthCode("MAR"));
        //    assertEquals(4,stringToMonthCode("APRIL"));
        //    assertEquals(5,stringToMonthCode("MAY"));
        //    assertEquals(6,stringToMonthCode("JUNE"));
        //    assertEquals(7,stringToMonthCode("JULY"));
        //    assertEquals(8,stringToMonthCode("AUGUST"));
        //    assertEquals(9,stringToMonthCode("SEPTEMBER"));
        //    assertEquals(10,stringToMonthCode("OCTOBER"));
        //    assertEquals(11,stringToMonthCode("NOVEMBER"));
        //    assertEquals(12,stringToMonthCode("DECEMBER"));
    }

    public void testIsValidWeekInMonthCode() throws Exception {
        for (int w = 0; w <= 4; w++) {
            assertTrue(isValidWeekInMonthCode(w));
        }
        assertFalse(isValidWeekInMonthCode(5));
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
            getPreviousDayOfWeek(-1, d(1, JANUARY, 2006));
            fail("Invalid day of week code should throw exception");
        } catch (IllegalArgumentException e) {
        }
    }

    public void testGetFollowingDayOfWeek() throws Exception {
        assertEquals(d(1, JANUARY, 2005), getFollowingDayOfWeek(SATURDAY, d(25, DECEMBER, 2004)));
        assertEquals(d(1, JANUARY, 2005), getFollowingDayOfWeek(SATURDAY, d(26, DECEMBER, 2004)));
        assertEquals(d(3, MARCH, 2004), getFollowingDayOfWeek(WEDNESDAY, d(28, FEBRUARY, 2004)));

        try {
            getFollowingDayOfWeek(-1, d(1, JANUARY, 2006));
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
            getNearestDayOfWeek(-1, d(1, JANUARY, 2006));
            fail("Invalid day of week code should throw exception");
        } catch (IllegalArgumentException e) {
        }
    }

    public void testEndOfCurrentMonth() throws Exception {
        DayDate d = DayDate.createInstance(2);
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
        assertEquals("First", weekInMonthToString(FIRST_WEEK_IN_MONTH));
        assertEquals("Second", weekInMonthToString(SECOND_WEEK_IN_MONTH));
        assertEquals("Third", weekInMonthToString(THIRD_WEEK_IN_MONTH));
        assertEquals("Fourth", weekInMonthToString(FOURTH_WEEK_IN_MONTH));
        assertEquals("Last", weekInMonthToString(LAST_WEEK_IN_MONTH));

        try {
            weekInMonthToString(-1);
            fail("Invalid week code should throw exception");
        } catch (IllegalArgumentException e) {
        }
    }

    public void testRelativeToString() throws Exception {
        assertEquals("Preceding", relativeToString(PRECEDING));
        assertEquals("Nearest", relativeToString(NEAREST));
        assertEquals("Following", relativeToString(FOLLOWING));

        try {
            relativeToString(-1000);
            fail("Invalid relative code should throw exception");
        } catch (IllegalArgumentException e) {
        }
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
