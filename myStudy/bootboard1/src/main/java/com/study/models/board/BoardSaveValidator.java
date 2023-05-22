package com.study.models.board;

import com.study.controllers.board.BoardForm;
import com.study.validators.Validator;
import org.springframework.stereotype.Component;

@Component
public class BoardSaveValidator implements Validator<BoardForm> {
    @Override
    public void check(BoardForm boardForm) {
        // 필수 항목(subject, content) 체크 - 실패시 SaveValidationException 발생
        requiredFieldCheck(boardForm.getSubject(), new SaveValidationException("제목을 입력하세요."));
        requiredFieldCheck(boardForm.getContent(), new SaveValidationException("내용을 입력하세요."));
    }
}
