package com.plurasight.review;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class SimpleDateFormatTest {

    private static DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

    public static void main(String[] args) throws JsonProcessingException {
        df.setTimeZone(TimeZone.getTimeZone("GMT"));
        Date now = new Date();
        System.out.println(df.format(now));
    }

}
