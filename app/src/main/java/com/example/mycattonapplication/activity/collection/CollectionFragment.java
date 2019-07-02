package com.example.mycattonapplication.activity.collection;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mycattonapplication.R;
import com.example.mycattonapplication.activity.categoryDetail.CategoryDetailAdapter;
import com.example.mycattonapplication.activity.home.HomeAdapter;
import com.example.mycattonapplication.dao.CartoonDao;
import com.example.mycattonapplication.model.Author;
import com.example.mycattonapplication.model.Cartoon;
import com.example.mycattonapplication.model.Category;
import com.example.mycattonapplication.model.HeadLine;
import com.example.mycattonapplication.model.MyBanner;
import com.example.mycattonapplication.model.NotAnyMore;

import java.util.ArrayList;
import java.util.List;

import static android.preference.PreferenceManager.getDefaultSharedPreferences;

public class CollectionFragment extends Fragment {
    private View view;
    private RecyclerView recyclerView;
    private CollectionCartoonAdapter cartoonAdapter;
    private List<Object> item_list;
    private Context context;

    SharedPreferences sharedPreferences;

    final Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.collection,container,false);
        context = getContext();
        view_init();
        return view;
    }

    public void view_init(){
        sharedPreferences = getDefaultSharedPreferences(context);

        item_list = new ArrayList<Object>();
        recyclerView = (RecyclerView)view.findViewById(R.id.collection_recycle_view);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context,1);
        recyclerView.setLayoutManager(gridLayoutManager);
        cartoonAdapter = new CollectionCartoonAdapter(item_list);
        recyclerView.setAdapter(cartoonAdapter);
        CartoonDao.getCollection(sharedPreferences.getString("userId","0"),handler);
    }

}
