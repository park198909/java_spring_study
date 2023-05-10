package models.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginService {

    private LoginValidator validator;
    private MemberDao memberDao;

    public LoginService(LoginValidator validator, MemberDao memberDao) {
        this.validator = validator;
        this.memberDao = memberDao;
    }

    public void login(HttpServletRequest request) {
        validator.check(request);

        Member member = memberDao.get(request.getParameter("userId"));
        HttpSession session = request.getSession();
        session.setAttribute("member",member);
    }
}
