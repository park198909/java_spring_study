package org.koreait.commons;

import org.springframework.http.HttpStatus;

public class CommonException extends RuntimeException {

    HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

    public CommonException(String message, HttpStatus status) {
        super(message);


    }
}
