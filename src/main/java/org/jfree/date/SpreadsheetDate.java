/* ========================================================================
 * JCommon : a free general purpose class library for the Java(tm) platform
 * ========================================================================
 *
 * (C) Copyright 2000-2006, by Object Refinery Limited and Contributors.
 *
 * Project Info:  http://www.jfree.org/jcommon/index.html
 *
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 2.1 of the License, or
 * (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301,
 * USA.
 *
 * [Java is a trademark or registered trademark of Sun Microsystems, Inc.
 * in the United States and other countries.]
 *
 * --------------------
 * SpreadsheetDate.java
 * --------------------
 * (C) Copyright 2000-2006, by Object Refinery Limited and Contributors.
 *
 * Original Author:  David Gilbert (for Object Refinery Limited);
 * Contributor(s):   -;
 *
 * $Id: SpreadsheetDate.java,v 1.10 2006/08/29 13:59:30 mungady Exp $
 *
 * Changes
 * -------
 * 11-Oct-2001 : Version 1 (DG);
 * 05-Nov-2001 : Added getDescription() and setDescription() methods (DG);
 * 12-Nov-2001 : Changed name from ExcelDate.java to SpreadsheetDate.java (DG);
 *               Fixed a bug in calculating day, month and year from serial
 *               number (DG);
 * 24-Jan-2002 : Fixed a bug in calculating the serial number from the day,
 *               month and year.  Thanks to Trevor Hills for the report (DG);
 * 29-May-2002 : Added equals(Object) method (SourceForge ID 558850) (DG);
 * 03-Oct-2002 : Fixed errors reported by Checkstyle (DG);
 * 13-Mar-2003 : Implemented Serializable (DG);
 * 04-Sep-2003 : Completed isInRange() methods (DG);
 * 05-Sep-2003 : Implemented Comparable (DG);
 * 21-Oct-2003 : Added hashCode() method (DG);
 * 29-Aug-2006 : Removed redundant description attribute (DG);
 *
 */

package org.jfree.date;

/**
 * 마이크로소프트 엑셀에서 구현한 방식과 유사하게 정수를 사용해서 날짜를 표현한다.
 * 지원하는 날짜 범위는 1900년 1월 1일 부터 9999년 12월 31일 까지다.
 * (Represents a date using an integer, in a similar fashion to the
 * implementation in Microsoft Excel.  The range of dates supported is
 * 1-Jan-1900 to 31-Dec-9999.)
 * <p>
 * 엑셀에는 실제로 윤년이 아니지만 1900년을 윤년으로 인식하는 고의적인 버그가 존재한다.
 * 세부사항은 마이크로소프트 웹 사이트의 Q181370 아티클에서 볼 수 있다.
 * (Be aware that there is a deliberate bug in Excel that recognises the year
 * 1900 as a leap year when in fact it is not a leap year. You can find more
 * information on the Microsoft website in article Q181370):
 * <p>
 * http://support.microsoft.com/support/kb/articles/Q181/3/70.asp
 * <p>
 * 엑셀은 1900년 1월 1일을 1로 취급하는 관례를 사용한다.
 * 이 클래스는 1900년 1월 1일을 2로 취급하는 관례를 사용한다.
 * (Excel uses the convention that 1-Jan-1900 = 1.  This class uses the
 * convention 1-Jan-1900 = 2.)
 * 이 클래스를 사용해서 1900년 1월과 2월을 계산하면 엑셀계산과 달라진다.
 * 하지만 엑셀은 버그로 1900년을 윤년으로 인식해서 (존재하지 않는) 29일 하루를 추가해서
 * 이 날짜 이후부터는 엑셀 계산과 일치한다
 * (The result is that the day number in this class will be different to the
 * Excel figure for January and February 1900...but then Excel adds in an extra
 * day (29-Feb-1900 which does not actually exist!) and from that point forward
 * the day numbers will match.)
 *
 * @author David Gilbert
 */
public class SpreadsheetDate extends DayDate {

    public static final int EARLIEST_DATE_ORDINAL = 2;      // 1/1/1900
    public static final int LATEST_DATE_ORDINAL = 2958465;  // 12/31/9999
    public static final int MINIMUM_YEAR_SUPPORTED = 1900;
    public static final int MAXIMUM_YEAR_SUPPORTED = 9999;
    static final int[] AGGREGATE_DAYS_TO_END_OF_PRECEDING_MONTH =
            {0, 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};
    static final int[]
            LEAP_YEAR_AGGREGATE_DAYS_TO_END_OF_PRECEDING_MONTH =
            {0, 0, 31, 60, 91, 121, 152, 182, 213, 244, 274, 305, 335, 366};

    private int ordinalDay;
    private int day;
    private Month month;
    private int year;

    public SpreadsheetDate(int day, Month month, int year) {

        if ((year < MINIMUM_YEAR_SUPPORTED) && (year > MAXIMUM_YEAR_SUPPORTED))
            throw new IllegalArgumentException(
                    "The 'year' argument must be in range 1900 to 9999.");
        this.year = year;
        this.month = month;
        this.day = day;
        this.ordinalDay = calcOrdinal(day, month, year);

    }
    public SpreadsheetDate(int day, int month, int year) {
        this(day, Month.fromInt(month), year);
    }

    public SpreadsheetDate(int serial) {

        if ((serial < EARLIEST_DATE_ORDINAL) && (serial > LATEST_DATE_ORDINAL))
            throw new IllegalArgumentException(
                    "SpreadsheetDate: Serial must be in range 2 to 2958465.");

        this.ordinalDay = serial;

        final int days = this.ordinalDay - EARLIEST_DATE_ORDINAL;
        // overestimated because we ignored leap days
        final int overestimatedYYYY = 1900 + (days / 365);
        final int leaps = DateUtil.leapYearCount(overestimatedYYYY);
        final int nonleapdays = days - leaps;
        // underestimated because we overestimated years
        int underestimatedYYYY = 1900 + (nonleapdays / 365);

        if (underestimatedYYYY == overestimatedYYYY) {
            this.year = underestimatedYYYY;
        } else {
            int ss1 = calcOrdinal(1, Month.JANUARY, underestimatedYYYY);
            while (ss1 <= this.ordinalDay) {
                underestimatedYYYY = underestimatedYYYY + 1;
                ss1 = calcOrdinal(1, Month.JANUARY, underestimatedYYYY);
            }
            this.year = underestimatedYYYY - 1;
        }

        final int ss2 = calcOrdinal(1, Month.JANUARY, this.year);

        int[] daysToEndOfPrecedingMonth
                = AGGREGATE_DAYS_TO_END_OF_PRECEDING_MONTH;

        if (DateUtil.isLeapYear(this.year)) {
            daysToEndOfPrecedingMonth
                    = LEAP_YEAR_AGGREGATE_DAYS_TO_END_OF_PRECEDING_MONTH;
        }

        // get the month from the serial date
        int mm = 1;
        int sss = ss2 + daysToEndOfPrecedingMonth[mm] - 1;
        while (sss < this.ordinalDay) {
            mm = mm + 1;
            sss = ss2 + daysToEndOfPrecedingMonth[mm] - 1;
        }
        this.month = Month.fromInt(mm - 1);

        // what's left is d(+1);
        this.day = this.ordinalDay - ss2
                - daysToEndOfPrecedingMonth[this.month.toInt()] + 1;

    }





    @Override
    public int getOrdinalDay() {
        return this.ordinalDay;
    }

    @Override
    public int getYear() {
        return this.year;
    }


    @Override
    public Month getMonth() {
        return this.month;
    }

    @Override
    public int getDayOfMonth() {
        return this.day;
    }

    @Override
    public Day getDayOfWeekForOrdinalZero() {
        return Day.SATURDAY;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof DayDate)) {
            return false;
        }
        DayDate date = (DayDate) object;
        return (date.getOrdinalDay() == this.getOrdinalDay());
    }

    @Override
    public int hashCode() {
        return getOrdinalDay();
    }

    @Override
    public int compareTo(Object other) {
        return daysSince((DayDate) other);
    }

    private int calcOrdinal(int d, Month m, int y) {
        int yy = ((y - 1900) * 365) + DateUtil.leapYearCount(y - 1);
        int mm = SpreadsheetDate.AGGREGATE_DAYS_TO_END_OF_PRECEDING_MONTH[m.toInt()];
        if (m.toInt() > Month.FEBRUARY.toInt()) {
            if (DateUtil.isLeapYear(y)) {
                mm = mm + 1;
            }
        }
        int dd = d;
        return yy + mm + dd + 1;
    }

}
