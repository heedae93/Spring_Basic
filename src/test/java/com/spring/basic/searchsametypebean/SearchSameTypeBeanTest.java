package com.spring.basic.searchsametypebean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

public class SearchSameTypeBeanTest {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TestConfig.class);

    }

    @ComponentScan(basePackages = "com.spring.basic.searchsametypebean")
    static class TestConfig {

    }
}
