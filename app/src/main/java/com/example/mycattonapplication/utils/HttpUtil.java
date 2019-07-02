package com.example.mycattonapplication.utils;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class HttpUtil {

    public static String basePath = "http://10.0.2.2:8080";

    //Asynchronous
    public static void sendHttpRequestAsy(String address, okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(basePath+address)
                .build();
        client.newCall(request).enqueue(callback);
    }

    public static void sendHttpRequestPost(String address, RequestBody requestBody,okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(basePath+address)
                .post(requestBody)
                .build();
        client.newCall(request).enqueue(callback);
    }




}
