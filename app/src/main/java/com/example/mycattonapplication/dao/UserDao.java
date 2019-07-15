package com.example.mycattonapplication.dao;

import android.os.Handler;
import android.os.Message;
import android.view.View;

import com.example.mycattonapplication.activity.mine.UserInfoActivity;
import com.example.mycattonapplication.model.User;
import com.example.mycattonapplication.utils.HttpUtil;
import com.example.mycattonapplication.utils.ShowMyToast;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.RequestBody;
import okhttp3.Response;


public class UserDao {

    public static void getUserByTelAndPwd(String tel, String pwd, final Handler handler){



        RequestBody requestBody = new FormBody.Builder()
                .add("tel",tel)
                .add("pwd",pwd)
                .build();

        HttpUtil.sendHttpRequestPost("/user/getUserByTelAndPwd", requestBody, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson = new Gson();
                User user = gson.fromJson(response.body().string(),new TypeToken<User>(){}.getType());
                //User user1 = gson.fromJson(response.body().string(),User.class);
                Message message = new Message();
                message.what = 1;
                message.obj = user;
                handler.sendMessage(message);
            }
        });

    }

    public static void getUserById(String userId, final Handler handler){
        RequestBody requestBody = new FormBody.Builder()
                .add("userId",userId)
                .build();

        HttpUtil.sendHttpRequestPost("/user/getUserById", requestBody, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson = new Gson();
                User user = gson.fromJson(response.body().string(),User.class);
                Message message = new Message();
                message.what = 1;
                message.obj = user;
                handler.sendMessage(message);
            }
        });

    }

    public static void getSystemCheckNum(String tel, final Handler handler){
        RequestBody requestBody = new FormBody.Builder()
                .add("tel",tel)
                .build();

        HttpUtil.sendHttpRequestPost("/user/getSystemCheckNum", requestBody, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson = new Gson();
                String checkNum = gson.fromJson(response.body().string(),String.class);
                Message message = new Message();
                message.what = 1;
                message.obj = checkNum;
                handler.sendMessage(message);
            }
        });
    }

    public static void registerUser(String tel,String pwd ,final Handler handler){
        RequestBody requestBody = new FormBody.Builder()
                .add("tel",tel)
                .add("pwd",pwd)
                .build();

        HttpUtil.sendHttpRequestPost("/user/registerUser", requestBody, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson = new Gson();
                boolean flag = gson.fromJson(response.body().string(),new TypeToken<Boolean>(){}.getType());
                Message message = new Message();
                message.what = 2;
                message.obj = flag;
                handler.sendMessage(message);
            }
        });
    }


    public static void updateUser(User user, final Handler handler) {
        RequestBody requestBody = new FormBody.Builder()
                .add("userName",user.getUserName())
                .add("userAge", String.valueOf(user.getUserAge()))
                .add("autograph",user.getAutograph())
                .add("sex",user.getSex())
                .add("userId",user.getId())
                .build();

        HttpUtil.sendHttpRequestPost("/user/updateUser", requestBody, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson = new Gson();
                boolean flag = gson.fromJson(response.body().string(),new TypeToken<Boolean>(){}.getType());
                if(flag){
                    Message message = new Message();
                    message.what = 2;
                    handler.sendMessage(message);
                }

            }
        });
    }
}

