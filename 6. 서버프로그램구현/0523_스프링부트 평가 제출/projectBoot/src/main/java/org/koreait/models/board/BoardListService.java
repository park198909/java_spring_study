package org.koreait.models.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardListService {
    @Autowired
    private BoardDao boardDao;

    public List<Board> gets() {
        List<Board> board = boardDao.gets();
        return board;
    }

    public Board get(Long id) {
        Board board = boardDao.get(id);
        return board;
    }
}
