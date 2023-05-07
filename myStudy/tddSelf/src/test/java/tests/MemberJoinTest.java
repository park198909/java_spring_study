package tests;

import models.member.*;
import org.apache.taglibs.standard.lang.jstl.test.EvaluationTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.http.HttpServletRequest;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class MemberJoinTest {

    @Mock
    private HttpServletRequest request;
    private Member member;
    private JoinService service;

    @BeforeEach
    public void init() {
        service = new JoinService(new JoinValidator(), new MemberDao());
        member = getMember();
    }

    public Member getMember() {
        member = new Member();
        member.setUserId("user01");
        member.setUserPw("_aA123456");
        member.setUserPwRe("_aA123456");
        member.setUserNm("사용자01");

        return member;
    }

    @Test
    @DisplayName("회원가입에 실패하면 JoinValidationException발생")
    public void JoinSuccessTest() {
        assertDoesNotThrow(()->{
            service.join(member);
        });
    }

    @Test
    @DisplayName("필수입력사항 - userId, userPw가 null이거나 빈칸이면 JoinValidationException 발생")
    public void requiredFieldTest() {
            assertThrows(JoinValidationException.class, ()->{
                member.setUserId(null);
                service.join(member);
            });
            assertThrows(JoinValidationException.class, ()->{
                member.setUserId("    ");
                service.join(member);
            });
            assertThrows(JoinValidationException.class, ()->{
                member.setUserId("user01"); // userPw체크를 위해 userId의 에러 제거
                member.setUserPw(null);
                service.join(member);
            });
            assertThrows(JoinValidationException.class, ()->{
                member.setUserPw(null);
                service.join(member);
            });
    }

    @Test
    @DisplayName("아이디 자리수 제한 : 6~16자리, 벗어나면 JoinValidationException 발생")
    public void joinUserIdLengthTest() {
        assertThrows(JoinValidationException.class,()->{
           member.setUserId("user012345678910111213");
           service.join(member);
        });
    }

    @Test
    @DisplayName("패스워드 자리수 제한 : 8자리 이상, 벗어나면 JoinValidationException 발생")
    public void joinUserPwLengthTest() {
        assertThrows(JoinValidationException.class,()->{
            member.setUserPw("1234");
            service.join(member);
        });
    }
    
    @Test
    @DisplayName("가입정보 중복 테스트 - userId가 기존 userId와 겹치면 JoinValidationException 발생")
    public void duplicationTest() {
        assertThrows(JoinValidationException.class,()->{
            service.join(member);   // 최초 가입
            service.join(member);   // 중복 가입
        });
    }
}
