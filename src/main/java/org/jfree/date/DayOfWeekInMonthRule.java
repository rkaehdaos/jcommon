/* ========================================================================
 * JCommon : a free general purpose class library for the Java(tm) platform
 * ========================================================================
 *
 * (C) Copyright 2000-2005, by Object Refinery Limited and Contributors.
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
 * -------------------------
 * DayOfWeekInMonthRule.java
 * -------------------------
 * (C) Copyright 2000-2003, by Object Refinery Limited.
 *
 * Original Author:  David Gilbert (for Object Refinery Limited);
 * Contributor(s):   -;
 *
 * $Id: DayOfWeekInMonthRule.java,v 1.5 2005/11/16 15:58:40 taqua Exp $
 *
 * Changes (from 26-Oct-2001)
 * --------------------------
 * 26-Oct-2001 : Changed package to com.jrefinery.date.*;
 * 03-Oct-2002 : Fixed errors reported by Checkstyle (DG);
 * 01-Jun-2005 : Removed the explicit clonable declaration, it is declared
 *               in the super class.
 */

package org.jfree.date;

import static org.jfree.date.Day.MONDAY;
import static org.jfree.date.Month.JANUARY;
import static org.jfree.date.WeekInMonth.*;

/**
 * An annual date rule that specifies the nth day of the week in a given month
 * (for example, the third Wednesday in June, or the last Friday in November).
 *
 * @author David Gilbert
 */
public class DayOfWeekInMonthRule extends AnnualDateRule {

    /** FIRST, SECOND, THIRD, FOURTH or LAST. */
    private WeekInMonth weekInMonth;

    /** The day of the week (SerialDate.MONDAY, SerialDate.TUESDAY...). */
    private Day dayOfWeek;

    /** The month (1 to 12, or SerialDate.JANUARY, SerialDate.FEBRUARY...). */
    private Month month;

    /**
     * Default constructor: builds a rule for the first Monday in January by default.
     */
    public DayOfWeekInMonthRule() {
        this(FIRST, MONDAY, JANUARY);
    }

    /**
     * Standard constructor: builds a rule with the specified attributes.
     *
     * @param weekInMonth  one of: FIRST, SECOND, THIRD, FOURTH or LAST.
     * @param dayOfWeek  the day-of-the-week (SerialDate.MONDAY, SerialDate.TUESDAY, etc.).
     * @param month  the month (SerialDate.JANUARY, SerialDate.FEBRUARY, etc.).
     */
    public DayOfWeekInMonthRule(final WeekInMonth weekInMonth, final Day dayOfWeek, final Month month) {
        this.weekInMonth = weekInMonth;
        this.dayOfWeek = dayOfWeek;
        this.month = month;
    }

    /**
     * Returns the 'count' for this rule (one of FIRST, SECOND, THIRD, FOURTH and LAST).
     *
     * @return the 'count'.
     */
    public WeekInMonth getWeekInMonth() {
        return this.weekInMonth;
    }

    /**
     * Sets the 'count' for this rule (one of FIRST, SECOND, THIRD, FOURTH and LAST).
     *
     * @param weekInMonth the 'count'.
     */
    public void setWeekInMonth(final WeekInMonth weekInMonth) {
        this.weekInMonth = weekInMonth;
    }


    public Day getDayOfWeek() {
        return this.dayOfWeek;
    }

    /**
     * Sets the day-of-the-week for this rule.
     *
     * @param dayOfWeek  the day-of-the-week.
     */
    public void setDayOfWeek(final Day dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    /**
     * Returns the month for this rule.
     *
     * @return the month.
     */
    public Month getMonth() {
        return this.month;
    }

    /**
     * Sets the month for this rule.
     *
     * @param month  the month (SerialDate.JANUARY, SerialDate.FEBRUARY, etc.).
     */
    public void setMonth(final Month month) {
        this.month = month;
    }

    /**
     * Return the date for this rule, given the year.
     *
     * @param year  the year.
     *
     * @return the date generated by the rule for the given year.
     */
    public DayDate getDate(final int year) {
        DayDate result;
        if (this.weekInMonth != LAST) {
            // start at the beginning of the month
            result = DayDate.createInstance(1, this.month, year);
            while (result.getDayOfWeek() != this.dayOfWeek) {
                result = result.plusDays(1);
            }
            result = result.plusDays(7 * (this.weekInMonth.index - 1));

        }
        else {
            // start at the end of the month and work backwards...
            result = DayDate.createInstance(1, this.month, year);
            result = result.getEndOfCurrentMonth(result);
            while (result.getDayOfWeek() != this.dayOfWeek) {
                result = result.plusDays(-1);
            }

        }
        return result;
    }

}
