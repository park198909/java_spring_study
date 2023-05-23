package org.koreait.models.board;

import org.koreait.controllers.board.BoardForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardSaveService {

    @Autowired
    private BoardSaveValidator saveValidator;
    @Autowired
    private BoardDao boardDao;

    public void save(BoardForm boardForm) {
        saveValidator.check(boardForm);

        // 저장 처리
        boardDao.insert(boardForm);
    }
}
