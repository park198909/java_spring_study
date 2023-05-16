package models.member;

import java.util.HashMap;
import java.util.Map;

public class MemberDao {
    private Map<String, Member> members = new HashMap<>();

    private Member member;

    public void insert(Member member) {
        members.put(member.getUserId(), member);
    }

    public Member get(String userId) {
        member = members.get(userId);
        return member;
    }

    public void remove(String userId) {
        members.remove(userId);
        System.out.printf("%s회원 삭제완료");
    }
}
