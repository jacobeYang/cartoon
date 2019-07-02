package com.example.mycattonapplication.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateExchangeString {
    static SimpleDateFormat simpleDateFormat;
    public static String DateToString(Date source) {
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(source);
    }

}
