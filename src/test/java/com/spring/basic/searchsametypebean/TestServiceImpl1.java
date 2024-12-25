package com.spring.basic.searchsametypebean;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@MainServiceAnnotation
public class TestServiceImpl1 implements TestService {
    @Override
    public void test() {
        System.out.println("TestServiceImpl1");
    }
}
