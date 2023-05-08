package Servlets.member;

import models.member.LoginService;
import models.member.ServiceManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static common.ErrorAndGo.alertError;
import static common.ErrorAndGo.go;

@WebServlet("/member/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/member/login.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // 로그인
            ServiceManager manager = new ServiceManager();
            LoginService loginService = manager.loginService();
            loginService.login(req);

            // 아이디 저장 체크 시 쿠키 생성
            String saveId = req.getParameter("userId");
            Cookie cookie = new Cookie("saveId", saveId);
            if (saveId == null) {   // 체크 해제 시 쿠키 제거
                cookie.setMaxAge(0);
            } else {    // 체크 시 1년간 유지되는 쿠키 생성
                cookie.setMaxAge(60 * 60 * 24 * 365);
            }
            resp.addCookie(cookie);

            // 로그인 성공 시  메인페이지로
            String url = req.getContextPath() + "/index.jsp";
            go(resp, url, "parent");
        } catch (RuntimeException e) {
            // 로그인 실패 시 에러메시지 출력
            e.printStackTrace();
            alertError(resp, e);
        }
    }
}
