package com.spring.basic.searchsametypebean;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class TestServiceMain {

    private final TestService testService;

    public TestServiceMain(TestService testService) {
        this.testService = testService;
    }
}
