package servlets.member;

import commons.ErrorAndGo;
import models.member.JoinService;
import models.member.Member;
import models.member.ServiceManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
            req.setCharacterEncoding("UTF-8");
            ServiceManager manager = new ServiceManager();
            JoinService joinService = manager.joinService();
            Member member = manager.member();
            member.setUserId(req.getParameter("userId"));
            member.setUserPw(req.getParameter("userPw"));
            member.setUserPwRe(req.getParameter("userPwRe"));
            member.setUserNm(req.getParameter("userNm"));
            joinService.join(member);

            // 성공하면 로그인페이지로 이동
            String url = req.getContextPath() + "member/login";
            ErrorAndGo.go(url, "parent", resp);

        } catch (Exception e) {
            // 실패하면 에러메세지 출력
            e.printStackTrace();
            String message = e.getMessage();
            ErrorAndGo.ErrorMsg(resp,message);
        }
    }
}
