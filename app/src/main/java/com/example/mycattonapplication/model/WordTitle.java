package com.example.mycattonapplication.model;

public class WordTitle {
    private String id;

    private String cartoonId;

    private String wordTitle;

    private Integer wordNumber;

    private Integer imageNumber;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCartoonId() {
        return cartoonId;
    }

    public void setCartoonId(String cartoonId) {
        this.cartoonId = cartoonId == null ? null : cartoonId.trim();
    }

    public String getWordTitle() {
        return wordTitle;
    }

    public void setWordTitle(String wordTitle) {
        this.wordTitle = wordTitle == null ? null : wordTitle.trim();
    }

    public Integer getWordNumber() {
        return wordNumber;
    }

    public void setWordNumber(Integer wordNumber) {
        this.wordNumber = wordNumber;
    }

    public Integer getImageNumber() {
        return imageNumber;
    }

    public void setImageNumber(Integer imageNumber) {
        this.imageNumber = imageNumber;
    }
}