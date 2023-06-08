package org.koreait.controllers.member;

import lombok.RequiredArgsConstructor;
import org.koreait.models.member.social.SocialLogin;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/social")
@RequiredArgsConstructor
public class SocialLoginController {

    private final SocialLogin socialLogin;

    @GetMapping("/login")
    @ResponseBody
    public void login(String code) {
        if (code == null || code.isBlank()) {
            // return "redirect:/member/login";
        }

        socialLogin.getProfile(code);
    }
}
