package com.example.mycattonapplication.model;

import android.widget.ImageView;
import android.widget.TextView;

public class Remark {

    private int remark_user_image;
    private String remark_user_name;
    private String remark_time;
    private String remark_content;
    private String id;

    public int getRemark_user_image() {
        return remark_user_image;
    }

    public void setRemark_user_image(int remark_user_image) {
        this.remark_user_image = remark_user_image;
    }

    public String getRemark_user_name() {
        return remark_user_name;
    }

    public void setRemark_user_name(String remark_user_name) {
        this.remark_user_name = remark_user_name;
    }

    public String getRemark_time() {
        return remark_time;
    }

    public void setRemark_time(String remark_time) {
        this.remark_time = remark_time;
    }

    public String getRemark_content() {
        return remark_content;
    }

    public void setRemark_content(String remark_content) {
        this.remark_content = remark_content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
