package com.example.mycattonapplication.activity.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mycattonapplication.R;
import com.example.mycattonapplication.activity.MyActivity;
import com.example.mycattonapplication.activity.home.MainActivity;
import com.example.mycattonapplication.dao.UserDao;
import com.example.mycattonapplication.model.User;
import com.example.mycattonapplication.utils.JudgeNull;
import com.example.mycattonapplication.utils.ShowMyToast;

import static android.preference.PreferenceManager.getDefaultSharedPreferences;


public class LoginActivity extends MyActivity implements View.OnClickListener{
    private EditText edit_tel = null;
    private EditText edit_pwd = null;
    private Button btn_login = null;
    private TextView login_to_register = null;
    private static final String TAG = "LoginActivity";

    private SharedPreferences preferences ;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ActionBar actionBar =  getSupportActionBar();

        if(actionBar != null){
            actionBar.hide();
        }

        preferences = getDefaultSharedPreferences(this);
        editor = preferences.edit();

        edit_tel = (EditText)findViewById(R.id.login_edit_tel);
        edit_pwd = (EditText)findViewById(R.id.login_edit_pwd);
        btn_login = (Button) findViewById(R.id.btn_login);
        login_to_register = (TextView) findViewById(R.id.login_to_register);

        btn_login.setOnClickListener(this);
        login_to_register.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_login: click_login();
                break;
            case R.id.login_to_register:
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                break;
        }
    }


    public void click_login(){
        String str_tel = edit_tel.getText().toString().trim();
        String str_pwd = edit_pwd.getText().toString().trim();

        if(!JudgeNull.judge(str_tel,str_pwd)){//判断输入是否为空
            ShowMyToast.show(LoginActivity.this,"手机号或密码为空");
            return;
        }

        final Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);

                switch (msg.what){
                    case 1:
                        User user = (User)msg.obj;
                        Log.i(TAG, "handleMessage: user = "+user.getAutograph());
                        if(user == null){//判断账号密码是否存在
                            ShowMyToast.show(LoginActivity.this,"手机号或密码错误，请重试");
                            edit_tel.setText("");
                            edit_pwd.setText("");
                        }else{
                            //登录
                            editor.putBoolean("login_statue",true);//这是用户登录状态
                            editor.putString("userId",user.getId());
                            if(editor.commit()) {
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                intent.putExtra("user_id", user.getId());
                                startActivity(intent);
                            }
                        }
                        break;
                }
            }
        };

        UserDao.getUserByTelAndPwd(str_tel,str_pwd,handler);//后台数据库查询

    }


}
