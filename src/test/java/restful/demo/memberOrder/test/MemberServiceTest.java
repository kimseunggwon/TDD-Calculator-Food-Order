package restful.demo.memberOrder.test;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import restful.demo.memberOrder.member.Grade;
import restful.demo.memberOrder.member.Member;
import restful.demo.memberOrder.member.MemberService;
import restful.demo.memberOrder.member.MemberServiceImpl;

public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    @Test
    void join() {
        //given
        Member member = new Member(1L,"memberA", Grade.VIP);

        //when
        memberService.join(member);

        Member findMember = memberService.findMember(1L);

        //then
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
