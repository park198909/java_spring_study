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

    private JoinService joinService;
    private Member member;
    private JoinValidator validator;
    private MemberDao memberDao;

    @BeforeEach
    void init() {
        memberDao = new MemberDao();
        validator = new JoinValidator();
        validator.setMemberDao(memberDao);
        joinService = new JoinService(validator,memberDao);
        member = new Member();
        member = getSuccessMember();
    }

    Member getSuccessMember() {
        member.setUserId("user01");
        member.setUserPw("12345678");
        member.setUserPwRe("12345678");
        member.setUserNm("사용자01");
        return member;
    }

    Member getFailMember(String userId, String userPw, String userPwRe, String userNm) {
        member.setUserId(userId);
        member.setUserPw(userPw);
        member.setUserPwRe(userPwRe);
        member.setUserNm(userNm);
        return member;
    }

    @Test
    @DisplayName("회원가입 성공 시 예외 없음")
    void joinSuccessTest() {
        assertDoesNotThrow(()->{
            member = getSuccessMember();
            joinService.join(member);
        });
    }


    @Test
    @DisplayName("필수 입력 사항(userId, userPw, userPwRe, userNm) 체크 - null 또는 빈칸이면 JoinValidationException 발생")
    void joinRequiredFieldTest() {
        assertAll(
                ()->assertThrows(JoinValidationException.class, ()->{
                    // userId == null
                    member = getFailMember(null,"12345678","12345678","사용자01");
                    joinService.join(member);
                }),
                ()->assertThrows(JoinValidationException.class, ()->{
                    // userId == "    "
                    member = getFailMember("     ","12345678","12345678","사용자01");
                    joinService.join(member);
                }),
                ()->assertThrows(JoinValidationException.class, ()->{
                    // userPw == null
                    member = getFailMember("user01",null,"12345678","사용자01");
                    joinService.join(member);
                }),
                ()->assertThrows(JoinValidationException.class, ()->{
                    // userPw == "    "
                    member = getFailMember("user01","    ","12345678","사용자01");
                    joinService.join(member);
                }),
                ()->assertThrows(JoinValidationException.class, ()->{
                    // userPwRe == null
                    member = getFailMember("user01","12345678",null,"사용자01");
                    joinService.join(member);
                }),
                ()->assertThrows(JoinValidationException.class, ()->{
                    // userPwRe == "    "
                    member = getFailMember("user01", "12345678","     ", "사용자01");
                    joinService.join(member);
                }),
                ()->assertThrows(JoinValidationException.class, ()->{
                    // userNm == null
                    member = getFailMember("user01", "12345678","12345678",null);
                    joinService.join(member);
                }),
                ()->assertThrows(JoinValidationException.class, ()->{
                    // userNm == "     "
                    member = getFailMember("user01", "12345678","12345678","     ");
                    joinService.join(member);
                })
        );
    }
    
    @Test
    @DisplayName("자릿수 테스트 - 아이디(6~16자리), 비밀번호(8자리 이상) : 자릿수 벗어나면 JoinValidationException 발생")
    void LengthTest() {
        assertAll(
                ()->assertThrows(JoinValidationException.class, ()->{
                    // 아이디가 6자리 미만
                    member.setUserId("user");
                    joinService.join(member);
                }),
                ()->assertThrows(JoinValidationException.class, ()->{
                    // 아이디가 16자리 초과
                    member.setUserId("useruseru1243254543643");
                    joinService.join(member);
                }),
                ()->assertThrows(JoinValidationException.class, ()->{
                    // 비밀번호 8자리 미만
                    member.setUserId("user01");
                    member.setUserPw("1234");
                    member.setUserPwRe("1234");
                    joinService.join(member);
                })
        );
    }

    @Test
    @DisplayName("비밀번호 일치여부 확인 - userPw와 userPwRe가 일치하지 않으면 JoinValidationException 발생")
    void passwordEqualTest() {
        assertThrows(JoinValidationException.class, ()->{
           member.setUserPwRe("12395688");
           joinService.join(member);
        });
    }


    @Test
    @DisplayName("중복가입 체크 - 동일한 아이디가 이미 있으면 ExistValidationException 발생")
    void ExistUserIdTest() {
        assertThrows(ExistValidationException.class, ()->{
            member.setUserId("user02");
            joinService.join(member);   // 최초가입
            joinService.join(member);   // 중복가입
        });
    }

}
