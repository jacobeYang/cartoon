package com.example.mycattonapplication.activity;

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
import com.example.mycattonapplication.model.Cartoon;
import com.example.mycattonapplication.model.Category;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private View view;
    private Banner banner;
    private RecyclerView recyclerView;
    private CartoonAdapter cartoonAdapter;
    private List<Cartoon> item_list;
    private List<Category> category_list;
    private Context context;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.home,container,false);
        context = getContext();
        view_init();
        return view;
    }

    public void view_init(){
        //轮播
        banner = (Banner)view.findViewById(R.id.banner);
        setBanner();

        //漫画列表
        list_init();
        recyclerView = (RecyclerView)view.findViewById(R.id.main_recycle);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context,6);
        recyclerView.setLayoutManager(gridLayoutManager);
        cartoonAdapter = new CartoonAdapter(item_list,category_list,7);
        recyclerView.setAdapter(cartoonAdapter);
    }


    public void list_init(){
        category_list = new ArrayList<Category>();
        Category category1 = new Category();
        category1.setCategory_name("类型一");
        Category category2 = new Category();
        category2.setCategory_name("类型Er");
        Category category3 = new Category();
        category3.setCategory_name("类SaN");
        category_list.add(category1);
        category_list.add(category2);
        category_list.add(category3);

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


    private void setBanner() {
        //设置图片集合
        List<Integer> imgs = new ArrayList<>();
        imgs.add(R.mipmap.a1);
        imgs.add(R.mipmap.a2);
        imgs.add(R.mipmap.a3);
        List<String> titles = new ArrayList<>();
        titles.add("图片1");
        titles.add("图片2");
        titles.add("图片3");
//      .setBannerTitles(titles)
        banner.setImages(imgs).setBannerStyle(BannerConfig.CIRCLE_INDICATOR)//显示风格

                .setDelayTime(4000)
                .setBannerAnimation(Transformer.CubeIn)//轮播动画
                .setImageLoader(new GlideImageLoader())
                .setIndicatorGravity(BannerConfig.CENTER)//设置指示器位置（当banner模式中有指示器时）
                .start();

        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                Intent intent = new Intent(context,CartoonDetailActivity.class);
                intent.putExtra("cartoon_id",position);
                startActivity(intent);
            }
        });
    }


}
