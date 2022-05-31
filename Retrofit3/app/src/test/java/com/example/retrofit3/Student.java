package com.example.retrofit3;

public class Student {

    private String name;
    private int grade;

    private Student() {

    }

    // 1. 내부 클래스 생성 (static (public, default, private ) - 내부 정적 클래스
    public static class MyBuilder {
        // 2-1. out class 멤버 변수를 한번 더 정의 한다. ( 단 private )
        private String name;
        private int grade;

        // 2-2. setter 메서드를 만들어 준다. (하지만 리턴 타입은 자기 자신이다. --> this)
        public MyBuilder setName(String name){
            this.name = name;
            return this;
        }

        public MyBuilder setGrade(int grade){
            this.grade = grade;
            return this;
        }
        // 3. 핵심!!
        // 리턴 타입을 out class 반환하는 메서드를 만들어 준다.
        public Student build() {
            Student student = new Student();
            student.name = name; // outer 클래스 멤버 = inner 클래스 멤버
            student.grade = grade;
            return  student;
        }

    }

    public static void main(String[] args) {
        Student student1 = new MyBuilder()
                                .setName("홍길동")
                                .build();

        Student student = new MyBuilder()
                                .setGrade(20)
                                .build();

        Student student2 = new MyBuilder()
                                .setName("이순신")
                                .setGrade(15)
                                .build();
    }

}
