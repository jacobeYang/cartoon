package com.example.mycattonapplication.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.mycattonapplication.R;

public class MainActivity extends FragmentActivity implements View.OnClickListener{

    private LinearLayout ll_home;
    private LinearLayout ll_collection;

    private ImageView iv_home;
    private ImageView iv_collection;

    private TextView tv_home;
    private TextView tv_collection;

    private Fragment homeFragment;
    private Fragment collectionFragment;


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


    }

    private void initEvent() {
        // 设置按钮监听
        ll_home.setOnClickListener(this);
        ll_collection.setOnClickListener(this);


    }

    private void initView() {

        // 底部菜单4个Linearlayout
        this.ll_home = (LinearLayout) findViewById(R.id.ll_home);
        this.ll_collection = (LinearLayout)findViewById(R.id.ll_collection);
        // 底部菜单4个ImageView
        this.iv_home = (ImageView) findViewById(R.id.iv_home);
        this.iv_collection = (ImageView) findViewById(R.id.iv_collection);

        // 底部菜单4个菜单标题
        this.tv_home = (TextView) findViewById(R.id.tv_home);
        this.tv_collection = (TextView) findViewById(R.id.tv_collection);

    }

    @Override
    public void onClick(View v) {

        // 在每次点击后将所有的底部按钮(ImageView,TextView)颜色改为灰色，然后根据点击着色
        restartBotton();
        // ImageView和TetxView置为绿色，页面随之跳转
        switch (v.getId()) {
            case R.id.ll_home:
                iv_home.setImageResource(R.mipmap.ic_launcher_round);
                tv_home.setTextColor(0xff1B940A);
                initFragment(0);
                break;
            case R.id.ll_collection:
                iv_collection.setImageResource(R.mipmap.ic_launcher);
                tv_collection.setTextColor(0xff1B940A);
                initFragment(1);
                break;

        }

    }

    private void restartBotton() {
        // ImageView置为灰色
        iv_home.setImageResource(R.mipmap.ic_launcher_round);
        iv_collection.setImageResource(R.mipmap.ic_launcher);
        // TextView置为白色
        tv_home.setTextColor(0xffffffff);
        tv_collection.setTextColor(0xffffffff);
    }

}
