package com.example.cinfood.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MenuModel {
    @SerializedName("id")
@Expose
private String id;
@SerializedName("postid")
@Expose
private String postid;
@SerializedName("catid")
@Expose
private String catid;
@SerializedName("normalprice")
@Expose
private String normalprice;
@SerializedName("discountprice")
@Expose
private String discountprice;
@SerializedName("title")
@Expose
private String title;
@SerializedName("time")
@Expose
private String time;
@SerializedName("options")
@Expose
private String options;
@SerializedName("picture")
@Expose
private String picture;
@SerializedName("moreimages")
@Expose
private String moreimages;
@SerializedName("content")
@Expose
private String content;

public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public String getPostid() {
return postid;
}

public void setPostid(String postid) {
this.postid = postid;
}

public String getCatid() {
return catid;
}

public void setCatid(String catid) {
this.catid = catid;
}

public String getNormalprice() {
return normalprice;
}

public void setNormalprice(String normalprice) {
this.normalprice = normalprice;
}

public String getDiscountprice() {
return discountprice;
}

public void setDiscountprice(String discountprice) {
this.discountprice = discountprice;
}

public String getTitle() {
return title;
}

public void setTitle(String title) {
this.title = title;
}

public String getTime() {
return time;
}

public void setTime(String time) {
this.time = time;
}

public String getOptions() {
return options;
}

public void setOptions(String options) {
this.options = options;
}

public String getPicture() {
return picture;
}

public void setPicture(String picture) {
this.picture = picture;
}

public String getMoreimages() {
return moreimages;
}

public void setMoreimages(String moreimages) {
this.moreimages = moreimages;
}

public String getContent() {
return content;
}

public void setContent(String content) {
this.content = content;
}

}
