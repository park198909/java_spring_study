package org.koreait.models.board;

import lombok.RequiredArgsConstructor;
import org.koreait.entities.BoardData;
import org.koreait.repositories.BoardDataRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardDeleteService {
    private final BoardDataRepository repository;

    public void delete(Long id) {
        BoardData boardData = repository.findById(id).orElseThrow(()->new BoardValidationException("삭제에 실패했습니다."));

        repository.delete(boardData);
        repository.flush();
    }
}
