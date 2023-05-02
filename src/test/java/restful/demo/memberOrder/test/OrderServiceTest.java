package restful.demo.memberOrder.test;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import restful.demo.memberOrder.AppConfig;
import restful.demo.memberOrder.member.Grade;
import restful.demo.memberOrder.member.Member;
import restful.demo.memberOrder.member.MemberService;
import restful.demo.memberOrder.member.MemberServiceImpl;
import restful.demo.memberOrder.order.Order;
import restful.demo.memberOrder.order.OrderService;
import restful.demo.memberOrder.order.OrderServiceImpl;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;
    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {
        //given
        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);

        //when
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "itemA", 10000);

        //then
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}
