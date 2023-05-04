package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.servlet.http.HttpSession;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class TDDexam01Test {
    HttpSession session;

    @BeforeEach
    @DisplayName("session 모의객체 생성 및 회원정보입력용 스텁설정")
    void init() {
        session = mock(HttpSession.class);
        given(session.getAttribute("userId")).willReturn("user01");
        given(session.getAttribute("userPw")).willReturn("12345678");
    }

    @Test
    @DisplayName("assertEquals test")
    void test1() {
        String userId = (String)session.getAttribute("userId");
        String userPw = (String)session.getAttribute("userPw");

        assertEquals("user01", userId);
        assertEquals("12345678", userPw);
    }

    @Test
    @DisplayName("LoginService check() test")
    void test2() {
        LoginService service = new LoginService();
        String userId = (String)session.getAttribute("userId");
        String result = service.check(session);
        String exspected =  "(" + userId + ") 님 로그인!";
        System.out.println(userId);
        assertEquals(exspected, result);
    }
}
