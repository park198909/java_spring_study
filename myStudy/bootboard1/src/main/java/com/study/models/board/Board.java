package com.study.models.board;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Board {
    private Long id;
    private String subject;
    private String content;
    private LocalDateTime regDt;
}
