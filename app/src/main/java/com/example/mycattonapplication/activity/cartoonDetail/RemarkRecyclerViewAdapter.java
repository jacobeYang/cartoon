package com.example.mycattonapplication.activity.cartoonDetail;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.example.mycattonapplication.R;
import com.example.mycattonapplication.model.Remark;
import com.example.mycattonapplication.utils.DateExchangeString;

import java.util.List;

public class RemarkRecyclerViewAdapter extends RecyclerView.Adapter<RemarkRecyclerViewAdapter.ViewHolder>  {
    private List<Remark> remarkList;
    private Context context;
    public RemarkRecyclerViewAdapter( List<Remark> remarkList){
        this.remarkList = remarkList;
    }

    @NonNull
    @Override
    public RemarkRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(context == null){
            context = parent.getContext();
        }
        View view = LayoutInflater.from(context).inflate(R.layout.remark_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RemarkRecyclerViewAdapter.ViewHolder holder, int position) {
        Remark remark = remarkList.get(position);
        holder.remark_user_name.setText(remark.getUser().getUserName());
        holder.remark_content.setText(remark.getRemarkContent());

        holder.remark_time.setText(DateExchangeString.DateToString(remark.getTime()));
        Glide.with(context).load(remark.getUser().getUserImageId()).transform(new CenterCrop(context),new GlideRoundImage(context)).into(holder.remark_user_image);

    }

    @Override
    public int getItemCount() {
        return remarkList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView remark_user_image;
        private TextView remark_user_name;
        private TextView remark_time;
        private TextView remark_content;
        public ViewHolder(View itemView) {
            super(itemView);
            remark_user_image = (ImageView)itemView.findViewById(R.id.remark_user_image);
            remark_user_name = (TextView)itemView.findViewById(R.id.remark_user_name);
            remark_time = (TextView)itemView.findViewById(R.id.remark_time);
            remark_content = (TextView)itemView.findViewById(R.id.remark_content);
        }
    }
}
