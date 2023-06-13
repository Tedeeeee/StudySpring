package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// join 안에 given, when, then 은 테스트를 작성할때 도움이 된다. 이렇게 주고(given) 그것을 실행했을때(when) 그러면 이렇게 된다(then)이다.
public class MemberServiceTest {

    // MemberService memberService = new MemberServiceImpl();
    MemberService memberService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    // Test 할때 사용하는 어노테이션
    @Test
    void join() {
        // given
        Member member = new Member(1L, "memberA", Grade.VIP);

        // when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        // then ... Assertions 는 비교할때 많이 사용된다. Test 를 작성할때 많이 보게 될것이다.
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
