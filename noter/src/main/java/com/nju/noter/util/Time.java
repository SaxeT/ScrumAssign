package com.nju.noter.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {
//    private static Time TIME;
//
//    private Time(){}
//
//    public static Time getInstance(){
//        if(TIME==null)
//            TIME = new Time();
//        return TIME;
//    }

    public static String getCurrentTime(){
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        return dateFormat.format(now);
    }
}
