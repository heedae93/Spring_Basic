package com.spring.basic.constructorinjection;

import org.springframework.beans.factory.annotation.Autowired;

public class ConstructorInjection  {

    private  final TestInterface testInterface;

    public ConstructorInjection(TestInterface testInterface) {
        this.testInterface = testInterface;
    }


//    public void setTestInterface(TestInterface testInterface) {
//        this.testInterface = testInterface;
//    }


    public void testMethod() {
        System.out.println("ConstructorInjection.testMethod()");
        testInterface.testMethod();
    }
}
