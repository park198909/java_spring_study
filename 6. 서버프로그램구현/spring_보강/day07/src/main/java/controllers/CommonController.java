package controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("controllers")    // 공통 컨트롤러
public class CommonController {
    @ExceptionHandler(Exception.class)  // 컨트롤러 예외 처리 메서드로 지정
    public String errorHandler(RuntimeException e, Model model) {
        model.addAttribute("message", e.getMessage());

        e.printStackTrace();
        return "error/common";  // 에러 발생 시 에러페이지로 이동
    }
}
