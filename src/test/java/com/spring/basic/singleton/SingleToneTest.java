package com.spring.basic.singleton;

import com.spring.basic.AppConfig;
import com.spring.basic.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingleToneTest {


    @Test
    @DisplayName("스프링 없는 순순한 di 컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();

        // 1. 조회: 호출할 때 마다 객체를 생성
        MemberService memberService1 = appConfig.memberService();

        // 2. 조회: 호출할 때 마다 객체를 생성
        MemberService memberService2 = appConfig.memberService();

        // 3. 참조값이 다른 것을 확인
        System.out.println("memberService1 = " + memberService1); // memberService1 = com.spring.basic.member.MemberServiceImpl@7857fe2
        System.out.println("memberService2 = " + memberService2); // memberService2 = com.spring.basic.member.MemberServiceImpl@7eecb5b8
        Assertions.assertThat(memberService1).isNotSameAs(memberService2);
    }


    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest() {

        // private으로 생성자를 막아두어서 new로 생성 불가하다, 따라서 만들어 둔 getInstance() 메서드를 통해서만 객체를 생성할 수 있다.
        SingleToneService singleToneService1 = SingleToneService.getInstance();
        SingleToneService singleToneService2 = SingleToneService.getInstance();

        // 아래 출력 결과를 보면 참조값이 같은 것을 볼 수 있다.
        System.out.println("singleToneService1 = " + singleToneService1); // com.spring.basic.singleton.SingleToneService@7eecb5b8
        System.out.println("singleToneService2 = " + singleToneService2); // com.spring.basic.singleton.SingleToneService@7eecb5b8

        Assertions.assertThat(singleToneService1).isSameAs(singleToneService2);
    }

}
