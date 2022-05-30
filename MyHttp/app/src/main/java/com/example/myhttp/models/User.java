package com.example.myhttp.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {
    //jsonschema2pojo에서 편하게 만들 수있다.
    @SerializedName("userId")
    @Expose
    public Integer userId;
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("body")
    @Expose
    public String body;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}