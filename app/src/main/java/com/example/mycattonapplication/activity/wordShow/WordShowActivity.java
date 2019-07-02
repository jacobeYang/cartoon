package com.example.mycattonapplication.activity.wordShow;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mycattonapplication.R;
import com.example.mycattonapplication.activity.MyActivity;
import com.example.mycattonapplication.dao.WordShowDao;
import com.example.mycattonapplication.model.WordTitle;
import com.example.mycattonapplication.utils.AutoPollRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class WordShowActivity extends MyActivity {
    private AutoPollRecyclerView recyclerView;
    private TextView textView;
    private ImageView imageView;
    private List<String> list;
    private int maxNum;
    private WordTitle wordTitle;
    private int flag = 0;
    WordshowAdapter wordshowAdapter;

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    wordTitle = (WordTitle) msg.obj;
                    textView.setText(wordTitle.getWordTitle());
                    break;
                case 2:
                    list.clear();
                    if(flag == 0||flag == 1){
                        list.addAll((List<String>)msg.obj);
                    }else{
                        list.addAll(0,(List<String>)msg.obj);
                    }

                    wordshowAdapter.notifyDataSetChanged();

                    break;
                case 3:
                    maxNum = msg.arg1;
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_show);

        String intent_word_id = getIntent().getStringExtra("wordId");
        view_init();
        WordShowDao.getMaxNum(intent_word_id,handler);
        WordShowDao.getWordImage(intent_word_id,flag,handler);
    }

    public void view_init(){
        textView = (TextView)findViewById(R.id.word_show_title);
        textView.setText("");

        imageView = (ImageView)findViewById(R.id.word_show_back);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        list = new ArrayList<String>();
        recyclerView = (AutoPollRecyclerView)findViewById(R.id.word_show_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        wordshowAdapter = new WordshowAdapter(list);
        recyclerView.setAdapter(wordshowAdapter);
        recyclerView.start();

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            private int flag_upOr_down = 0;//-1代表下拉，1代表上拉

            @Override
            public void onScrollStateChanged(RecyclerView rv, int newState) {
                super.onScrollStateChanged(rv, newState);
                if((!rv.canScrollVertically(1))&&flag_upOr_down == 1){//传入1 判断是否到底，没到底返回true，到底返回false   传入-1代表判断是否到顶
                    //如果到底,重新填充数据，自动播放
                    //选择下一话
                    if(wordTitle.getWordNumber() <=maxNum){
                        flag = 1;
                        WordShowDao.getWordImage(wordTitle.getId(),flag,handler);
                    }


//                    recyclerView.setAdapter(new WordshowAdapter(list));
//                    recyclerView.start();
                }
                if((!rv.canScrollVertically(-1))&&flag_upOr_down == -1){
                    Toast.makeText(WordShowActivity.this,"到顶了",Toast.LENGTH_SHORT).show();
                    if(wordTitle.getWordNumber()!=1){
                        flag = -1;
                        WordShowDao.getWordImage(wordTitle.getId(),flag,handler);
                    }

//                    recyclerView.setAdapter(new WordshowAdapter(list));
//                    recyclerView.start();
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


}
