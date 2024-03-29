package com.example.mycattonapplication.activity.wordShow;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.INotificationSideChannel;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.mycattonapplication.R;
import com.example.mycattonapplication.utils.HttpUtil;

import java.util.List;

public class WordshowAdapter extends RecyclerView.Adapter<WordshowAdapter.ViewHolder> {
    private List<String> image_list;
    private Context myContext;

    public WordshowAdapter(List<String> image_list){
        this.image_list = image_list;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView = null;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.word_show_item_image);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(myContext == null){
            myContext = parent.getContext();
        }
        View view = LayoutInflater.from(myContext).inflate(R.layout.word_show_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String imageSrc = image_list.get(position);
        Glide.with(myContext).load(HttpUtil.basePath+imageSrc).centerCrop().into(holder.imageView);
    }



    @Override
    public int getItemCount() {
        return image_list.size();
    }
}
