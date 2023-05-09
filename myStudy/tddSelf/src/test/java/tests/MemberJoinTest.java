package tests;

import models.member.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class MemberJoinTest {

    private Member member;
    private JoinService joinService;

    @BeforeEach
    public void init() {
        JoinValidator validator = new JoinValidator();;
        MemberDao memberDao = new MemberDao();;
        validator.setMemberDao(memberDao);

        joinService = new JoinService(validator, memberDao);
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

    @Test
    @DisplayName("회원가입 성공 시 오류 없음")
    public void joinSuccess() {
        assertDoesNotThrow(()->{
            joinService.join(member);
        });
    }

    @Test
    @DisplayName("필수항목 체크1 - userId,userPw,userPwRe,userNm이 null 또는 빈칸이면 BadRequestException발생")
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
                }),
                // userPwRe = null
                ()->assertThrows(BadRequestException.class, ()->{
                    member.setUserPw("12345678"); // userPwRe 체크를 위한 userPw 초기화
                    member.setUserPwRe(null);
                    joinService.join(member);
                }),
                // userPwRe = 빈칸
                ()->assertThrows(BadRequestException.class, ()->{
                    member.setUserPwRe("   ");
                    joinService.join(member);
                }),
                // userNm = null
                ()->assertThrows(BadRequestException.class, ()->{
                    member.setUserPwRe("12345678"); // userNm 체크를 위한 userPwRe 초기화
                    member.setUserNm(null);
                    joinService.join(member);
                }),
                // userPwRe = 빈칸
                ()->assertThrows(BadRequestException.class, ()->{
                    member.setUserNm("   ");
                    joinService.join(member);
                })
        );
    }
    
    @Test
    @DisplayName("필수항목 체크2 -userPwRe 자리수 체크 - 틀리면 BadRequestException 발생")
    public void requiredFieldTest2() {
        BadRequestException thrown = assertThrows(BadRequestException.class,()->{
            member.setUserPwRe("1234");
            joinService.join(member);
        });
        String message = thrown.getMessage();
        assertTrue(message.contains("비밀번호가 일치하지 "));
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
            ()->assertThrows(BadRequestException.class, ()->{
                // userId 자릿수  미만
                member.setUserId("user");
                joinService.join(member);
            }),
            ()->assertThrows(BadRequestException.class,()->{
                // userPw 자릿수 이하
                member.setUserPw("1234");
                member.setUserPwRe("1234");
                joinService.join(member);
            })
        );
    }

    @Test
    @DisplayName("필수항목 체크4 - 중복가입 - 동일한 userId면 IdExistException 발생")
    public void duplicatedUserIdTest() {
        assertThrows(IdExistException.class, ()->{
            joinService.join(member);   // 최초가입
            joinService.join(member);   // 중복가입
        });
    }
}
