package com.spring.basic.singleton;

public class StatefulService {

        // 기존의 필드를 제거하고
        // private int price;

        public int order(String name, int price) {
            System.out.println("name = " + name + " price = " + price);
            //this.price = price;
            return price;
        }

//        public int getPrice() {
//            return price;
//        }
}
