package tests;

import models.member.BadRequestException;
import models.member.JoinService;
import models.member.Member;
import models.member.ServiceManager;
import org.junit.jupiter.api.*;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("회원가입 테스트")
public class MemberJoinTest {

    private JoinService joinService;
    private Member member;
    private ServiceManager manager = new ServiceManager();


    @BeforeEach
    @DisplayName("테스트 전 초기설정")
    void init() {
        joinService = manager.joinService();
        member = getSuccessMember();

    }

    public Member getSuccessMember() {
        member = manager.member();
        member.setUserId("user01");
        member.setUserPw("@a123456");
        member.setUserPwRe("@a123456");
        member.setUserNm("사용자01");
        member.setEmail("user01@org.com");
        member.setMobile("01012345678");
        member.setRegDt(LocalDateTime.now());
        return member;
    }

    public Member getFailMember(String key, String value) {
        member = getSuccessMember();
        if (key.equals("userId")) member.setUserId(value);
        if (key.equals("userPw")) member.setUserPw(value);
        if (key.equals("userPwRe"))  member.setUserPwRe(value);
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
    @DisplayName("필수항목 null체크(userId, userPw, userPwRe, userNm, email, mobile,) - null 이면 예외 발생")
    void requiredFieldNullTest() {
        assertAll(
                ()->assertThrows(BadRequestException.class, ()->{
                    // userId == null
                   member = getFailMember("userId", null);
                   joinService.join(member);
                }),
                ()->assertThrows(BadRequestException.class, ()->{
                    // userPw == null
                    member = getFailMember("userPw", null);
                    joinService.join(member);
                }),
                ()->assertThrows(BadRequestException.class, ()->{
                    // userPwRe == null
                    member = getFailMember("userPwRe", null);
                    joinService.join(member);
                }),
                ()->assertThrows(BadRequestException.class, ()->{
                    // userNm == null
                    member = getFailMember("userNm", null);
                    joinService.join(member);
                }),
                ()->assertThrows(BadRequestException.class, ()->{
                    // email == null
                    member = getFailMember("email", null);
                    joinService.join(member);
                }),
                ()->assertThrows(BadRequestException.class, ()->{
                    // mobile == null
                    member = getFailMember("mobile", null);
                    joinService.join(member);
                })
        );
    }
    @Test
    @DisplayName("필수항목 빈칸체크(userId, userPw, userPwRe, userNm, email, mobile,) - 빈칸 이면 예외 발생")
    void requiredFieldBlankTest() {
        assertAll(
                ()->assertThrows(BadRequestException.class, ()->{
                    // userId == "     "
                    member = getFailMember("userId", "     ");
                    joinService.join(member);
                }),
                ()->assertThrows(BadRequestException.class, ()->{
                    // userPw == "     "
                    member = getFailMember("userPw", "     ");
                    joinService.join(member);
                }),
                ()->assertThrows(BadRequestException.class, ()->{
                    // userPwRe == "     "
                    member = getFailMember("userPwRe", "     ");
                    joinService.join(member);
                }),
                ()->assertThrows(BadRequestException.class, ()->{
                    // userNm == "     "
                    member = getFailMember("userNm", "     ");
                    joinService.join(member);
                }),
                ()->assertThrows(BadRequestException.class, ()->{
                    // email == "     "
                    member = getFailMember("email", "     ");
                    joinService.join(member);
                }),
                ()->assertThrows(BadRequestException.class, ()->{
                    // mobile == "     "
                    member = getFailMember("mobile", "     ");
                    joinService.join(member);
                })
        );
    }

    @Test
    @DisplayName("비밀번호 일치 확인 - 비밀번호 다르면 예외 발생, 비밀번호가 일치하지 않습니다")
    void passwordEqualTest() {
        BadRequestException thw = assertThrows(BadRequestException.class, ()->{
            member = getFailMember("userPwRe", "!a123456");
            joinService.join(member);
        });
        String msg = thw.getMessage();
        assertTrue(msg.contains("비밀번호가 일치하지"));
    }

    @Test
    @DisplayName("자릿수 일치 테스트 - 아이디(6~16자리), 비밀번호(8자리 이상), 전화번호(11자리) : 자릿수 안맞으면 예외발생 ")
    void strLengthTest() {
        assertAll(
                ()->{
                    BadRequestException thw = assertThrows(BadRequestException.class, ()->{
                        // userId 6자리 미만, 아이디는 6~16자리 이내로 작성하세요.
                        member = getFailMember("userId", "user");
                        joinService.join(member);
                    });
                    String msg = thw.getMessage();
                    assertTrue(msg.contains("아이디는 6~16자리 "));
                },
                ()->{
                    BadRequestException thw = assertThrows(BadRequestException.class, ()->{
                        // userId 16자리 초과, 아이디는 6~16자리 이내로 작성하세요.
                        member = getFailMember("userId", "user123456789123456789");
                        joinService.join(member);
                    });
                    String msg = thw.getMessage();
                    assertTrue(msg.contains("아이디는 6~16자리 "));
                },
                ()->{
                    BadRequestException thw = assertThrows(BadRequestException.class, ()->{
                        // userPw 8자리 미만, 비밀번호는 8자리 이상 입력하세요.
                        member = getFailMember("userPw", "@a123");
                        member.setUserPwRe("@a123");
                        joinService.join(member);
                    });
                    String msg = thw.getMessage();
                    assertTrue(msg.contains("비밀번호는 8자리 이상"));
                },
                ()->{
                    BadRequestException thw = assertThrows(BadRequestException.class, ()->{
                        // mobile 11자리 이외, 전화번호는 11자리 모두 입력하세요.
                        member = getFailMember("mobile", "010123456789");
                        joinService.join(member);
                    });
                    String msg = thw.getMessage();
                    assertTrue(msg.contains("전화번호는 11자리"));
                }
        );
    }



}
