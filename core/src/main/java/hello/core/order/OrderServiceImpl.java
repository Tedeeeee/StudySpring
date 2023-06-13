package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{

    // 이런식으로 필요할때 마다 코드를 변경해주고 구현체를 직접 의존하게 되면 DIP 와 OCP 를 위반한다
    // private final MemberRepository memberRepository = new MemoryMemberRepository();
    // private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    // private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    // 이것을 해결하는 방법이다. 인터페이스만 의존하게 되는것이다.
    // private DiscountPolicy discountPolicy;
    // 하지만 아무런 구현이 안된 discountPolicy 인터페이스는 텅 빈 껍데기라서 안돌아간다.

    // 이렇게 인터페이스만 불러오고 AppConfig 생성자를 통해 가져온다. ( 추상화만 가져온다 DIP 를 지키기 시작 )
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        // 이것이 단일 체계 원칙이 잘 지켜진 코드이다.
        // 할인이 잘못되면 주문서를 고치는 것이 아닌 discount 부분을 고치면 된다
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // Test 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
