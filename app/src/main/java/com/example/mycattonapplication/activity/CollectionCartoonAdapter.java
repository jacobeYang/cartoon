package com.example.mycattonapplication.activity;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mycattonapplication.R;
import com.example.mycattonapplication.model.Cartoon;
import com.example.mycattonapplication.model.Category;

import java.util.List;


public class CollectionCartoonAdapter extends RecyclerView.Adapter<CollectionCartoonAdapter.ViewHolder> {
    private Context myContext;
    private List<Cartoon> cartoon_list = null;


    public CollectionCartoonAdapter(Context context,List<Cartoon> cartoon_list){
        this.cartoon_list = cartoon_list;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView = null;
        TextView cartoon_name =null;
        TextView author_name = null;
        ImageView imageView = null;
        LinearLayout collection_item_ll;

        public ViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView;
            cartoon_name = (TextView)itemView.findViewById(R.id.cartoon_name);
            author_name = (TextView)itemView.findViewById(R.id.author_name);
            imageView = (ImageView)itemView.findViewById(R.id.cartoon_image);
            collection_item_ll = (LinearLayout)itemView.findViewById(R.id.collection_item_ll);
        }
    }


    @NonNull
    @Override
    public CollectionCartoonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent,int type) {
        if (myContext == null) {
            myContext = parent.getContext();
        }
        View view = LayoutInflater.from(myContext).inflate(R.layout.collection_item, parent, false);
        return new ViewHolder(view);

    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            final Cartoon cartoon = cartoon_list.get(position);
            ViewHolder viewHolder = (ViewHolder)holder;
            viewHolder.cartoon_name.setText(cartoon.getCartoon_name());
            viewHolder.author_name.setText(cartoon.getAuthor_name());
            Glide.with(myContext).load(cartoon.getImageId()).into(viewHolder.imageView);
            viewHolder.collection_item_ll.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(myContext,CartoonDetailActivity.class);
                    intent.putExtra("cartoon_id",cartoon.getId());
                    myContext.startActivity(intent);
                }
            });
    }


    @Override
    public int getItemCount() {
        return cartoon_list.size();
    }

}
