package com.example.mycattonapplication.model;

public class Word {
    private String id;
    private String cartoon_id;
    private String word_name;
    private String word_number;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCartoon_id() {
        return cartoon_id;
    }

    public void setCartoon_id(String cartoon_id) {
        this.cartoon_id = cartoon_id;
    }

    public String getWord_name() {
        return word_name;
    }

    public void setWord_name(String word_name) {
        this.word_name = word_name;
    }

    public String getWord_number() {
        return word_number;
    }

    public void setWord_number(String word_number) {
        this.word_number = word_number;
    }
}
