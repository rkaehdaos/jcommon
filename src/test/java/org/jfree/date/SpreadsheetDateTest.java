/* ========================================================================
 * JCommon : a free general purpose class library for the Java(tm) platform
 * ========================================================================
 *
 * (C) Copyright 2000-2014, by Object Refinery Limited and Contributors.
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
 * ------------------------
 * SpreadsheetDateTest.java
 * ------------------------
 * (C) Copyright 2001-2014, by Object Refinery Limited.
 *
 * Original Author:  David Gilbert (for Object Refinery Limited);
 * Contributor(s):   -;
 *
 * $Id: SpreadsheetDateTest.java,v 1.6 2007/11/02 17:50:35 taqua Exp $
 *
 * Changes
 * -------
 * 15-Nov-2001 : Version 1 (DG);
 * 24-Oct-2002 : Fixed errors reported by Checkstyle (DG);
 * 29-Aug-2006 : Added checks for get/setDescription (DG);
 *
 */

package org.jfree.date;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import static org.jfree.date.Day.MONDAY;
import static org.jfree.date.Month.*;

/**
 * Tests for the {@link SpreadsheetDate} class.
 */
public class SpreadsheetDateTest extends TestCase {

    /** Date representing 1 January 1900. */
    private DayDate jan1Y1900;

    /** Date representing serial day number 2. */
    private DayDate s2;

    /**
     * Returns a test suite for the JUnit test runner.
     *
     * @return the test suite.
     */
    public static Test suite() {
        return new TestSuite(SpreadsheetDateTest.class);
    }

    /**
     * Creates a new test case.
     *
     * @param name  the name.
     */
    public SpreadsheetDateTest(final String name) {
        super(name);
    }

    /**
     * Setup.
     */
    @Override
    protected void setUp() {
        this.jan1Y1900 = new SpreadsheetDate(1, JANUARY, 1900);
        this.s2 = new SpreadsheetDate(2);
    }

    /**
     * 1 January 1900 is a Thursday.
     */
    public void test1Jan1900GetDayOfWeek() {
        final Day dayOfWeek = this.jan1Y1900.getDayOfWeek();
        assertEquals(MONDAY, dayOfWeek);
    }

    /**
     * 12 November 2001 is a Monday.
     */
    public void test12Nov2001GetDayOfWeek() {
        DayDate nov12Y2001 = new SpreadsheetDate(12,
                NOVEMBER, 2001);
        Day dayOfWeek = nov12Y2001.getDayOfWeek();
        assertEquals(MONDAY, dayOfWeek);
    }

    /**
     * Day 2 is the first of the month.
     */
    public void testS2GetDayOfMonth() {
        final int dayOfMonth = this.s2.getDayOfMonth();
        assertEquals(1, dayOfMonth);
    }

    /**
     * Day 2 is in January.
     */
    public void testS2GetMonth() {
        final Month month = this.s2.getMonth();
        assertEquals(JANUARY, month);
    }

    /**
     * Day 2 is in 1900.
     */
    public void testS2GetYYYY() {
        final int year = this.s2.getYear();
        assertEquals(1900, year);
    }

    /**
     * Day 37986 is 31 Dec 2003.
     */
    public void test37986() {
        final SpreadsheetDate d = new SpreadsheetDate(37986);
        assertEquals(31, d.getDayOfMonth());
        assertEquals(DECEMBER, d.getMonth());
        assertEquals(2003, d.getYear());
    }

    /**
     * Day 37987 is 1 Jan 2004.
     */
    public void test37987() {
        final SpreadsheetDate d = new SpreadsheetDate(37987);
        assertEquals(1, d.getDayOfMonth());
        assertEquals(JANUARY, d.getMonth());
        assertEquals(2004, d.getYear());
    }

    /**
     * Day 38352 is 31 Dec 2004.
     */
    public void test38352() {
        final SpreadsheetDate d = new SpreadsheetDate(38352);
        assertEquals(31, d.getDayOfMonth());
        assertEquals(DECEMBER, d.getMonth());
        assertEquals(2004, d.getYear());
    }

    /**
     * Day 38353 is 1 Jan 2005.
     */
    public void test38353() {
        final SpreadsheetDate d = new SpreadsheetDate(38353);
        assertEquals(1, d.getDayOfMonth());
        assertEquals(JANUARY, d.getMonth());
        assertEquals(2005, d.getYear());
    }

    /**
     * Create a date for serial number 36584: it should be 28-Feb-2000.
     */
    public void test36584() {
        final SpreadsheetDate d = new SpreadsheetDate(36584);
        assertEquals(28, d.getDayOfMonth());
        assertEquals(FEBRUARY, d.getMonth());
        assertEquals(2000, d.getYear());
    }

    /**
     * Create a date for serial number 36585: it should be 29-Feb-2000.
     */
    public void test36585() {
        final SpreadsheetDate d = new SpreadsheetDate(36585);
        assertEquals(29, d.getDayOfMonth());
        assertEquals(FEBRUARY, d.getMonth());
        assertEquals(2000, d.getYear());
    }

    /**
     * Create a date for serial number 36586: it should be 1-Mar-2000.
     */
    public void test36586() {
        final SpreadsheetDate d = new SpreadsheetDate(36586);
        assertEquals(1, d.getDayOfMonth());
        assertEquals(MARCH, d.getMonth());
        assertEquals(2000, d.getYear());
    }

    /**
     * Create a date for 01-Jan-1900: the serial number should be 2.
     */
    public void test01Jan1900ToSerial() {
        final int serial = this.jan1Y1900.getOrdinalDay();
        assertEquals(2, serial);
    }

    /**
     * Create a date for 28-Feb-1900: the serial number should be 60.
     */
    public void test28Feb1900ToSerial() {
        SpreadsheetDate d = new SpreadsheetDate(28, FEBRUARY,
                1900);
        assertEquals(60, d.getOrdinalDay());
    }

    /**
     * Create a date for 01-Mar-1900: the serial number should be 61.
     */
    public void test01Mar1900ToSerial() {
        SpreadsheetDate d = new SpreadsheetDate(1, MARCH, 1900);
        assertEquals(61, d.getOrdinalDay());
    }

    /**
     * Create a date for 31-Dec-1999: the serial number should be 36525.
     */
    public void test31Dec1999ToSerial() {
        SpreadsheetDate d = new SpreadsheetDate(31, DECEMBER,
                1999);
        assertEquals(36525, d.getOrdinalDay());
    }

    /**
     * Create a date for 1-Jan-2000: the serial number should be 36526.
     */
    public void test01Jan2000ToSerial() {
        SpreadsheetDate d = new SpreadsheetDate(1, JANUARY,
                2000);
        assertEquals(36526, d.getOrdinalDay());
    }

    /**
     * Create a date for 31-Jan-2000: the serial number should be 36556.
     */
    public void test31Jan2000ToSerial() {
        SpreadsheetDate d = new SpreadsheetDate(31, JANUARY,
                2000);
        assertEquals(36556, d.getOrdinalDay());
    }

    /**
     * Create a date for 01-Feb-2000: the serial number should be 36557.
     */
    public void test01Feb2000ToSerial() {
        SpreadsheetDate d = new SpreadsheetDate(1, FEBRUARY,
                2000);
        assertEquals(36557, d.getOrdinalDay());
    }

    /**
     * Create a date for 28-Feb-2000: the serial number should be 36584.
     */
    public void test28Feb2000ToSerial() {
        SpreadsheetDate d = new SpreadsheetDate(28, FEBRUARY,
                2000);
        assertEquals(36584, d.getOrdinalDay());
    }

    /**
     * Create a date for 29-Feb-2000: the serial number should be 36585.
     */
    public void test29feb2000ToSerial() {
        SpreadsheetDate d = new SpreadsheetDate(29, FEBRUARY,
                2000);
        assertEquals(36585, d.getOrdinalDay());
    }

    /**
     * Create a date for 1-Mar-2000: the serial number should be 36586.
     */
    public void test1mar2000ToSerial() {
        SpreadsheetDate d = new SpreadsheetDate(1, MARCH, 2000);
        assertEquals(36586, d.getOrdinalDay());
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {

        final SpreadsheetDate d1 = new SpreadsheetDate(15, APRIL, 2000);
        SpreadsheetDate d2 = null;

        try {
            final ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            final ObjectOutput out = new ObjectOutputStream(buffer);
            out.writeObject(d1);
            out.close();

            ObjectInput in = new ObjectInputStream(new ByteArrayInputStream(
                    buffer.toByteArray()));
            d2 = (SpreadsheetDate) in.readObject();
            in.close();
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
        assertEquals(d1, d2);

    }

}
