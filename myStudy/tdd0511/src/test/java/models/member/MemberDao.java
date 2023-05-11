package models.member;

import java.util.*;

public class MemberDao {
    private Map<String,  Member> members = new HashMap<>();

    public void put(Member member) {
        members.put(member.getUserId(), member);
    }

    public Member get(String userId) {
        return members.get(userId);
    }

    public void remove(String userId) {
        members.remove(userId);
    }
}
