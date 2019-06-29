package com.example.mycattonapplication.activity.mine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.example.mycattonapplication.R;
import com.example.mycattonapplication.activity.cartoonDetail.GlideRoundImage;

public class UserInfoActivity extends AppCompatActivity {
    private TextView back;
    private TextView update;
    private ImageView user_image;
    private EditText user_name;
    private EditText user_autograph;
    private EditText user_age;
    private EditText user_sex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        init_view();

    }

    public void init_view(){
        user_image = (ImageView)findViewById(R.id.user_info_image);
        back = (TextView)findViewById(R.id.user_info_back);
        update = (TextView)findViewById(R.id.user_info_update);
        user_name = (EditText)findViewById(R.id.info_user_name);
        user_autograph = (EditText)findViewById(R.id.info_user_autograph);
        user_age = (EditText)findViewById(R.id.info_user_age);
        user_sex = (EditText)findViewById(R.id.info_user_sex);



        Glide.with(this).load(R.mipmap.a2).transform(new CenterCrop(this),new GlideRoundImage(this)).into(user_image);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str_name = user_name.getText().toString();
                String str_sex = user_sex.getText().toString();
                String str_age = user_age.getText().toString();
                String str_autograph = user_autograph.getText().toString();

                //更新数据

            }
        });
    }
}
