package com.example.retrofit3;

public class Car {
    private String name;
    private String carNumber;
    private String carColor;
    private Company Company;

    private static class Builder {
        private String name;
        private String carNumber;
        private String carColor;
        private Company company;

        public Builder setName(String name){
            this.name = name;
            return this;
        }

        public Builder setCarNumber(String carNumber){
            this.carNumber = carNumber;
            return this;
        }

        public Builder setCarColor(String carColor){
            this.carColor = carColor;
            return this;
        }
        public Builder setCompany(Company company){
            this.company = company;
            return this;
        }

        public Car build(){
            Car car = new Car();
            car.name = name;
            car.carNumber = carNumber;
            car.carColor = carColor;
            car.Company = company;
            return car;
        }

    }

    public static void main(String[] args) {
        Car car = new Builder()
                    .setCompany(new Company("현대","울산"))
                    .setName("소나타")
                    .build();
    }

}
