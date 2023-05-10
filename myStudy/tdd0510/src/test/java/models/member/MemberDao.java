package models.member;

import java.util.HashMap;
import java.util.Map;

public class MemberDao {

    private Map<String, Member> members = new HashMap<>();

    public Member get(String userId) {
        return members.get(userId);
    }

    public void register(Member member) {
        members.put(member.getUserId(), member);
    }

    public void remover(String userId) {
        members.remove(userId);
    }
}
