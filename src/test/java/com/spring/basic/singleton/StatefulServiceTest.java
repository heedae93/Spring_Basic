package com.spring.basic.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

        // 스프링은 싱글톤으로 동작하기 때문에 아래 두 객체는 참조값이 같다.
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        statefulService1.order("userA", 10000);
        statefulService2.order("userB", 20000);

        int price = statefulService1.getPrice();
        System.out.println("price = " + price);

        // userA가 주문금액을 조회했는데 2000이 나와 버린다. 기존의 값을 덮어 버린 것.
        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);
    }

    static class TestConfig {
        private int price; // 상태를 유지하는 필드

        @Bean
        public StatefulService statefulService () {
            return new StatefulService();
        }
    }

}