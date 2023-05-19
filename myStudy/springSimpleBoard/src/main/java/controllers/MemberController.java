package controllers;

import oracle.jdbc.proxy.annotation.Post;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {

    @GetMapping("/join")
    public String join(@ModelAttribute JoinForm joinForm) {

        return "member/join";
    }

    @PostMapping("/join")
    public String joinPs(JoinForm joinForm, Errors errors) {


        return "redirect:/member/login";
    }

    @GetMapping("/login")
    public String login() {


        return "member/login";
    }

    @PostMapping("/login")
    public String loginPs() {

        return "redirect:/";
    }
}
