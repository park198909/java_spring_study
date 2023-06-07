package org.koreait.commons.rest;

import lombok.Data;
import org.koreait.entities.BoardData;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
public class JSONResult {
    private HttpStatus status;
    private String errorMessage;
}
