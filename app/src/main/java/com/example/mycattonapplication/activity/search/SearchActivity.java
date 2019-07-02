package com.example.mycattonapplication.activity.search;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.mycattonapplication.R;
import com.example.mycattonapplication.activity.home.MainActivity;
import com.example.mycattonapplication.dao.CartoonDao;
import com.example.mycattonapplication.model.Cartoon;
import com.example.mycattonapplication.model.NotAnyMore;
import com.example.mycattonapplication.utils.JudgeNull;
import com.example.mycattonapplication.utils.ShowMyToast;

import java.util.List;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener{
    private SearchView searchView;
    private TextView tv_cancle;
    private TextView tv__search_cartoon_1;
    private TextView tv__search_cartoon_2;
    private TextView tv__search_cartoon_3;
    private TextView tv__search_cartoon_4;
    private TextView tv__search_cartoon_5;
    private Intent intentToSearchResult;
    private String searchText;

    final Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch(msg.what){
                case 1:
                    List<String> cartoonList= (List<String>)msg.obj;
                    tv__search_cartoon_1.setText(cartoonList.get(0));
                    tv__search_cartoon_2.setText(cartoonList.get(1));
                    tv__search_cartoon_3.setText(cartoonList.get(2));
                    tv__search_cartoon_4.setText(cartoonList.get(3));
                    tv__search_cartoon_5.setText(cartoonList.get(4));
                    break;
            }

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        init_view();
        intentToSearchResult = new Intent(this,SearchResultActivity.class);
    }

    private void init_view(){
        searchView = (SearchView)findViewById(R.id.home_search_view);
        tv_cancle = (TextView)findViewById(R.id.home_search_cancel);
        tv__search_cartoon_1 = (TextView)findViewById(R.id.search_cartoon_1);
        tv__search_cartoon_2 = (TextView)findViewById(R.id.search_cartoon_2);
        tv__search_cartoon_3 = (TextView)findViewById(R.id.search_cartoon_3);
        tv__search_cartoon_4 = (TextView)findViewById(R.id.search_cartoon_4);
        tv__search_cartoon_5 = (TextView)findViewById(R.id.search_cartoon_5);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if(JudgeNull.judge(query)){
                    searchText = query;
                    intentToSearchResult.putExtra("name",searchText);
                    startActivity(intentToSearchResult);
                }else{
                    ShowMyToast.show(SearchActivity.this,"搜索内容为空");
                }

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                return false;
            }
        });

        tv_cancle.setOnClickListener(this);
        tv__search_cartoon_1.setOnClickListener(this);
        tv__search_cartoon_2.setOnClickListener(this);
        tv__search_cartoon_3.setOnClickListener(this);
        tv__search_cartoon_4.setOnClickListener(this);
        tv__search_cartoon_5.setOnClickListener(this);

        CartoonDao.getSearchRecommend(handler);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.home_search_cancel:
                finish();
                break;
            case R.id.search_cartoon_1:
                intentToSearchResult.putExtra("name",tv__search_cartoon_1.getText());
                startActivity(intentToSearchResult);
                break;
            case R.id.search_cartoon_2:
                intentToSearchResult.putExtra("name",tv__search_cartoon_2.getText());
                startActivity(intentToSearchResult);
                break;
            case R.id.search_cartoon_3:
                intentToSearchResult.putExtra("name",tv__search_cartoon_3.getText());
                startActivity(intentToSearchResult);
                break;
            case R.id.search_cartoon_4:
                intentToSearchResult.putExtra("name",tv__search_cartoon_4.getText());
                startActivity(intentToSearchResult);
                break;
            case R.id.search_cartoon_5:
                intentToSearchResult.putExtra("name",tv__search_cartoon_5.getText());
                startActivity(intentToSearchResult);
                break;
        }
    }
}
