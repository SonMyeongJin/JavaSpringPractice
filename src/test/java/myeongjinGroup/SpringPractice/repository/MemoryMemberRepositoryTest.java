package myeongjinGroup.SpringPractice.repository;

import myeongjinGroup.SpringPractice.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach // 다른 함수가 실행될때마다 함수가 끝나면 이 함수가 한번씩 실행됨
    public void afterEach() {
        repository.clearStore();
    }


    @Test
    public void save(){
        Member member = new Member();
        member.setName("Son Myeong Jin");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();

        //같은지 체크하는법
        System.out.println("result : "  +  (result == member)); // 비추천
        Assertions.assertEquals(member , result );
        assertThat(member).isEqualTo(result);  //자주쓴다
        }


    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("Mario");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("Ruizi");
        repository.save(member2);


        // Optional<Member> mario = repository.findByname("Mario");
        // 옵셔널 벗겨낼려면 .get() 사용해서 꺼내오면 됨

        Member result = repository.findByname("Mario").get();

        assertThat(result).isEqualTo(member1);


    }

    @Test
    public void findAll() {
        Member member = new Member();
        member.setName("SON");
        repository.save(member);

        Member member1 = new Member();
        member1.setName("KIM");
        repository.save(member1);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);

    }

}
