package com.example.mycattonapplication.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mycattonapplication.R;
import com.example.mycattonapplication.model.Word;

import java.util.ArrayList;
import java.util.List;

public class CartoonDetailActivity extends AppCompatActivity {
    private ImageView imageView;
    private TextView cartoon_name;
    private TextView breif_introduction;
    private RecyclerView cartoon_detail_recyclerView;
    private CartoonDetailAdapter cartoon_detail_adapter;
    private List<Word> word_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartoon_detail);

        view_init();
    }


    public void view_init(){
        imageView = (ImageView)findViewById(R.id.cartoon_detail_image);
        cartoon_name = (TextView)findViewById(R.id.cartoon_detail_cartoon_name);
        breif_introduction = (TextView)findViewById(R.id.cartoon_detail_brief_introduction);
        cartoon_detail_recyclerView = (RecyclerView)findViewById(R.id.cartoon_detail_recyclerView);

        Glide.with(this).load(R.mipmap.a1).into(imageView);
        cartoon_name.setText("漫画名");
        breif_introduction.setText("漫画简介");

        list_init();
        cartoon_detail_adapter = new CartoonDetailAdapter(word_list);
        cartoon_detail_recyclerView.setAdapter(cartoon_detail_adapter);

    }

    public void list_init(){
        word_list = new ArrayList<Word>();
        Word word = new Word();
        word.setWord_name("该话名");
        word.setWord_number("1");
        word_list.add(word);
        word_list.add(word);
        word_list.add(word);
        word_list.add(word);
        word_list.add(word);
    }
}
