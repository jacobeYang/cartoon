package com.example.mycattonapplication.activity.wordShow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mycattonapplication.R;
import com.example.mycattonapplication.utils.AutoPollRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class WordShowActivity extends AppCompatActivity {
    private AutoPollRecyclerView recyclerView;
    private TextView textView;
    private ImageView imageView;
    private List<Integer> list;
    private String show_word_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_show);

        show_word_name = getIntent().getStringExtra("wordName");
        view_init();

    }

    public void view_init(){
        textView = (TextView)findViewById(R.id.word_show_title);
        textView.setText(show_word_name);

        imageView = (ImageView)findViewById(R.id.word_show_back);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        list_init();
        recyclerView = (AutoPollRecyclerView)findViewById(R.id.word_show_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new WordshowAdapter(list));
        recyclerView.start();

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            private int flag_upOr_down = 0;//-1代表下拉，1代表上拉

            @Override
            public void onScrollStateChanged(RecyclerView rv, int newState) {
                super.onScrollStateChanged(rv, newState);
                if((!rv.canScrollVertically(1))&&flag_upOr_down == 1){//传入1 判断是否到底，没到底返回true，到底返回false   传入-1代表判断是否到顶
                    //如果到底,重新填充数据，自动播放
                    //选择下一话

                    recyclerView.setAdapter(new WordshowAdapter(list));
                    recyclerView.start();
                }
                if((!rv.canScrollVertically(-1))&&flag_upOr_down == -1){
                    Toast.makeText(WordShowActivity.this,"到顶了",Toast.LENGTH_SHORT).show();
                    recyclerView.setAdapter(new WordshowAdapter(list));
                    recyclerView.start();
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if(dy>0){
                    flag_upOr_down = 1;
                }else if(dy<0){
                    flag_upOr_down = -1;
                }else{
                    flag_upOr_down = 0;
                }
            }
        });
    }

    public void list_init(){
        list = new ArrayList<Integer>();
        list.add(R.mipmap.a1);
        list.add(R.mipmap.a1);
        list.add(R.mipmap.a1);
        list.add(R.mipmap.a1);
        list.add(R.mipmap.a1);
        list.add(R.mipmap.a1);
        list.add(R.mipmap.a1);
    }
}
