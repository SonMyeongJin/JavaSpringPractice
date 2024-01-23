package myeongjinGroup.SpringPractice.repository;

import myeongjinGroup.SpringPractice.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    @Override
    Optional<Member> findByname(String name);
}
