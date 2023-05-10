package tests;

import models.member.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
@DisplayName("로그인 테스트")
public class MemberLoginTest {

    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpSession session;

    private Member member;
    private MemberDao memberDao;
    private JoinValidator joinValidator;
    private JoinService joinService;

    private LoginValidator loginValidator;
    private LoginService loginService;

    @BeforeEach
    @DisplayName("개별 테스트 시작 시 적용되는 기본 설정")
    void init() {
        memberDao = new MemberDao();
        // 회원가입
        joinValidator = new JoinValidator();
        joinValidator.setMemberDao(memberDao);
        joinService = new JoinService(joinValidator, memberDao);
        member = getSuccessMember();
        joinService.join(member);
        // 로그인
        loginValidator = new LoginValidator();
        loginValidator.setMemberDao(memberDao);
        loginService = new LoginService(loginValidator, memberDao);
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

    public void createSuccessData() {
        // 스텁 설정 - given은 선언하고 사용하지 않으면 에러가 발생하므로 주의!
        given(request.getParameter("userId")).willReturn("user01");
        given(request.getParameter("userPw")).willReturn("_aA123456");
        given(request.getSession()).willReturn(session);
    }

    public void createFailData(String userId, String userPw) {
        given(request.getParameter("userId")).willReturn(userId);
        given(request.getParameter("userPw")).willReturn(userPw);
    }

    @Test
    @DisplayName("로그인 성공하면 예외 없음")
    void loginSuccessTest() {
        assertDoesNotThrow(() -> {
            createSuccessData();
            loginService.login(request);
        });
    }

    @Test
    @DisplayName("필수항목(userId, userPw) 체크 - null 또는 빈칸이면 LoginValidationException 발생")
    void loginRequiredTest() {
        assertAll(
                () -> assertThrows(LoginValidationException.class, () -> {
                    // userId == null
                    createFailData(null, member.getUserPw());
                    loginService.login(request);
                }),
                () -> assertThrows(LoginValidationException.class, () -> {
                    // userId == "     "
                    createFailData("     ", member.getUserPw());
                    loginService.login(request);
                }),
                () -> assertThrows(LoginValidationException.class, () -> {
                    // userPw == null
                    createFailData(member.getUserId(), null);
                    loginService.login(request);
                }),
                () -> assertThrows(LoginValidationException.class, () -> {
                    // userPw == "     "
                    createFailData(member.getUserId(), "     ");
                    loginService.login(request);
                })
        );
    }

    @Test
    @DisplayName("미등록 아이디 체크 - 미등록 아이디 입력 시 ExistIdValidationException 발생, 미등록된 아이디 입니다.")
    void notExistIdTest() {
        assertAll(
                () -> {
                    RuntimeException thrown = assertThrows(ExistIdValidationException.class, () -> {
                        createFailData("user02", "_aA123456");
                        loginService.login(request);
                    });
                    String message = thrown.getMessage();
                    assertTrue(message.contains("미등록된 아이디 입니다."));
                });
    }
    // 비밀번호 틀림
    @Test
    @DisplayName("비밀번호 체크 - 비밀번호 틀리면 PasswordValidationException 발생, 아이디 또는 비밀번호를 확인하세요.")
    void passwordFailTest() {
        assertAll(
                () -> {
                    RuntimeException thrown = assertThrows(PasswordValidationException.class, () -> {
                        createFailData("user01", "_aA123555");
                        loginService.login(request);
                    });
                    String message = thrown.getMessage();
                    assertTrue(message.contains("아이디 또는 비밀번호를 "));
                });
    }
}

