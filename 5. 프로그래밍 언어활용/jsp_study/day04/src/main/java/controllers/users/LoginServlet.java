package controllers.users;

import models.users.LoginService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher rd = req.getRequestDispatcher("/user/login.jsp");
        rd.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // MVC패턴
        String userId = req.getParameter("userId");
        String userPw = req.getParameter("userPw");
        // 컨트롤러 - 요청에 대한 적절한 서비스(Model) 탐색 및 실행

        // 서비스(Model) - 비즈니스 로직 수행 : 기능 실행
        LoginService service = new LoginService();
        service.login(userId, userPw);

        // view - 처리결과 응답(jsp)
        req.setAttribute("message", "로그인 성공!");
        RequestDispatcher rd = req.getRequestDispatcher("/user/login_done.jsp");
        rd.forward(req,resp);
    }
}
