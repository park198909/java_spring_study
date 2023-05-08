package tests;

import models.member.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
public class MemberLoginTest {

    private LoginService loginService;
    private JoinService joinService;
    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpSession session;

    private Member member;

    @BeforeEach
    void init() {
        MemberDao memberDao = new MemberDao();
        loginService = new LoginService(new LoginValidator(memberDao), memberDao);

        JoinValidator joinValidator = new JoinValidator();
        joinValidator.setMemberDao(memberDao);
        joinService = new JoinService(joinValidator, memberDao);

        // 회원가입
        member = memberDao.get("user01");
        if (member == null) {
            member = new Member();
            member.setUserId("user01");
            member.setUserPw("12345678");
            member.setUserPwRe("12345678");
            member.setUserNm("사용자01");
            joinService.join(member);
        }
    }

    private void createSuccessData() {
        given(request.getParameter("userId")).willReturn(member.getUserId());
        given(request.getParameter("userPw")).willReturn(member.getUserPw());
        given(request.getSession()).willReturn(session);
    }

    private void createFailData(String userId, String userPw) {
        given(request.getParameter("userId")).willReturn(userId);
        given(request.getParameter("userPw")).willReturn(userPw);
    }


    @Test
    @DisplayName("로그인 성공 하면 예외 없음")
    void loginSuccessTest() {
        assertDoesNotThrow(()->{
            createSuccessData();
            loginService.login(request);
        });
    }

    @Test
    @DisplayName("필수항목 검증 - userId, userPw이 null 또는 빈칸이면 BadRequestException 발생")
    void loginRequiredFieldTest() {
        assertAll(
                // userId == null
                ()->assertThrows(BadRequestException.class, ()->{
                    createFailData(null,"12345678");
                    loginService.login(request);
                }),
                // userId == "    "
                ()->assertThrows(BadRequestException.class,()->{
                    createFailData("    ", "12345678");
                    loginService.login(request);
                }),
                // userPw == null
                ()->assertThrows(BadRequestException.class, ()->{
                    createFailData("user01", null);
                    loginService.login(request);
                }),
                // userPw == "     "
                ()->assertThrows(BadRequestException.class, ()->{
                    createFailData("user01", "    ");
                    loginService.login(request);
                })
        );
    }

    @Test
    @DisplayName("등록되지 않은 아이디로 로그인 시도하면 BadRequestException 발생, 등록되지 않은 아이디입니다.")
    void loginUnregisteredIdTest() {
        assertAll(
                         // 등록된 아이디로 로그인시 예외 없음
()->assertDoesNotThrow( ()->{
                        createSuccessData();
                        loginService.login(request);
                        }),
                        // 미등록 아이디로 로그인시 예외 발생
                        ()-> {
                            BadRequestException thrown = assertThrows(BadRequestException.class, () -> {
                                createFailData("user0002", "12345678");
                                loginService.login(request);
                            });

                            String message = thrown.getMessage();
                            assertTrue(message.contains("등록되지 않은 아이디"));
                        }
        );
    }

    @Test
    @DisplayName("패스워드 불일치 테스트 - 비밀번호가 맞지 않는 경우  - BadRequestException 발생, 아이디 또는 비밀번호가 일치하지 않습니다.")
    void loginPasswordTest() {
        BadRequestException thrown = assertThrows(BadRequestException.class, ()->{
            createFailData("user01","12345679");
            loginService.login(request);
        });

        String message = thrown.getMessage();
        assertTrue(message.contains("아이디 또는 비밀번호가 일치하지"));
    }

}
