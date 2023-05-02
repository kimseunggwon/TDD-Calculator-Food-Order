package restful.demo.memberOrder.order;

import restful.demo.memberOrder.member.Grade;
import restful.demo.memberOrder.member.Member;
import restful.demo.memberOrder.member.MemberService;
import restful.demo.memberOrder.member.MemberServiceImpl;

public class OrderApp {

    public static void main(String[] args) {

        MemberService memberService = new MemberServiceImpl();

        OrderService orderService = new OrderServiceImpl();

        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
    }
}
