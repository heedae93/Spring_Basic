package com.spring.basic.order;

import com.spring.basic.discount.DiscountPolicy;
import com.spring.basic.member.Member;
import com.spring.basic.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;



    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // 싱글톤 테스트용 메서드
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
