package controllers.member;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member/join")
public class MemberController {

    public String join(@ModelAttribute JoinForm joinForm) {

        return "member/join";
    }

    public String joinPs(JoinForm joinForm, Errors errors) {
        JoinValidator validator = new JoinValidator();
        validator.validate(joinForm, errors);

        if (errors.hasErrors()) {
            return "member/join";
        }


        return "redirect:/member/login";
    }

    public String login() {

        return "member/login";
    }

    public String loginPs() {

        return "member/index";
    }
}
