package com.example.retrofit3;

public class User {

    private String userName;
    private String userId;
    private String telNum;
    private String address;

    private User() {
    }

    public static class Builder {
        private String userName;
        private String userId;
        private String telNum;
        private String address;

        public Builder setUserName(String userName){
            this.userName = userName;
            return this;
        }
        public Builder setUserId(String userId){
            this.userId = userId;
            return this;
        }
        public Builder setTelNum(String telNum){
            this.telNum = telNum;
            return this;
        }
        public Builder setAddress(String address){
            this.address = address;
            return this;
        }

        public User build(){
            User user = new User();
            user.userName = userName;
            user.userId = userId;
            user.address = address;
            user.telNum = telNum;
            return user;
        }


    }

    public static void main(String[] args) {
        User user = new Builder()
                        .setUserName("sample")
                        .setUserId("sample12")
                        .setTelNum("sdfsd")
                        .setAddress("sdfsdfsdsd")
                        .build();
    }
}
