package restful.demo.memberOrder.order;

import restful.demo.memberOrder.discount.DiscountPolicy;
import restful.demo.memberOrder.discount.FixDiscountPolicy;
import restful.demo.memberOrder.member.Member;
import restful.demo.memberOrder.member.MemberRepository;
import restful.demo.memberOrder.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();


    /**  주문 생성 요청이 오면, 회원 정보 조회 -> 할인 정책 적용 -> 주문 객체를 생성해서 반환
     *   메모리 회원 리포지토리, 고정 금액 할인 정책을 구현체로 생성
     */
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member,itemPrice);

        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}
