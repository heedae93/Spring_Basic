package com.spring.basic;

import com.spring.basic.discount.DiscountPolicy;
import com.spring.basic.discount.FixDiscountPolicy;
import com.spring.basic.member.MemberRepository;
import com.spring.basic.member.MemberService;
import com.spring.basic.member.MemberServiceImpl;
import com.spring.basic.member.MemoryMemberRepository;
import com.spring.basic.order.OrderService;
import com.spring.basic.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}
