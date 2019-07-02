package com.example.mycattonapplication.activity.search;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mycattonapplication.R;
import com.example.mycattonapplication.dao.CartoonDao;
import com.example.mycattonapplication.model.Author;
import com.example.mycattonapplication.model.Cartoon;
import com.example.mycattonapplication.model.NotAnyMore;

import java.util.ArrayList;
import java.util.List;

public class SearchResultActivity extends AppCompatActivity {
    private TextView title;
    private RecyclerView search_result_recyclerView;
    private ImageView search_result_back;
    private List<Cartoon> cartoonList;
    private CartoonAdapterOne cartoonAdapterOne;

    final Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch(msg.what){
                case 1:
                    List<Cartoon> resultList = (List<Cartoon>)msg.obj;
                    cartoonList.addAll(resultList);
                    cartoonAdapterOne.notifyDataSetChanged();
                    break;
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

        Intent get_intent = getIntent();
        String intent_title = get_intent.getStringExtra("name");

        title = (TextView)findViewById(R.id.search_result_title);
        title.setText(intent_title);

        search_result_recyclerView = (RecyclerView) findViewById(R.id.search_result_recyclerView);
        cartoonList = new ArrayList<Cartoon>();
        search_result_recyclerView.setLayoutManager(new LinearLayoutManager(this));
        cartoonAdapterOne = new CartoonAdapterOne(cartoonList);
        search_result_recyclerView.setAdapter(cartoonAdapterOne);

        search_result_back = (ImageView)findViewById(R.id.search_result_back);
        search_result_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        CartoonDao.getSearchResult(intent_title,handler);

    }

}
