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
    private LoginService loginService;

    private JoinService joinService
    private Member member;  // 실제 가입 회원

    @BeforeEach
    void init() {
        loginService = new LoginService(new LoginValidator());

        joinValidator = new JoinValidator();
        joinValidator = setMemberDao(memberDao);
        memberDao = new MemberDao();
        joinService = new JoinService(joinValidator, memberDao);

    }

    private void createSuccessData() {
        given(request.getParameter("userId")).willReturn("user01");
        given(request.getParameter("userPw")).willReturn("12345678");
    }
    private void createWrongData(String userId, String userPw) {
        given(request.getParameter("userId")).willReturn(userId);
        given(request.getParameter("userPw")).willReturn(userPw);
    }
    
    
    @Test
    @DisplayName("로그인 성공시 오류 없음")
    void loginSuccessTest() {
        assertDoesNotThrow(()->{
            createSuccessData();
            loginService.login(request);
        });
    }
    
    @Test
    @DisplayName("로그인 필수항목(userId,userPw) 체크 - 검증 실패 LoginValidationException")
    void loginRequiredFieldTest() {
        assertAll(
                ()->assertThrows(LoginValidationException.class, ()->{
                    // userId == null
                    createWrongData(null,"12345678");
                    loginService.login(request);
                }),
                ()->assertThrows(LoginValidationException.class, ()->{
                    // userId == "   "
                    createWrongData("   ","12345678");
                    loginService.login(request);
                }), ()->assertThrows(LoginValidationException.class, ()->{
                    // userPw == null
                    createWrongData("user01",null);
                    loginService.login(request);
                }), ()->assertThrows(LoginValidationException.class, ()->{
                    // userPw == "   "
                    createWrongData("user01","    ");
                    loginService.login(request);
                })
        );
    }
    
    @Test
    @DisplayName("등록되지 않은 아이디로 로그인 시 LoginValidationException 발생, 가입되지 않은 회원입니다.")
    void loginMemberExistTest() {
        // 회원 가입
        // 회원 가입 아이디로 로그인 시 오류 없음
        // 등록되지 않은 아이디로 로그인시 오류 발생
        
    }
}
