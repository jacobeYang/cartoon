package com.example.mycattonapplication.activity.cartoonDetail;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mycattonapplication.R;
import com.example.mycattonapplication.activity.wordShow.WordShowActivity;
import com.example.mycattonapplication.model.Remark;
import com.example.mycattonapplication.model.Word;

import java.util.List;

public class WordTitleRecyclerViewAdapter extends RecyclerView.Adapter<WordTitleRecyclerViewAdapter.ViewHolder>  {
    private List<Word> wordList;
    private Context context;
    public WordTitleRecyclerViewAdapter(List<Word> wordList){
        this.wordList = wordList;
    }

    @NonNull
    @Override
    public WordTitleRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(context == null){
            context = parent.getContext();
        }
        View view = LayoutInflater.from(context).inflate(R.layout.word_title_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WordTitleRecyclerViewAdapter.ViewHolder holder, int position) {
        final Word word = wordList.get(position);
        holder.word_name.setText(word.getWord_name());
        holder.word_number.setText(word.getWord_number());

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, WordShowActivity.class);
                intent.putExtra("wordName",word.getWord_name());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return wordList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView word_name;
        private TextView word_number;
        private LinearLayout linearLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            word_name = (TextView)itemView.findViewById(R.id.world_item_name);
            word_number = (TextView)itemView.findViewById(R.id.world_item_number);
            linearLayout = (LinearLayout)itemView.findViewById(R.id.word_title_item);
        }
    }
}
