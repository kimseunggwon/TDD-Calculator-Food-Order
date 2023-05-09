package study.demo.memberOrder.test;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import study.demo.memberOrder.AppConfig;
import study.demo.memberOrder.member.Grade;
import study.demo.memberOrder.member.Member;
import study.demo.memberOrder.member.MemberService;

public class MemberServiceTest {

    //MemberService memberService = new MemberServiceImpl();


    MemberService memberService;
    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

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
