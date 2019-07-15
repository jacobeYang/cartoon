package com.example.mycattonapplication.utils;

public class TimeKepper {
    public static long time_size;
    public static long start_time;
    public static final long MAX_TIME = 10000;//一小时 3600000

    public static long getTime_size() {
        return time_size;
    }

    public static void setTime_size(long time_size) {
        TimeKepper.time_size += time_size;
    }

    public static long getStart_time() {
        return start_time;
    }

    public static void setStart_time(long start_time) {
        TimeKepper.start_time = start_time;
    }
}
