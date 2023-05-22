package com.study.tests;

import com.study.models.board.Board;
import com.study.models.board.BoardDao;
import com.study.models.board.BoardListService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@EnableScheduling
public class BoardListTest {

    @Autowired
    private BoardListService listService;

    @Test
    @DisplayName("게시글 목록 조회 - 조회 실패 시 fail() 발생")
    void BoardListTest() {
        assertDoesNotThrow(()->{
            List<Board> lists = listService.gets();
            if (lists.isEmpty() ) {
                fail();
            }
        });
    }
}