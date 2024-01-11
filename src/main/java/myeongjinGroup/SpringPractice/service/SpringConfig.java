package myeongjinGroup.SpringPractice.service;

import myeongjinGroup.SpringPractice.domain.Member;
import myeongjinGroup.SpringPractice.repository.MemberRepository;
import myeongjinGroup.SpringPractice.repository.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService( memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
