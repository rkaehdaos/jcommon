/* ========================================================================
 * JCommon : Java(tm) 플랫폼을 위한 범용 클래스 오픈 소스 라이브러리
 * ========================================================================
 *
 * (C) Copyright 2000-2006, by Object Refinery Limited and Contributors.
 * 
 * Project Info:  http://www.jfree.org/jcommon/index.html
 *
 * 이 라이브러리는 자유 소프트웨어입니다.
 * 소프트웨어의 피양도자는 자유 소프트웨어 재단이 공표한 GNU 약소 일반 공중 사용 허가서 2.1판 또는 그 이후 판을 임의로 선택해서,
 * 그 규정에 따라 라이브러리를 개작하거나 재배포할 수 있습니다.
 *
 * 이 라이브러리는 유용하게 사용될 수 있으리라는 희망에서 배포되고 있지만,
 * 특정한 목적에 맞는 적합성 여부나 판매용으로 사용할 수 있으리라는 묵시적인 보증을 포함한 어떠한 형태의 보증도 제공하지 않습니다.
 * 보다 자세한 사항에 대해서는 GNU 약소 일반 공중 사용 허가서를 참고하시기 바랍니다.
 *
 * GNU 약소 일반 공중 사용 허가서는 이 라이브러리와 함께 제공됩니다.
 * 만약, 이 문서가 누락되어 있다면 자유 소프트웨어 재단으로 문의하시기 바랍니다.
 * (자유 소프트웨어 재단: Free Software Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA)
 *
 * [자바는 썬 마이크로시스템즈(Sun Microsystems, Inc)의 등록 상표로써,
 * 미국과 다른 국가에서 적용된다.]
 *
 * ---------------
 * SerialDate.java
 * ---------------
 * (C) Copyright 2001-2006, by Object Refinery Limited.
 *
 * 원래 저자:  David Gilbert(데이비드 길버트)  (for Object Refinery Limited);
 * 공헌자:   -;
 *
 * $Id: SerialDate.java,v 1.9 2011/10/17 20:08:22 mungady Exp $

 */

package org.jfree.date;

import java.io.Serializable;
import java.util.*;

/**
 *  <pre>
 *  An abstract class that defines our requirements for manipulating dates,
 *  without tying down a particular implementation.
 *  <P>
 *  Requirement 1 : match at least what Excel does for dates;
 *  Requirement 2 : the date represented by the class is immutable;
 *  <P>
 *  Why not just use java.util.Date?  We will, when it makes sense.  At times,
 *  java.util.Date can be *too* precise - it represents an instant in time,
 *  accurate to 1/1000th of a second (with the date itself depending on the
 *  time-zone).  Sometimes we just want to represent a particular day (e.g. 21
 *  January 2015) without concerning ourselves about the time of day, or the
 *  time-zone, or anything else.  That's what we've defined SerialDate for.
 *  <P>
 *  You can call getInstance() to get a concrete subclass of SerialDate,
 *  without worrying about the exact implementation.
 *  </pre>
 * @author David Gilbert
 */
public abstract class DayDate implements Comparable, Serializable {

    public static final int MINIMUM_YEAR_SUPPORTED = 1900;
    public static final int MAXIMUM_YEAR_SUPPORTED = 9999;

    public DayDate plusDays(int days) {
        return DayDateFactory.makeDate(getOrdinalDay() + days);
    }

    public DayDate plusMonths(int months) {

        int thisMonthAsOrdinal = 12 * getYear() + getMonth().index - 1;
        int resultMonthAsOrdinal = thisMonthAsOrdinal + months;
        int resultYear = resultMonthAsOrdinal / 12;
        Month resultMonth = Month.fromInt(resultMonthAsOrdinal % 12 + 1);
        int lastDayOfResultMonth = DateUtil.lastDayOfMonth(resultMonth, resultYear);
        int resultDay = Math.min(getDayOfMonth(), lastDayOfResultMonth);
        return DayDateFactory.makeDate(resultDay, resultMonth, resultYear);

    }

    public DayDate plusYears(int years) {

        int resultYear = getYear() + years;
        int lastDayOfMonthInResultYear = DateUtil.lastDayOfMonth(getMonth(), resultYear);
        int resultDay = Math.min(getDayOfMonth(), lastDayOfMonthInResultYear);
        return DayDateFactory.makeDate(resultDay, getMonth(), resultYear);
    }

    public DayDate getEndOfCurrentMonth() {
        Month month = getMonth();
        int year = getYear();
        int lastDay = DateUtil.lastDayOfMonth(month, year);
        return DayDateFactory.makeDate(lastDay, month, year);
    }

    public static DayDate createInstance(int day, Month month, int yyyy) {
        return new SpreadsheetDate(day, month, yyyy);
    }

    public static DayDate createInstance(int serial) {
        return new SpreadsheetDate(serial);
    }

    public static DayDate createInstance(java.util.Date date) {

        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        return new SpreadsheetDate(calendar.get(Calendar.DATE),
                                   Month.fromInt(calendar.get(Calendar.MONTH) + 1),
                                   calendar.get(Calendar.YEAR));

    }

    public abstract int getOrdinalDay();

    public abstract int getYear();

    public abstract Month getMonth();

    public abstract int getDayOfMonth();

    public Day getDayOfWeek() {
        Day startingDay = getDayOfWeekForOrdinalZero();
        int startingOffset = startingDay.index - Day.SUNDAY.index;
        return Day.fromInt((getOrdinalDay() + startingOffset) % 7 + 1);
    }

    public int daysSince(DayDate other) {
        return getOrdinalDay() - other.getOrdinalDay();
    }

    public boolean isOn(DayDate other) {
        return (getOrdinalDay() == other.getOrdinalDay());
    }

    public boolean isBefore(DayDate other) {
        return (getOrdinalDay() < other.getOrdinalDay());
    }

    public boolean isOnOrBefore(DayDate other) {
        return (getOrdinalDay() <= other.getOrdinalDay());
    }

    public boolean isAfter(DayDate other) {
        return (getOrdinalDay() > other.getOrdinalDay());
    }

    public boolean isOnOrAfter(DayDate other) {
        return (getOrdinalDay() >= other.getOrdinalDay());
    }

    public boolean isInRange(DayDate d1, DayDate d2) {
        return isInRange(d1, d2, DateInterval.OPEN);
    }

    public boolean isInRange(DayDate d1, DayDate d2, DateInterval interval) {
        int left = Math.min(d1.getOrdinalDay(), d2.getOrdinalDay());
        int right = Math.max(d1.getOrdinalDay(), d2.getOrdinalDay());
        return interval.isIn(getOrdinalDay(), left, right);
    }

    public abstract Day getDayOfWeekForOrdinalZero();

    public DayDate getNearestDayOfWeek(Day targetDayOfWeek) {

        int offsetToThisWeeksTarget = targetDayOfWeek.index - getDayOfWeek().index;
        int offsetToFutureTarget = (offsetToThisWeeksTarget + 7) % 7;
        int offsetToPreviousTarget = offsetToFutureTarget - 7;
        if (offsetToFutureTarget > 3) {
            return plusDays(offsetToPreviousTarget);
        } else
            return plusDays(offsetToFutureTarget);
    }

    public DayDate getFollowingDayOfWeek(Day targetDayOfWeek) {

        int offsetToTarget = targetDayOfWeek.index - getDayOfWeek().index;
        if (offsetToTarget <= 0)
            offsetToTarget += 7;
        return plusDays(offsetToTarget);
    }

    public DayDate getPreviousDayOfWeek(Day targetDayOfWeek) {

        int offsetToTarget = targetDayOfWeek.index - getDayOfWeek().index;
        if (offsetToTarget >= 0)
            offsetToTarget -= 7;
        return plusDays(offsetToTarget);
    }

    /**
     * Returns a <code>java.util.Date</code> equivalent to this date.
     *
     * @return The date.
     */
    public Date toDate() {
        final Calendar calendar = Calendar.getInstance();
        calendar.set(getYear(), getMonth().index - 1, getDayOfMonth(), 0, 0, 0);
        return calendar.getTime();
    }

    public String toString() {
        return getDayOfMonth() + "-" + getMonth().toString()
                + "-" + getYear();
    }
}
