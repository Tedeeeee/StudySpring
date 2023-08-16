package hello.core.member;

import java.util.*;

// MemberRepository 의 구현체
public class MemoryMemberRepository implements MemberRepository {

    // 실무에서는 동시성 이슈로 인해 ConcurrentHashMap 를 사용해야 한다.
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
