package com.example.mycattonapplication.activity.home;

import android.content.Context;
import android.content.Intent;
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
import com.example.mycattonapplication.activity.categoryDetail.CategoryDetailActivity;
import com.example.mycattonapplication.model.Cartoon;
import com.example.mycattonapplication.model.Category;
import com.example.mycattonapplication.model.HeadLine;
import com.example.mycattonapplication.model.Home;
import com.example.mycattonapplication.model.MyBanner;
import com.example.mycattonapplication.model.NotAnyMore;
import com.example.mycattonapplication.utils.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import java.util.ArrayList;
import java.util.List;


public class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE1_BANNER = 0;
    private static final int TYPE1_CATEGORY= 1;
    private static final int TYPE1_CARTOON = 2;
    private static final int TYPE1_HEADLINE = 3;
    private static final int TYPE1_NOT_ANY_MORE = 4;
    private Context myContext;
    private List<Object> list;

    public HomeAdapter(Home home){
        list = new ArrayList<Object>();
        if(home.getBanner() != null){
            list.add(home.getBanner());
            list.addAll(home.getCategoryList());
            list.add(home.getGuessYouLike());
            list.addAll(home.getGuessYouLikeCartoon());
            list.add(home.getHotRecommend());
            list.addAll(home.getHotRecommendCartoon());
            list.add(home.getCategory1());
            list.addAll(home.getCategory1Cartoon());
            list.add(home.getCategory2());
            list.addAll(home.getCategory2Cartoon());
            list.add(home.getNotAnyMore());
        }
    }

    static class CartoonItemViewHolder extends RecyclerView.ViewHolder{
        LinearLayout cardView = null;
        TextView cartoon_name =null;
        TextView author_name = null;
        ImageView imageView = null;
        LinearLayout ll_cartoon = null;

        public CartoonItemViewHolder(View itemView) {
            super(itemView);
            cardView = (LinearLayout) itemView;
            cartoon_name = itemView.findViewById(R.id.cartoon_name);
            author_name = itemView.findViewById(R.id.author_name);
            imageView = itemView.findViewById(R.id.cartoon_image);
            ll_cartoon = itemView.findViewById(R.id.ll_cartoon);
        }
    }

    static class HeadLineItemViewHolder extends  RecyclerView.ViewHolder{
        TextView category_name = null;
        TextView detail = null;

        public HeadLineItemViewHolder(View itemView) {
            super(itemView);
            category_name = itemView.findViewById(R.id.headline_category_name);
            detail = itemView.findViewById(R.id.headline_detail);
        }
    }

    static class CategoryItemViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView = null;
        TextView textView = null;
        LinearLayout categoryItem;
        public CategoryItemViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.home_category_item_image);
            textView = itemView.findViewById(R.id.home_category_item_text);
            categoryItem = itemView.findViewById(R.id.home_category_item);
        }
    }

    static class BannerViewHolder extends RecyclerView.ViewHolder{
        Banner banner = null;
        public BannerViewHolder(View itemView) {
            super(itemView);
            banner = itemView.findViewById(R.id.banner);
        }
    }


    static class NotAnyMoreViewHolder extends RecyclerView.ViewHolder{

        public NotAnyMoreViewHolder(View itemView) {
            super(itemView);
        }
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        if (myContext == null) {
            myContext = parent.getContext();
        }
        if(viewType == TYPE1_CARTOON) {
            View view = LayoutInflater.from(myContext).inflate(R.layout.cartoon_item, parent, false);
            return new CartoonItemViewHolder(view);
        }else if(viewType == TYPE1_HEADLINE){//viewType == TYPE1_HEADLINE
            View view = LayoutInflater.from(myContext).inflate(R.layout.headline_item, parent, false);
            return new HeadLineItemViewHolder(view);
        }else if(viewType == TYPE1_CATEGORY){
            View view = LayoutInflater.from(myContext).inflate(R.layout.home_category_item, parent, false);
            return new CategoryItemViewHolder(view);
        }else if(viewType == TYPE1_BANNER){
            View view = LayoutInflater.from(myContext).inflate(R.layout.home_banner, parent, false);
            return new BannerViewHolder(view);
        }else if(viewType == TYPE1_NOT_ANY_MORE){
            View view = LayoutInflater.from(myContext).inflate(R.layout.not_any_more, parent, false);
            return new NotAnyMoreViewHolder(view);
        }

        return null;
    }


    @Override
    public void onBindViewHolder( RecyclerView.ViewHolder holder, final int position) {

        if(holder instanceof CartoonItemViewHolder){
            final Cartoon cartoon = (Cartoon) list.get(position);
            CartoonItemViewHolder cartoonItemViewHolder = (CartoonItemViewHolder)holder;
            cartoonItemViewHolder.cartoon_name.setText(cartoon.getCartoonName());
            cartoonItemViewHolder.author_name.setText(cartoon.getAuthor().getAuthorName());
            Glide.with(myContext).load(cartoon.getImageId()).centerCrop().into(cartoonItemViewHolder.imageView);
            cartoonItemViewHolder.ll_cartoon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(myContext, CartoonDetailActivity.class);
                    intent.putExtra("cartoonId",cartoon.getId());
                    myContext.startActivity(intent);
                }
            });
        }else if(holder instanceof HeadLineItemViewHolder){
            final HeadLine headLine = (HeadLine)list.get(position);
            HeadLineItemViewHolder headLineItemViewHolder = (HeadLineItemViewHolder)holder;
            headLineItemViewHolder.category_name.setText(headLine.getName());
            headLineItemViewHolder.detail.setText(headLine.getMore());
            headLineItemViewHolder.detail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(myContext, CategoryDetailActivity.class);
                    intent.putExtra("categoryId",headLine.getCategoryId());
                    intent.putExtra("categoryName",headLine.getName());
                    myContext.startActivity(intent);
                }
            });
        }else if(holder instanceof CategoryItemViewHolder){
            final Category category = (Category)list.get(position);
            CategoryItemViewHolder categoryItemViewHolder = (CategoryItemViewHolder)holder;
            categoryItemViewHolder.textView.setText(category.getCategoryName());
            Glide.with(myContext).load(category.getIconId()).into(categoryItemViewHolder.imageView);
            categoryItemViewHolder.categoryItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(myContext, CategoryDetailActivity.class);
                    intent.putExtra("categoryId",category.getId());
                    intent.putExtra("categoryName",category.getCategoryName());
                    myContext.startActivity(intent);
                }
            });
        }else if(holder instanceof BannerViewHolder){
            BannerViewHolder bannerViewHolder = (BannerViewHolder)holder;

            MyBanner banner = (MyBanner)list.get(position);
            List<String> imagelist = new ArrayList<String>();
            final List<Cartoon> cartoonList = banner.getCartoonList();
            for(Cartoon cartoon:cartoonList){
                imagelist.add(cartoon.getImageId());
            }
            List<Integer> integerList = new ArrayList<Integer>();
            integerList.add(R.mipmap.a1);
            integerList.add(R.mipmap.a2);
            integerList.add(R.mipmap.a3);
            integerList.add(R.mipmap.a3);

            bannerViewHolder.banner.setImages(imagelist).setBannerStyle(BannerConfig.CIRCLE_INDICATOR)//显示风格
                    .setDelayTime(4000)
                    .setBannerAnimation(Transformer.CubeIn)//轮播动画
                    .setImageLoader(new GlideImageLoader())
                    .setIndicatorGravity(BannerConfig.CENTER)//设置指示器位置（当banner模式中有指示器时）
                    .start();

            bannerViewHolder.banner.setOnBannerListener(new OnBannerListener() {
                @Override
                public void OnBannerClick(int position) {
                    Intent intent = new Intent(myContext, CartoonDetailActivity.class);
                    intent.putExtra("cartoonId",cartoonList.get(position).getId());
                    myContext.startActivity(intent);
                }
            });

        }else{//holder instanceof NotAnyMoreViewHolder
            //不需要设置页面内容或者点击事件
            //内容也在页面写好了
        }

    }



    @Override
    public int getItemCount() {
        return list.size();
    }


    @Override
    public int getItemViewType(int position) {
        if(list.get(position) instanceof MyBanner){
            return TYPE1_BANNER;
        }else if(list.get(position) instanceof Category){
            return TYPE1_CATEGORY;
        }else if(list.get(position) instanceof HeadLine){
            return TYPE1_HEADLINE;
        }else if(list.get(position) instanceof Cartoon){
            return TYPE1_CARTOON;
        }else if(list.get(position) instanceof NotAnyMore){
            return TYPE1_NOT_ANY_MORE;
        }

        return 0;

    }

    @Override
    public void onAttachedToRecyclerView( RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
        if(manager instanceof GridLayoutManager){
            final GridLayoutManager gridLayoutManager = (GridLayoutManager)manager;
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    int type = getItemViewType(position);
                    if(type == TYPE1_HEADLINE){
                        return 12;
                    }else if (type == TYPE1_CARTOON){//type == TYPE1_CartoonItem;
                        return 4;
                    }else if(type == TYPE1_CATEGORY){
                        return 3;
                    }else if(type == TYPE1_BANNER){
                        return 12;
                    }else{//type == TYPE1_NOT_ANY_MORE
                        return 12;
                    }
                }
            });
        }
    }
}
