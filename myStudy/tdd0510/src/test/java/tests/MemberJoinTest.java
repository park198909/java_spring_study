package tests;

import models.member.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("회원가입 테스트")
public class MemberJoinTest {

    private Member member;
    private MemberDao memberDao;
    private JoinService joinService;
    private JoinValidator joinValidator;

    @BeforeEach
    @DisplayName("개별 테스트 시작 시 적용되는 기본 설정")
    void init() {
        memberDao = new MemberDao();
        joinValidator = new JoinValidator();
        joinValidator.setMemberDao(memberDao);
        joinService = new JoinService(joinValidator,memberDao);
    
        member = getSuccessMember();
    }

    public Member getSuccessMember() {
        member = new Member();
        member.setUserId("user01");
        member.setUserPw("_aA123456");
        member.setUserPwRe("_aA123456");
        member.setUserNm("사용자01");
        member.setEmail("user01@org.com");
        member.setMobile("01011112222");
        return member;
    }

    public Member getFailMember(String key, String value) {
        member = getSuccessMember();
        if(key.equals("userId")) member.setUserId(value);
        if(key.equals("userPw")) member.setUserPw(value);
        if(key.equals("userPwRe")) member.setUserPwRe(value);
        if(key.equals("userNm")) member.setUserNm(value);
        if(key.equals("email")) member.setEmail(value);
        if(key.equals("mobile")) member.setMobile(value);
        return member;
    }

    @Test
    @DisplayName("회원가입 성공하면 예외 없음")
    void joinSuccessTest() {
        assertDoesNotThrow(()->{
            joinService.join(member);
        });
    }

    @Test
    @DisplayName("필수 입력 사항(userId, userPw, userPwRe, userNm, email. mobile) 체크 - null 또는 빈칸이면 JoinValidationException 발생")
    void joinRequiredTest() {
        assertAll(
                ()->assertThrows(JoinValidationException.class, ()->{
                    // userId == null
                    member = getFailMember("userId",null);
                    joinService.join(member);
                }),
                ()->assertThrows(JoinValidationException.class, ()->{
                    // userId == "     "
                    member = getFailMember("userId","    ");
                    joinService.join(member);
                }),
                ()->assertThrows(JoinValidationException.class, ()->{
                    // userPw == null
                    member = getFailMember("userPw",null);
                    joinService.join(member);
                }),
                ()->assertThrows(JoinValidationException.class, ()->{
                    // userPw == "     "
                    member = getFailMember("userPw","    ");
                    joinService.join(member);
                }),
                ()->assertThrows(JoinValidationException.class, ()->{
                    // userPwRe == null
                    member = getFailMember("userPwRe",null);
                    joinService.join(member);
                }),
                ()->assertThrows(JoinValidationException.class, ()->{
                    // userPwRe == "     "
                    member = getFailMember("userPwRe","    ");
                    joinService.join(member);
                }),
                ()->assertThrows(JoinValidationException.class, ()->{
                    // userNm == null
                    member = getFailMember("userNm",null);
                    joinService.join(member);
                }),
                ()->assertThrows(JoinValidationException.class, ()->{
                    // userNm == "     "
                    member = getFailMember("userNm","    ");
                    joinService.join(member);
                }),
                ()->assertThrows(JoinValidationException.class, ()->{
                    // email == null
                    member = getFailMember("email",null);
                    joinService.join(member);
                }),
                ()->assertThrows(JoinValidationException.class, ()->{
                    // email == "     "
                    member = getFailMember("email","    ");
                    joinService.join(member);
                }),
                ()->assertThrows(JoinValidationException.class, ()->{
                    // mobile == null
                    member = getFailMember("mobile",null);
                    joinService.join(member);
                }),
                ()->assertThrows(JoinValidationException.class, ()->{
                    // mobile == "     "
                    member = getFailMember("mobile","    ");
                    joinService.join(member);
                })
        );
    }
    
    @Test
    @DisplayName("자릿수 테스트 - 아이디 6~16자리, 비밀번호 8자리 이상, 전화번호 11자리 - 자릿수 벗어나면 JoinValidationException 발생 ")
    void lengthTest() {
        assertAll(
                ()->assertThrows(JoinValidationException.class, ()->{
                    // userId 16자리 이상
                   member = getFailMember("userId", "user123456789123456789123456");
                   joinService.join(member);
                }),
                ()->assertThrows(JoinValidationException.class, ()->{
                    // userId 6자리 이하
                    member = getFailMember("userId", "user");
                    joinService.join(member);
                }),
                ()->assertThrows(JoinValidationException.class, ()->{
                    // userPw 8자리 이하
                    member = getFailMember("userPw", "1234");
                    member.setUserPwRe("1234");
                    joinService.join(member);
                }),
                ()->assertThrows(JoinValidationException.class, ()->{
                    // mobile 11자리 이외
                    member = getFailMember("mobile", "0101111222233");
                    joinService.join(member);
                })               
        );
    }

    @Test
    @DisplayName("아이디 중복가입 체크 - 이미 가입한 아이디면 JoinValidationException 발생")
    void existIdTest() {
        assertThrows(DuplicateValidationException.class, ()->{
            System.out.println(member.getEmail());
            joinService.join(member);   // 최초가입
            joinService.join(member);   // 중복가입
        });
    }

    @Test
    @DisplayName("비밀번호 일치 체크 - 일치하지 않으면 JoinValidationException 발생, 비밀번호가 일치하지 않습니다.")
    void passwordTest() {
        JoinValidationException thrown = assertThrows(JoinValidationException.class, ()->{
            member = getFailMember("userPwRe", "12345678");
            joinService.join(member);
        });
        String message = thrown.getMessage();
        assertTrue(message.contains("비밀번호가 일치하지"));
    }

    @Test
    @DisplayName("전화번호 010시작 체크 - 010으로 시작하지 않으면 JoinValidationException 발생, 전화번호는 010으로 시작해야 합니다.")
    void mobileNumberStartTest() {
        JoinValidationException thrown = assertThrows(JoinValidationException.class, ()->{
            member = getFailMember("mobile","01122223333");
            joinService.join(member);
        });
        String message = thrown.getMessage();
        assertTrue(message.contains("전화번호는 010으로 시작"));
    }

    @Test
    @DisplayName("이메일 형식 테스트 - 이메일에 @가 1개만 포함, 틀리면 JoinValidationException 발생, 이메일 형식(email@org.com)을 맞춰서 작성하세요.")
    void emailFormTest() {
        assertAll(
                ()->{
                    JoinValidationException thrown = assertThrows(JoinValidationException.class, ()->{
                        // 이메일에 @ 미포함
                        member = getFailMember("email","user01-org.com");
                        joinService.join(member);
                    });
                    String message = thrown.getMessage();
                    assertTrue(message.contains("이메일 형식(email@org.com)을 맞춰서"));
                },
                ()->{
                    JoinValidationException thrown = assertThrows(JoinValidationException.class, ()->{
                        // 이메일에 @ 2개 이상 포함
                        member = getFailMember("email","user@01@org.com");
                        joinService.join(member);
                    });
                    String message = thrown.getMessage();
                    assertTrue(message.contains("이메일 형식(email@org.com)을 맞춰서"));
                }
        );
    }
}
