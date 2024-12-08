package com.spring.basic;

import com.spring.basic.discount.FixDiscountPolicy;
import com.spring.basic.discount.RateDiscountPolicy;
import com.spring.basic.member.*;
import com.spring.basic.order.Order;
import com.spring.basic.order.OrderService;
import com.spring.basic.order.OrderServiceImpl;

public class OrderMain {
    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();


        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order = " + order);
        System.out.println("order.calculatePrice = " + order.calculatePrice());
    }
}
