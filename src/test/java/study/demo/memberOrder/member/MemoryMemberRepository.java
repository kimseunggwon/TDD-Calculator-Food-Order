package study.demo.memberOrder.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MemoryMemberRepository implements MemberRepository {

    // 데이터베이스없이 오직 메모리만으로 개발을 진행
    // HashMap 동시성 이슈가 발생하면 ConcurrentHashMap 사용
    private static Map<Long,Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
