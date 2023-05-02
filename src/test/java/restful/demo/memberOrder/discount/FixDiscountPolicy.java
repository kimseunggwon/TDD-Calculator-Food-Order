package restful.demo.memberOrder.discount;

import restful.demo.memberOrder.member.Grade;
import restful.demo.memberOrder.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000; // 1000원 할인

    @Override
    public int discount(Member member, int price) {
        if (member.getGradle() == Grade.VIP) {
            return discountFixAmount;
        }else {
            return 0;
        }
    }
}
