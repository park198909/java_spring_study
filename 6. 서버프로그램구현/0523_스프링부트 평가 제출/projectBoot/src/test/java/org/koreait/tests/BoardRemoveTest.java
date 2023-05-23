package org.koreait.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.koreait.models.board.BoardDao;
import org.koreait.models.board.BoardRemoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BoardRemoveTest {
    @Autowired
    private BoardDao boardDao;

    @Autowired
    private BoardRemoveService removeService;
    
    @Test
    @DisplayName("게시글 삭제 기능 - 게시글이 지워지지 않았으면 fail() 발생")
    void boardRemoveTest() {
        assertDoesNotThrow(()->{
            // 게시글 삭제 시 1 출력
            int success = removeService.remove(25L);
            if(success == 0) {  // 게시글이 지워지지 않음
                fail();
            }
        });
    }
}
