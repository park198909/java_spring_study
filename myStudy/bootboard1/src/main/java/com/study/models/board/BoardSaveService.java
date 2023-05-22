package com.study.models.board;

import com.study.controllers.board.BoardForm;
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

        boardDao.insert(boardForm);
    }
}
