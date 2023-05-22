package com.study.tests;

import com.study.models.board.Board;
import com.study.models.board.BoardDao;
import com.study.models.board.BoardRemoveService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
@EnableScheduling
public class BoardRemoveTest {

    @Autowired
    private BoardRemoveService removeService;

    @Autowired
    private BoardDao boardDao;

    @Test
    @DisplayName("게시글 삭제 - 삭제 실패 시 fail() 발생")
    void boardRemoveTest() {
        assertDoesNotThrow(()->{
            Integer success = removeService.remove(11L);
            if (success == 0 ) {
                fail();
            }
        });
    }
}
