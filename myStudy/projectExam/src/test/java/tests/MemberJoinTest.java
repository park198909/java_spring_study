package tests;

import models.member.BadRequestException;
import models.member.JoinService;
import models.member.Member;
import models.member.ServiceManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class MemberJoinTest {

    private Member member;
    private JoinService service;

    @BeforeEach
    public void init() {
        ServiceManager manager = new ServiceManager();
        service = manager.getJoinService();

        member = new Member();
        member.setUserId("userfirst");
        member.setUserPw("_aA123456");
        member.setUserPwRe("_aA123456");
        member.setUserNm("사용자01");
        member.setAgree(true);
    }

    @Test
    @DisplayName("회원가입에 성공하면 예외가 발생 안함")
    public void joinSuccess() {
        assertDoesNotThrow(()->{
           service.join(member);
        });
    }
    
    @Test
    @DisplayName("join 메서드에 null값이 들어가면 BadRequestException 발생")
    public void dataValidation1() {
        assertThrows(BadRequestException.class, ()->{
           service.join(null); 
        });
    }

    @Test
    @DisplayName("필수 항목 체크 - userId, userPw, userPw, userNm 실패 시 BadRequestException 발생")
    public void dataValidation2() {
        assertThrows(BadRequestException.class, () -> {
            // userNm이 null인 경우
            member.setUserNm(null);
            service.join(member);
        });
        assertThrows(BadRequestException.class, () -> {
            // userPwRe이 null인 경우
            member.setUserPwRe(null);
            service.join(member);
        });
        assertThrows(BadRequestException.class, () -> {
            // userPw이 null인 경우
            member.setUserPw(null);
            service.join(member);
        });
        assertThrows(BadRequestException.class, () -> {
            // userId이 null인 경우
            member.setUserId(null);
            service.join(member);
        });
    }
}
