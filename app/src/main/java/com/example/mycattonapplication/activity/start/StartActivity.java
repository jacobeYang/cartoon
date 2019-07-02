package com.example.mycattonapplication.activity.start;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.mycattonapplication.R;
import com.example.mycattonapplication.activity.home.MainActivity;
import com.example.mycattonapplication.activity.login.LoginActivity;

import static android.preference.PreferenceManager.getDefaultSharedPreferences;


public class StartActivity extends AppCompatActivity {
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
                }else{
                    Intent intent = new Intent(StartActivity.this, LoginActivity.class);
                    startActivity(intent);
                }

            }
        });

        thread.start();
    }

}
