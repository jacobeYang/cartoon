package com.example.mycattonapplication.dao;

import android.os.Handler;
import android.os.Message;

import com.example.mycattonapplication.utils.HttpUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.RequestBody;
import okhttp3.Response;

public class UserOptionDao {
    public static void setCartoonLike(String userId,String cartoonId,boolean flag_like,final Handler handler){
        RequestBody requestBody = new FormBody.Builder()
                .add("cartoonId",cartoonId)
                .add("userId",userId)
                .add("flag_like", String.valueOf(flag_like))
                .build();

        HttpUtil.sendHttpRequestPost("/setCartoonLike",requestBody, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
//                boolean flag = Boolean.parseBoolean(response.body().string());
//                //gson.fromJson(result,new TypeToken<boolean[]>(){}.getType());
//                Message message = new Message();
//                message.what = 1;
//                message.obj = flag;
//                handler.sendMessage(message);
            }
        });
    }
    public static void setCartoonCollection(String userId,String cartoonId,boolean flag_collection,final Handler handler){
        RequestBody requestBody = new FormBody.Builder()
                .add(   "cartoonId",cartoonId)
                .add(   "userId",userId)
                .add(   "flag_collect", String.valueOf(flag_collection))
                .build();

        HttpUtil.sendHttpRequestPost("/setCartoonCollection",requestBody, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
//                boolean flag = Boolean.getBoolean(response.body().string());
//                Message message = new Message();
//                message.what = 2;
//                message.obj = flag;
//                handler.sendMessage(message);
            }
        });
    }

}
