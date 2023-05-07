package tests;

import models.member.BadRequestException;
import models.member.LoginService;
import models.member.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.http.HttpServletRequest;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class MemberLoginTest {
    @Mock
    private HttpServletRequest request;
    private LoginService service;
    private Member member;

    @BeforeEach
    public void init() {
        service = new LoginService();

        member = new Member();
        member.setUserId("user01");       ;
        member.setUserPw("_aA123456");       ;
        member.setUserPwRe("_aA123456");       ;
        member.setUserNm("사용자01");       ;
        member.setAgree(true);
    }

    @Test
    @DisplayName("로그인 실패하면 BadRequestException 발생")
    public void loginSuccessTest() {
        assertThrows(BadRequestException.class,()->{
            service.login(member);
        });
    }


}
