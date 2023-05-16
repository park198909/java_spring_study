package tests;

import models.member.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MemberJoinTest {

    private Member member;
    private JoinService joinService;
    private JoinValidator joinValidator;
    private MemberDao memberDao;


    public Member getSuccessMember() {
        member = new Member();
        member.setUserId("user01");
        member.setUserPw("_aA123456");
        member.setUserPwRe("_aA123456");
        member.setUserNm("사용자01");
        member.setEmail("user01@org.com");
        member.setMobile("01012345678");
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

    @BeforeEach
    void init() {
        memberDao = new MemberDao();
        joinValidator = new JoinValidator();
        joinValidator.setMemberDao(memberDao);
        joinService = new JoinService(joinValidator, memberDao);
        member = getSuccessMember();
    }
    @Test
    @DisplayName("회원가입 성공하면 예외 없음")
    void joinSuccessTest() {
        assertDoesNotThrow(()->{
            joinService.join(member);
        });
    }
    @Test
    @DisplayName("필수항목(userId,userPw,userPwRe,userNm,email,mobile) 체크 - null or 빈칸이면 예외 발생")
    void requiredFieldTest() {
        assertAll(
                ()->assertThrows(BadRequestException.class, ()->{
                    // userId ==null
                    member = getFailMember("userId", null);
                    joinService.join(member);
                }),
                ()->assertThrows(BadRequestException.class, ()->{
                    // userId =="     "
                    member = getFailMember("userId", "     ");
                    joinService.join(member);
                }),
                ()->assertThrows(BadRequestException.class, ()->{
                    // userPw ==null
                    member = getFailMember("userPw", null);
                    joinService.join(member);
                }),
                ()->assertThrows(BadRequestException.class, ()->{
                    // userPw =="     "
                    member = getFailMember("userPw", "     ");
                    joinService.join(member);
                }),
                ()->assertThrows(BadRequestException.class, ()->{
                    // userPwRe==null
                    member = getFailMember("userPwRe", null);
                    joinService.join(member);
                }),
                ()->assertThrows(BadRequestException.class, ()->{
                    // userPwRe=="     "
                    member = getFailMember("userPwRe", "     ");
                    joinService.join(member);
                }),
                ()->assertThrows(BadRequestException.class, ()->{
                    // userNm==null
                    member = getFailMember("userNm", null);
                    joinService.join(member);
                }),
                ()->assertThrows(BadRequestException.class, ()->{
                    // userNm=="     "
                    member = getFailMember("userNm", "     ");
                    joinService.join(member);
                }),
                ()->assertThrows(BadRequestException.class, ()->{
                    // email==null
                    member = getFailMember("email", null);
                    joinService.join(member);
                }),
                ()->assertThrows(BadRequestException.class, ()->{
                    // email=="     "
                    member = getFailMember("email", "     ");
                    joinService.join(member);
                }),
                ()->assertThrows(BadRequestException.class, ()->{
                    // mobile==null
                    member = getFailMember("mobile", null);
                    joinService.join(member);
                }),
                ()->assertThrows(BadRequestException.class, ()->{
                    // mobile=="     "
                    member = getFailMember("mobile", "     ");
                    joinService.join(member);
                })
        );
    }
    
    @Test
    @DisplayName("비밀번호 일치 체크 - 일치하지 않으면 에러 발생, 비밀번호가 일치하지 않습니다.")
    void passwordEqualTest() {
        assertAll(
                ()->{
                    BadRequestException thw = assertThrows(BadRequestException.class, ()->{
                        member = getFailMember("userPw","!aA123456");
                        joinService.join(member);
                    });
                    String msg = thw.getMessage();
                    assertTrue(msg.contains("비밀번호가 일치하지"));
                }
        );
    }

    @Test
    @DisplayName("아이디(6~16자리), 비밀번호(8자리 이상), 전화번호 자릿수(11자리) 체크 - 자릿수 벗어나면 예외 발생")
    void dataLengthTest() {
        assertAll(
                ()->{
                    BadRequestException thw = assertThrows(BadRequestException.class, ()->{
                        // userId 6자리 미만 
                       member = getFailMember("userId","user");
                       joinService.join(member);                       
                    });
                    String msg = thw.getMessage();
                    assertTrue(msg.contains("아이디는 6~16자리 사이로 "));
                },
                ()->{
                    BadRequestException thw = assertThrows(BadRequestException.class, ()->{
                        // userId 16자리 초과 
                        member = getFailMember("userId","user123456789123456789");
                        joinService.join(member);
                    });
                    String msg = thw.getMessage();
                    assertTrue(msg.contains("아이디는 6~16자리 사이로 "));
                },
                ()->{
                    BadRequestException thw = assertThrows(BadRequestException.class, ()->{
                        // userPw 8자리 미만 
                        member = getFailMember("userPw","_a3456");
                        member.setUserPwRe("_a3456");
                        joinService.join(member);
                    });
                    String msg = thw.getMessage();
                    assertTrue(msg.contains("비밀번호는 8자리 이상"));
                },
                ()->{
                    BadRequestException thw = assertThrows(BadRequestException.class, ()->{
                        // mobile 11자리 이외
                        member = getFailMember("mobile","010123456");
                        joinService.join(member);
                    });
                    String msg = thw.getMessage();
                    assertTrue(msg.contains("전화번호는 11자리 모두"));
                }
        );
    }
    
    // 이메일,전화번호,비밀번호 형식 체크 - 형식을 벗어나면 예외 발생
    @Test
    @DisplayName("이메일(user01@org.com),전화번호(010********),비밀번호 형식(영문자,숫자,특수문자 1개씩 포함) 체크 - 형식을 벗어나면 예외 발생")
    void dataFormTest() {
        assertAll(
                ()->{
                    // email 형식 체크,, 이메일 형식을 확인하세요.
                    BadRequestException thw = assertThrows(BadRequestException.class, ()->{
                        member = getFailMember("email", "user01@orgcom");
                        joinService.join(member);
                    });
                    String msg = thw.getMessage();
                    System.out.println(msg);
                    assertTrue(msg.contains("이메일 형식을 확인"));
                },
                ()->{
                    // 전화번호 형식 체크, -를 제외한 전화번호 11자리를 입력하세요.
                    BadRequestException thw = assertThrows(BadRequestException.class, ()->{
                        member = getFailMember("mobile", "01312345678");
                        joinService.join(member);
                    });
                    String msg = thw.getMessage();
                    System.out.println(msg);
                    assertTrue(msg.contains("-를 제외한 전화번호 11자리를"));
                },
                ()->{
                    // 비밀번호 형식 체크, 비밀번호는 영어 대소문자,숫자,특수문자가 각각 1개 이상 포함되야 합니다.
                    BadRequestException thw = assertThrows(BadRequestException.class, ()->{
                        // 영문자 부재 _!@#$%^&*\(\)]
                        member = getFailMember("userPw", "1^234567");
                        member.setUserPwRe("1^234567");
                        joinService.join(member);
                    });
                    String msg = thw.getMessage();
                    System.out.println(msg);
                    assertTrue(msg.contains("비밀번호는 영어 대소문자,숫자,특수문자가 "));
                },
                ()->{
                    BadRequestException thw = assertThrows(BadRequestException.class, ()->{
                        // 특수문자 부재
                        member = getFailMember("userPw", "a12345678");
                        member.setUserPwRe("a12345678");
                        joinService.join(member);
                    });
                    String msg = thw.getMessage();
                    System.out.println(msg);
                    assertTrue(msg.contains("비밀번호는 영어 대소문자,숫자,특수문자가 "));
                },
                ()->{
                    BadRequestException thw = assertThrows(BadRequestException.class, ()->{
                        // 숫자 부재
                        member = getFailMember("userPw", "!asddgfgfe");
                        member.setUserPwRe("!asddgfgfe");
                        joinService.join(member);
                    });
                    String msg = thw.getMessage();
                    System.out.println(msg);
                    assertTrue(msg.contains("비밀번호는 영어 대소문자,숫자,특수문자가 "));
                }
        );
    }

    // 아이디 중복가입 체크


}
