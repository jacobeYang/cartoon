package com.example.mycattonapplication.activity.mine;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.mycattonapplication.R;
import com.example.mycattonapplication.activity.collection.CollectionCartoonAdapter;
import com.example.mycattonapplication.model.Cartoon;
import com.example.mycattonapplication.model.NotAnyMore;

import java.util.ArrayList;
import java.util.List;

public class RemarkCartoonActivity  extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ImageView back;
    private List<Object> item_list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.remark_cartoon);

        recyclerView = (RecyclerView) findViewById(R.id.remark_cartoon_recycler_view);
        back = (ImageView) findViewById(R.id.remark_cartoon_back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        list_init();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new CollectionCartoonAdapter(item_list));
    }

    public void list_init() {
        item_list = new ArrayList<Object>();
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

        item_list.add(new NotAnyMore());
    }
}
