package controllers.members;

import models.member.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static commons.MessageUtil.*;

@WebServlet("/member/join")
public class JoinServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher rd = req.getRequestDispatcher("/member/join.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ServiceManager manager = new ServiceManager();
            JoinService joinService = manager.getJoinService();

            Member member = new Member();
            member.setUserId(req.getParameter("userId"));
            member.setUserPw(req.getParameter("userPw"));
            member.setUserPwRe(req.getParameter("userPwRe"));
            member.setUserNm(req.getParameter("userNm"));

            joinService.join(member);

            // 가입 성공
            String url = req.getContextPath()+"/member.login";
            go(resp,url,"parent");

        }catch (RuntimeException e) {
            alertError(resp,e);
            e.printStackTrace();
        }
    }
}
