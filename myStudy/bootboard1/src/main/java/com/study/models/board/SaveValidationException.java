package com.study.models.board;

public class SaveValidationException extends RuntimeException {
    public SaveValidationException(String message) {
        super(message);
    }
}
