package study.demo.memberOrder;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.demo.memberOrder.discount.DiscountPolicy;
import study.demo.memberOrder.discount.RateDiscountPolicy;
import study.demo.memberOrder.member.MemberRepository;
import study.demo.memberOrder.member.MemberService;
import study.demo.memberOrder.member.MemberServiceImpl;
import study.demo.memberOrder.member.MemoryMemberRepository;
import study.demo.memberOrder.order.OrderService;
import study.demo.memberOrder.order.OrderServiceImpl;

// 애플리케이션의 전체 동작 방식을 구성(config)하기 위해, 구현 객체를 생성하고, 연결하는 책임을 가지는 별도의 설정 클래스 개념
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

/** 정리
 */
//--제어의 역전
//내가 무언가를 직접 호출하는게 아니라
//AppConfig가 등장한 이후에 구현 객체는 자신의 로직을 실행하는 역할만 담당한다. 프로그램의 제어 흐름은 이제 AppConfig가 가져간다.
//예를 들어서 OrderServiceImpl 은 필요한 인터페이스들을 호출하지만 어떤 구현 객체들이 실행될지 모른다.

//--의존관계 주입
//의존관계는 정적인 클래스 의존 관계와, 실행 시점에 결정되는 동적인 객체(인스턴스) 의존 관계 둘을 분리해서 생각해야 한다.
//AppConfig가 플리케이션 실행 시점(런타임)에 외부에서 실제 구현 객체를 생성하고 클라이언트에 전달해서 클라이언트와 서버의 실제 의존관계가 연결 되는 것을 의존관계 주입이라 한다.

//정적인 클래스 의존관계
//클래스가 사용하는 import 코드만 보고 의존관계를 쉽게 판단할 수 있다.

//동적인 객체 인스턴스 의존 관계
//애플리케이션 실행 시점에 실제 생성된 객체 인스턴스의 참조가 연결된 의존 관계다.

// 기존에는 개발자가 직접 자바코드로 모든 것을 했다면 (AppConfig를 직접 만들고)
// 이제부터는 스프링 컨테이너에 객체를 스프링 빈으로 등록하고, 스프링 컨테이너에서 스프링 빈을 찾아서 사용하도록 변경되었다.
// 스프링 컨테이너를 사용하면 너무 큰 이점이 있다.



