package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import javax.servlet.http.HttpServletRequest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class TDDexam02Test {
    @Mock
    private HttpServletRequest request;
    private LoginService service;

    @BeforeEach
    void init() {
        request = mock(HttpServletRequest.class);

        given(request.getParameter("userId")).willReturn("user01");
        given(request.getParameter("userPw")).willReturn("12345678");

        service = new LoginService();
    }

    private void changeParameter(String key, String value) {
        given(request.getParameter(key)).willReturn(value);
    }

    @Test
    @DisplayName("login success test")
    void loginSuccessTest() {
        assertDoesNotThrow(()->{
            service.login(request);
        });
    }

    @Test
    @DisplayName("Login Test")
    void LoginTest() {
        assertThrows(LoginValidationException.class,()->{
            changeParameter("userId",null);
            service.login(request);
        });

        assertThrows(LoginValidationException.class,()->{
            changeParameter("userId","   ");
            service.login(request);
        });

        assertThrows(LoginValidationException.class,()->{
            changeParameter("userId","user01");
            changeParameter("userPw",null);
            service.login(request);
        });

        assertThrows(LoginValidationException.class, ()->{
            changeParameter("userId","user01");
            changeParameter("userPw","    ");
            service.login(request);
        });
    }
}
