package org.koreait.models.board;

import org.koreait.controllers.board.BoardForm;
import org.koreait.validators.Validator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
public class BoardSaveValidator implements Validator<BoardForm> {
    @Override
    public void check(BoardForm boardForm) {
        // 필수항목 체크
        checkRequired(boardForm.getSubject(), new BoardValidationException("제목을 입력하세요."));
        checkRequired(boardForm.getContent(), new BoardValidationException("내용을 입력하세요."));
    }
}
