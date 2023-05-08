package models.member;

import java.util.HashMap;
import java.util.Map;

public class MemberDao {
    private static Map<String, Member> members = new HashMap<>();

    public Member get(String userId) {
        return members.get(userId);
    }

    public void register(Member member){
        members.put(member.getUserId(),member);
    }
}
