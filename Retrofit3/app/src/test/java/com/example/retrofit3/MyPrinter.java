package com.example.retrofit3;

public class MyPrinter {
    private static MyPrinter myPrinter;
    private MyPrinter() {}

    public static MyPrinter getInstance(){
        if(myPrinter == null){
            myPrinter = new MyPrinter();
        }
        return myPrinter;
    }

    // 테스트 코드 작성
    public static void main(String[] args) {
        AClazz aClazz = new AClazz();
        BClazz bClazz = new BClazz();

        MyPrinter myPrinter = aClazz.myPrinter;
        MyPrinter myPrinter2 = bClazz.myPrinter;

        if(myPrinter.hashCode() == myPrinter2.hashCode()){
            System.out.println("같다.");
        }
    }
}

class AClazz {
    public MyPrinter myPrinter;

    public AClazz(){
        myPrinter = MyPrinter.getInstance();
    }
}

class BClazz {
    public  MyPrinter myPrinter;

    public BClazz() {
        myPrinter = MyPrinter.getInstance();
    }
}
