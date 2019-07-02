package com.example.mycattonapplication.activity.mine;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.example.mycattonapplication.R;
import com.example.mycattonapplication.activity.cartoonDetail.GlideRoundImage;

import static android.preference.PreferenceManager.getDefaultSharedPreferences;

public class MyFragment extends Fragment implements View.OnClickListener {
    private ImageView user_image;
    private TextView user_name;
    private TextView user_autograph;
    private LinearLayout mine_like;
    private LinearLayout mine_look_through;
    private LinearLayout mine_collect;
    private LinearLayout mine_remark;
    private TextView mine_logout;

    private View view;
    private Context context;
    private Intent intent;

    private SharedPreferences preferences ;
    private SharedPreferences.Editor editor;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.mine,container,false);
        context = view.getContext();
        init_view();
        return view;
    }

    public void init_view(){
        preferences = getDefaultSharedPreferences(context);
        editor = preferences.edit();

        user_image = (ImageView)view.findViewById(R.id.mine_user_image);
        user_name = (TextView)view.findViewById(R.id.mine_user_name);
        user_autograph = (TextView)view.findViewById(R.id.mine_user_autograph);

        mine_like = (LinearLayout)view.findViewById(R.id.mine_like);
        mine_look_through = (LinearLayout)view.findViewById(R.id.mine_look_through);
        mine_collect = (LinearLayout)view.findViewById(R.id.mine_collect);
        mine_remark = (LinearLayout)view.findViewById(R.id.mine_remark);

        mine_logout = (TextView)view.findViewById(R.id.mine_logout);

        Glide.with(context).load(R.mipmap.a2).transform(new CenterCrop(context),new GlideRoundImage(context)).into(user_image);
        user_name.setText("杀心大士");
        user_autograph.setText("美景可念而不可达，佳人可望而不可及");

        user_image.setOnClickListener(this);
        mine_like.setOnClickListener(this);
        mine_look_through.setOnClickListener(this);
        mine_collect.setOnClickListener(this);
        mine_remark.setOnClickListener(this);

        mine_logout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.mine_user_image:
                intent = new Intent(context,UserInfoActivity.class);
                startActivity(intent);
                break;
            case R.id.mine_look_through:
                intent = new Intent(context,LookThroughCartoon.class);
                startActivity(intent);
                break;
            case R.id.mine_collect:
                intent = new Intent(context,CollectCartoonActivity.class);
                startActivity(intent);
                break;
            case R.id.mine_like:
                intent = new Intent(context,LikeCartoonActivity.class);
                startActivity(intent);
                break;
            case R.id.mine_remark:
                intent = new Intent(context,RemarkCartoonActivity.class);
                startActivity(intent);
                break;
            case R.id.mine_logout:
                editor.putBoolean("login_statue",false);
                editor.commit();
        }
    }
}
