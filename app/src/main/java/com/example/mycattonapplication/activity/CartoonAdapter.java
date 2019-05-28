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


public class CartoonAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE1_HEADLINE = 0;
    private static final int TYPE1_CONTENT = 1;
    private int item_size;
    private Context myContext;
    private List<Cartoon> cartoon_list = null;
    private List<Category> category_list = null;

    public CartoonAdapter(List<Cartoon> cartoon_list,List<Category> category_list,int item_size){
        this.cartoon_list = cartoon_list;
        this.category_list = category_list;
        this.item_size = item_size;
    }

    static class CartoonItemViewHolder extends RecyclerView.ViewHolder{
        CardView cardView = null;
        TextView cartoon_name =null;
        TextView author_name = null;
        ImageView imageView = null;
        LinearLayout ll_cartoon = null;

        public CartoonItemViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView;
            cartoon_name = (TextView)itemView.findViewById(R.id.cartoon_name);
            author_name = (TextView)itemView.findViewById(R.id.author_name);
            imageView = (ImageView)itemView.findViewById(R.id.cartoon_image);
            ll_cartoon = (LinearLayout)itemView.findViewById(R.id.ll_cartoon);
        }
    }

    static class HeadLineItemViewHolder extends  RecyclerView.ViewHolder{
        TextView category_name = null;
        TextView detail = null;

        public HeadLineItemViewHolder(View itemView) {
            super(itemView);
            category_name = (TextView)itemView.findViewById(R.id.headline_category_name);
            detail = (TextView)itemView.findViewById(R.id.headline_detail);
        }
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (myContext == null) {
            myContext = parent.getContext();
        }
        if(viewType == TYPE1_CONTENT) {
            View view = LayoutInflater.from(myContext).inflate(R.layout.cartoon_item, parent, false);
            return new CartoonItemViewHolder(view);
        }else{//viewType == TYPE1_HEADLINE
            View view = LayoutInflater.from(myContext).inflate(R.layout.headline_item, parent, false);
            return new HeadLineItemViewHolder(view);
        }

    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        if(holder instanceof CartoonItemViewHolder){
            final Cartoon cartoon = cartoon_list.get(position-position/item_size-1);
            CartoonItemViewHolder cartoonItemViewHolder = (CartoonItemViewHolder)holder;
            cartoonItemViewHolder.cartoon_name.setText(cartoon.getCartoon_name());
            cartoonItemViewHolder.author_name.setText(cartoon.getAuthor_name());
            Glide.with(myContext).load(cartoon.getImageId()).into(cartoonItemViewHolder.imageView);
            cartoonItemViewHolder.ll_cartoon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(myContext,CartoonDetailActivity.class);
                    intent.putExtra("cartoon_id",cartoon.getId());
                    myContext.startActivity(intent);
                }
            });
        }else{//holder instanceof HeadLineItemViewHolder
            final Category category = category_list.get(position/item_size);
            HeadLineItemViewHolder headLineItemViewHolder = (HeadLineItemViewHolder)holder;
            headLineItemViewHolder.category_name.setText(category.getCategory_name());
            headLineItemViewHolder.detail.setText("点击查看更多>>");
            headLineItemViewHolder.detail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(myContext,CategoryDetailActivity.class);
                    intent.putExtra("cartoon_id",category.getId());
                    myContext.startActivity(intent);
                }
            });
        }

    }



    @Override
    public int getItemCount() {
        return cartoon_list.size()+category_list.size();
    }


    @Override
    public int getItemViewType(int position) {
        if(position%item_size == 0)
            return TYPE1_HEADLINE;
        else
            return TYPE1_CONTENT;
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
        if(manager instanceof GridLayoutManager){
            final GridLayoutManager gridLayoutManager = (GridLayoutManager)manager;
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    int type = getItemViewType(position);
                    if(type == TYPE1_HEADLINE){
                        return 6;
                    }else{//type == TYPE1_CartoonItem;
                        return 2;
                    }

                }
            });
        }
    }
}
