package com.example.mycattonapplication.utils;

public class JudgeNull {
    public static boolean judge(String... text){
        for(String str:text){
            if("".equals(str)||str==null){
                return false;
            }
        }
        return true;
    }
}
