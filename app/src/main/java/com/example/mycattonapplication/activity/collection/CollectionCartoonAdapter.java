package com.example.mycattonapplication.activity.collection;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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
import com.example.mycattonapplication.activity.search.SearchActivity;
import com.example.mycattonapplication.model.Cartoon;

import java.util.List;


public class CollectionCartoonAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context myContext;
    private List<Object> cartoon_list = null;
    private static final int TYPE_CARTOON = 0;
    private static final int TYPE_ADD = 1;


    public CollectionCartoonAdapter(List<Object> cartoon_list){
        this.cartoon_list = cartoon_list;
    }

    static class CartoonViewHolder extends RecyclerView.ViewHolder{
        TextView cartoon_name =null;
        TextView carton_author = null;
        TextView cartoon_brief = null;
        ImageView imageView = null;
        LinearLayout cartoon_item_one = null;

        public CartoonViewHolder(View itemView) {
            super(itemView);
            cartoon_name = (TextView)itemView.findViewById(R.id.cartoon_item_one_name);
            carton_author = (TextView)itemView.findViewById(R.id.cartoon_item_one_author);
            imageView = (ImageView)itemView.findViewById(R.id.cartoon_item_one_image);
            cartoon_brief = (TextView) itemView.findViewById(R.id.cartoon_item_one_brief);
            cartoon_item_one = (LinearLayout) itemView.findViewById(R.id.cartoon_item_one);
        }
    }

    static class AddViewHolder extends RecyclerView.ViewHolder{
        private LinearLayout collection_add_item;

        public AddViewHolder(View itemView) {
            super(itemView);
            collection_add_item = (LinearLayout)itemView.findViewById(R.id.collection_add_item);
        }
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent,int type) {
        if (myContext == null) {
            myContext = parent.getContext();
        }
        if(type == TYPE_CARTOON){
            View view = LayoutInflater.from(myContext).inflate(R.layout.cartoon_item_one, parent, false);
            return new CartoonViewHolder(view);
        }else{
            View view = LayoutInflater.from(myContext).inflate(R.layout.collection_add_item, parent, false);
            return new AddViewHolder(view);
        }


    }



    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            Object object= cartoon_list.get(position);
            if(object instanceof Cartoon) {
                final Cartoon cartoon = (Cartoon)object;
                CartoonViewHolder cartoonViewHolder = (CartoonViewHolder) holder;
                cartoonViewHolder.cartoon_name.setText(cartoon.getCartoon_name());
                cartoonViewHolder.carton_author.setText(cartoon.getAuthor_name());
                Glide.with(myContext).load(cartoon.getImageId()).centerCrop().into(cartoonViewHolder.imageView);
                cartoonViewHolder.cartoon_item_one.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(myContext, CartoonDetailActivity.class);
                        intent.putExtra("cartoonId", cartoon.getId());
                        myContext.startActivity(intent);
                    }
                });

                cartoonViewHolder.cartoon_item_one.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        showNormalDialog();
                        return true;
                    }
                });
            }else{
                AddViewHolder addViewHolder = (AddViewHolder)holder;
                addViewHolder.collection_add_item.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(myContext, SearchActivity.class);
                        myContext.startActivity(intent);
                    }
                });
            }
    }


    @Override
    public int getItemCount() {
        return cartoon_list.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(cartoon_list.get(position) instanceof Cartoon){
            return TYPE_CARTOON;
        }else {
            return TYPE_ADD;
        }
    }

    private void showNormalDialog(){
        /* @setIcon 设置对话框图标
         * @setTitle 设置对话框标题
         * @setMessage 设置对话框消息提示
         * setXXX方法返回Dialog对象，因此可以链式设置属性
         */
        final AlertDialog.Builder normalDialog =
                new AlertDialog.Builder(myContext);
        normalDialog.setIcon(R.mipmap.question);
        normalDialog.setTitle("确认删除吗");
        normalDialog.setMessage("该漫画将会从收藏列表移除");
        normalDialog.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //...To-do
                    }
                });
        normalDialog.setNegativeButton("关闭",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //...To-do
                    }
                });
        // 显示
        normalDialog.show();
    }


}
