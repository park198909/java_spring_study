package tests;

import models.member.BadRequestException;
import models.member.JoinService;
import models.member.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.http.HttpServletRequest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
public class MemberJoinTest {
    @Mock
    private HttpServletRequest request;

    private Member member;
    private JoinService joinService;

    @BeforeEach
    public void init() {
        joinService = new JoinService();
        member = getMember();
    }

    public Member getMember() {
        member = new Member();
        member.setUserId("user01");
        member.setUserPw("12345678");
        member.setUserPwRe("12345678");
        member.setUserNm("사용자01");

        return member;
    }

    public void changeParam(String userId, String userPw) {
        given(request.getParameter("userId")).willReturn(userId);
        given(request.getParameter("userPw")).willReturn(userPw);
    }

    @Test
    @DisplayName("회원가입 성공 시 오류 없음")
    public void joinSuccess() {
        assertDoesNotThrow(()->{
            joinService.join(member);
        });
    }

    @Test
    @DisplayName("필수항목 체크1 - userId,userPw이 null 또는 빈칸이면 BadRequestException발생")
    public void requiredFieldTest() {
        assertAll(
                // userId = null
                ()->assertThrows(BadRequestException.class, ()->{
                    member.setUserId(null);
                    joinService.join(member);
                }),
                // userId = 빈칸
                ()->assertThrows(BadRequestException.class, ()->{
                    member.setUserId("  ");
                    joinService.join(member);
                }),
                // userPw = null
                ()->assertThrows(BadRequestException.class, ()->{
                    member.setUserId("user01"); // userPw 체크를 위한 userId 초기화
                    member.setUserPw(null);
                    joinService.join(member);
                }),
                // userPw = 빈칸
                ()->assertThrows(BadRequestException.class, ()->{
                    member.setUserPw("   ");
                    joinService.join(member);
                })
        );
    }


}
