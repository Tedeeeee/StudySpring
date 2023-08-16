package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {

    // 1000 원 할인
    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {

        // Tip! Enum 타입은 == 을 사용해도 괜찮다
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
