package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService {

    // 이렇게 불러주면 다형성으로 인해 MemoryMemberRepository 에 의해 save 와 findById를 사용할 수 있다
    // private final MemberRepository memberRepository = new MemoryMemberRepository();

    // 이렇게 인터페이스만 불러오고 생성자를 통해 가져온다. ( 추상화만 가져온다 DIP 를 지키기 시작 )
    private final MemberRepository memberRepository;

    @Autowired // 의존관계 주입을 자동으로 연결해준다.
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // Test 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
