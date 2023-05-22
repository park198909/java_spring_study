package com.study.models.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardViewService {
    @Autowired
    private BoardDao boardDao;

    public Board get(Long id) {
        return boardDao.get(id);
    }
}
