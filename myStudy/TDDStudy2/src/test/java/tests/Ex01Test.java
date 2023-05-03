package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockitoSession;

@ExtendWith(MockitoExtension.class)
public class Ex01Test {

    @Mock
    private HttpServletRequest request;
    private LoginService service;
    private JoinService service2;

    @BeforeEach
    void init() {
        //request = mock(HttpServletRequest.class);
        given(request.getParameter("userId")).willReturn("user01");
        given(request.getParameter("userPw")).willReturn("12345678");

        service = new LoginService();
        service2 = new JoinService();

    }

    void changeParameter(String key, String value) {
        given(request.getParameter(key)).willReturn(value);
    }

    @Test
    @DisplayName("로그인 테스트 - 성공")
    void test1() {
        assertDoesNotThrow(()->{
            service.login(request);
        });

        String access = service.check(request);
        System.out.println(access);
    }

    @Test
    @DisplayName("로그인 테스트 - 실패(userId)")
    void test2() {
        assertDoesNotThrow(() -> {
            changeParameter("userId", null);
            service.login(request);
        });
    }

    @Test
    @DisplayName("로그인 테스트 - 실패(userPw)")
    void test3() {
        assertDoesNotThrow(() -> {
            changeParameter("userPw", null);
            service.login(request);
        });
    }

    @Test
    @DisplayName("회원가입 증복 테스트")
    void test4() {
        Map<String, String> memberlist = new HashMap<>();
        for(int i=1; i<=10; i++) {
            memberlist.put("user"+i, "사용자"+i);
        }
//        for(Map.Entry<String,String> entry : memberlist.entrySet()) {
//            System.out.println(entry.getKey());
//            System.out.println(entry.getValue());
//        }
//        changeParameter("userId","user1");
        service2.join(memberlist,request);

    }
}
