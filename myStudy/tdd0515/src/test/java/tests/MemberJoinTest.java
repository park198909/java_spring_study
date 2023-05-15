package tests;

import models.member.BadRequestException;
import models.member.JoinService;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("회원가입 테스트")
public class MemberJoinTest {

    private JoinService joinService;

    
    @BeforeEach
    @DisplayName("초기 설정")
    public void init() {
        joinService = new JoinService();
    }
    
    @Test
    @DisplayName("회원가입 성공 시 예외 없음")
    void joinSuccessTest() {
        assertDoesNotThrow(()->{
            joinService.join();
        });
    }

    @Test
    @DisplayName("필수입력사항(userId,userPw,userPwRe,userNm,email,mobile) 체크 - null 이면 예외발생")
    void requiredFieldNullTest() {
        assertAll(
                ()->{
                    BadRequestException thw = assertThrows(BadRequestException.class, ()->{
                        // userId == null
                       joinService.join();
                    });
                    String msg = thw.getMessage();
                    assertTrue(msg.contains("아이디를 입력하세요."));
                },
                ()->{
                    BadRequestException thw = assertThrows(BadRequestException.class, ()->{
                        // userPw == null
                        joinService.join();
                    });
                    String msg = thw.getMessage();
                    assertTrue(msg.contains("비밀번호를 입력하세요."));
                },
                ()->{
                    BadRequestException thw = assertThrows(BadRequestException.class, ()->{
                        // userPwRe == null
                        joinService.join();
                    });
                    String msg = thw.getMessage();
                    assertTrue(msg.contains("비밀번호를 확인하세요."));
                },
                ()->{
                    BadRequestException thw = assertThrows(BadRequestException.class, ()->{
                        // userNm == null
                        joinService.join();
                    });
                    String msg = thw.getMessage();
                    assertTrue(msg.contains("회원명을 입력하세요."));
                },
                ()->{
                    BadRequestException thw = assertThrows(BadRequestException.class, ()->{
                        // email == null
                        joinService.join();
                    });
                    String msg = thw.getMessage();
                    assertTrue(msg.contains("이메일을 입력하세요."));
                },
                ()->{
                    BadRequestException thw = assertThrows(BadRequestException.class, ()->{
                        // mobile == null
                        joinService.join();
                    });
                    String msg = thw.getMessage();
                    assertTrue(msg.contains("전화번호를 입력하세요."));
                }
        );
    }

    @Test
    @DisplayName("필수입력사항(userId,userPw,userPwRe,userNm,email,mobile) 체크 - 빈칸 이면 예외발생")
    void requiredFieldBlankTest() {
        assertAll(
                ()->{
                    BadRequestException thw = assertThrows(BadRequestException.class, ()->{
                        // userId == "    "
                        joinService.join();
                    });
                    String msg = thw.getMessage();
                    assertTrue(msg.contains("아이디를 입력하세요."));
                },
                ()->{
                    BadRequestException thw = assertThrows(BadRequestException.class, ()->{
                        // userPw == "    "
                        joinService.join();
                    });
                    String msg = thw.getMessage();
                    assertTrue(msg.contains("비밀번호를 입력하세요."));
                },
                ()->{
                    BadRequestException thw = assertThrows(BadRequestException.class, ()->{
                        // userPwRe == "    "
                        joinService.join();
                    });
                    String msg = thw.getMessage();
                    assertTrue(msg.contains("비밀번호를 확인하세요."));
                },
                ()->{
                    BadRequestException thw = assertThrows(BadRequestException.class, ()->{
                        // userNm == "    "
                        joinService.join();
                    });
                    String msg = thw.getMessage();
                    assertTrue(msg.contains("회원명을 입력하세요."));
                },
                ()->{
                    BadRequestException thw = assertThrows(BadRequestException.class, ()->{
                        // email == "    "
                        joinService.join();
                    });
                    String msg = thw.getMessage();
                    assertTrue(msg.contains("이메일을 입력하세요."));
                },
                ()->{
                    BadRequestException thw = assertThrows(BadRequestException.class, ()->{
                        // mobile == "    "
                        joinService.join();
                    });
                    String msg = thw.getMessage();
                    assertTrue(msg.contains("전화번호를 입력하세요."));
                }
        );
    }
    
}
