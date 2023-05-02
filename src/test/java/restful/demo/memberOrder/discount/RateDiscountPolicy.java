package restful.demo.memberOrder.discount;

import restful.demo.memberOrder.member.Grade;
import restful.demo.memberOrder.member.Member;

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
