package study.demo.memberOrder.discount;

import org.springframework.stereotype.Component;
import study.demo.memberOrder.member.Grade;
import study.demo.memberOrder.member.Member;

@Component
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;  // 10% 할인

    @Override
    public int discount(Member member, int price) {

        if (member.getGradle() == Grade.VIP) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}
