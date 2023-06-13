package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// 직접 만든 순수한 자바 코드로 만든 코드가 적절히 작동하는지 확인
// 하지만 main 메소드로 계속해서 Test 하는것은 좋지 않다.
public class MemberApp {
    public static void main(String[] args) {
        // MemberService memberService = new MemberServiceImpl();

        // AppConfig appConfig = new AppConfig();
        // MemberService memberService = appConfig.memberService();

        // 스프링 컨테이너에 집어넣어서 관리해준다. .class 는 클래스타입이라는 뜻이다.
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findmember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("findMember = " + findmember.getName());
    }
}
