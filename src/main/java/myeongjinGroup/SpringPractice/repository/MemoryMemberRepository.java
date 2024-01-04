package myeongjinGroup.SpringPractice.repository;

import myeongjinGroup.SpringPractice.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store =  new HashMap<>();
    private static long sequence = 0L; // key 값을 0,1,2 ... 생성해주는 얘

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
        //null값이 나왔을때 처리하기 위해서 옵셔널로 감싼다
    }

    @Override
    public Optional<Member> findByname(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
