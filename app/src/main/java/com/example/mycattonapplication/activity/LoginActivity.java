package com.example.mycattonapplication.activity;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mycattonapplication.R;
import com.example.mycattonapplication.model.User;
import com.example.mycattonapplication.utils.JudgeNull;
import com.example.mycattonapplication.utils.ShowMyToast;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText edit_tel = null;
    private EditText edit_pwd = null;
    private Button btn_login = null;
    private TextView login_to_register = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ActionBar actionBar =  getSupportActionBar();
        if(actionBar != null){
            actionBar.hide();
        }


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
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
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


        User user =  null;//后台数据库查询
        if(user == null){//判断账号密码是否存在
            ShowMyToast.show(LoginActivity.this,"手机号或密码错误，请重试");
            edit_tel.setText("");
            edit_pwd.setText("");
        }else{
            //登录
            Intent intent = new Intent(this,MainActivity.class);
            intent.putExtra("user_id",user.getId());
            startActivity(intent);
        }
    }
}