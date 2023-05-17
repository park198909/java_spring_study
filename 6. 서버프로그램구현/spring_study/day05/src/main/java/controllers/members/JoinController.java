package controllers.members;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/member/join")
public class JoinController {
    @Autowired
    private HttpSession session;

    @GetMapping
    public String join(Model model) {
        model.addAttribute("joinForm", new JoinForm());
        return "member/join";
    }

    /**
    @PostMapping
    public String joinPs(JoinForm joinForm, Model model, HttpServletRequest request) {
//        System.out.println("회원가입!!!");
//        System.out.printf("userId=%s, userPw=%s, agree=%s%n",userId,userPw,agree);
//        System.out.println(joinForm);
//        model.addAttribute("joinForm", joinForm);
        String requestURI = request.getRequestURI();
        System.out.println(requestURI);
        System.out.println(session);

        return "member/join";
    }*/

    @PostMapping
    public String joinPs(JoinForm join) {
        System.out.println(join);
        // 커맨드 객체는 EL식 변수로 추가됨 -> joinForm
        return "member/join";
    }
}
