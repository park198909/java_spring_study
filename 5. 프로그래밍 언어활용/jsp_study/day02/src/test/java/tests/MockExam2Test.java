package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.http.HttpServletRequest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class MockExam2Test {

    @Mock
    private HttpServletRequest request;
    private LoginService service;
    
    @BeforeEach
    void init() {
        // HttpServletRequest의 모의 객체 생성
//        request = mock(HttpServletRequest.class); // @Mock을 사용하면 필요없음

        // 스텁설정 - 모의객체에 userId가 주어지면, "user01"을 반환한다.
        given(request.getParameter("userId")).willReturn("user01");
        given(request.getParameter("userPw")).willReturn("12345678");
        
        // LoginService객체 생성
        service = new LoginService();
    }

    private void changeParameter(String key, String value) {
        // 스텁설정 - 모의객체에 key가 주어지면, "value"을 반환한다.
        given(request.getParameter(key)).willReturn(value);
    }

    @Test
    @DisplayName("로그인 성공시 예외 없음")
    void loginSuccessTest() {
        assertDoesNotThrow(()->{
            service.login(request);
        });
    }

    @Test
    @DisplayName("필수 항목 검증(userId, userPw) - 검증 실패시 LoginValidatiomException")
    void loginTest() {

        assertThrows(LoginValidationException.class, ()->{
            // userId가 입력되면 null을 반환
            changeParameter("userId",null);     // 기본값을 null로 초기화 
            service.login(request);             // 검증이 되면 null이 바뀌므로 성공, 실패하면 null이 반환되어 실패
        });
        assertThrows(LoginValidationException.class,()->{
            // userId가 입력되면 빈 공백을 반환
            changeParameter("userId","  ");     // 기본값을 공백으로 초기화 
            service.login(request);             // 검증이 되면 null이 바뀌므로 성공, 실패하면 null이 반환되어 실패
        });

        assertThrows(LoginValidationException.class, ()->{
            changeParameter("userId","user01");
            // userPw가 입력되면 null을 반환
            changeParameter("userPw",null);     // 기본값을 null로 초기화
            service.login(request);             // 검증이 되면 null이 바뀌므로 성공, 실패하면 null이 반환되어 실패
        });
        assertThrows(LoginValidationException.class, ()->{
            // userPw가 입력되면 빈 공백을 반환
            changeParameter("userPw","   ");    // 기본값을 null로 초기화
            service.login(request);             // 검증이 되면 null이 바뀌므로 성공, 실패하면 null이 반환되어 실패
        });
    }
}
