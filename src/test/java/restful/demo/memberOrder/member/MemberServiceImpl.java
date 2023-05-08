package restful.demo.memberOrder.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    // MemberServiceImpl은 MemoryMemberRepository 의존하지 않는다
    // private final MemberRepository memberRepository = new MemoryMemberRepository();


    /**
     *  MemberRepository 인터페이스만 의존한다
     *  MemberServiceImpl 입장에서 생성자를 통해 어떤 구현 객체가 들어올지 알 수 없다. 어떤 객체를 주입할지는 오직 외부 AppConfig에서 결정된다.
     *  객체의 생성과 연결은 AppConfig가 담당한다
     */
    private final MemberRepository memberRepository;


    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
