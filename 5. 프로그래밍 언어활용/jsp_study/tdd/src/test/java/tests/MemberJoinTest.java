package tests;

import models.member.JoinService;
import models.member.JoinValidationException;
import models.member.JoinValidator;
import models.member.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class MemberJoinTest {

    private JoinService service;
    private Member member;

    @BeforeEach
    void init() {
        service = new JoinService(new JoinValidator());
        member = getMember();
    }

    private Member getMember() {
        member = new Member();
        member.setUserId("user01");
        member.setUserPw("12345678");
        member.setUserPwRe("12345678");
        member.setUserNm("사용자01");
        return member;
    }

    @Test
    @DisplayName("회원가입 성공하면 예외발생 안함")
    void joinSuccessTest() {    // 단위테스트1
        assertDoesNotThrow(()->{
            service.join(member);
        });
    }
    
    @Test
    @DisplayName("필수항목(userId, userPw, userPwRe, userNm) 체크 - 검증 실패시 JoinValidationException 발생")
    void joinRequiredFieldsTest() {
        assertAll(()->{
            // userId 필수항목 검증 - null
            assertThrows(JoinValidationException.class,()->{
                Member member = getMember();
                member.setUserId(null);
                service.join(member);
            });
            // userId 필수항목 검증 - 공백
            assertThrows(JoinValidationException.class,()->{
               Member member = getMember();
               member.setUserId("   ");
                service.join(member);
            });
            // userPw 필수항목 검증 - 공백
            assertThrows(JoinValidationException.class,()->{
                Member member = getMember();
                member.setUserPw(null);
                service.join(member);
            });
            // userPw 필수항목 검증 - 공백
            assertThrows(JoinValidationException.class,()->{
                Member member = getMember();
                member.setUserPw("   ");
                service.join(member);
            });
        });
    }


}
