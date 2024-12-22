package com.spring.basic.searchsametypebean;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("testServiceImpl1") // 이렇게 이름을 지정해주면 TestService 타입과 함께 등록하고 싶은 이름도 지정하여 등록할 수 있다.
public class TestServiceImpl1 implements TestService {
    @Override
    public void test() {
        System.out.println("TestServiceImpl1");
    }
}
