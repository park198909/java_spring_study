package Servlets.member;

import models.member.JoinService;
import models.member.LoginService;
import models.member.Member;
import models.member.ServiceManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static common.ErrorAndGo.*;

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
            // 회원가입
            ServiceManager manager = new ServiceManager();
            JoinService loginService = manager.joinService();

            Member member = manager.member();
            member.setUserId(req.getParameter("userId"));
            member.setUserPw(req.getParameter("userPw"));
            member.setUserPwRe(req.getParameter("userPwRe"));
            member.setUserNm(req.getParameter("userNm"));

            loginService.join(member);
            // 가입 성공 시 로그인 페이지로 이동
            String url = req.getContextPath() + "/member/login";
            go(resp, url, "parent");
        } catch (RuntimeException e) {
            // 가입 실패 시 에러메시지 출력
            e.printStackTrace();
            alertError(resp,e);
        }



    }
}
