package controllers.member;

import common.MessageUtil;
import models.member.LoginService;
import models.member.LoginValidator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet{
    // 로그인 양식 페이지

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
        rd.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // 로그인 진행
            LoginService loginService = new LoginService(new LoginValidator());
            loginService.login(req);

            // 아이디 저장을 체크하면 쿠키저장
            String saveId = req.getParameter("saveId");
            String userId = req.getParameter("userId");
            Cookie cookie = new Cookie("saveId", userId);
            if (saveId != null) {   // 아이디저장을 체크한 경우
                cookie.setMaxAge(60 * 60 * 24 * 365);     // 생성한 쿠키를 1년간 보존
            } else {     // 아이디저장을 체크하지 않은 경우
                cookie.setMaxAge(0);    // 생성한 쿠키를 삭제
            }
            resp.addCookie(cookie);     // 응답헤더에 쿠키 변경사항을 적용

            // 로그인 성공하면 메인페이지로 이동
            String url = req.getContextPath();  // 메인페이지 주소 저장
            MessageUtil.go(url, resp);               // 메인페이지로 이동

        }catch (RuntimeException e) {
            // 로그인 실패시  -> 에러메세지 출력
            MessageUtil.alertError(resp,e);
        }
    }
}
