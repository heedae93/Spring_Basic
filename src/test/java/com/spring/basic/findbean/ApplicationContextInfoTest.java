package com.spring.basic.findbean;

import com.spring.basic.AppConfig;
import com.spring.basic.discount.DiscountPolicy;
import com.spring.basic.discount.FixDiscountPolicy;
import com.spring.basic.discount.RateDiscountPolicy;
import com.spring.basic.member.MemberRepository;
import com.spring.basic.member.MemoryMemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    AnnotationConfigApplicationContext ac2 = new AnnotationConfigApplicationContext(SameBeanConfig.class);
    AnnotationConfigApplicationContext ac3 = new AnnotationConfigApplicationContext(extendsConfig.class);
    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("name = " + beanDefinitionName + " object = " + bean);
        }
    }

    @Test
    @DisplayName("애클리케이션 빈 출력하기")
    void findApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            // ROLE_APPLICATION : 직접 등록한 애플리케이션 빈
            // ROLE_INFRASTRUCTURE : 스프링이 내부에서 사용하는 빈
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("name = " + beanDefinitionName + " object = " + bean);
            }
        }

    }


    @Test
    @DisplayName("등록 되지 않은 빈 이름으로 출력하기")
    void findUnregisteredBean() {
        // assertThrows를 사용하면 지정한 예와가 발생했을 때 테스트가 통과되는 것.
        assertThrows(NoSuchBeanDefinitionException.class, () -> ac.getBean("unregisteredBean"));

    }


    @Test
    @DisplayName("타입이 같은 빈이 2개 이상 등록되어 있을 때, 타입으로 빈을 조회하면 중복 오류가 발생한다.")
    void findDuplicatedBean() {
        assertThrows(NoUniqueBeanDefinitionException.class, () -> ac2.getBean(MemberRepository.class));
    }

    @Test
    @DisplayName("타입이 같은 빈이 2개 이상 등록되어 있을 때, 빈 이름을 지정하여 빈을 조회하면 중복 오류가 발생하지 않는다.")
    void findDuplicatedBeanByName() {
        MemberRepository memberRepository1 = ac2.getBean("memberRepository1", MemberRepository.class);
        assertThat(memberRepository1).isInstanceOf(MemberRepository.class);
    }

    @Test
    @DisplayName("타입이 같은 빈들도 등록된 이름은 다르기 때문에 특정 타입을 모두 조회해 볼 수도 있다.")
    void findAllSameTypeBeans() {
       Map<String, MemberRepository> beanDefinitionNames = ac2.getBeansOfType(MemberRepository.class);
         for (String key : beanDefinitionNames.keySet()) {
              System.out.println("key = " + key + " value = " + beanDefinitionNames.get(key));
         }

         assertThat(beanDefinitionNames.size()).isEqualTo(2);
    }


    @Test
    @DisplayName("부모타입으로 조회시 자식이 둘 이상이면 중복 오류가 발생한다.")
    void findBeanByParentType() {
        DiscountPolicy bean = ac3.getBean(DiscountPolicy.class);
        assertThrows(NoUniqueBeanDefinitionException.class, () -> ac3.getBean(DiscountPolicy.class));
    }

    @Test
    @DisplayName("부모타입으로 조회시 자식이 둘 이상이면 중복 오류가 발생한다. 그러나 빈 이름을 지정하면 중복 오류가 발생하지 않는다.")
    void findBeanByParentType2() {
        DiscountPolicy rateDiscountPolicy = ac3.getBean("rateDiscountPolicy",DiscountPolicy.class);
        assertThat(rateDiscountPolicy).isInstanceOf(RateDiscountPolicy.class);
    }

    @Test
    @DisplayName("부모타입으로 모두 조회하기")
    void findAllBeansByParentType() {
        Map<String, DiscountPolicy> beansOfType = ac3.getBeansOfType(DiscountPolicy.class);
        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key + " value = " + beansOfType.get(key));
        }
        assertThat(beansOfType.size()).isEqualTo(2);
    }


    // 아래 config는 static이 붙었기 때문에 ApplicationContextInfoTest 클래스 안에서만 사용할 수 있다.
    // findDuplicatedBean(), findDupicateBeanByName 테스트를 위해 사용된다.
    @Configuration
    static class SameBeanConfig {
        @Bean
        public MemberRepository memberRepository1() {
            return new MemoryMemberRepository();
        }

        @Bean
        public MemberRepository memberRepository2() {
            return new MemoryMemberRepository();
        }
    }


    // 아래는 상속 관계 빈 조회 테스트를 위한 구성 정보
    @Configuration
    static class extendsConfig {
        @Bean
        public DiscountPolicy rateDiscountPolicy() {
            return new RateDiscountPolicy();
        }

        @Bean
        public DiscountPolicy fixDiscountPolicy() {
            return new FixDiscountPolicy();
        }
    }
}