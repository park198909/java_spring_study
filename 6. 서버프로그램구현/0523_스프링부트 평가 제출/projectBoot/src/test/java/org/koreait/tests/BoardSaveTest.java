package org.koreait.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.koreait.controllers.board.BoardForm;
import org.koreait.models.board.Board;
import org.koreait.models.board.BoardDao;
import org.koreait.models.board.BoardSaveService;
import org.koreait.models.board.SaveValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BoardSaveTest {

    @Autowired
    private BoardSaveService saveService;

    @Autowired
    private BoardDao boardDao;

    public BoardForm getBoardForm() {
        BoardForm boardForm = new BoardForm();
        boardForm.setId(1L);
        boardForm.setSubject("제목");
        boardForm.setContent("내용");
        
        return boardForm;
    }
    

    @Test
    @DisplayName("게시글 저장 체크 - 저장되면 예외 없음")
    void boardSaveTest() {
        assertDoesNotThrow(()-> {
            BoardForm boardForm = getBoardForm();
            saveService.save(boardForm);
        });
    }

    @Test
    @DisplayName("필수 항목(subject, content) 체크 - null 또는 빈값이면 SaveBalidationException 예외발생")
    void requiredFieldTest() {
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
                    boardForm.setSubject("    ");
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
                    boardForm.setContent("    ");
                    saveService.save(boardForm);
                })
        );
    }
    
    @Test
    @DisplayName("동일 게시글 체크 - 동일한 게시글이 있으면 fail()발생")
    void existBoardTest() {
        BoardForm boardForm = getBoardForm();
        assertDoesNotThrow(()->{
            boardDao.insert(boardForm);
        });

        Long id = boardForm.getId();
        if (id == null) {   // 게시글번호가 없으면 fail()
            fail();
        }

        Board board = boardDao.get(boardForm.getId());
        if(board == null) { // 조회된 게시글이 없으면 fail()
            fail();
        }

        // 저장한 값과 조회된 값이 동일한지 체크
        assertEquals(board.getSubject(), boardForm.getSubject());
        assertEquals(board.getContent(), boardForm.getContent());
    }
}
