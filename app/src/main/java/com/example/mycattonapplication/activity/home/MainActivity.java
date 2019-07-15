package com.example.mycattonapplication.activity.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.mycattonapplication.R;
import com.example.mycattonapplication.activity.MyActivity;
import com.example.mycattonapplication.activity.collection.CollectionFragment;
import com.example.mycattonapplication.activity.mine.MyFragment;

public class MainActivity extends MyActivity implements View.OnClickListener{

    private LinearLayout ll_home;
    private LinearLayout ll_collection;
    private LinearLayout ll_my;

    private ImageView iv_home;
    private ImageView iv_collection;
    private ImageView iv_my;

    private TextView tv_home;
    private TextView tv_collection;
    private TextView tv_my;

    private Fragment homeFragment;
    private Fragment collectionFragment;
    private Fragment myFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // 初始化控件
        initView();
        // 初始化底部按钮事件
        initEvent();
        // 初始化并设置当前Fragment
        initFragment(0);


    }





    private void initFragment(int index) {
        // 由于是引用了V4包下的Fragment，所以这里的管理器要用getSupportFragmentManager获取
        FragmentManager fragmentManager = getSupportFragmentManager();
        // 开启事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // 隐藏所有Fragment
        hideFragment(transaction);
        switch (index) {
            case 0:
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                    transaction.add(R.id.fl_content, homeFragment);
                } else {
                    transaction.show(homeFragment);
                }
                break;
            case 1:
                if (collectionFragment == null) {
                    collectionFragment = new CollectionFragment();
                    transaction.add(R.id.fl_content, collectionFragment);
                } else {
                    transaction.show(collectionFragment);
                }

                break;
            case 2:
                if (myFragment == null) {
                    myFragment = new MyFragment();
                    transaction.add(R.id.fl_content, myFragment);
                } else {
                    transaction.show(myFragment);
                }


        }

        // 提交事务
        transaction.commit();

    }

    //隐藏Fragment
    private void hideFragment(FragmentTransaction transaction) {
        if (homeFragment != null) {
            transaction.hide(homeFragment);
        }
        if (collectionFragment != null) {
            transaction.hide(collectionFragment);
        }
        if (myFragment != null) {
            transaction.hide(myFragment);
        }


    }

    private void initEvent() {
        // 设置按钮监听
        ll_home.setOnClickListener(this);
        ll_collection.setOnClickListener(this);
        ll_my.setOnClickListener(this);

    }

    private void initView() {

        // 底部菜单4个Linearlayout
        this.ll_home = findViewById(R.id.ll_home);
        this.ll_collection = findViewById(R.id.ll_collection);
        this.ll_my = findViewById(R.id.ll_my);
        // 底部菜单4个ImageView
        this.iv_home = findViewById(R.id.iv_home);
        this.iv_collection = findViewById(R.id.iv_collection);
        this.iv_my = findViewById(R.id.iv_my);

        // 底部菜单4个菜单标题
        this.tv_home = findViewById(R.id.tv_home);
        this.tv_collection = findViewById(R.id.tv_collection);
        this.tv_my = findViewById(R.id.tv_my);

    }

    @Override
    public void onClick(View v) {

        // 在每次点击后将所有的底部按钮(ImageView,TextView)颜色改为灰色，然后根据点击着色
        restartBotton();
        // ImageView和TetxView置为绿色，页面随之跳转
        switch (v.getId()) {
            case R.id.ll_home:
                iv_home.setImageResource(R.mipmap.home);
                tv_home.setTextColor(getColor(R.color.my_primary));
                initFragment(0);
                break;
            case R.id.ll_collection:
                iv_collection.setImageResource(R.mipmap.collection);
                tv_collection.setTextColor(getColor(R.color.my_primary));
                initFragment(1);
                break;
            case R.id.ll_my:
                iv_my.setImageResource(R.mipmap.mine);
                tv_my.setTextColor(getColor(R.color.my_primary));
                initFragment(2);
        }

    }

    private void restartBotton() {
        // ImageView置为灰色
        iv_home.setImageResource(R.mipmap.homewhite);
        iv_collection.setImageResource(R.mipmap.collectionwhite);
        iv_my.setImageResource(R.mipmap.minewhite);
        // TextView置为白色
        tv_home.setTextColor(getColor(R.color.my_primary_white));
        tv_collection.setTextColor(getColor(R.color.my_primary_white));
        tv_my.setTextColor(getColor(R.color.my_primary_white));
    }

}
