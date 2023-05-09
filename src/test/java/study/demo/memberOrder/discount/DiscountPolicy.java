package study.demo.memberOrder.discount;

import study.demo.memberOrder.member.Member;

public interface DiscountPolicy {

    // 할인 대상 금액 @return
    int discount(Member member, int price);
}
