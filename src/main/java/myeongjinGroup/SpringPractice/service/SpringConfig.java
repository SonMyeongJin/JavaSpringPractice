package myeongjinGroup.SpringPractice.service;

import myeongjinGroup.SpringPractice.repository.JdbcMemberRepository;
import myeongjinGroup.SpringPractice.repository.JdbcTemplateMemberRepository;
import myeongjinGroup.SpringPractice.repository.MemberRepository;
import myeongjinGroup.SpringPractice.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService( memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        //return new MemoryMemberRepository();
       // return new JdbcMemberRepository(dataSource);
        //return new JdbcTemplateMemberRepository(dataSource);
       //return new JpaMemberRepository(em);


    }
}
