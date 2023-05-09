package servlets.member;

import commons.ErrorAndGo;
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
            req.setCharacterEncoding("UTF-8");
            ServiceManager manager = new ServiceManager();
            LoginService loginService = manager.loginService();
            loginService.login(req);
            // 아이디 저장 클릭하면 쿠키 생성
            String saveId = req.getParameter("saveId");
            Cookie cookie = new Cookie("saveId",saveId);
            if(saveId == null){
                cookie.setMaxAge(0);
            } else {
                cookie.setMaxAge(60 * 60 * 24 * 365);
            }
            resp.addCookie(cookie);


            // 성공하면 메인페이지 이동
            String url = req.getContextPath() + "/index.jsp";
            ErrorAndGo.go(url, "parent", resp);

        } catch (RuntimeException e) {
            // 실패하면 에러메세지 출력
            e.printStackTrace();
            String message = e.getMessage();
            ErrorAndGo.ErrorMsg(resp, message);
        }
    }
}
