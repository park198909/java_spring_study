package tests;

import models.member.LoginService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.http.HttpServletRequest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("로그인 기능 테스트")
public class MemberLoginTest {

    private LoginService loginService;
    @Mock
    private HttpServletRequest request;

    @BeforeEach
    void init() {
        loginService = new LoginService();
        //request = mock(HttpServletRequest.class);
        given(request.getParameter("userId")).willReturn("user01");
        given(request.getParameter("userPw")).willReturn("12345678");
    }

    @Test
    @DisplayName("로그인에 성공하면 예외가 발생하지 않음")
    void loginSuccessTest() {
        assertDoesNotThrow(()->{
            loginService.login(request);
        });
    }
}
