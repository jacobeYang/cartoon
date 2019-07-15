package com.example.mycattonapplication.activity.categoryDetail;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mycattonapplication.R;
import com.example.mycattonapplication.activity.MyActivity;
import com.example.mycattonapplication.activity.home.HomeAdapter;
import com.example.mycattonapplication.dao.CartoonDao;
import com.example.mycattonapplication.model.Cartoon;
import com.example.mycattonapplication.model.Category;
import com.example.mycattonapplication.model.HeadLine;
import com.example.mycattonapplication.model.MyBanner;
import com.example.mycattonapplication.model.NotAnyMore;

import java.util.ArrayList;
import java.util.List;

import static android.preference.PreferenceManager.getDefaultSharedPreferences;

public class CategoryDetailActivity extends MyActivity {
    private RecyclerView recyclerView;
    private CategoryDetailAdapter cartoonAdapter;
    private List<Object> item_list;
    private ImageView back;
    private TextView title;

    private String intent_category_id;
    private String intent_category_name;

    SharedPreferences sharedPreferences;

    final Handler handler = new Handler(){
        int caseNum = 0;
        @Override
        public void handleMessage(Message msg){
            super.handleMessage(msg);
            switch(msg.what){
                case 1:
                    List<Cartoon> cartoons = (List<Cartoon>)msg.obj;
                    item_list.addAll(cartoons);
                    item_list.add(new NotAnyMore());
                    cartoonAdapter.notifyDataSetChanged();
                    break;
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_detail);

        sharedPreferences = getDefaultSharedPreferences(this);

        Intent intent = getIntent();
        intent_category_id = intent.getStringExtra("categoryId");
        intent_category_name = intent.getStringExtra("categoryName");

        //漫画列表
        item_list = new ArrayList<Object>();
        view_init();

    }

    public void view_init(){
        back = findViewById(R.id.category_detail_result_back);
        title = findViewById(R.id.category_detail_title);
        recyclerView = findViewById(R.id.category_recycler_view);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);
        cartoonAdapter = new CategoryDetailAdapter(item_list);
        recyclerView.setAdapter(cartoonAdapter);

        title.setText(intent_category_name);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //请求数据
        CartoonDao.getCartoonByCategory(sharedPreferences.getString("userId","0"),intent_category_id,handler);
    }

}
