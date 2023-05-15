package com.revnomix.revseed.wrapper;

import java.io.Serializable;
import java.util.ArrayList;

public class SubMenuDto implements Serializable {
    private String name;
    private Integer menuId;
    private String Desc;
    private String Img;

    public SubMenuDto(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getImg() {
        return Img;
    }

    public void setImg(String img) {
        Img = img;
    }
}
