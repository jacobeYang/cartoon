package com.example.mycattonapplication.activity.wordShow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.example.mycattonapplication.R;

import java.util.ArrayList;
import java.util.List;

public class WordShowActivity extends AppCompatActivity {
    private RecyclerView  recyclerView;
    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_show);

    }

    public void view_init(){
        list_init();
        recyclerView = (RecyclerView)findViewById(R.id.word_show_recyclerView);
        recyclerView.setAdapter(new WordshowAdapter(list));
    }

    public void list_init(){
        list = new ArrayList<String>();
        list.add(String.valueOf(R.mipmap.a1));
        list.add(String.valueOf(R.mipmap.a1));
        list.add(String.valueOf(R.mipmap.a1));
        list.add(String.valueOf(R.mipmap.a1));
        list.add(String.valueOf(R.mipmap.a1));
        list.add(String.valueOf(R.mipmap.a1));
    }
}
