package com.nju.noter.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {

    private Time(){
        throw new IllegalStateException("Utility class");
    }

    public static String getCurrentTime(){
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        return dateFormat.format(now);
    }
}
