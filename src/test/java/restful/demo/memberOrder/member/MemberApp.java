package restful.demo.memberOrder.member;

public class MemberApp {


    /**  원시적으로 test 하는 방법은 안좋으니 , Junit 테스트를 이용하자.
     */
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }

}