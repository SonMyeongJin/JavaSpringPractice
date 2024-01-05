package myeongjinGroup.SpringPractice.service;

import myeongjinGroup.SpringPractice.domain.Member;
import myeongjinGroup.SpringPractice.repository.MemberRepository;
import myeongjinGroup.SpringPractice.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    //join member
    public Long join(Member member) {

        validateDuplicateMemeber(member); // 중복회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMemeber(Member member) {
        memberRepository.findByname(member.getName())
                .ifPresent(member1 -> {
                    throw new IllegalStateException("already has same member");
                });
    }


    //전체회원조회
    public List<Member> findMemebers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
       return memberRepository.findById(memberId);
    }
}
