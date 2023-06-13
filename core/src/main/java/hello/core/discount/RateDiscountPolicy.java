package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.stereotype.Component;

@Component
public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            // 이처럼 돈과 관련된 로직은 굉장히 어렵다.
            // 혹 나중에 관련해서 로직을 구성한다면 정말 꼼꼼히 따져봐야한다.
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}
