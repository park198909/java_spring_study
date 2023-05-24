package org.koreait.models.board;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Builder
@Data
public class Board3 {
    private Long id;
    private String subject;
    private String content;
}
