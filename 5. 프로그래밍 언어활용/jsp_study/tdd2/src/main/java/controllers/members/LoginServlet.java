package controllers.members;

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
import static commons.MessageUtil.*;

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
            ServiceManager manager = new ServiceManager();
            LoginService service = manager.getLoginService();
            service.login(req);

            // 아이디 저장
            String savaId = req.getParameter("saveId");
            Cookie cookie = new Cookie("saveId", req.getParameter("userId"));
            if (savaId == null) {
                cookie.setMaxAge(0);
            } else {
                cookie.setMaxAge(60 * 60 * 24 * 365);
            }
            resp.addCookie(cookie);

            // 로그인 성공
            String url = req.getContextPath()+"/index.jsp";
            go(resp, url, "parent");

        } catch (RuntimeException e) {
            alertError(resp, e);
            e.printStackTrace();
        }
    }
}
