package org.koreait.models.board;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Board {

    private Long Id;
    private String subject;
    private String content;
    private LocalDateTime regDt;

}
