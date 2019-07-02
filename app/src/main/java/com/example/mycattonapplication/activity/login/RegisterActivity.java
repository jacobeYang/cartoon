package com.example.mycattonapplication.activity.login;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mycattonapplication.R;
import com.example.mycattonapplication.dao.UserDao;
import com.example.mycattonapplication.utils.JudgeNull;
import com.example.mycattonapplication.utils.ShowMyToast;


public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText edit_tel;
    private EditText edit_pwd;
    private EditText check_num;
    private Button send_check_num;
    private Button btn_register;
    private String system_check_num;

    public final Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (msg.what){
                case 1:
                    system_check_num = (String)msg.obj;
                    break;
                case 2:
                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init_view();
    }

    public void init_view(){
        edit_tel = (EditText)findViewById(R.id.register_edit_tel);
        edit_pwd = (EditText)findViewById(R.id.register_edit_pwd);
        check_num = (EditText)findViewById(R.id.register_check_num);
        send_check_num = (Button)findViewById(R.id.register_send_num);
        btn_register = (Button)findViewById(R.id.btn_register);
        send_check_num.setOnClickListener(this);
        btn_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.register_send_num:
                getCheckNum();
                break;
            case R.id.btn_register:
                click_register();
                break;
        }
    }

    public void getCheckNum(){
        String str_tel = edit_tel.getText().toString().trim();
        String str_pwd = edit_pwd.getText().toString().trim();
        if(!JudgeNull.judge(str_tel,str_pwd)){
            ShowMyToast.show(this,"手机号或密码为空");
            return;
        }




        //后台发送验证码
        UserDao.getSystemCheckNum(str_tel,handler);
    }

    public void click_register(){
        String str_tel = edit_tel.getText().toString().trim();
        String str_pwd = edit_pwd.getText().toString().trim();
        String str_check_num = check_num.getText().toString().trim();

        if(!JudgeNull.judge(str_tel,str_pwd)){//判断输入是否为空
            ShowMyToast.show(RegisterActivity.this,"手机号或密码为空");
            return;
        }

        if(!JudgeNull.judge(str_check_num)){
            ShowMyToast.show(RegisterActivity.this,"验证码为空");
            return;
        }else{//对比验证码是否正确
            if(system_check_num.equals(str_check_num)){//验证码正确，进入登陆页面
                UserDao.registerUser(str_tel,str_pwd,handler);
            }else{//验证码错误
                ShowMyToast.show(RegisterActivity.this,"验证码错误");
            }
        }
    }
}
