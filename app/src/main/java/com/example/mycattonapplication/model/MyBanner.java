package com.example.mycattonapplication.model;

import com.example.mycattonapplication.R;

import java.util.ArrayList;
import java.util.List;

public class MyBanner {
    private List<Cartoon> cartoonList;

    public MyBanner(List<Cartoon> cartoonList){
        this.cartoonList = cartoonList;
    }

    public List<Cartoon> getCartoonList() {
        return cartoonList;
    }

    public void setCartoonList(List<Cartoon> cartoonList) {
        this.cartoonList = cartoonList;
    }
}
