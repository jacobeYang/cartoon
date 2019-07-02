package com.example.mycattonapplication.dao;

import android.os.Handler;
import android.os.Message;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mycattonapplication.model.Remark;
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

public class RemarkDao {
    public static void getCartoonRemark(String cartoonId,final Handler handler){
        RequestBody requestBody = new FormBody.Builder()
                .add(   "cartoonId",cartoonId)
                .build();

        HttpUtil.sendHttpRequestPost("/getCartoonRemark",requestBody, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson = new Gson();
                String result = response.body().string();
                List<Remark> remarkList = gson.fromJson(result,new TypeToken<List<Remark>>(){}.getType());
                Message message = new Message();
                message.what = 1;
                message.obj = remarkList;
                handler.sendMessage(message);
            }
        });
    }

    public static void setRemark(String userId, String cartoonId, String content, final Handler handler, final TextView input) {
        RequestBody requestBody = new FormBody.Builder()
                .add(   "cartoonId",cartoonId)
                .add(   "userId",userId)
                .add(   "content",content)
                .build();

        HttpUtil.sendHttpRequestPost("/setRemark",requestBody, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson = new Gson();
                String result = response.body().string();
                List<Remark> remarkList = gson.fromJson(result,new TypeToken<List<Remark>>(){}.getType());
                Message message = new Message();
                message.what = 1;
                message.obj = remarkList;
                handler.sendMessage(message);
                input.setText("");
            }
        });
    }
}
