package com.spring.basic.constructorinjection;

import org.junit.jupiter.api.Test;

public class ConstructorInjectioinTest {

    @Test
    void createTest () {
        ConstructorInjection constructorInjection = new ConstructorInjection(new TestImpl());
        constructorInjection.testMethod();

    }
}
