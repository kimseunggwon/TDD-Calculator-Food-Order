package study.demo.memberOrder.order;

import org.springframework.stereotype.Component;
import study.demo.memberOrder.discount.DiscountPolicy;
import study.demo.memberOrder.member.Member;
import study.demo.memberOrder.member.MemberRepository;

@Component
public class OrderServiceImpl implements OrderService{

    // private final MemberRepository memberRepository = new MemoryMemberRepository();

    // 할인 정책을 변경하러면 클라이언트 OrderServiceImpl 수정해야한다
    // private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    // private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    /**  인터페이스에만 의존 하도록 코드 변경 => 관심사를 분리 => 구현 객체를 대신 생성하고 주입해주어야 한다. (AppConfig)
     */
    private DiscountPolicy discountPolicy;
    private MemberRepository memberRepository;



    public OrderServiceImpl(DiscountPolicy discountPolicy, MemberRepository memberRepository) {
        this.discountPolicy = discountPolicy;
        this.memberRepository = memberRepository;
    }

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
