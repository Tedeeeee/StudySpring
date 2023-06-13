package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 공연 기획자의 역할 필요한 아이들을 데려온다
@Configuration
public class AppConfig {

    // 이렇게 누군가 MemberService 를 부르면 이때 MemoryMemberRepository 를 자동적으로 불러오게 되는것이다.
    // 생성자 주입
    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    // MemoryMemberRepository 이것이 memberService 와 orderService 의 두군데 모두 사용한다. -> 중복이다
    // 중복 = 제거
    @Bean
    public MemoryMemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    // Order 또한 생성자를 주입해준다.
    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    // 이렇게 각자 무슨 역할을 하는지 알수 있다.
    // 이로써 만약 여기에 문제가 생기면 정확히 이것만 바꾸면 된다.
    @Bean
    public DiscountPolicy discountPolicy() {
        // return new FixDiscountPolicy();
        // 이때 만약 정책을 "할인율"로 바꾸고 싶다면?
        System.out.println("call AppConfig.discountPolicy");
        return new RateDiscountPolicy();
        // 이렇게 기존의 FixDiscountPolicy()을 RateDiscountPolicy()로 리턴값을 바꿔주면 끝이다
    }

}
