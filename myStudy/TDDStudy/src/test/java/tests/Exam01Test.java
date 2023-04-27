package tests;

import models.member.JoinService;
import models.member.JoinValidationException;
import models.member.Member;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("TDD day01")
public class Exam01Test {
    private Member member;
    private JoinService service;

    @BeforeAll      //  최초 1회만 수행
    static void allInit() {
        System.out.println("BeforeAll");
    }

    @BeforeEach     // 테스트 메서드 실행 전 수행
    void init() {
        member = new Member();
        member.setUserId("user01");
        member.setUserPw("12345678");

        service = new JoinService();
        System.out.println("BeforeEach");
    }

    @Test
    @DisplayName("TDD add")
    @Disabled
    void test1() {
        int result = 2+3;
        assertEquals(4,result);
    }

    @Test
    @DisplayName("TDD practice1")
    @Disabled
    void test2() {
        assertEquals(5,4);
        assertEquals(5,5);
    }

    @Test
    @DisplayName("TDD practice2")
    @Disabled
    void test3() {
        assertAll(()->assertEquals(5,4),
                ()->assertEquals(5,5),
                ()->assertEquals(10,5)
        );
    }

    @Test
    @DisplayName("회원가입 성공시 예외없음")
    void test4() {
        assertDoesNotThrow(()->{
            service.join(member);
        });
    }

    @Test
    @DisplayName("필수항목 체크 - userId누락 시 JoinValidationException발생")
    void test5() {
        JoinValidationException thrown = assertThrows(JoinValidationException.class,
                ()->{   // JoinValidationException 발생하면 통과
                  member.setUserId("   ");  // 예외발생을 위해 userId를 공백으로 변환
                  service.join(member);     // JoinValidationException 발생
                });
        String message = thrown.getMessage();   // JoinValidationException객체.getMessage();
        assertTrue(message.contains("아이디"));    // message안에 "아이디"가 포함되면  통과
    }

    @AfterEach      // 테스트 메서드 실행 후 수행
    void destroy() {
        System.out.println("AfterEach");
    }

    @AfterAll   // 최후 1회만 실행
    static void afterAll() {
        System.out.println("AfterAll");
    }
}
