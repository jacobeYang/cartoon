package com.example.mycattonapplication.utils;

import android.content.Context;
import android.widget.Toast;

public class ShowMyToast {
    public static void show(Context context, String text){
        Toast.makeText(context,text,Toast.LENGTH_SHORT).show();
    }
}
