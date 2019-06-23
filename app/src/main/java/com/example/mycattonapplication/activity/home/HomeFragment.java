package com.example.mycattonapplication.activity.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.mycattonapplication.R;
import com.example.mycattonapplication.model.HeadLine;
import com.example.mycattonapplication.model.MyBanner;
import com.example.mycattonapplication.model.NotAnyMore;
import com.example.mycattonapplication.activity.search.SearchActivity;
import com.example.mycattonapplication.model.Cartoon;
import com.example.mycattonapplication.model.Category;
import com.youth.banner.Banner;

import android.support.v4.app.Fragment;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements View.OnClickListener{
    private View view;
    private Banner banner;
    private RecyclerView recyclerView;
    private HomeAdapter homeAdapter;
    private List<Object> list;
    private Context context;
    private ImageView search;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.home,container,false);
        context = getContext();
        view_init();
        return view;
    }

    public void view_init(){
        //搜索按钮
        search = (ImageView)view.findViewById(R.id.home_search);
        search.setOnClickListener(this);

        //漫画列表
        list_init();
        recyclerView = (RecyclerView)view.findViewById(R.id.main_recycle);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context,12);
        recyclerView.setLayoutManager(gridLayoutManager);
        homeAdapter = new HomeAdapter(list);
        recyclerView.setAdapter(homeAdapter);
    }


    public void list_init(){
        list = new ArrayList<Object>();

        MyBanner myBanner = new MyBanner();
        Category category1 = new Category();
        category1.setCategory_name("热血");
        category1.setIconId(R.mipmap.icon1);
        Category category2 = new Category();
        category2.setCategory_name("玄幻");
        category2.setIconId(R.mipmap.icon2);
        Category category3 = new Category();
        category3.setCategory_name("青春");
        category3.setIconId(R.mipmap.icon3);
        Category category4 = new Category();
        category4.setCategory_name("都市");
        category4.setIconId(R.mipmap.icon4);
//        Category category5 = new Category();
//        category5.setCategory_name("热血");
//        category5.setIconId(R.mipmap.shield);
//        Category category6 = new Category();
//        category6.setCategory_name("热血");
//        category6.setIconId(R.mipmap.shield);
        HeadLine headLine1 = new HeadLine();
        headLine1.setName("猜你喜欢");
        headLine1.setMore("更多>>>");
        HeadLine headLine2 = new HeadLine();
        headLine2.setName("热门推荐");
        headLine2.setMore("更多>>>");
        HeadLine headLine3 = new HeadLine();
        headLine3.setName("恋爱手册");
        headLine3.setMore("更多>>>");
        HeadLine headLine4 = new HeadLine();
        headLine4.setName("异世魔神");
        headLine4.setMore("更多>>>");

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

        list.add(myBanner);
        list.add(category1);
        list.add(category2);
        list.add(category3);
        list.add(category4);

        list.add(headLine1);
        list.add(cartoon1);
        list.add(cartoon2);
        list.add(cartoon3);
        list.add(cartoon1);
        list.add(cartoon2);
        list.add(cartoon3);

        list.add(headLine2);
        list.add(cartoon1);
        list.add(cartoon2);
        list.add(cartoon3);
        list.add(cartoon1);
        list.add(cartoon2);
        list.add(cartoon3);

        list.add(headLine3);
        list.add(cartoon1);
        list.add(cartoon2);
        list.add(cartoon3);
        list.add(cartoon1);
        list.add(cartoon2);
        list.add(cartoon3);

        list.add(headLine4);
        list.add(cartoon1);
        list.add(cartoon2);
        list.add(cartoon3);
        list.add(cartoon1);
        list.add(cartoon2);
        list.add(cartoon3);

        list.add(new NotAnyMore());


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.home_search:
                Intent intent = new Intent(context, SearchActivity.class);
                startActivity(intent);
        }
    }
}
