package com.example.mycattonapplication.dao;

import android.os.Handler;
import android.os.Message;

import com.example.mycattonapplication.model.WordTitle;
import com.example.mycattonapplication.utils.HttpUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.RequestBody;
import okhttp3.Response;

public class WordShowDao {
    public static void getWordImage(String wordId,int flag,final Handler handler){
        RequestBody requestBody = new FormBody.Builder()
                .add(   "flag", String.valueOf(flag))
                .add(   "wordId",wordId)
                .build();

        HttpUtil.sendHttpRequestPost("/getNextWordTitle",requestBody, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson = new Gson();
                String result = response.body().string();
                WordTitle wordTitle = gson.fromJson(result,WordTitle.class);
                Message message = new Message();
                message.what = 1;
                message.obj = wordTitle;
                handler.sendMessage(message);
            }
        });

        HttpUtil.sendHttpRequestPost("/getWordImage",requestBody, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson = new Gson();
                String result = response.body().string();
                List<String> wordTitles = gson.fromJson(result,new TypeToken<List<String>>(){}.getType());
                Message message = new Message();
                message.what = 2;
                message.obj = wordTitles;
                handler.sendMessage(message);
            }
        });
    }


    public static void getMaxNum(String wordId,final Handler handler){
        RequestBody requestBody = new FormBody.Builder()
                .add(   "wordId",wordId)
                .build();

        HttpUtil.sendHttpRequestPost("/getMaxNum",requestBody, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson = new Gson();
                String result = response.body().string();
                int maxNum = gson.fromJson(result,Integer.class);
                Message message = new Message();
                message.what = 3;
                message.arg1 = maxNum;
                handler.sendMessage(message);
            }
        });

    }

}
