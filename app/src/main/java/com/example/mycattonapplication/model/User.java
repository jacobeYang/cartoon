package com.example.mycattonapplication.model;

import com.example.mycattonapplication.utils.HttpUtil;

import java.util.Date;

public class User {
    private String id;

    private String userName;

    private String userTel;

    private String userPwd;

    private String sex;

    private Date time;

    private String autograph;

    private Integer userAge;

    private String userImageId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getAutograph() {
        return autograph;
    }

    public void setAutograph(String autograph) {
        this.autograph = autograph;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public String getUserImageId() {
        return HttpUtil.basePath+userImageId;
    }

    public void setUserImageId(String userImageId) {
        this.userImageId = userImageId;
    }
}
