package models.member;

import java.util.HashMap;
import java.util.Map;

public class MemberDao {
    private static Map<String , Member> members = new HashMap<>();
    public void memberSave(Member member) {
            String checkId = member.getUserId();
            members.put(checkId, member);
    }
}
