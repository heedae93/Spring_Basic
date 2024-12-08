package com.spring.basic.discount;

import com.spring.basic.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
