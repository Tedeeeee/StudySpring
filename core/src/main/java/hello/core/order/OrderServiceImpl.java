package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private MemberRepository memberRepository = new MemoryMemberRepository();
    private DiscountPolicy discountPolicy = new FixDiscountPolicy();

    // 이런식으로 작성하는것이 SRP 원칙을 잘 지킨 코드라고 볼수있다.
    // 만약 discountPolicy 가 없었다면 할인과 관련된 요청이 오면 OrderService 가 수정해야하는 문제가 생긴다.
    // 이 주문 생성 메소드는 주문을 하는 곳이지 가격에 대한 행위를 하는 곳이 아니다.
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
