package com.spring.basic;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;



// @ComponentScan을 사용하면 @Component가 붙은 모든 클래스를  자동으로 스프링 빈으로 등록한다.
// 아래 filter설정은 기존의 코드를 유지하기 위해서 @Configuration이 붙은 클래스는 제외하고 컴포넌트 스캔을 하겠다는 의미이다.
// 실무적으로는 이렇게 하지 않아도 된다.
@Configuration
@ComponentScan(
        basePackages = "com.spring.member",
        basePackageClasses = AutoAppConfig.class,
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class))
public class AutoAppConfig {

}
