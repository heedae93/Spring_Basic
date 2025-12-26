package com.spring.basic.autowired;

import com.spring.basic.member.Member;
import jakarta.annotation.Nullable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutoWiredOption () {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }


    @ComponentScan
    static class TestBean {

        // required = false로 설정하면 메서드 호출이 되지 않는다. 따라서 콘솔에 아무것도 출력되지 않을 것.
        // AutowiredMember2는 @Component가 붙지 않아 빈으로 등록되어 있지 않지만 메서드 자체가 호출되지 않기 때문에 예외가 발생하지 않는다.
        @Autowired(required = false)
        public void setNoBean1(AutowiredMember2 noBean1) {
            System.out.println("noBean1 = " + noBean1);
        }

        // Autowired는 기본값으로 required = true로 설정되어 있다. 따라서 해당 빈이 없으면 예외가 발생한다.
        // 아래 AutowiredMember2는 @Component가 붙지 않아 빈으로 등록되어 있지 않기 때문에 예외가 발생한다.
        @Autowired
        public void setNoBean2(AutowiredMember2 noBean1) {
            System.out.println("noBean1 = " + noBean1);
        }

        // @Nullable을 사용하면 해당 빈이 없으면 null로 주입된다.
        // AutowiredMember는 @Component가 붙어 빈으로 등록되어 있기 때문에 정상적으로 주입된다.
        @Autowired
        public void setNoBean3(@Nullable AutowiredMember noBean2) {
            System.out.println("noBean2 = " + noBean2);
        }

        // AutowiredMember2는 @Component가 붙지 않아 빈으로 등록되어 있지 않지만 @Nullable이 붙어 있기 때문에 null로 주입된다.
        @Autowired
        public void setNoBean4(@Nullable AutowiredMember2 noBean2) {
            System.out.println("noBean2 = " + noBean2);
        }

        // Optional을 사용하면 해당 빈이 없으면 Optional.empty로 주입된다.
        // 자바 8 이상에서 사용 가능하다.
        @Autowired
        public void setNoBean5(Optional<Member> noBean3) {
            System.out.println("noBean3 = " + noBean3);
        }
    }
}
