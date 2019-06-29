package com.example.mycattonapplication.activity.categoryDetail;

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
import com.example.mycattonapplication.activity.cartoonDetail.CartoonDetailActivity;
import com.example.mycattonapplication.model.Cartoon;

import java.util.List;


public class CategoryDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context myContext;
    private List<Object> cartoon_list = null;

    private static final int type_cartoon = 0;
    private static final int type_not_any_more = 1;


    public CategoryDetailAdapter(List<Object> cartoon_list){
        this.cartoon_list = cartoon_list;
    }

    static class CartoonViewHolder extends RecyclerView.ViewHolder{
        TextView cartoon_name =null;
        TextView author_name = null;
        ImageView imageView = null;
        LinearLayout ll_cartoon_item;

        public CartoonViewHolder(View itemView) {
            super(itemView);
            ll_cartoon_item = (LinearLayout)itemView.findViewById(R.id.ll_cartoon);
            cartoon_name = (TextView)itemView.findViewById(R.id.cartoon_name);
            author_name = (TextView)itemView.findViewById(R.id.author_name);
            imageView = (ImageView)itemView.findViewById(R.id.cartoon_image);
        }
    }

    static class NotAnyMoreViewHolder extends RecyclerView.ViewHolder{

        public NotAnyMoreViewHolder(View itemView) {
            super(itemView);
        }
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int type) {
        if (myContext == null) {
            myContext = parent.getContext();
        }

        if(type == type_cartoon) {
            View view = LayoutInflater.from(myContext).inflate(R.layout.cartoon_item, parent, false);
            return new CartoonViewHolder(view);
        }else{
            View view = LayoutInflater.from(myContext).inflate(R.layout.not_any_more, parent, false);
            return new NotAnyMoreViewHolder(view);
        }

    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Object object = cartoon_list.get(position);

        if(object instanceof  Cartoon) {
            CartoonViewHolder cartoonViewHolder = (CartoonViewHolder) holder;
            final Cartoon cartoon = (Cartoon) object;
            cartoonViewHolder.cartoon_name.setText(cartoon.getCartoon_name());
            cartoonViewHolder.author_name.setText(cartoon.getAuthor_name());
            Glide.with(myContext).load(cartoon.getImageId()).centerCrop().into(cartoonViewHolder.imageView);
            cartoonViewHolder.ll_cartoon_item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(myContext, CartoonDetailActivity.class);
                    intent.putExtra("cartoonId", cartoon.getId());
                    myContext.startActivity(intent);
                }
            });
        }else{
            //不用管
        }
    }




    @Override
    public int getItemCount() {
        return cartoon_list.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(cartoon_list.get(position) instanceof Cartoon){
            return type_cartoon;
        }else {
            return type_not_any_more;
        }
    }

    @Override
    public void onAttachedToRecyclerView( RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
        if(manager instanceof GridLayoutManager){
            final GridLayoutManager gridLayoutManager = (GridLayoutManager)manager;
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    int type = getItemViewType(position);
                    if(type == type_cartoon){
                        return 1;
                    }else {
                        return 2;
                    }
                }
            });
        }
    }

}
