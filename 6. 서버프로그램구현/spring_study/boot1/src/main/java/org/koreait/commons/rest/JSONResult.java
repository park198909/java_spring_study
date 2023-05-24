package org.koreait.commons.rest;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class JSONResult<T> {
    private HttpStatus status = HttpStatus.OK;  // 응답코드가 담긴 상수가 있음
    private boolean success;    // 응답 성공, 실패 구분
    private String message;     // 에러 메세지
    private T data;             // 응답 성공 데이터
}
