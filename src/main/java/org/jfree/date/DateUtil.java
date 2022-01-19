package org.jfree.date;


import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class DateUtil {


    public static DateFormatSymbols
            dateFormatSymbols = new SimpleDateFormat("", Locale.US).getDateFormatSymbols();
}
