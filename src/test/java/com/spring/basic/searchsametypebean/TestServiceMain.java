package com.spring.basic.searchsametypebean;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
public class TestServiceMain {

    private final TestService testService;


    // 아래 처럼 testServiceImpl2는 빈으로 등록될 때 첫글자가 소문자로 등록이 되므로
    // 아래 처럼 매개변수를 받으면 TestService 타입으로 등록된 빈 중에서
    // testServiceImpl2를 찾아서 주입해준다.
    // 이것은 @Autowired의 기능인데 아래 코드는 생성자가 하나라서 생략이 된것.

//    public TestServiceMain(TestService testServiceImpl2) {
//        this.testService = testServiceImpl2;
//    }


    // 아래 처럼 @Qualifier를 사용하면 @Qualifier에 지정한 이름과 같은 이름을 가진 빈을 찾아서 주입해준다.
    public TestServiceMain(@Qualifier("testServiceImpl1") TestService testService) {
        this.testService = testService;
        System.out.println(testService);
    }
}
