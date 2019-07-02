package com.example.mycattonapplication.activity.cartoonDetail;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.mycattonapplication.R;
import com.example.mycattonapplication.dao.CartoonDao;
import com.example.mycattonapplication.model.Cartoon;
import com.example.mycattonapplication.model.CartoonDetail;
import com.example.mycattonapplication.model.CartoonRole;
import com.example.mycattonapplication.model.RemarkRecyclerView;
import com.example.mycattonapplication.model.Remark_input;
import com.example.mycattonapplication.model.WordTitleRecyclerView;

import java.util.ArrayList;
import java.util.List;

import static android.preference.PreferenceManager.getDefaultSharedPreferences;

public class CartoonDetailActivity extends AppCompatActivity {
    private RecyclerView cartoon_detail_recyclerView;
    private ImageView back;
    private CartoonDetailAdapter cartoon_detail_adapter;
    private List<Object> list;
    private String cartoonId;

    private SharedPreferences sharedPreferences;

    private CartoonDetail cartoonDetail;


    final Handler handler = new Handler(){
        int num = 0;
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch(msg.what){
                case 1:
                    cartoonDetail.setCartoon((Cartoon)msg.obj);
                    num+=1;
                    break;
                case 2:
                    List<CartoonRole> cartoonRoleList = (List<CartoonRole>)msg.obj;
                    cartoonDetail.setCartoonRole1(cartoonRoleList.get(0));
                    cartoonDetail.setCartoonRole2(cartoonRoleList.get(1));
                    num+=1;
                    break;
                case 3:
                    num+=1;
                    boolean[] result =(boolean[]) msg.obj;
                    cartoonDetail.setFlag_like(result[0]);
                    cartoonDetail.setFlag_collection(result[1]);
                    break;
            }

            if(num == 3){
                RemarkRecyclerView remarkRecyclerView = new RemarkRecyclerView();
                Remark_input remark_input = new Remark_input();
                WordTitleRecyclerView wordTitleRecyclerView = new WordTitleRecyclerView();
                list.add(cartoonDetail);
                list.add(remarkRecyclerView);
                list.add(remark_input);
                list.add(wordTitleRecyclerView);

                cartoon_detail_adapter.notifyDataSetChanged();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartoon_detail);
        cartoonId = getIntent().getStringExtra("cartoonId");

        view_init();
    }


    public void view_init(){
//        LayoutInflater factory = LayoutInflater.from(CartoonDetailActivity.this);
//        View layout = factory.inflate(R.layout.detail_item, null);
//        ImageView imageView = (ImageView) layout.findViewById(R.id.cartoon_detail_image);
        sharedPreferences = getDefaultSharedPreferences(this);
        cartoonDetail = new CartoonDetail();

        list = new ArrayList<Object>();
        cartoon_detail_recyclerView = (RecyclerView)findViewById(R.id.cartoon_detail_recyclerView);
        cartoon_detail_recyclerView.setLayoutManager(new LinearLayoutManager(   this));
        cartoon_detail_adapter = new CartoonDetailAdapter(list,sharedPreferences,cartoonId);
        cartoon_detail_recyclerView.setAdapter(cartoon_detail_adapter);

        back = (ImageView)findViewById(R.id.cartoon_detail_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        CartoonDao.getCartoonAndAuthor(cartoonId,handler);
        CartoonDao.getCartoonRole(cartoonId,handler);
        CartoonDao.getCartoonLikeAndCollect(sharedPreferences.getString("userId","0"),cartoonId,handler);
    }

}
