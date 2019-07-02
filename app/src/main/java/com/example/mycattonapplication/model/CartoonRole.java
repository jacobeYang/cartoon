package com.example.mycattonapplication.model;

import com.example.mycattonapplication.utils.HttpUtil;

public class CartoonRole {
    private String id;

    private String roleName;

    private String roleImageId;

    private String cartoonId;

    public String getCartoonId() {
        return cartoonId;
    }

    public void setCartoonId(String cartoonId) {
        this.cartoonId = cartoonId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getRoleImageId() {
        return HttpUtil.basePath+roleImageId;
    }

    public void setRoleImageId(String roleImageId) {
        this.roleImageId = roleImageId == null ? null : roleImageId.trim();
    }
}