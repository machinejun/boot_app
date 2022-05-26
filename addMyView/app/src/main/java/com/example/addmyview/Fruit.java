package com.example.addmyview;

import java.util.ArrayList;

public class Fruit {
    String imageUrl;
    String name;
    String price;
    String count;

    public Fruit(String imageUrl, String name, String price, String count) {
        this.imageUrl = imageUrl;
        this.name = name;
        this.price = String.format("%s$",price);
        this.count = String.format("%s개",count);;
    }
    
    // 샘플 데이터 만들어보기

    public static ArrayList<Fruit> getFruits(){
        ArrayList<Fruit> fruits = new ArrayList<Fruit>();
        fruits.add(new Fruit("https://cdn.pixabay.com/photo/2013/07/12/19/18/watermelon-154510__480.png","수박","10000", "5"));
        fruits.add(new Fruit("https://cdn.pixabay.com/photo/2021/02/10/16/48/melon-6002760__340.jpg","참외","3000", "2"));
        fruits.add(new Fruit("https://cdn.pixabay.com/photo/2014/12/21/23/25/apples-575317__340.png","사과","2000", "3"));
        fruits.add(new Fruit("https://cdn.pixabay.com/photo/2012/04/05/00/32/lemon-25342__340.png","레몬","2500", "1"));


        return fruits;
    }
}
