package com.spring.basic.singleton;

import com.spring.basic.AppConfig;
import com.spring.basic.member.MemberRepository;
import com.spring.basic.member.MemberServiceImpl;
import com.spring.basic.order.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletoneTest {

    @Test
    void configurationDeep() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberRepository memberRepository = ac.getBean(MemberServiceImpl.class).getMemberRepository();
        MemberRepository memberRepository1 = ac.getBean(OrderServiceImpl.class).getMemberRepository();

        // 객체가 2개 생성되어 참조값이 다를것 같았지만 참조값이 같은 것을 볼 수 있다.
        System.out.println("memberRepository1 = " + memberRepository1); // com.spring.basic.member.MemoryMemberRepository@389adf1d
        System.out.println("memberRepository = " + memberRepository); // com.spring.basic.member.MemoryMemberRepository@389adf1d
    }
}
