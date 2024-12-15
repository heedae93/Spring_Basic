package com.spring.basic.singleton;

public class SingleToneService {

    // static 영역에 객체를 딱 1개만 생성
    private static final SingleToneService instance = new SingleToneService();

    // public으로 열어서 객체 인스턴스가 필요하면 이 static 메서드를 통해서만 조회하도록 허용, 이 메서드를 호출하면 항상 같은 인스턴스 반환
    public static SingleToneService getInstance() {
        return instance;
    }

    // 생성자를 private로 선언해서 외부에서 new 키워드를 사용한 객체 생성을 못하게 막음
    private SingleToneService() {
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
