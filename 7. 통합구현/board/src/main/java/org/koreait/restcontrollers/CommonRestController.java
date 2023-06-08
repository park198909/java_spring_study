package org.koreait.restcontrollers;

import org.koreait.commons.CommonException;
import org.koreait.commons.rest.JSONResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice("org.koreait.restcontrollers")
public class CommonRestController {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<JSONResult> errorHandler(Exception e) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;   // 기본 응답코드 설정(500)
        if (e instanceof CommonException) {                     // 예외타입이 CommonException 일 때
            CommonException commonException = (CommonException) e; // 발생에외를 CommonException 타입으로 변경
            status = commonException.getStatus();               // status 에 발생에외의 응답코드를 저장
        }
        JSONResult jsonResult = new JSONResult();               // JSONResult 객체 생성
        jsonResult.setStatus(status);                           // JSONResult 객체의 응답코드를 status 로 변경
        jsonResult.setErrorMessage(e.getMessage());             // JSONResult 객체의 에러메세지를 예외객체의 에러메시지로 변경

        e.printStackTrace();

        return ResponseEntity.status(status).body(jsonResult);  // JSON 형태로 응답코드에 실어 보내기
    }
}
