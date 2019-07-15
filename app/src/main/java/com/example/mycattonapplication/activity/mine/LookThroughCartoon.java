package com.example.mycattonapplication.activity.mine;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.mycattonapplication.R;
import com.example.mycattonapplication.activity.collection.CollectionCartoonAdapter;
import com.example.mycattonapplication.dao.CartoonDao;
import com.example.mycattonapplication.model.Author;
import com.example.mycattonapplication.model.Cartoon;
import com.example.mycattonapplication.model.NotAnyMore;

import java.util.ArrayList;
import java.util.List;

import static android.preference.PreferenceManager.getDefaultSharedPreferences;


public class LookThroughCartoon  extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ImageView back;
    private List<Object> item_list;
    CollectionCartoonAdapter collectionCartoonAdapter;
    SharedPreferences sharedPreferences;

    final Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    item_list.addAll(( List<Object>)msg.obj);
                    collectionCartoonAdapter.notifyDataSetChanged();
                    break;
            }
        }
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.look_through_cartoon);

        recyclerView = findViewById(R.id.look_through_cartoon_recycler_view);
        back = findViewById(R.id.look_through_cartoon_back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        item_list = new ArrayList<Object>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        collectionCartoonAdapter = new CollectionCartoonAdapter(item_list);
        recyclerView.setAdapter(collectionCartoonAdapter);

        sharedPreferences = getDefaultSharedPreferences(this);
        CartoonDao.getLookThroughCartoon(sharedPreferences.getString("userId","0"),handler);
    }

}
