package tests;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class LoginService {
    void login(HttpServletRequest request) {
        String userId = request.getParameter("userId");
        if(userId == null || userId.isBlank()) {
            throw new LoginValidationException("아이디를 입력하세요.");
        }
        String userPw = request.getParameter("userPw");
        if(userPw == null || userPw.isBlank()) {
            throw new LoginValidationException("비밀번호를 입력하세요.");
        }
    }

    String check(HttpServletRequest request) {
        String userId = request.getParameter("userId");
        return "("+userId+")님 로그인!";
    }

}
