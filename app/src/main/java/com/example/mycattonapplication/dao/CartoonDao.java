package com.example.mycattonapplication.dao;

import android.os.Handler;
import android.os.Message;

import com.example.mycattonapplication.model.Cartoon;
import com.example.mycattonapplication.model.CartoonRole;
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

public class CartoonDao {
    public static void getBanner(final Handler handler){
        HttpUtil.sendHttpRequestAsy("/home/getBanner", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson = new Gson();
                List<Cartoon> bannerList = gson.fromJson(response.body().string(),new TypeToken<List<Cartoon>>(){}.getType());
                Message message = new Message();
                message.what = 1;
                message.obj = bannerList;
                handler.sendMessage(message);
            }
        });
    }

    public static void getGuessYouLike(String userId,final Handler handler){
        RequestBody requestBody = new FormBody.Builder()
                .add("userId",userId)
                .build();

        HttpUtil.sendHttpRequestPost("/home/getGuessYouLike",requestBody, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson = new Gson();
                String result = response.body().string();
                List<Cartoon> bannerList = gson.fromJson(result,new TypeToken<List<Cartoon>>(){}.getType());
                Message message = new Message();
                message.what = 3;
                message.obj = bannerList;
                handler.sendMessage(message);
            }
        });
    }

    public static void getHotRecommend(final Handler handler){
        HttpUtil.sendHttpRequestAsy("/home/getHotRecommend", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson = new Gson();
                List<Cartoon> bannerList = gson.fromJson(response.body().string(),new TypeToken<List<Cartoon>>(){}.getType());
                Message message = new Message();
                message.what = 4;
                message.obj = bannerList;
                handler.sendMessage(message);
            }
        });
    }

    public static void getCartoonByCategory(String userId,String categoryId,final Handler handler){
        RequestBody requestBody = new FormBody.Builder()
                .add("categoryId",categoryId)
                .add("userId",userId)
                .build();

        HttpUtil.sendHttpRequestPost("/getCartoonByCategory",requestBody, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson = new Gson();
                List<Cartoon> bannerList = gson.fromJson(response.body().string(),new TypeToken<List<Cartoon>>(){}.getType());
                Message message = new Message();
                message.what = 1;
                message.obj = bannerList;
                handler.sendMessage(message);
            }
        });
    }

    public static void getCollection(String userId,final Handler handler){
        RequestBody requestBody = new FormBody.Builder()
                .add("userId",userId)
                .build();

        HttpUtil.sendHttpRequestPost("/getCollection",requestBody, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson = new Gson();
                String result = response.body().string();
                List<Cartoon> bannerList = gson.fromJson(result,new TypeToken<List<Cartoon>>(){}.getType());
                Message message = new Message();
                message.what = 1;
                message.obj = bannerList;
                handler.sendMessage(message);
            }
        });
    }

    public static void getSearchRecommend(final Handler handler){
        HttpUtil.sendHttpRequestAsy("/home/getSearchRecommend", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson = new Gson();
                List<String> list = gson.fromJson(response.body().string(),new TypeToken<List<String>>(){}.getType());
                Message message = new Message();
                message.what = 1;
                message.obj = list;
                handler.sendMessage(message);
            }
        });
    }

    public static void getSearchResult(String name,final Handler handler){
        RequestBody requestBody = new FormBody.Builder()
                .add("cartoonName",name)
                .build();

        HttpUtil.sendHttpRequestPost("/home/getSearchResult",requestBody, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson = new Gson();
                String result = response.body().string();
                List<Cartoon> bannerList = gson.fromJson(result,new TypeToken<List<Cartoon>>(){}.getType());
                Message message = new Message();
                message.what = 1;
                message.obj = bannerList;
                handler.sendMessage(message);
            }
        });
    }

    public static void getCartoonAndAuthor(String cartoonId,final Handler handler){
        RequestBody requestBody = new FormBody.Builder()
                .add("cartoonId",cartoonId)
                .build();

        HttpUtil.sendHttpRequestPost("/getCartoonAndAuthor",requestBody, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson = new Gson();
                String result = response.body().string();
                Cartoon cartoon = gson.fromJson(result,Cartoon.class);
                Message message = new Message();
                message.what = 1;
                message.obj = cartoon;
                handler.sendMessage(message);
            }
        });
    }

    public static void getCartoonRole(String cartoonId,final Handler handler){
        RequestBody requestBody = new FormBody.Builder()
                .add(   "cartoonId",cartoonId)
                .build();

        HttpUtil.sendHttpRequestPost("/getCartoonRole",requestBody, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson = new Gson();
                String result = response.body().string();
                List<CartoonRole> roleList = gson.fromJson(result,new TypeToken<List<CartoonRole>>(){}.getType());
                Message message = new Message();
                message.what = 2;
                message.obj = roleList;
                handler.sendMessage(message);
            }
        });
    }

    public static void getCartoonLikeAndCollect(String userId,String cartoonId,final Handler handler){
        RequestBody requestBody = new FormBody.Builder()
                .add(   "cartoonId",cartoonId)
                .add(   "userId",userId)
                .build();

        HttpUtil.sendHttpRequestPost("/getCartoonLikeAndCollect",requestBody, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson = new Gson();
                String result = response.body().string();
                boolean[] booleans = gson.fromJson(result,new TypeToken<boolean[]>(){}.getType());
                Message message = new Message();
                message.what = 3;
                message.obj = booleans;
                handler.sendMessage(message);
            }
        });
    }
}
