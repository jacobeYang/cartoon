package com.example.mycattonapplication.model;


import com.example.mycattonapplication.utils.HttpUtil;

public class Author {
    private String id;

    private String authorName;

    private String authorImageId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName == null ? null : authorName.trim();
    }

    public String getAuthorImageId() {
        return HttpUtil.basePath+authorImageId;
    }

    public void setAuthorImageId(String authorImageId) {
        this.authorImageId = authorImageId == null ? null : authorImageId.trim();
    }
}