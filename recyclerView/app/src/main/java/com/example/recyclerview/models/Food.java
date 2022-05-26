package com.example.recyclerview.models;

import java.util.ArrayList;

public class Food {

    private String thumbnail;
    private String title;
    private String subTitle;
    private String detail;

    public Food(String thumbnail, String title, String subTitle, String detail) {
        this.thumbnail = thumbnail;
        this.title = title;
        this.subTitle = subTitle;
        this.detail = detail;
    }


    public static ArrayList<Food> getSampleData(){
        ArrayList<Food> foods = new ArrayList<Food>();
        foods.add(new Food("https://cdn.pixabay.com/photo/2013/07/12/19/18/watermelon-154510__480.png","Food1","subTitle1","detail1"));
        foods.add(new Food("https://cdn.pixabay.com/photo/2013/07/12/19/18/watermelon-154510__480.png","Food2","subTitle1","detail1"));
        foods.add(new Food("https://cdn.pixabay.com/photo/2013/07/12/19/18/watermelon-154510__480.png","Food3","subTitle1","detail1"));
        foods.add(new Food("https://cdn.pixabay.com/photo/2013/07/12/19/18/watermelon-154510__480.png","Food4","subTitle1","detail1"));
        foods.add(new Food("https://cdn.pixabay.com/photo/2013/07/12/19/18/watermelon-154510__480.png","Food5","subTitle1","detail1"));
        foods.add(new Food("https://cdn.pixabay.com/photo/2013/07/12/19/18/watermelon-154510__480.png","Food6","subTitle1","detail1"));
        foods.add(new Food("https://cdn.pixabay.com/photo/2013/07/12/19/18/watermelon-154510__480.png","Food7","subTitle1","detail1"));
        foods.add(new Food("https://cdn.pixabay.com/photo/2013/07/12/19/18/watermelon-154510__480.png","Food8","subTitle1","detail1"));
        foods.add(new Food("https://cdn.pixabay.com/photo/2013/07/12/19/18/watermelon-154510__480.png","Food9","subTitle1","detail1"));
        foods.add(new Food("https://cdn.pixabay.com/photo/2013/07/12/19/18/watermelon-154510__480.png","Food10","subTitle1","detail1"));
        foods.add(new Food("https://cdn.pixabay.com/photo/2013/07/12/19/18/watermelon-154510__480.png","Food11","subTitle1","detail1"));
        foods.add(new Food("https://cdn.pixabay.com/photo/2013/07/12/19/18/watermelon-154510__480.png","Food12","subTitle1","detail1"));
        foods.add(new Food("https://cdn.pixabay.com/photo/2013/07/12/19/18/watermelon-154510__480.png","Food13","subTitle1","detail1"));
        foods.add(new Food("https://cdn.pixabay.com/photo/2013/07/12/19/18/watermelon-154510__480.png","Food14","subTitle1","detail1"));
        foods.add(new Food("https://cdn.pixabay.com/photo/2013/07/12/19/18/watermelon-154510__480.png","Food15","subTitle1","detail1"));
        foods.add(new Food("https://cdn.pixabay.com/photo/2013/07/12/19/18/watermelon-154510__480.png","Food16","subTitle1","detail1"));
        return foods;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
