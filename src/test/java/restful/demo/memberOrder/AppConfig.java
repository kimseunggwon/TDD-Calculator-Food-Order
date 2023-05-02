package restful.demo.memberOrder;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import restful.demo.memberOrder.discount.DiscountPolicy;
import restful.demo.memberOrder.discount.FixDiscountPolicy;
import restful.demo.memberOrder.discount.RateDiscountPolicy;
import restful.demo.memberOrder.member.MemberRepository;
import restful.demo.memberOrder.member.MemberService;
import restful.demo.memberOrder.member.MemberServiceImpl;
import restful.demo.memberOrder.member.MemoryMemberRepository;
import restful.demo.memberOrder.order.OrderService;
import restful.demo.memberOrder.order.OrderServiceImpl;

@Configuration
public class AppConfig {

    /**  AppConfig 객체는 MemoryMemberRepository 객체를 생성하고 그 참조값을 MemberServiceImpl을 생성하면서 생성자로 전달한다.
     *   클라이언트인 MemberServiceImpl 입장에서 보면 의존관계를 마치 외부에서 주입해주는 것 같다고 해서 의존성 주입(DI)이라 한다
     */
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    /**  OrderServiceImpl 은 DiscountPolicy 인터페이스에 의존한다. 실제 어떤 구현 객체가 사용될지 모른다. (DI)
     */
    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(
                discountPolicy(),
                memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }


    /** AppConfig에서 할인 정책 역할을 담당하는 구현을 FixDiscountPolicy -> RateDiscountPolicy 변경했다.
     *  이제 할인 정책을 변경해도, AppConfig만 변경하면 된다.
     *  클라이언트 OrderServiceImpl 포함해 사용 영역의 어떤 코드도 변경할 필요가 없다.
     */
    @Bean
    public DiscountPolicy discountPolicy() {
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}

/**
 *
 */