package tests;

import models.member.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("회원가입 테스트")
public class MemberJoinTest {

    private Member member;
    private JoinService joinService;
    private JoinValidator joinValidator;
    private MemberDao memberDao;


    @BeforeEach
    void init() {
        member = new Member();
        memberDao = new MemberDao();
        joinValidator = new JoinValidator();
        joinValidator.setMemberDao(memberDao);
        joinService = new JoinService(joinValidator, memberDao);

        member = getSuccessMember();
    }

    public Member getSuccessMember() {
        member = new Member();
        member.setUserId("user01");
        member.setUserPw("!a1234567");
        member.setUserPwRe("!a1234567");
        member.setUserNm("사용자01");
        member.setEmail("user01@org.com");
        member.setMobile("01011112222");
        return member;
    }

    public Member getFailMember(String key, String value) {
        member = getSuccessMember();
        if (key.equals("userId")) member.setUserId(value);
        if (key.equals("userPw")) member.setUserPw(value);
        if (key.equals("userPwRe")) member.setUserPwRe(value);
        if (key.equals("userNm")) member.setUserNm(value);
        if (key.equals("email")) member.setEmail(value);
        if (key.equals("mobile")) member.setMobile(value);
        return member;
    }

    @Test
    @DisplayName("회원가입 성공 시 예외 없음")
    void joinSuccessTest() {
        assertDoesNotThrow(()->{
            joinService.join(member);
        });
    }

    @Test
    @DisplayName("필수 입력 사항(userId,userPw,userPwRe,userNm,email,mobile)체크 - null 또는 빈칸이면 JoinValidationException 발생" )
    void RequiredDataTest() {
        assertAll(
                ()->assertThrows(JoinValidationException.class, ()->{
                    // userId == null
                    member = getFailMember("userId", null);
                    joinService.join(member);
                }),
                ()->assertThrows(JoinValidationException.class, ()->{
                    // userId == "     "
                    member = getFailMember("userId", "     ");
                    joinService.join(member);
                }),
                ()->assertThrows(JoinValidationException.class, ()->{
                    // userPw == null
                    member = getFailMember("userPw", null);
                    joinService.join(member);
                }),
                ()->assertThrows(JoinValidationException.class, ()->{
                    // userPw == "     "
                    member = getFailMember("userPw", "     ");
                    joinService.join(member);
                }),
                ()->assertThrows(JoinValidationException.class, ()->{
                    // userPwRe == null
                    member = getFailMember("userPwRe", null);
                    joinService.join(member);
                }),
                ()->assertThrows(JoinValidationException.class, ()->{
                    // userPwRe == "     "
                    member = getFailMember("userPwRe", "     ");
                    joinService.join(member);
                }),
                ()->assertThrows(JoinValidationException.class, ()->{
                    // userNm == null
                    member = getFailMember("userNm", null);
                    joinService.join(member);
                }),
                ()->assertThrows(JoinValidationException.class, ()->{
                    // userNm == "     "
                    member = getFailMember("userNm", "     ");
                    joinService.join(member);
                }),
                ()->assertThrows(JoinValidationException.class, ()->{
                    // email == null
                    member = getFailMember("email", null);
                    joinService.join(member);
                }),
                ()->assertThrows(JoinValidationException.class, ()->{
                    // email == "     "
                    member = getFailMember("email", "     ");
                    joinService.join(member);
                }),
                ()->assertThrows(JoinValidationException.class, ()->{
                    // mobile == null
                    member = getFailMember("mobile", null);
                    joinService.join(member);
                }),
                ()->assertThrows(JoinValidationException.class, ()->{
                    // mobile == "     "
                    member = getFailMember("mobile", "     ");
                    joinService.join(member);
                })
        );
    }

    @Test
    @DisplayName("비밀번호 일치 체크 - 비밀번호와 비밀번호 확인이 일치하지 않으면 JoinValidationException 발생 ")
    void passwordEqualTest() {
        assertThrows(JoinValidationException.class, ()->{
           member = getFailMember("userPw","!a1234568");
           joinValidator.check(member);
        });
    }

    @Test
    @DisplayName("가입 정보 자릿수 체크 - 아이디는 6~16자리, 전화번호는 11자리, 비밀번호는 8자리 이상 : 자릿수 벗어날시 JoinValidationException 발생")
    void dataLengthTest() {
        assertAll(
                ()->assertThrows(JoinValidationException.class, ()->{
                    // 아이디 6자리 미만
                    member = getFailMember("userId", "user");
                    joinService.join(member);
                }),
                ()->assertThrows(JoinValidationException.class, ()->{
                    // 아이디 16자리 초과
                    member = getFailMember("userId", "user123456789123456789");
                    joinService.join(member);
                }),
                ()->assertThrows(JoinValidationException.class, ()->{
                    // 비밀번호 8자리 미만
                    member = getFailMember("userPw", "1234");
                    member = getFailMember("userPwRe", "1234");
                    joinService.join(member);
                }),
                ()->assertThrows(JoinValidationException.class, ()->{
                    // 전화번호 11자리 이외
                    member = getFailMember("mobile", "010123456789");
                    joinService.join(member);
                })
        );
    }

    @Test
    @DisplayName("비밀번호가 영문자,숫자,특수문자를 각 1개 이상 포함하지 않거나 한글을 포함하면 JoinValidationException 발생, " +
            "비밀번호는  알파벳, 숫자, 특수문자가 1개 이상 포함되어야 하며 한글은 불가합니다.")
    void passwordFormTest() {
        assertAll (
        ()->{
                JoinValidationException thr = assertThrows(JoinValidationException.class, () -> {
                    // userPw, userPwRe에 특수문자 미포함
                    member = getFailMember("userPw", "a1234567");
                    member.setUserPwRe("a1234567");
                    joinService.join(member);
                    });
                   String msg1 = thr.getMessage();
                   assertTrue(msg1.contains("비밀번호는  알파벳, 숫자, 특수문자가 1개 이상 포함되어야"));
                    } ,
            () ->{
                    JoinValidationException thr = assertThrows(JoinValidationException.class, () -> {
                    // userPw, userPwRe에 영문자 미포함
                    member = getFailMember("userPw", "!@123456");
                    member.setUserPwRe("!@123456");
                    joinService.join(member);
                    });
                    String msg1 = thr.getMessage();
                    assertTrue(msg1.contains("비밀번호는  알파벳, 숫자, 특수문자가 1개 이상 포함되어야"));
                    },
                () ->{
                    JoinValidationException thr = assertThrows(JoinValidationException.class, () -> {
                    // userPw, userPwRe에 숫자 미포함
                    member = getFailMember("userPw", "!@asdfgh");
                    member.setUserPwRe("!@asdfgh");
                    joinService.join(member);
                    });
                    String msg1 = thr.getMessage();
                    assertTrue(msg1.contains("비밀번호는  알파벳, 숫자, 특수문자가 1개 이상 포함되어야"));
                    },
                () ->{
                    JoinValidationException thr = assertThrows(JoinValidationException.class, () -> {
                    // userPw, userPwRe에 한글 포함
                    member = getFailMember("userPw", "!a123456롷");
                    member.setUserPwRe("!a123456롷");
                    joinService.join(member);
                    });
                    String msg1 = thr.getMessage();
                    assertTrue(msg1.contains("비밀번호는  알파벳, 숫자, 특수문자가 1개 이상 포함되어야"));
                    }
        );
    }

    @Test
    @DisplayName("이메일형식 체크 - 이메일 형식에 맞지 않으면  JoinValidationException 발생, 이메일 형식에 맞춰 입력해주세요(sample@sample.com)")
    void emailFormTest() {
        JoinValidationException thr = assertThrows(JoinValidationException.class, ()->{
            member = getFailMember("email", "user#$^01@org.com");
            joinService.join(member);
        });
        String msg = thr.getMessage();
        assertTrue(msg.contains("이메일 형식에 맞춰 입력"));
    }

    // 아이디 중복가입 체크
    @Test
    @DisplayName("가입 아이디 중복 체크 - 가입하려는 아이디가 존재하면 JoinValidationException 발생, 이미 존재하는 아이디입니다.")
    void userIdExistTest() {
        JoinValidationException thr = assertThrows(JoinValidationException.class, ()->{
            member.setUserId("user99");
            joinService.join(member);   // 최초 가입
            joinService.join(member);   // 중복 가입
        });
        String msg = thr.getMessage();
        assertTrue(msg.contains("이미 존재하는 아이디"));
    }
}
