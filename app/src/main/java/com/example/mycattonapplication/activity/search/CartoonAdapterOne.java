package com.example.mycattonapplication.activity.search;

import android.content.Context;
import android.content.Intent;
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
import com.example.mycattonapplication.activity.categoryDetail.CategoryDetailActivity;
import com.example.mycattonapplication.model.Cartoon;
import com.example.mycattonapplication.model.Category;
import com.example.mycattonapplication.model.HeadLine;
import com.example.mycattonapplication.model.MyBanner;
import com.example.mycattonapplication.model.NotAnyMore;
import com.example.mycattonapplication.utils.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.List;


public class CartoonAdapterOne extends RecyclerView.Adapter<CartoonAdapterOne.CartoonItemViewHolder> {

    private Context myContext;
    private List<Cartoon> list;

    public CartoonAdapterOne(List<Cartoon> list){
        this.list = list;
    }

    static class CartoonItemViewHolder extends RecyclerView.ViewHolder{
        TextView cartoon_name =null;
        TextView cartoon_author =null;
        TextView cartoon_brief = null;
        ImageView imageView = null;
        LinearLayout cartoon_item_one;

        public CartoonItemViewHolder(View itemView) {
            super(itemView);
            cartoon_name = itemView.findViewById(R.id.cartoon_item_one_name);
            cartoon_author = itemView.findViewById(R.id.cartoon_item_one_author);
            cartoon_brief = itemView.findViewById(R.id.cartoon_item_one_brief);
            cartoon_item_one = itemView.findViewById(R.id.cartoon_item_one);
            imageView = itemView.findViewById(R.id.cartoon_item_one_image);
        }
    }





    @Override
    public CartoonItemViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        if (myContext == null) {
            myContext = parent.getContext();
        }

        View view = LayoutInflater.from(myContext).inflate(R.layout.cartoon_item_one, parent, false);
        return new CartoonItemViewHolder(view);


    }


    @Override
    public void onBindViewHolder( CartoonItemViewHolder holder, final int position) {
        final Cartoon cartoon = list.get(position);
        Glide.with(myContext).load(cartoon.getImageId()).centerCrop().into(holder.imageView);
        holder.cartoon_author.setText(cartoon.getAuthor().getAuthorName());
        holder.cartoon_name.setText(cartoon.getCartoonName());
        holder.cartoon_brief.setText(cartoon.getBriefIntroduction());

        holder.cartoon_item_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(myContext,CartoonDetailActivity.class);
                intent.putExtra("cartoonId",cartoon.getId());
                myContext.startActivity(intent);
            }
        });
    }



    @Override
    public int getItemCount() {
        return list.size();
    }



}
