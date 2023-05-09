package tests;

import models.member.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class MemberLoginService {

    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpSession session;

    private LoginService loginService;
    private LoginValidator loginValidator;
    private JoinValidator joinValidator;

    private MemberDao memberDao;
    private JoinService joinService;
    private Member member;

    @BeforeEach
    void init() {
        loginValidator = new LoginValidator();
        joinValidator = new JoinValidator();
        joinValidator.setMemberDao(memberDao);
        memberDao = new MemberDao();
        loginService = new LoginService(loginValidator, memberDao);
        joinService = new JoinService(joinValidator, memberDao);

        if(memberDao.get("user01") == null){
            member = getMember();
            joinService.join(member);
        }
    }

    Member getMember() {
        member = new Member();
        member.setUserId("user01");
        member.setUserPw("12345678");
        member.setUserPwRe("12345678");
        member.setUserNm("사용자01");
        return member;
    }

    void createSuccessData() {
        given(request.getParameter("userId")).willReturn("user01");
        given(request.getParameter("userPw")).willReturn("12345678");
        given(request.getSession()).willReturn(session);
    }

    void createFailData(String userId, String userPw) {
        given(request.getParameter("userId")).willReturn(userId);
        given(request.getParameter("userPw")).willReturn(userPw);
    }


    @Test
    @DisplayName("로그인 성공 시 예외 없음")
    void loginSuccessTest() {
        assertDoesNotThrow(()->{
            createSuccessData();
            loginService.login(request);
        });
    }
    
    
    @Test
    @DisplayName("필수 항목(userId, userPw) 체크 - null 또는 빈칸이면 LoginValidationException 발생")
    void loginRequiredFieldTest() {

        assertAll(
                // userId == null
                ()->assertThrows(LoginValidationException.class, ()->{
                    createFailData(null, "12345678");
                    loginService.login(request);
                }),
                // userId == "    "
                ()->assertThrows(LoginValidationException.class, ()->{
                    createFailData("    ", "12345678");
                    loginService.login(request);
                }),
                // userPw == null
                ()->assertThrows(LoginValidationException.class, ()->{
                    createFailData("user01", null);
                    loginService.login(request);
                }),
                // userPw == "    "
                ()->assertThrows(LoginValidationException.class, ()->{
                    createFailData("user01", "    ");
                    loginService.login(request);
                })
        );

    }
    
    @Test
    @DisplayName("등록되지 않은 아이디 입력 시 LoginValidationException 발생, 등록되지 않은 아이디 입니다.")
    void insertWrongIdTest() {
        assertAll(
                ()-> {
                    LoginValidationException thrown = assertThrows(LoginValidationException.class, () -> {
                        createFailData("user02", "12345678");
                        loginService.login(request);
                    });

                    String message = thrown.getMessage();
                    assertTrue(message.contains("등록되지 않은 아이디"));

                });
    }

    @Test
    @DisplayName("비밀번호 오입력 시 LoginValidationException 발생, 아이디 또는 비밀번호를 확인하세요.")
    void insertWrongPasswordTest() {
        assertAll(
                ()-> {
                    LoginValidationException thrown = assertThrows(LoginValidationException.class, () -> {
                        createFailData("user01", "12345555");
                        loginService.login(request);
                    });

                    String message = thrown.getMessage();
                    assertTrue(message.contains("아이디 또는 비밀번호를 확인"));
                });
    }



}
