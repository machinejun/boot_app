package com.example.retrofit3.models.request;

public class RequestPostDto {
    /*
        A(모바일) --> 객체를 생성 --> 서비스 로직 매개변수에 전달하는 코드를 사용
        객체를 생성해서 보내야 한다.
     */

    public String title;
    public String body;
    public Integer id;

    public RequestPostDto(String title, String body, Integer id) {
        this.title = title;
        this.body = body;
        this.id = id;
    }
}
