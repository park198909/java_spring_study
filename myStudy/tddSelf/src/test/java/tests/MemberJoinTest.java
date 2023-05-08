package tests;

import models.member.BadRequestException;
import models.member.JoinService;
import models.member.JoinValidator;
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
        joinService = new JoinService(new JoinValidator());
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
    public void requiredFieldTest1() {
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
    
    @Test
    @DisplayName("필수항목 체크2 - userPw와 userPw 자리수 체크 - 틀리면 BadRequestException 발생")
    public void requiredFieldTest2() {
        assertThrows(BadRequestException.class,()->{
            member.setUserPwRe("1234");
            joinService.join(member);
        });
    }
    
    @Test
    @DisplayName("필수항목 체크3 - userId : 6~16자리 userPw : 8자리 이상 - 자리수를 벗어나면 BadRequestException 발생")
    public void requiredFieldTest3() {
        assertAll(
            ()->assertThrows(BadRequestException.class, ()->{
                // userId 자릿수 초과
                member.setUserId("user1111111111111111111111111111111");
                joinService.join(member);
            }),
            ()->assertThrows(BadRequestException.class,()->{
                // userPw 자릿수 이하
                member.setUserPw("123456");
                member.setUserPwRe("123456");
                joinService.join(member);
            })
        );
    }

    @Test
    @DisplayName("필수항목 체크4 - 중복가입 - 동일한 userId면 BadRequestException 발생")
    public void duplicatedUserIdTest() {
        assertThrows(BadRequestException.class, ()->{
            joinService.join(member);
            joinService.join(member);
        });
    }
}
