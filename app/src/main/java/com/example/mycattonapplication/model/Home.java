package com.example.mycattonapplication.model;

import java.util.List;

public class Home {
    MyBanner banner;
    List<Category> categoryList;
    HeadLine guessYouLike;
    List<Cartoon> guessYouLikeCartoon;
    HeadLine hotRecommend;
    List<Cartoon> hotRecommendCartoon;
    HeadLine category1;
    List<Cartoon> category1Cartoon;
    HeadLine category2;
    List<Cartoon> category2Cartoon;
    NotAnyMore notAnyMore;

    public MyBanner getBanner() {
        return banner;
    }

    public void setBanner(MyBanner banner) {
        this.banner = banner;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public HeadLine getGuessYouLike() {
        return guessYouLike;
    }

    public void setGuessYouLike(HeadLine guessYouLike) {
        this.guessYouLike = guessYouLike;
    }

    public List<Cartoon> getGuessYouLikeCartoon() {
        return guessYouLikeCartoon;
    }

    public void setGuessYouLikeCartoon(List<Cartoon> guessYouLikeCartoon) {
        this.guessYouLikeCartoon = guessYouLikeCartoon;
    }

    public HeadLine getHotRecommend() {
        return hotRecommend;
    }

    public void setHotRecommend(HeadLine hotRecommend) {
        this.hotRecommend = hotRecommend;
    }

    public List<Cartoon> getHotRecommendCartoon() {
        return hotRecommendCartoon;
    }

    public void setHotRecommendCartoon(List<Cartoon> hotRecommendCartoon) {
        this.hotRecommendCartoon = hotRecommendCartoon;
    }

    public HeadLine getCategory1() {
        return category1;
    }

    public void setCategory1(HeadLine category1) {
        this.category1 = category1;
    }

    public List<Cartoon> getCategory1Cartoon() {
        return category1Cartoon;
    }

    public void setCategory1Cartoon(List<Cartoon> category1Cartoon) {
        this.category1Cartoon = category1Cartoon;
    }

    public HeadLine getCategory2() {
        return category2;
    }

    public void setCategory2(HeadLine category2) {
        this.category2 = category2;
    }

    public List<Cartoon> getCategory2Cartoon() {
        return category2Cartoon;
    }

    public void setCategory2Cartoon(List<Cartoon> category2Cartoon) {
        this.category2Cartoon = category2Cartoon;
    }

    public NotAnyMore getNotAnyMore() {
        return notAnyMore;
    }

    public void setNotAnyMore(NotAnyMore notAnyMore) {
        this.notAnyMore = notAnyMore;
    }
}
