package restful.demo.memberTest;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);
}
