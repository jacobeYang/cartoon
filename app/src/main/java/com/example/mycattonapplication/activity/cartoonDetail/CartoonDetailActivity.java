package com.example.mycattonapplication.activity.cartoonDetail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.mycattonapplication.R;
import com.example.mycattonapplication.model.CartoonDetail;
import com.example.mycattonapplication.model.RemarkRecyclerView;
import com.example.mycattonapplication.model.Remark_input;
import com.example.mycattonapplication.model.WordTitleRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CartoonDetailActivity extends AppCompatActivity {
    private RecyclerView cartoon_detail_recyclerView;
    private ImageView back;
    private CartoonDetailAdapter cartoon_detail_adapter;
    private List<Object> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartoon_detail);

        view_init();
    }


    public void view_init(){
//        LayoutInflater factory = LayoutInflater.from(CartoonDetailActivity.this);
//        View layout = factory.inflate(R.layout.detail_item, null);
//        ImageView imageView = (ImageView) layout.findViewById(R.id.cartoon_detail_image);
        list_init();
        cartoon_detail_recyclerView = (RecyclerView)findViewById(R.id.cartoon_detail_recyclerView);
        cartoon_detail_recyclerView.setLayoutManager(new LinearLayoutManager(   this));
        cartoon_detail_adapter = new CartoonDetailAdapter(list);
        cartoon_detail_recyclerView.setAdapter(cartoon_detail_adapter);

        back = (ImageView)findViewById(R.id.cartoon_detail_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    public void list_init(){
        list = new ArrayList<Object>();
        CartoonDetail cartoonDetail = new CartoonDetail();
        cartoonDetail.setCartoon_image(R.mipmap.a1);
        cartoonDetail.setCartoon_name("心悦值超");
        cartoonDetail.setFlag_collection(true);
        cartoonDetail.setFlag_like(true);
        cartoonDetail.setCartoon_author("冷冷月");
        cartoonDetail.setCartoon_author_image(R.mipmap.a2);
        cartoonDetail.setCartoon_role1("罗小黑");
        cartoonDetail.setCartoon_role1_image(R.mipmap.a2);
        cartoonDetail.setCartoon_role2("小白");
        cartoonDetail.setCartoon_role2_image(R.mipmap.a2);
        cartoonDetail.setCartoon_brief("和范德萨回复哈斯福和hiU覅忽而奥规划和公安更好地化工ID辅导费红烧豆腐哈师德师风");

        RemarkRecyclerView remarkRecyclerView = new RemarkRecyclerView();
        Remark_input remark_input = new Remark_input();
        WordTitleRecyclerView wordTitleRecyclerView = new WordTitleRecyclerView();

        list.add(cartoonDetail);
        list.add(remarkRecyclerView);
        list.add(remark_input);
        list.add(wordTitleRecyclerView);



    }
}
