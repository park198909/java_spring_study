package org.koreait.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.koreait.models.board.Board;
import org.koreait.models.board.BoardDao;
import org.koreait.models.board.BoardListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BoardListTest {
    @Autowired
    private BoardDao boardDao;

    @Autowired
    private BoardListService listService;

    @Test
    @DisplayName("게시글 전체 조회 - 조회된 게시글이 없으면 fail() 발생")
    void boardListTest() {
        assertDoesNotThrow(()->{
            List<Board> board = listService.gets();
            if (board.isEmpty()) {
                fail();
            }
        });
    }

    @Test
    @DisplayName("게시글 개별 조회 - 조회된 게시글이 없으면 fail() 발생")
    void boardGetTest() {
        assertDoesNotThrow(()->{
            Board board = listService.get(25L);
            if (board == null) {
                fail();
            }
        });
    }
}
