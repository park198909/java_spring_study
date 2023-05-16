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
        member = manager.member();
        if (key.equals("userId")) member.setUserId(value);
        if (key.equals("userPw")) member.setUserPw("@a123456");
        if (key.equals("userPwRe"))  member.setUserPwRe("@a123456");
        if (key.equals("userNm")) member.setUserNm("사용자01");
        if (key.equals("email")) member.setEmail("user01@org.com");
        if (key.equals("mobile")) member.setMobile("01012345678");
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
    @DisplayName("필수항목 체크(userId, userPw, userPwRe, userNm, email, mobile, regDt) - null 이면 예외 발생")
    void requiredFieldNullTest() {
        assertAll(
                ()->assertThrows(BadRequestException.class, ()->{
                    // userId == null
                   member = getFailMember("userId", null);
                }),
                ()->assertThrows(BadRequestException.class, ()->{
                    // userPw == null
                    member = getFailMember("userPw", null);
                }),
                ()->assertThrows(BadRequestException.class, ()->{
                    // userPwRe == null
                    member = getFailMember("userPwRe", null);
                }),
                ()->assertThrows(BadRequestException.class, ()->{
                    // userNm == null
                    member = getFailMember("userNm", null);
                }),
                ()->assertThrows(BadRequestException.class, ()->{
                    // email == null
                    member = getFailMember("email", null);
                }),
                ()->assertThrows(BadRequestException.class, ()->{
                    // mobile == null
                    member = getFailMember("mobile", null);
                }),
                ()->assertThrows(BadRequestException.class, ()->{
                    // regDt == null
                    member = getFailMember("regDt", null);
                })
        );
    }



}
