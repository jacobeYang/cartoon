package com.example.mycattonapplication.dao;

import android.os.Handler;
import android.os.Message;

import com.example.mycattonapplication.model.Cartoon;
import com.example.mycattonapplication.model.Category;
import com.example.mycattonapplication.utils.HttpUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class CategoryDao {
    public static void getCategory(final Handler handler){
        HttpUtil.sendHttpRequestAsy("/home/getCategory", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson = new Gson();
                List<Category> categoryList = gson.fromJson(response.body().string(),new TypeToken<List<Category>>(){}.getType());
                Message message = new Message();
                message.what = 2;
                message.obj = categoryList;
                handler.sendMessage(message);
            }
        });
    }
}
