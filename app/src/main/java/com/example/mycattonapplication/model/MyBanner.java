package com.example.mycattonapplication.model;

import com.example.mycattonapplication.R;

import java.util.ArrayList;
import java.util.List;

public class MyBanner {
    private List<Integer> imageList;

    public MyBanner(){
        //设置图片集合
        imageList = new ArrayList<>();
        imageList.add(R.mipmap.a1);
        imageList.add(R.mipmap.a2);
        imageList.add(R.mipmap.a3);
    }

    public List<Integer> getImageList() {
        return imageList;
    }




}
