package com.example.mycattonapplication.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.mycattonapplication.R;
import com.example.mycattonapplication.model.Cartoon;
import com.example.mycattonapplication.model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryDetailActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CollectionCartoonAdapter cartoonAdapter;
    private List<Cartoon> item_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_detail);

        //漫画列表
        list_init();
        recyclerView = (RecyclerView)findViewById(R.id.category_recycler_view);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,6);
        recyclerView.setLayoutManager(gridLayoutManager);
        cartoonAdapter = new CollectionCartoonAdapter(item_list);
        recyclerView.setAdapter(cartoonAdapter);
    }

    public void list_init(){

        item_list = new ArrayList<Cartoon>();
        Cartoon cartoon1 = new Cartoon();
        cartoon1.setImageId(R.mipmap.a1);
        cartoon1.setCartoon_name("漫画名");
        cartoon1.setAuthor_name("作者名");
        Cartoon cartoon2 = new Cartoon();
        cartoon2.setImageId(R.mipmap.a2);
        cartoon2.setCartoon_name("漫画名");
        cartoon2.setAuthor_name("作者名");
        Cartoon cartoon3 = new Cartoon();
        cartoon3.setImageId(R.mipmap.a3);
        cartoon3.setCartoon_name("漫画名");
        cartoon3.setAuthor_name("作者名");

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
    }
}
