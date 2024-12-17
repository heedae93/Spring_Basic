package com.spring.basic.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@Component
public class MemoryMemberRepository implements MemberRepository {


    private static Map<Long, Member> store = new ConcurrentHashMap<>();


    public void save(Member member) {
        store.put(member.getId(), member);
    }

    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
