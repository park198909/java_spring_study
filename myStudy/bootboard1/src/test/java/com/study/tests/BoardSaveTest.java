package com.study.tests;

import com.study.controllers.board.BoardForm;
import com.study.models.board.Board;
import com.study.models.board.BoardDao;
import com.study.models.board.BoardSaveService;
import com.study.models.board.SaveValidationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@EnableScheduling
@Transactional
public class BoardSaveTest {

    @Autowired
    private BoardSaveService saveService;

    @Autowired
    private BoardDao boardDao;

    public BoardForm getBoardForm() {
        BoardForm boardForm = new BoardForm();
        boardForm.setSubject("제목");
        boardForm.setContent("내용");

        return boardForm;
    }

    @Test
    @DisplayName("게시글 작성 테스트 - 성공하면 예외 없음")
    void insertSuccessTest() {
        assertDoesNotThrow(()->{
            BoardForm boardForm = getBoardForm();
            saveService.save(boardForm);
        });
    }

    @Test
    @DisplayName("필수 항목(subject, content) 체크 - 실패시 SaveValidationException 발생")
    void RequiredFieldTest() {
        assertAll(
                ()->assertThrows(SaveValidationException.class, ()->{
                   // subject == null
                   BoardForm boardForm = getBoardForm();
                   boardForm.setSubject(null);
                   saveService.save(boardForm);
                }),
                ()->assertThrows(SaveValidationException.class, ()->{
                    // subject == 빈값
                    BoardForm boardForm = getBoardForm();
                    boardForm.setSubject("     ");
                    saveService.save(boardForm);
                }),
                ()->assertThrows(SaveValidationException.class, ()->{
                    // content == null
                    BoardForm boardForm = getBoardForm();
                    boardForm.setContent(null);
                    saveService.save(boardForm);
                }),
                ()->assertThrows(SaveValidationException.class, ()->{
                    // content == 빈값
                    BoardForm boardForm = getBoardForm();
                    boardForm.setContent("     ");
                    saveService.save(boardForm);
                })
        );
    }
    
    @Test
    @DisplayName("등록한 게시글 동일성 체크 - 일치하지 않으면 fail()")
    void ExistDataTest() {
        BoardForm boardForm = getBoardForm();
        assertDoesNotThrow(()->{
            saveService.save(boardForm);
        });
        
        // 게시글 번호가 비어있으면 실패
        Long id = boardForm.getId();
        if (id ==null) { 
            fail();
        }
        
        // 게시글 번호가 조회되지 않으면 실패
        Board board = boardDao.get(id);
        if (board == null) {
            fail();
        }
        
        // 작성한 게시글과 조회된 게시글이 같은지 체크
        assertEquals(boardForm.getSubject(), board.getSubject());
        assertEquals(boardForm.getContent(), board.getContent());
    }

}
