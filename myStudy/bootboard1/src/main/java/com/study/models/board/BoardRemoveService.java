package com.study.models.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardRemoveService {

    @Autowired
    private BoardDao boardDao;

    public Integer remove(Long id) {
       return boardDao.remove(id);
    }
}
