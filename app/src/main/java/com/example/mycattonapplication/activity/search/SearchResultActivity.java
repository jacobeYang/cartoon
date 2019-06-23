package com.example.mycattonapplication.activity.search;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mycattonapplication.R;
import com.example.mycattonapplication.model.Cartoon;

import java.util.ArrayList;
import java.util.List;

public class SearchResultActivity extends AppCompatActivity {
    private TextView title;
    private RecyclerView search_result_recyclerView;
    private ImageView search_result_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

        title = (TextView)findViewById(R.id.search_result_title);
        search_result_recyclerView = (RecyclerView) findViewById(R.id.search_result_recyclerView);

        List<Cartoon> cartoonList = new ArrayList<Cartoon>();
        Cartoon cartoon = new Cartoon();
        cartoon.setAuthor_name("浪白白");
        cartoon.setCartoon_name("凤执天下");
        cartoon.setImageId(R.mipmap.a1);
        cartoon.setBrief_introduction("had双方就发的啥咖啡加咖啡和吉安市大黄蜂科技哈第三方开花结实");
        cartoon.setId("1213");
        cartoonList.add(cartoon);
        cartoonList.add(cartoon);
        cartoonList.add(cartoon);
        cartoonList.add(cartoon);

        search_result_recyclerView.setLayoutManager(new LinearLayoutManager(this));
        CartoonAdapterOne cartoonAdapterOne = new CartoonAdapterOne(cartoonList);
        search_result_recyclerView.setAdapter(cartoonAdapterOne);


        search_result_back = (ImageView)findViewById(R.id.search_result_back);
        search_result_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
