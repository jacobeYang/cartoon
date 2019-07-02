package com.example.mycattonapplication.activity.home;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.mycattonapplication.R;
import com.example.mycattonapplication.dao.CartoonDao;
import com.example.mycattonapplication.dao.CategoryDao;
import com.example.mycattonapplication.model.HeadLine;
import com.example.mycattonapplication.model.Home;
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

import static android.preference.PreferenceManager.getDefaultSharedPreferences;

public class HomeFragment extends Fragment implements View.OnClickListener{
    private View view;
    private RecyclerView recyclerView;
    private HomeAdapter homeAdapter;
    private Context context;
    private ImageView search;
    SharedPreferences sharedPreferences;
    public Home home;

    final Handler handler = new Handler(){
        int caseNum = 0;
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch(msg.what){
                case 1: //轮播图
                    List<Cartoon> cartoons = (List<Cartoon>)msg.obj;
                    MyBanner myBanner = new MyBanner(cartoons);
                    home.setBanner(myBanner);
                    caseNum++;
                    break;
                case 2: //漫画类别
                    List<Category> categoryList = (List<Category>)msg.obj;
                    home.setCategoryList(categoryList);
                    caseNum++;
                    break;
                case 3:
                    HeadLine headLine1 = new HeadLine();
                    headLine1.setName("猜你喜欢");
                    headLine1.setMore("更多>>>");
                    headLine1.setCategoryId("7");
                    home.setGuessYouLike(headLine1);

                    List<Cartoon> like_cartoons = (List<Cartoon>)msg.obj;
                    home.setGuessYouLikeCartoon(like_cartoons);
                    caseNum++;
                    break;
                case 4:
                    HeadLine headLine2 = new HeadLine();
                    headLine2.setName("热门推荐");
                    headLine2.setMore("更多>>>");
                    headLine2.setCategoryId("8");
                    home.setHotRecommend(headLine2);
                    List<Cartoon> hot_cartoons = (List<Cartoon>)msg.obj;
                    home.setHotRecommendCartoon(hot_cartoons);

                    HeadLine headLine3 = new HeadLine();
                    headLine3.setName("恋爱手册");
                    headLine3.setMore("更多>>>");
                    headLine3.setCategoryId("5");
                    home.setCategory1(headLine3);
                    home.setCategory1Cartoon(hot_cartoons);

                    HeadLine headLine4 = new HeadLine();
                    headLine4.setName("异世魔神");
                    headLine4.setMore("更多>>>");
                    headLine4.setCategoryId("6");
                    home.setCategory2(headLine4);
                    home.setCategory2Cartoon(hot_cartoons);
                    home.setNotAnyMore(new NotAnyMore());

                    caseNum++;
                    break;
            }

            if(caseNum == 4){
                //homeAdapter.notifyDataSetChanged();
                homeAdapter = new HomeAdapter(home);
                recyclerView.setAdapter(homeAdapter);
            }
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.home,container,false);
        context = getContext();
        sharedPreferences = getDefaultSharedPreferences(context);
        view_init();
        return view;
    }

    public void view_init(){
        //搜索按钮
        search = (ImageView)view.findViewById(R.id.home_search);
        search.setOnClickListener(this);

        //漫画列表
        home = new Home();
        recyclerView = (RecyclerView)view.findViewById(R.id.main_recycle);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context,12);
        recyclerView.setLayoutManager(gridLayoutManager);


        CartoonDao.getBanner(handler);
        CategoryDao.getCategory(handler);
        CartoonDao.getGuessYouLike(sharedPreferences.getString("userId","0"),handler);
        CartoonDao.getHotRecommend(handler);



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
