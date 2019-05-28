package com.example.mycattonapplication.activity;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mycattonapplication.R;
import com.example.mycattonapplication.model.Cartoon;

import java.util.ArrayList;
import java.util.List;

public class CollectionFragment extends Fragment {
    private View view;
    private RecyclerView recyclerView;
    private CollectionCartoonAdapter cartoonAdapter;
    private List<Cartoon> item_list;
    private Context context;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.collection,container,false);
        context = getContext();
        view_init();
        return view;
    }

    public void view_init(){
        list_init();
        recyclerView = (RecyclerView)view.findViewById(R.id.collection_recycle_view);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context,1);
        recyclerView.setLayoutManager(gridLayoutManager);
        cartoonAdapter = new CollectionCartoonAdapter(context,item_list);
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
