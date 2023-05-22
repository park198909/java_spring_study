package org.koreait.models.board;

import lombok.RequiredArgsConstructor;
import org.koreait.controllers.board.BoardForm;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardSaveService {

    private final BoardDao boardDao;

    private final BoardSaveValidator saveValidator;

    public void save(BoardForm boardForm) {
        saveValidator.check(boardForm);

        boardDao.insert(boardForm);
    }
}
