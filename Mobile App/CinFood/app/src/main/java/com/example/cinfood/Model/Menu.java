package com.example.cinfood.Model;

import com.google.gson.annotations.SerializedName;

public class Menu {
    @SerializedName("id")
    private Integer id;

    @SerializedName("postid")
    private Integer postid;

    @SerializedName("catid")
    private Integer catid;

    @SerializedName("normalprice")
    private Integer normalprice;

    @SerializedName("discountprice")
    private Integer discountprice;

    @SerializedName("title")
    private String title;

    @SerializedName("time")
    private Integer time;

    @SerializedName("options")
    private String options;

    @SerializedName("picture")
    private String picture;

    @SerializedName("moreimages")
    private String moreimages;

    @SerializedName("content")
    private String content;

    public Menu(
            Integer id, Integer postid, Integer catid,
            Integer normalprice, Integer discountprice,
            Integer time, String title, String options,
            String picture, String moreimages, String content){
        this.id = id;
        this.postid = postid;
        this.catid = catid;
        this.normalprice = normalprice;
        this.discountprice = discountprice;
        this.title = title;
        this.time = time;
        this.options = options;
        this.picture = picture;
        this.moreimages = moreimages;
        this.content = content;
    }

    public Integer getId() { return  getId(); }

    public Integer getNormalprice() {
        return normalprice;
    }

    public Integer getDiscountprice() {
        return discountprice;
    }

    public String getTitle() {
        return title;
    }

    public String getPicture() {
        return picture;
    }

    public String getContent() {
        return content;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNormalprice(Integer normalprice) {
        this.normalprice = normalprice;
    }

    public void setDiscountprice(Integer discountprice) {
        this.discountprice = discountprice;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", postid=" + postid +
                ", catid=" + catid +
                ", normalprice=" + normalprice +
                ", discountprice=" + discountprice +
                ", title='" + title + '\'' +
                ", time=" + time +
                ", options='" + options + '\'' +
                ", picture='" + picture + '\'' +
                ", moreimages='" + moreimages + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
