package com.example.mycattonapplication.model;

import com.example.mycattonapplication.utils.HttpUtil;

public class Category {
    private String id;
    private String categoryName;
    private String iconId;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getIconId() {
        return HttpUtil.basePath+iconId;
    }

    public void setIconId(String iconId) {
        this.iconId = iconId;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
