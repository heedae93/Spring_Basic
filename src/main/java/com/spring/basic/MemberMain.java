package com.spring.basic;

import com.spring.basic.member.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberMain {
    public static void main(String[] args) {
        //AppConfig appConfig = new AppConfig();
        //MemberService memberService = appConfig.memberService();

        /**
         * spring은 ApplicationContext라는 곳에서 시작 한다. 이것이 스프링 컨테이너이다. 여기서 모든 객체들을 관리한다.
         * AnnotationConfigApplicationContext는 AppConfig에 있는 설정 정보를 가지고 spring 컨테이너에 객체를 생성하고 관리한다.
         * applicationContext.getBean("memberService", MemberService.class) : memberService라는 이름으로 MemberService.class 타입을 찾아서 반환한다.
         */
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findMember.getName());
    }
}
