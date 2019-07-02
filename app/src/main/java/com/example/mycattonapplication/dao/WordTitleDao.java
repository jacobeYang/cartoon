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

public class WordTitleDao {
    public static void getWordTitle(String cartoonId,final Handler handler){
        RequestBody requestBody = new FormBody.Builder()
                .add(   "cartoonId",cartoonId)
                .build();

        HttpUtil.sendHttpRequestPost("/getWordTitle",requestBody, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson = new Gson();
                String result = response.body().string();
                List<WordTitle> wordTitles = gson.fromJson(result,new TypeToken<List<WordTitle>>(){}.getType());
                Message message = new Message();
                message.what = 2;
                message.obj = wordTitles;
                handler.sendMessage(message);
            }
        });
    }

}
