package controllers.member;

import common.MessageUtil;
import models.member.JoinService;
import models.member.JoinValidator;
import models.member.Member;
import models.member.MemberDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/join")
public class JoinController extends HttpServlet {
    // 회원가입 양식 페이지
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/join.jsp");
        rd.forward(req, resp);
    }

    // 회원가입 처리
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // 회원가입 진행
            Member member = new Member();
            member.setUserId("user01");
            member.setUserPw("_aA123456");
            member.setUserPwRe("_aA123456");
            member.setUserNm("사용자01");
            JoinService joinService = new JoinService(new JoinValidator(), new MemberDao());
            joinService.join(member);

            // 회원가입 성공시 -> 로그인 화면으로 이동
            String url = req.getContextPath() + "/login";     // 로그인화면 URL
            MessageUtil.go(url,resp);                // 로그인 화면으로 이동

        }catch (RuntimeException e) {
            // 회원가입 실패시 -> 에러메세지 출력
            e.printStackTrace();
            MessageUtil.alertError(resp,e);
        }
    }
}
