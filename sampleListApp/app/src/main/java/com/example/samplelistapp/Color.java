package com.example.samplelistapp;

import java.util.ArrayList;

public class Color {

    private String imageUrl;
    private String name;
    private String RGBcode;
    private int favorite;

    public Color(String imageUrl,String name, String RGBcode, int favorite) {
        this.imageUrl = imageUrl;
        this.name = name;
        this.RGBcode = RGBcode;
        this.favorite = favorite;
    }


    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getRGBcode() {
        return RGBcode;
    }

    public int getFavorite() {
        return favorite;
    }

    public static ArrayList<Color> getColorData(){
        ArrayList<Color> data = new ArrayList<Color>();
        data.add(new Color("https://cdn.pixabay.com/photo/2015/05/11/14/51/heart-762564__340.jpg","빨강색", "#ff0000", 2));
        data.add(new Color("https://cdn.pixabay.com/photo/2015/08/26/17/35/water-908813__340.png","파란색", "#0000ff", 3));
        data.add(new Color("https://cdn.pixabay.com/photo/2017/07/28/14/21/macarons-2548799__340.jpg","보라색", "#800080", 1));
        data.add(new Color("https://cdn.pixabay.com/photo/2017/07/19/10/55/woman-2518758__340.png","검은색", "#000000", 2));
        data.add(new Color("https://cdn.pixabay.com/photo/2015/07/02/20/14/leaves-829513__340.jpg","초록색", "#008000", 1));

        return data;
    }
}
