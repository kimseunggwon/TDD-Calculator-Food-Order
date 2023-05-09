package study.demo.memberOrder.discount;

import study.demo.memberOrder.member.Grade;
import study.demo.memberOrder.member.Member;

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
