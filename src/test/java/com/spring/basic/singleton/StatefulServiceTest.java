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

        int userAPrice =  statefulService1.order("userA", 10000);
        int userBPrice =  statefulService2.order("userB", 20000);

        System.out.println("userAPrice = " + userAPrice); // 10000
        System.out.println("userBPrice = " + userBPrice); // 20000
    }

    static class TestConfig {
        private int price; // 상태를 유지하는 필드

        @Bean
        public StatefulService statefulService () {
            return new StatefulService();
        }
    }

}