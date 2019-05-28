package com.example.mycattonapplication.model;

public class Cartoon {
    String id;
    String cartoon_name;
    int imageId;
    String author_name;
    String brief_introduction;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCartoon_name() {
        return cartoon_name;
    }

    public void setCartoon_name(String cartton_name) {
        this.cartoon_name = cartton_name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getBrief_introduction() {
        return brief_introduction;
    }

    public void setBrief_introduction(String brief_introduction) {
        this.brief_introduction = brief_introduction;
    }
}
