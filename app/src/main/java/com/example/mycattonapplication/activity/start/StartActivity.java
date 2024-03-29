package com.example.mycattonapplication.activity.start;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.example.mycattonapplication.R;
import com.example.mycattonapplication.activity.MyActivity;
import com.example.mycattonapplication.activity.home.MainActivity;
import com.example.mycattonapplication.activity.login.LoginActivity;

import static android.preference.PreferenceManager.getDefaultSharedPreferences;


public class StartActivity extends MyActivity {
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        preferences = getDefaultSharedPreferences(this);
        final boolean flag_login = preferences.getBoolean("login_statue",false);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(flag_login){
                    Intent intent = new Intent(StartActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Intent intent = new Intent(StartActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }

            }
        });

        thread.start();
    }

}
