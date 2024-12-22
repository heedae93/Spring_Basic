package com.spring.basic.searchsametypebean;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;



@Component
@Primary
public class TestServiceImpl2 implements TestService {
    @Override
    public void test() {
        System.out.println("TestServiceImpl2");
    }

}
