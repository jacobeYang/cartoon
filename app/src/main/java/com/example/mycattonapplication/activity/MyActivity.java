package com.example.mycattonapplication.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.mycattonapplication.activity.home.MainActivity;
import com.example.mycattonapplication.activity.wordShow.WordShowActivity;
import com.example.mycattonapplication.utils.ShowMyToast;
import com.example.mycattonapplication.utils.TimeKepper;

import java.util.ArrayList;
import java.util.List;

public class MyActivity extends AppCompatActivity {
    private static List<MyActivity> activityList = new ArrayList<MyActivity>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityList.add(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(this instanceof WordShowActivity){
            TimeKepper.setStart_time(System.currentTimeMillis());
            if(TimeKepper.getTime_size()>TimeKepper.MAX_TIME){
                ShowMyToast.show(this,"浏览时间太长，休息一会吧");
            }
        }

    }

    @Override
    protected void onStop() {
        super.onStop();
        if(this instanceof WordShowActivity) {
            TimeKepper.setTime_size(System.currentTimeMillis()-TimeKepper.getStart_time());

        }


    }

    public static void finishAll(){
        for(MyActivity activity:activityList){
            if(!activity.isFinishing()){
                activity.finish();
            }
        }
    }
}
