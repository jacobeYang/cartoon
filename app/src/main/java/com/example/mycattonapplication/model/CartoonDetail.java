package com.example.mycattonapplication.model;

public class CartoonDetail {
   private Cartoon cartoon;
   private CartoonRole cartoonRole1;
   private CartoonRole cartoonRole2;
   private boolean flag_like;
   private boolean flag_collection;

    public boolean isFlag_like() {
        return flag_like;
    }

    public void setFlag_like(boolean flag_like) {
        this.flag_like = flag_like;
    }

    public boolean isFlag_collection() {
        return flag_collection;
    }

    public void setFlag_collection(boolean flag_collection) {
        this.flag_collection = flag_collection;
    }

    public Cartoon getCartoon() {
        return cartoon;
    }

    public void setCartoon(Cartoon cartoon) {
        this.cartoon = cartoon;
    }

    public CartoonRole getCartoonRole1() {
        return cartoonRole1;
    }

    public void setCartoonRole1(CartoonRole cartoonRole1) {
        this.cartoonRole1 = cartoonRole1;
    }

    public CartoonRole getCartoonRole2() {
        return cartoonRole2;
    }

    public void setCartoonRole2(CartoonRole cartoonRole2) {
        this.cartoonRole2 = cartoonRole2;
    }
}
