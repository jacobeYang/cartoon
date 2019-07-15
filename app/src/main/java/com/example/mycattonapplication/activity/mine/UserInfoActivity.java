package com.example.mycattonapplication.activity.mine;

import android.os.Handler;
import android.os.Message;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.example.mycattonapplication.R;
import com.example.mycattonapplication.activity.MyActivity;
import com.example.mycattonapplication.activity.cartoonDetail.GlideRoundImage;
import com.example.mycattonapplication.dao.UserDao;
import com.example.mycattonapplication.model.User;
import com.example.mycattonapplication.utils.ShowMyToast;

public class UserInfoActivity extends MyActivity {
    private TextView back;
    private TextView update;
    private ImageView user_image;
    private EditText user_name;
    private EditText user_autograph;
    private EditText user_age;
    private EditText user_sex;
    private User user;

    final Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    user = (User)msg.obj;
                    Glide.with(UserInfoActivity.this).load(user.getUserImageId()).transform(new CenterCrop(UserInfoActivity.this),new GlideRoundImage(UserInfoActivity.this)).into(user_image);
                    user_name.setText(user.getUserName());
                    user_age.setText(user.getUserAge().toString());
                    user_autograph.setText(user.getAutograph());
                    user_sex.setText(user.getSex());
                    break;
                case 2:
                    ShowMyToast.show(UserInfoActivity.this,"修改成功");
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        init_view();

    }

    public void init_view(){
        user_image = findViewById(R.id.user_info_image);
        back = findViewById(R.id.user_info_back);
        update = findViewById(R.id.user_info_update);
        user_name = findViewById(R.id.info_user_name);
        user_autograph = findViewById(R.id.info_user_autograph);
        user_age = findViewById(R.id.info_user_age);
        user_sex = findViewById(R.id.info_user_sex);

        String userId = getIntent().getStringExtra("userId");
        UserDao.getUserById(userId,handler);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str_name = user_name.getText().toString().trim();
                String str_sex = user_sex.getText().toString().trim();
                String str_age = user_age.getText().toString().trim();
                String str_autograph = user_autograph.getText().toString().trim();

                user.setUserName(str_name);
                user.setSex(str_sex);
                user.setUserAge(Integer.valueOf(str_age));
                user.setAutograph(str_autograph);

                //更新数据
                UserDao.updateUser(user,handler);

            }
        });
    }
}
