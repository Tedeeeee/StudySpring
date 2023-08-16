package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    // 나의 회원가입이 정확히 이루어지고 있는지 확인하는 테스트기능
    @Test
    void join() {
        // given
        Member member = new Member(1L, "memberA", Grade.VIP);

        // when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        // 만약 이것이 2L 으로 없는 회원을 찾아서 확인을 해보면
        Member findMember2 = memberService.findMember(2L);

        // then
        Assertions.assertThat(member).isEqualTo(findMember);
        Assertions.assertThat(member).isEqualTo(findMember2);
    }
}
