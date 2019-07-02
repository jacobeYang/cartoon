package com.example.mycattonapplication.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MyActivity extends AppCompatActivity {
    private static List<MyActivity> activityList = new ArrayList<MyActivity>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityList.add(this);
    }

    public static void finishAll(){
        for(MyActivity activity:activityList){
            if(!activity.isFinishing()){
                activity.finish();
            }
        }
    }
}
