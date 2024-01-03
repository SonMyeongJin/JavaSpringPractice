package myeongjinGroup.SpringPractice.repository;

import myeongjinGroup.SpringPractice.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member memeber);
    Optional<Member> findById(Long id);
    Optional<Member> findByname(String name);
    List<Member> findAll();
}
