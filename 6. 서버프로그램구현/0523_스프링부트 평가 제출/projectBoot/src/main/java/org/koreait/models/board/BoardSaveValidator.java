package org.koreait.models.board;

import org.koreait.controllers.board.BoardForm;
import org.koreait.validators.Validator;
import org.springframework.stereotype.Component;

@Component
public class BoardSaveValidator implements Validator<BoardForm> {
    @Override
    public void check(BoardForm boardForm) {
        // 필수 항목(subject, content) 체크 - null 또는 빈값이면 SaveValidationException 예외발생
        requiredFieldCheck(boardForm.getSubject(), new SaveValidationException("제목을 입력하세요."));
        requiredFieldCheck(boardForm.getContent(), new SaveValidationException("내용을 입력하세요."));
    }
}
