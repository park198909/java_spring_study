package tests;

import models.member.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.http.HttpServletRequest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class MemberLoginTest {
    @Mock
    private HttpServletRequest request;
    private Member member;
    private JoinService joinService;
    private LoginService loginService;

    @BeforeEach
    public void init() {
        joinService = new JoinService(new JoinValidator(), new MemberDao());
        loginService = new LoginService(new LoginValidator());
        member = getMember();
        given(request.getParameter("userId")).willReturn("user01");
        given(request.getParameter("userPw")).willReturn("_aA123456");
    }

    public Member getMember() {
        member = new Member();
        member.setUserId("user01");
        member.setUserPw("_aA123456");
        member.setUserPwRe("_aA123456");
        member.setUserNm("사용자01");

        return member;
    }

    public void setParameter(String userId, String userPw) {
        given(request.getParameter("userId")).willReturn(userId);
        given(request.getParameter("userPw")).willReturn(userPw);
    }

    @Test
    @DisplayName("로그인 성공시 예외없음")
    public void loginSuccessTest() {
        assertDoesNotThrow(()->{
            member.setCheckId(member.getUserId());
            loginService.login(request);
        });
    }
    
    @Test
    @DisplayName("필수입력사항 - userId, userPw가 null 또는 공백이면 LoginValidationException 발생")
    public void requiredFieldTest() {
        // userId가 null일 때
        assertThrows(LoginValidationException.class,()->{
            setParameter(null, "_aA123456");
            loginService.login(request);
        });
        // userId가 빈칸일 때
        assertThrows(LoginValidationException.class,()->{
            setParameter("   ", "_aA123456");
            loginService.login(request);
        });
        // userPw가 null일 때
        assertThrows(LoginValidationException.class,()->{
            setParameter("user01", null);
            loginService.login(request);
        });
        // userPw가 빈칸일 때
        assertThrows(LoginValidationException.class,()->{
            setParameter("user01", "     ");
            loginService.login(request);
        });
    }

}
