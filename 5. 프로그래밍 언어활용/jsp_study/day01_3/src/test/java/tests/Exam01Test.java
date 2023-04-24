package tests;

import models.member.JoinService;
import models.member.JoinValidationException;
import models.member.Member;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("TDD 연습 첫시간")
public class Exam01Test {

    private Member member;
    private JoinService service;

    @BeforeAll
    static void allInit() {
        System.out.println("BeforeAll");
    }

    @BeforeEach
    void init() {   // 단위테스트(@Test) 전 처리할 부분 - 주로 초기화작업
        member = new Member();
        member.setUserId("user01");
        member.setUserPw("123456");

        service = new JoinService();
        System.out.println("BeforeEach");
    }
    
    @Test           // 테스트 케이스(단위 테스트)
    @DisplayName("더하기 테스트")
    void test1() {  // private, protected 사용금지
        int result = 2+3;
        assertEquals(4,result);        
    }

    @Test           // 테스트 케이스(단위 테스트)
    @DisplayName("TDD 연습1")
    @Disabled
    void test2() {
        assertEquals(5,4);  // 미통과
        assertEquals(5,5);  // 통과
    }

    @Test
    @DisplayName("TDD 연습2")
    @Disabled
    void test3() {
        assertAll(()-> assertEquals(5,4),
                ()-> assertEquals(5,5),
                ()-> assertEquals(10,5)
        );
    }
    
    @Test
    @DisplayName("회원가입 성공시 예외없음")
    void test4() {
        assertDoesNotThrow(()->{    // 예외 발생이 없으면 성공
            service.join(member);
        });
    }
    
    @Test
    @DisplayName("필수항목 체크 - userId 누락시 JoinValidationException 발생")
    void test5() {
        JoinValidationException thrown =  assertThrows(JoinValidationException.class,
                () -> { // JoinValidationException 발생하면 통과
                        member.setUserId("   ");
                        service.join(member);
                      });

        String message = thrown.getMessage();
        assertTrue(message.contains("아이디"));
    }

    @AfterEach
    void destroy() {
        System.out.println("AfterEach");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("AfterAll");
    }
}
