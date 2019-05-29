package com.example.mycattonapplication.activity;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mycattonapplication.R;
import com.example.mycattonapplication.model.Word;

import java.util.List;

public class CartoonDetailAdapter extends RecyclerView.Adapter<CartoonDetailAdapter.ViewHolder>{
    private List<Word> word_list = null;
    private Context myContext;

    public CartoonDetailAdapter(List<Word> word_list){
        this.word_list = word_list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(myContext == null){
            myContext = parent.getContext();
        }
        View view = LayoutInflater.from(myContext).inflate(R.layout.word_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Word word = word_list.get(position);
        holder.world_item_name.setText(word.getWord_name());
        holder.world_item_number.setText(word.getWord_number());
        holder.ll_word_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(myContext,WordShowActivity.class);
                intent.putExtra("word_id",word.getId());
                myContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return word_list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        private LinearLayout ll_word_item;
        private TextView world_item_number;
        private TextView world_item_name;

        public ViewHolder(View itemView) {
            super(itemView);
            ll_word_item = (LinearLayout)itemView.findViewById(R.id.ll_word_item);
            world_item_number = (TextView)itemView.findViewById(R.id.world_item_number);
            world_item_name = (TextView)itemView.findViewById(R.id.world_item_name);
        }
    }
}
