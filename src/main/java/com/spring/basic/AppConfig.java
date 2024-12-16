package com.spring.basic;

import com.spring.basic.discount.DiscountPolicy;
import com.spring.basic.discount.FixDiscountPolicy;
import com.spring.basic.member.MemberRepository;
import com.spring.basic.member.MemberService;
import com.spring.basic.member.MemberServiceImpl;
import com.spring.basic.member.MemoryMemberRepository;
import com.spring.basic.order.OrderService;
import com.spring.basic.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {


    // 스프링은 분명 싱글톤을 보장한다고 했다.
    // 하지만 아래 코드를 보면 memberService와 orderService를 호출할 때마다 memberRepository가 호출되면서 new MemoryMemberRepository()가  2번 호출된다.
    // 이러면 객체가 2개 생성이되는 건데 그러면 싱글톤이 깨지는게 아닐까?

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}
