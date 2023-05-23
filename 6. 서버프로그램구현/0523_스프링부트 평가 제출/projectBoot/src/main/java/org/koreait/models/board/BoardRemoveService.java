package org.koreait.models.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardRemoveService {

    @Autowired
    private BoardDao boardDao;

    public Integer remove(Long id) {
        Integer success = boardDao.remove(id);
        return success;
    }
}
