package com.example.mycattonapplication.activity.cartoonDetail;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.example.mycattonapplication.R;
import com.example.mycattonapplication.model.CartoonDetail;
import com.example.mycattonapplication.model.Remark;
import com.example.mycattonapplication.model.RemarkRecyclerView;
import com.example.mycattonapplication.model.Remark_input;
import com.example.mycattonapplication.model.Word;
import com.example.mycattonapplication.model.WordTitleRecyclerView;
import java.util.ArrayList;
import java.util.List;
public class CartoonDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Object> list = null;
    private Context myContext;

    private static final int TYPE_DETAIL = 0;
    private static final int TYPE_REMARK_RECYCLER_VIEW = 1;
    private static final int TYPE_REMARK_INPUT = 2;
    private static final int TYPE_TITLE_RECYCLER_VIEW = 3;

    public CartoonDetailAdapter(List<Object> word_list){
        this.list = word_list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(myContext == null){
            myContext = parent.getContext();
        }

        if(viewType == TYPE_DETAIL){
            View view = LayoutInflater.from(myContext).inflate(R.layout.detail_item, parent, false);
            return new DetailViewHolder(view);
        }else if(viewType == TYPE_REMARK_RECYCLER_VIEW){
            View view = LayoutInflater.from(myContext).inflate(R.layout.remark_recycler_view, parent, false);
            return new RemarkRecyclerViewHolder(view);
        }else if(viewType == TYPE_REMARK_INPUT){
            View view = LayoutInflater.from(myContext).inflate(R.layout.remark_inpit, parent, false);
            return new RemarkInputViewHolder(view);
        }else if(viewType == TYPE_TITLE_RECYCLER_VIEW){
            View view = LayoutInflater.from(myContext).inflate(R.layout.word_title_recycler_view, parent, false);
            return new WordTitleRecyclerViewHolder(view);
        }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Object object = list.get(position);
        if(object instanceof CartoonDetail){
            final DetailViewHolder detailViewHolder = (DetailViewHolder)holder;
            final CartoonDetail cartoonDetail = (CartoonDetail)object;
            Glide.with(myContext).load(cartoonDetail.getCartoon_image()).centerCrop().into(detailViewHolder.cartoon_detail_image);
            Glide.with(myContext).load(cartoonDetail.getCartoon_author_image()).transform(new CenterCrop(myContext),new GlideRoundImage(myContext)).into(detailViewHolder.cartoon_detail_author_image);
            Glide.with(myContext).load(cartoonDetail.getCartoon_role1_image()).transform(new CenterCrop(myContext),new GlideRoundImage(myContext)).into(detailViewHolder.cartoon_detail_role1_image);
            Glide.with(myContext).load(cartoonDetail.getCartoon_role2_image()).transform(new CenterCrop(myContext),new GlideRoundImage(myContext)).into(detailViewHolder.cartoon_detail_role2_image);
            if(cartoonDetail.isFlag_collection()){
                Glide.with(myContext).load(R.mipmap.collection).centerCrop().into(detailViewHolder.cartoon_detail_collect);
                detailViewHolder.detail_item_collect_text.setTextColor(myContext.getResources().getColor(R.color.my_primary));
            }else{
                Glide.with(myContext).load(R.mipmap.collectionwhite).centerCrop().into(detailViewHolder.cartoon_detail_collect);
                detailViewHolder.detail_item_collect_text.setTextColor(myContext.getResources().getColor(R.color.my_primary_white));
            }
           if(cartoonDetail.isFlag_like()){
               Glide.with(myContext).load(R.mipmap.like1).centerCrop().into(detailViewHolder.cartoon_detail_like);
               detailViewHolder.detail_item_like_text.setTextColor(myContext.getResources().getColor(R.color.my_primary));
           }else{
               Glide.with(myContext).load(R.mipmap.like1white).centerCrop().into(detailViewHolder.cartoon_detail_like);
               detailViewHolder.detail_item_like_text.setTextColor(myContext.getResources().getColor(R.color.my_primary_white));
           }

            detailViewHolder.cartoon_detail_cartoon_name.setText(cartoonDetail.getCartoon_name());
            detailViewHolder.cartoon_detail_author_name.setText(cartoonDetail.getCartoon_author());
            detailViewHolder.cartoon_detail_role1_name.setText(cartoonDetail.getCartoon_role1());
            detailViewHolder.cartoon_detail_role2_name.setText(cartoonDetail.getCartoon_role2());
            detailViewHolder.cartoon_detail_brief.setText(cartoonDetail.getCartoon_brief());

            detailViewHolder.cartoon_detail_collect.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(cartoonDetail.isFlag_collection()){
                        //取消收藏
                        Glide.with(myContext).load(R.mipmap.collectionwhite).centerCrop().into(detailViewHolder.cartoon_detail_collect);
                        cartoonDetail.setFlag_collection(false);
                        detailViewHolder.detail_item_collect_text.setTextColor(myContext.getColor(R.color.my_primary_white));

                    }else{
                        //收藏
                        Glide.with(myContext).load(R.mipmap.collection).centerCrop().into(detailViewHolder.cartoon_detail_collect);
                        cartoonDetail.setFlag_collection(true);
                        detailViewHolder.detail_item_collect_text.setTextColor(myContext.getColor(R.color.my_primary));

                    }
                    //修改数据库内容


                }
            });
            detailViewHolder.cartoon_detail_like.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(cartoonDetail.isFlag_like()){
                        //取消赞
                        Glide.with(myContext).load(R.mipmap.like1white).centerCrop().into(detailViewHolder.cartoon_detail_like);
                        detailViewHolder.detail_item_like_text.setTextColor(myContext.getResources().getColor(R.color.my_primary_white));
                        cartoonDetail.setFlag_like(false);
                    }else{
                        //赞
                        Glide.with(myContext).load(R.mipmap.like1).centerCrop().into(detailViewHolder.cartoon_detail_like);
                        detailViewHolder.detail_item_like_text.setTextColor(myContext.getResources().getColor(R.color.my_primary));
                        cartoonDetail.setFlag_like(true);
                    }
                    //修改数据库内容

                }
            });

        }else if(object instanceof RemarkRecyclerView){
            RemarkRecyclerViewHolder remarkRecyclerViewHolder = (RemarkRecyclerViewHolder)holder;
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(myContext);
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            remarkRecyclerViewHolder.remarkRecyclerView.setLayoutManager(linearLayoutManager);
            remarkRecyclerViewHolder.remarkRecyclerView.setAdapter(new RemarkRecyclerViewAdapter(getRemarkList()));
        }else if(object instanceof Remark_input){
            final RemarkInputViewHolder remarkInputViewHolder = (RemarkInputViewHolder)holder;

            //评价输入框监听回车时实事件
            remarkInputViewHolder.remark_input.setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    return false;
                }
            });

            //目录正序事件
            remarkInputViewHolder.up.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //判断当前是否为正序

                    //如果不是，设置为正序
                    remarkInputViewHolder.up.setImageResource(R.mipmap.up);
                    remarkInputViewHolder.down.setImageResource(R.mipmap.downwhite);
                }
            });

            //目录倒序事件
            remarkInputViewHolder.down.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //判断当前是否为倒序

                    //如果不是，设置为倒序
                    remarkInputViewHolder.up.setImageResource(R.mipmap.upwhite);
                    remarkInputViewHolder.down.setImageResource(R.mipmap.down);
                }
            });

        }else if(object instanceof WordTitleRecyclerView){
            WordTitleRecyclerViewHolder wordTitleRecyclerViewHolder = (WordTitleRecyclerViewHolder)holder;
            //WordTitleRecyclerView wordTitleRecyclerView = (WordTitleRecyclerView)list.get(position);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(myContext);
            wordTitleRecyclerViewHolder.wordTitleRecyclerView.setLayoutManager(linearLayoutManager);
            wordTitleRecyclerViewHolder.wordTitleRecyclerView.setAdapter(new WordTitleRecyclerViewAdapter(getWordList()));
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    static class DetailViewHolder extends RecyclerView.ViewHolder{
        private ImageView cartoon_detail_image;
        private ImageView cartoon_detail_like;
        private ImageView cartoon_detail_collect;
        private ImageView cartoon_detail_author_image;
        private ImageView cartoon_detail_role1_image;
        private ImageView cartoon_detail_role2_image;

        private TextView cartoon_detail_cartoon_name;
        private TextView cartoon_detail_brief;
        private TextView cartoon_detail_author_name;
        private TextView cartoon_detail_role1_name;
        private TextView cartoon_detail_role2_name;
        private TextView detail_item_like_text;
        private TextView detail_item_collect_text;


        public DetailViewHolder(View itemView) {
            super(itemView);
            cartoon_detail_image = (ImageView)itemView.findViewById(R.id.cartoon_detail_image);
            cartoon_detail_like = (ImageView)itemView.findViewById(R.id.cartoon_detail_like);
            cartoon_detail_collect = (ImageView)itemView.findViewById(R.id.cartoon_detail_collect);
            cartoon_detail_author_image = (ImageView)itemView.findViewById(R.id.cartoon_detail_author_image);
            cartoon_detail_role1_image = (ImageView)itemView.findViewById(R.id.cartoon_detail_role1_image);
            cartoon_detail_role2_image = (ImageView)itemView.findViewById(R.id.cartoon_detail_role2_image);

            cartoon_detail_cartoon_name = (TextView)itemView.findViewById(R.id.cartoon_detail_cartoon_name);
            cartoon_detail_brief = (TextView)itemView.findViewById(R.id.cartoon_detail_brief_introduction);
            cartoon_detail_author_name = (TextView)itemView.findViewById(R.id.cartoon_detail_author_name);
            cartoon_detail_role1_name = (TextView)itemView.findViewById(R.id.cartoon_detail_role1_name);
            cartoon_detail_role2_name = (TextView)itemView.findViewById(R.id.cartoon_detail_role2_name);
            detail_item_like_text = (TextView)itemView.findViewById(R.id.detail_item_like_text);
            detail_item_collect_text = (TextView)itemView.findViewById(R.id.cartoon_detail_collect_text);
        }
    }

    static class RemarkRecyclerViewHolder extends RecyclerView.ViewHolder{
        RecyclerView remarkRecyclerView;

        public RemarkRecyclerViewHolder(View itemView) {
            super(itemView);
            remarkRecyclerView = (RecyclerView)itemView.findViewById(R.id.remark_recycler_view);
        }
    }

    static class RemarkInputViewHolder extends  RecyclerView.ViewHolder{
        private TextView remark_input;
        private ImageView up;
        private ImageView down;
        private TextView cartoon_detail_update_msg;

        public RemarkInputViewHolder(View itemView) {
            super(itemView);
            remark_input = (EditText)itemView.findViewById(R.id.remark_input);
            up = (ImageView)itemView.findViewById(R.id.remark_input_up);
            down = (ImageView)itemView.findViewById(R.id.remark_input_down);
            cartoon_detail_update_msg =(TextView)itemView.findViewById(R.id.cartoon_detail_update_msg);

        }
    }


    static class WordTitleRecyclerViewHolder extends RecyclerView.ViewHolder{
        private RecyclerView wordTitleRecyclerView;
        public WordTitleRecyclerViewHolder(View itemView) {
            super(itemView);
            wordTitleRecyclerView = (RecyclerView)itemView.findViewById(R.id.word_title_recycle_view);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(list.get(position) instanceof CartoonDetail){
            return TYPE_DETAIL;
        }else if(list.get(position) instanceof RemarkRecyclerView){
            return TYPE_REMARK_RECYCLER_VIEW;
        }else if(list.get(position) instanceof Remark_input){
            return TYPE_REMARK_INPUT;
        }else if(list.get(position) instanceof WordTitleRecyclerView){
            return TYPE_TITLE_RECYCLER_VIEW;
        }

        return  0;
    }

    public  List<Remark> getRemarkList(){
        List<Remark> remarkList = new ArrayList<Remark>();
        Remark remark = new Remark();
        remark.setId("2132");
        remark.setRemark_content("很喜欢漫画主角的都比形象。");
        remark.setRemark_time("2019.06.15");
        remark.setRemark_user_name("星辰大海");
        remark.setRemark_user_image(R.mipmap.a3);

        remarkList.add(remark);
        remarkList.add(remark);
        remarkList.add(remark);
        remarkList.add(remark);
        remarkList.add(remark);
        remarkList.add(remark);

        return remarkList;
    }


    public  List<Word> getWordList(){
        List<Word> wordList = new ArrayList<Word>();
        Word word = new Word();
        word.setWord_number("第一话");
        word.setWord_name("序章");

        wordList.add(word);
        wordList.add(word);
        wordList.add(word);
        wordList.add(word);
        wordList.add(word);
        wordList.add(word);

        return wordList;
    }



}
