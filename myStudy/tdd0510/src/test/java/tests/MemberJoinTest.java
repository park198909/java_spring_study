package tests;

import models.member.JoinService;
import models.member.Member;
import models.member.MemberDao;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MemberJoinTest {

    private Member member;
    private MemberDao memberDao;
    private JoinService joinService;

    @Test
    @DisplayName("테스트 시작 시 적용되는 기본 설정")
    void init() {
        member = getSuccessMember();
    }

    public Member getSuccessMember() {
        member = new Member();
        member.setUserId("user01");
        member.setUserPw("_aA123456");
        member.setUserPwRe("_aA123456");
        member.setUserNm("사용자01");
        member.setEmail("user01@org.com");
        member.setMobile("01011112222");
        return member;
    }

    public Member getFailMember(String key, String value) {
        member = new Member();
        if(key.equals("userId")) member.setUserId(value);
        if(key.equals("userPw")) member.setUserPw(value);
        if(key.equals("userPwRe")) member.setUserPwRe(value);
        if(key.equals("userNm")) member.setUserNm(value);
        if(key.equals("email")) member.setUserId(value);
        if(key.equals("mobile")) member.setUserId(value);
        return member;
    }

    void joinSuccessTest() {
        assertDoesNotThrow(()->{
            joinService.join(member);
        });
    }
}
