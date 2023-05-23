package org.koreait.models.board;

public class SaveValidationException extends RuntimeException{
    public SaveValidationException(String message) {
        super(message);
    }
}
