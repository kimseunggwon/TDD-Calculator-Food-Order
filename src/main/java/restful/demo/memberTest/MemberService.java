package restful.demo.memberTest;

public interface MemberService {

    void join(Member member);
    Member findMember(Long memberId);
}
