package org.jfree.date;

import junit.framework.TestCase;

import java.util.Date;
import java.util.GregorianCalendar;

import static org.jfree.date.Day.*;
import static org.jfree.date.Month.*;

public class BobsDayDateTest extends TestCase {

    public void testGetMonths() throws Exception {
        assertEquals(13, DateUtil.getMonthNames().length);
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
        assertEquals("Sunday", SUNDAY.toString());
        assertEquals("Monday", MONDAY.toString());
        assertEquals("Tuesday", TUESDAY.toString());
        assertEquals("Wednesday", WEDNESDAY.toString());
        assertEquals("Thursday", THURSDAY.toString());
        assertEquals("Friday", FRIDAY.toString());
        assertEquals("Saturday", SATURDAY.toString());
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
        assertFalse(DateUtil.isLeapYear(1900));
        assertFalse(DateUtil.isLeapYear(1901));
        assertFalse(DateUtil.isLeapYear(1902));
        assertFalse(DateUtil.isLeapYear(1903));
        assertTrue(DateUtil.isLeapYear(1904));
        assertTrue(DateUtil.isLeapYear(1908));
        assertFalse(DateUtil.isLeapYear(1955));
        assertTrue(DateUtil.isLeapYear(1964));
        assertTrue(DateUtil.isLeapYear(1980));
        assertTrue(DateUtil.isLeapYear(2000));
        assertFalse(DateUtil.isLeapYear(2001));
        assertFalse(DateUtil.isLeapYear(2100));
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
        assertEquals(31, DateUtil.lastDayOfMonth(JANUARY, 1901));
        assertEquals(28, DateUtil.lastDayOfMonth(FEBRUARY, 1901));
        assertEquals(31, DateUtil.lastDayOfMonth(MARCH, 1901));
        assertEquals(30, DateUtil.lastDayOfMonth(APRIL, 1901));
        assertEquals(31, DateUtil.lastDayOfMonth(MAY, 1901));
        assertEquals(30, DateUtil.lastDayOfMonth(JUNE, 1901));
        assertEquals(31, DateUtil.lastDayOfMonth(JULY, 1901));
        assertEquals(31, DateUtil.lastDayOfMonth(AUGUST, 1901));
        assertEquals(30, DateUtil.lastDayOfMonth(SEPTEMBER, 1901));
        assertEquals(31, DateUtil.lastDayOfMonth(OCTOBER, 1901));
        assertEquals(30, DateUtil.lastDayOfMonth(NOVEMBER, 1901));
        assertEquals(31, DateUtil.lastDayOfMonth(DECEMBER, 1901));
        assertEquals(29, DateUtil.lastDayOfMonth(FEBRUARY, 1904));
    }

    public void testAddDays() throws Exception {
        DayDate newYears = d(1, JANUARY, 1900);
        assertEquals(d(2, JANUARY, 1900), newYears.plusDays(1));
        assertEquals(d(1, FEBRUARY, 1900), newYears.plusDays(31));
        assertEquals(d(1, JANUARY, 1901), newYears.plusDays(365));
        assertEquals(d(31, DECEMBER, 1904), newYears.plusDays(5 * 365));
    }

    private static SpreadsheetDate d(int day, Month month, int year) {
        return new SpreadsheetDate(day, month, year);
    }

    public void testAddMonths() throws Exception {
        assertEquals(d(1, FEBRUARY, 1900), d(1, JANUARY, 1900).plusMonths(1));
        assertEquals(d(28, FEBRUARY, 1900), d(31, JANUARY, 1900).plusMonths(1));
        assertEquals(d(28, FEBRUARY, 1900), d(30, JANUARY, 1900).plusMonths(1));
        assertEquals(d(28, FEBRUARY, 1900), d(29, JANUARY, 1900).plusMonths(1));
        assertEquals(d(28, FEBRUARY, 1900), d(28, JANUARY, 1900).plusMonths(1));
        assertEquals(d(27, FEBRUARY, 1900), d(27, JANUARY, 1900).plusMonths(1));

        assertEquals(d(30, JUNE, 1900), d(31, JANUARY, 1900).plusMonths(5));
        assertEquals(d(30, JUNE, 1901), d(31, JANUARY, 1900).plusMonths(17));

        assertEquals(d(29, FEBRUARY, 1904), d(31, JANUARY, 1900).plusMonths(49));

    }

    public void testAddYears() throws Exception {
        assertEquals(d(1, JANUARY, 1901), d(1, JANUARY, 1900).plusYears(1));
        assertEquals(d(28, FEBRUARY, 1905), d(29, FEBRUARY, 1904).plusYears(1));
        assertEquals(d(28, FEBRUARY, 1905), d(28, FEBRUARY, 1904).plusYears(1));
        assertEquals(d(28, FEBRUARY, 1904), d(28, FEBRUARY, 1903).plusYears(1));
    }

    public void testGetPreviousDayOfWeek() throws Exception {
        assertEquals(d(24, FEBRUARY, 2006), d(1, MARCH, 2006).getPreviousDayOfWeek(FRIDAY));
        assertEquals(d(22, FEBRUARY, 2006), d(1, MARCH, 2006).getPreviousDayOfWeek(WEDNESDAY));
        assertEquals(d(29, FEBRUARY, 2004), d(3, MARCH, 2004).getPreviousDayOfWeek(SUNDAY));
        assertEquals(d(29, DECEMBER, 2004), d(5, JANUARY, 2005).getPreviousDayOfWeek(WEDNESDAY));

        try {
            d(1, JANUARY, 2006).getPreviousDayOfWeek(Day.fromInt(-1));
            fail("Invalid day of week code should throw exception");
        } catch (IllegalArgumentException e) {
        }

        DayDate dayDate = DayDateFactory.makeDate(new Date());

        assertEquals(d(24, FEBRUARY, 2006), d(1, MARCH, 2006).getPreviousDayOfWeek(FRIDAY));
        assertEquals(d(22, FEBRUARY, 2006), d(1, MARCH, 2006).getPreviousDayOfWeek(WEDNESDAY));
        assertEquals(d(29, FEBRUARY, 2004), d(3, MARCH, 2004).getPreviousDayOfWeek(SUNDAY));
        assertEquals(d(29, DECEMBER, 2004), d(5, JANUARY, 2005).getPreviousDayOfWeek(WEDNESDAY));

    }

    public void testGetFollowingDayOfWeek() throws Exception {
        assertEquals(d(1, JANUARY, 2005), d(25, DECEMBER, 2004).getFollowingDayOfWeek(SATURDAY));
        assertEquals(d(1, JANUARY, 2005), d(26, DECEMBER, 2004).getFollowingDayOfWeek(SATURDAY));
        assertEquals(d(3, MARCH, 2004), d(28, FEBRUARY, 2004).getFollowingDayOfWeek(WEDNESDAY));

        try {
            d(1, JANUARY, 2006).getFollowingDayOfWeek(Day.fromInt(-1));
            fail("Invalid day of week code should throw exception");
        } catch (IllegalArgumentException e) {
        }
    }

    public void testGetNearestDayOfWeek() throws Exception {
        assertEquals(d(16, APRIL, 2006), d(16, APRIL, 2006).getNearestDayOfWeek(SUNDAY));
        assertEquals(d(16, APRIL, 2006), d(17, APRIL, 2006).getNearestDayOfWeek(SUNDAY));
        assertEquals(d(16, APRIL, 2006), d(18, APRIL, 2006).getNearestDayOfWeek(SUNDAY));
        assertEquals(d(16, APRIL, 2006), d(19, APRIL, 2006).getNearestDayOfWeek(SUNDAY));
        assertEquals(d(23, APRIL, 2006), d(20, APRIL, 2006).getNearestDayOfWeek(SUNDAY));
        assertEquals(d(23, APRIL, 2006), d(21, APRIL, 2006).getNearestDayOfWeek(SUNDAY));
        assertEquals(d(23, APRIL, 2006), d(22, APRIL, 2006).getNearestDayOfWeek(SUNDAY));

        assertEquals(d(17, APRIL, 2006), d(16, APRIL, 2006).getNearestDayOfWeek(MONDAY));
        assertEquals(d(17, APRIL, 2006), d(17, APRIL, 2006).getNearestDayOfWeek(MONDAY));
        assertEquals(d(17, APRIL, 2006), d(18, APRIL, 2006).getNearestDayOfWeek(MONDAY));
        assertEquals(d(17, APRIL, 2006), d(19, APRIL, 2006).getNearestDayOfWeek(MONDAY));
        assertEquals(d(17, APRIL, 2006), d(20, APRIL, 2006).getNearestDayOfWeek(MONDAY));
        assertEquals(d(24, APRIL, 2006), d(21, APRIL, 2006).getNearestDayOfWeek(MONDAY));
        assertEquals(d(24, APRIL, 2006), d(22, APRIL, 2006).getNearestDayOfWeek(MONDAY));

        assertEquals(d(18, APRIL, 2006), d(16, APRIL, 2006).getNearestDayOfWeek(TUESDAY));
        assertEquals(d(18, APRIL, 2006), d(17, APRIL, 2006).getNearestDayOfWeek(TUESDAY));
        assertEquals(d(18, APRIL, 2006), d(18, APRIL, 2006).getNearestDayOfWeek(TUESDAY));
        assertEquals(d(18, APRIL, 2006), d(19, APRIL, 2006).getNearestDayOfWeek(TUESDAY));
        assertEquals(d(18, APRIL, 2006), d(20, APRIL, 2006).getNearestDayOfWeek(TUESDAY));
        assertEquals(d(18, APRIL, 2006), d(21, APRIL, 2006).getNearestDayOfWeek(TUESDAY));
        assertEquals(d(25, APRIL, 2006), d(22, APRIL, 2006).getNearestDayOfWeek(TUESDAY));

        assertEquals(d(19, APRIL, 2006), d(16, APRIL, 2006).getNearestDayOfWeek(WEDNESDAY));
        assertEquals(d(19, APRIL, 2006), d(17, APRIL, 2006).getNearestDayOfWeek(WEDNESDAY));
        assertEquals(d(19, APRIL, 2006), d(18, APRIL, 2006).getNearestDayOfWeek(WEDNESDAY));
        assertEquals(d(19, APRIL, 2006), d(19, APRIL, 2006).getNearestDayOfWeek(WEDNESDAY));
        assertEquals(d(19, APRIL, 2006), d(20, APRIL, 2006).getNearestDayOfWeek(WEDNESDAY));
        assertEquals(d(19, APRIL, 2006), d(21, APRIL, 2006).getNearestDayOfWeek(WEDNESDAY));
        assertEquals(d(19, APRIL, 2006), d(22, APRIL, 2006).getNearestDayOfWeek(WEDNESDAY));

        assertEquals(d(13, APRIL, 2006), d(16, APRIL, 2006).getNearestDayOfWeek(THURSDAY));
        assertEquals(d(20, APRIL, 2006), d(17, APRIL, 2006).getNearestDayOfWeek(THURSDAY));
        assertEquals(d(20, APRIL, 2006), d(18, APRIL, 2006).getNearestDayOfWeek(THURSDAY));
        assertEquals(d(20, APRIL, 2006), d(19, APRIL, 2006).getNearestDayOfWeek(THURSDAY));
        assertEquals(d(20, APRIL, 2006), d(20, APRIL, 2006).getNearestDayOfWeek(THURSDAY));
        assertEquals(d(20, APRIL, 2006), d(21, APRIL, 2006).getNearestDayOfWeek(THURSDAY));
        assertEquals(d(20, APRIL, 2006), d(22, APRIL, 2006).getNearestDayOfWeek(THURSDAY));

        assertEquals(d(14, APRIL, 2006), d(16, APRIL, 2006).getNearestDayOfWeek(FRIDAY));
        assertEquals(d(14, APRIL, 2006), d(17, APRIL, 2006).getNearestDayOfWeek(FRIDAY));
        assertEquals(d(21, APRIL, 2006), d(18, APRIL, 2006).getNearestDayOfWeek(FRIDAY));
        assertEquals(d(21, APRIL, 2006), d(19, APRIL, 2006).getNearestDayOfWeek(FRIDAY));
        assertEquals(d(21, APRIL, 2006), d(20, APRIL, 2006).getNearestDayOfWeek(FRIDAY));
        assertEquals(d(21, APRIL, 2006), d(21, APRIL, 2006).getNearestDayOfWeek(FRIDAY));
        assertEquals(d(21, APRIL, 2006), d(22, APRIL, 2006).getNearestDayOfWeek(FRIDAY));

        assertEquals(d(15, APRIL, 2006), d(16, APRIL, 2006).getNearestDayOfWeek(SATURDAY));
        assertEquals(d(15, APRIL, 2006), d(17, APRIL, 2006).getNearestDayOfWeek(SATURDAY));
        assertEquals(d(15, APRIL, 2006), d(18, APRIL, 2006).getNearestDayOfWeek(SATURDAY));
        assertEquals(d(22, APRIL, 2006), d(19, APRIL, 2006).getNearestDayOfWeek(SATURDAY));
        assertEquals(d(22, APRIL, 2006), d(20, APRIL, 2006).getNearestDayOfWeek(SATURDAY));
        assertEquals(d(22, APRIL, 2006), d(21, APRIL, 2006).getNearestDayOfWeek(SATURDAY));
        assertEquals(d(22, APRIL, 2006), d(22, APRIL, 2006).getNearestDayOfWeek(SATURDAY));

        try {
            d(1, JANUARY, 2006).getNearestDayOfWeek(Day.fromInt(-1));
            fail("Invalid day of week code should throw exception");
        } catch (IllegalArgumentException e) {
        }
    }

    public void testEndOfCurrentMonth() throws Exception {
        DayDate d = DayDateFactory.makeDate(1, JANUARY, 2006);
        assertEquals(d(31, JANUARY, 2006), d.getEndOfMonth());
        d = d.plusMonths(1);
        assertEquals(d(28, FEBRUARY, 2006), d.getEndOfMonth());
        d = d.plusMonths(1);
        assertEquals(d(31, MARCH, 2006), d.getEndOfMonth());
        d = d.plusMonths(1);
        assertEquals(d(30, APRIL, 2006), d.getEndOfMonth());
        d = d.plusMonths(1);
        assertEquals(d(31, MAY, 2006), d.getEndOfMonth());
        d = d.plusMonths(1);
        assertEquals(d(30, JUNE, 2006), d.getEndOfMonth());
        d = d.plusMonths(1);
        assertEquals(d(31, JULY, 2006), d.getEndOfMonth());
        d = d.plusMonths(1);
        assertEquals(d(31, AUGUST, 2006), d.getEndOfMonth());
        d = d.plusMonths(1);
        assertEquals(d(30, SEPTEMBER, 2006), d.getEndOfMonth());
        d = d.plusMonths(1);
        assertEquals(d(31, OCTOBER, 2006), d.getEndOfMonth());
        d = d.plusMonths(1);
        assertEquals(d(30, NOVEMBER, 2006), d.getEndOfMonth());
        d = d.plusMonths(1);
        assertEquals(d(31, DECEMBER, 2006), d.getEndOfMonth());
        d = d.plusMonths(14);
        assertEquals(d(29, FEBRUARY, 2008), d.getEndOfMonth());
    }

    public void testCreateInstanceFromDDMMYYY() throws Exception {
        DayDate date = DayDateFactory.makeDate(1, JANUARY, 1900);
        assertEquals(1, date.getDayOfMonth());
        assertEquals(JANUARY, date.getMonth());
        assertEquals(1900, date.getYear());
        assertEquals(2, date.getOrdinalDay());
    }

    public void testCreateInstanceFromSerial() throws Exception {
        assertEquals(d(1, JANUARY, 1900), DayDateFactory.makeDate(2));
        assertEquals(d(1, JANUARY, 1901), DayDateFactory.makeDate(367));
    }

    public void testCreateInstanceFromJavaDate() throws Exception {
        assertEquals(d(1, JANUARY, 1900), DayDateFactory.makeDate(new GregorianCalendar(1900, 0, 1).getTime()));
        assertEquals(d(1, JANUARY, 2006), DayDateFactory.makeDate(new GregorianCalendar(2006, 0, 1).getTime()));
    }

    public void testDaysSince() throws Exception {
        assertEquals(14, d(15, JANUARY, 2006).daysSince(d(1, JANUARY, 2006)));
        assertEquals(-17, d(15, JANUARY, 2006).daysSince(d(1, FEBRUARY, 2006)));
        assertEquals(0, d(1, JANUARY, 2006).daysSince(d(1, JANUARY, 2006)));
    }


  public static void main(String[] args) {
    junit.textui.TestRunner.run(BobsDayDateTest.class);
  }
}
