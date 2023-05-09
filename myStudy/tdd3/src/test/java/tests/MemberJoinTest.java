package tests;

import models.member.JoinService;
import models.member.JoinValidationException;
import models.member.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class MemberJoinTest {

    private JoinService joinService;

    private Member member;

    @BeforeEach
    void init() {
        joinService = new JoinService();
        member = new Member();
    }

    Member getSuccessMember() {
        member.setUserId("user01");
        member.setUserPw("12345678");
        member.setUserPwRe("12345678");
        member.setUserNm("사용자01");
        return member;
    }

    Member getFailMember(String userId, String userPw, String userPwRe, String userNm) {
        member.setUserId("user01");
        member.setUserPw("12345678");
        member.setUserPwRe("12345678");
        member.setUserNm("사용자01");
        return member;
    }

    @Test
    @DisplayName("회원가입 성공 시 예외 없음")
    void joinSuccessTest() {
        member = getSuccessMember();
        assertDoesNotThrow(()->{
            joinService.join(member);
        });
    }

    @Test
    @DisplayName("필수 항목 체크 - userId,userPw,userPwRe,userNm이 null 또는 빈칸일 때 JoinValidationException 발생")
    void joinRequiredFieldTest() {
        assertAll(
                ()->assertThrows(JoinValidationException.class, ()->{
                    // userId == null
                    member = getFailMember(null, "12345678", "12345678", "사용자01");
                    joinService.join(member);
                }),
                ()->assertThrows(JoinValidationException.class, ()->{
                    // userId == "    "
                    member = getFailMember("    ", "12345678", "12345678", "사용자01");
                    joinService.join(member);
                }),
                ()->assertThrows(JoinValidationException.class, ()->{
                    // userPw == null
                    member = getFailMember("user01", null, "12345678", "사용자01");
                    joinService.join(member);
                }),
                ()->assertThrows(JoinValidationException.class, ()->{
                    // userPw == "    "
                    member = getFailMember("user01", "    ", "12345678", "사용자01");
                    joinService.join(member);
                }),
                ()->assertThrows(JoinValidationException.class, ()->{
                    // userPwRe == null
                    member = getFailMember("user01", "12345678", null, "사용자01");
                    joinService.join(member);
                }),
                ()->assertThrows(JoinValidationException.class, ()->{
                    // userPwRe == "    "
                    member = getFailMember("user01", "12345678", "    ", "사용자01");
                    joinService.join(member);
                }),
                ()->assertThrows(JoinValidationException.class, ()->{
                    // userNm == null
                    member = getFailMember("user01", "12345678", "12345678", null);
                    joinService.join(member);
                }),
                ()->assertThrows(JoinValidationException.class, ()->{
                    // userNm == "    "
                    member = getFailMember("user01", "12345678", "12345678", "    ");
                    joinService.join(member);
                })
        );
    }

}
