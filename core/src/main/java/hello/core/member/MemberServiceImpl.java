package hello.core.member;

// MemberService 의 구현체
// 추상화에 의존하게 만들수 있게 한다.
public class MemberServiceImpl implements MemberService {

    // MemberServiceImpl 에서 사용할 (사용자 저장과 사용자 찾기)를 가지고 있는것을 생성해야함
    // 이것은 문제가 있다. 바로 DIP 를 위배하고 있는 것인데
    // MemberRepository 는 추상화지만 MemoryMemberRepository 는 구체화로써 DIP 를 위배하게 되는것이다.
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
