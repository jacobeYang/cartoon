package com.example.mycattonapplication.activity.categoryDetail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mycattonapplication.R;
import com.example.mycattonapplication.activity.collection.CollectionCartoonAdapter;
import com.example.mycattonapplication.model.Cartoon;
import com.example.mycattonapplication.model.NotAnyMore;

import java.util.ArrayList;
import java.util.List;

public class CategoryDetailActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CartoonDetailAdapter cartoonAdapter;
    private List<Object> item_list;
    private ImageView back;
    private TextView title;

    private String intent_category_id;
    private String intent_category_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_detail);

        Intent intent = getIntent();
        intent_category_id = intent.getStringExtra("categoryId");
        intent_category_name = intent.getStringExtra("categoryName");

        //漫画列表
        list_init();
        view_init();

    }

    public void view_init(){
        back = (ImageView)findViewById(R.id.category_detail_result_back);
        title = (TextView)findViewById(R.id.category_detail_title);
        recyclerView = (RecyclerView)findViewById(R.id.category_recycler_view);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);
        cartoonAdapter = new CartoonDetailAdapter(item_list);
        recyclerView.setAdapter(cartoonAdapter);

        title.setText(intent_category_name);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void list_init(){
        item_list = new ArrayList<Object>();
        Cartoon cartoon1 = new Cartoon();
        cartoon1.setImageId(R.mipmap.a1);
        cartoon1.setCartoon_name("漫画名");
        cartoon1.setAuthor_name("作者名");
        cartoon1.setBrief_introduction("就发到卡夫卡打个卡就看见爱空间国家开发");
        cartoon1.setId("123231");

        Cartoon cartoon2 = new Cartoon();
        cartoon2.setImageId(R.mipmap.a2);
        cartoon2.setCartoon_name("漫画名");
        cartoon2.setAuthor_name("作者名");
        cartoon2.setBrief_introduction("就发到卡夫卡打个卡就看见爱空间国家开发");
        cartoon2.setId("123231");

        Cartoon cartoon3 = new Cartoon();
        cartoon3.setImageId(R.mipmap.a3);
        cartoon3.setCartoon_name("漫画名");
        cartoon3.setAuthor_name("作者名");
        cartoon3.setBrief_introduction("就发到卡夫卡打个卡就看见爱空间国家开发");
        cartoon3.setId("123231");


        item_list.add(cartoon1);
        item_list.add(cartoon2);
        item_list.add(cartoon3);
        item_list.add(cartoon1);
        item_list.add(cartoon2);
        item_list.add(cartoon3);
        item_list.add(cartoon1);
        item_list.add(cartoon2);
        item_list.add(cartoon3);
        item_list.add(cartoon1);
        item_list.add(cartoon2);
        item_list.add(cartoon3);
        item_list.add(cartoon1);
        item_list.add(cartoon2);
        item_list.add(cartoon3);
        item_list.add(cartoon1);
        item_list.add(cartoon2);
        item_list.add(cartoon3);

        item_list.add(new NotAnyMore());
    }
}
