package com.spring.basic.searchsametypebean;


import org.springframework.stereotype.Component;

@Component
public class TestServiceImpl1 implements TestService {
    @Override
    public void test() {
        System.out.println("TestServiceImpl1");
    }
}
