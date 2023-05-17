package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("title1", "메세지1");
        model.addAttribute("title2", "메세지2");
        return "hello";
    }


    /**
    @GetMapping("/hello")
    public String hello(@RequestParam(value="nm", required=false) String name) {
        System.out.println(name);
        return "hello";
    }*/

    /*
    @GetMapping("/hello")
    public String hello(String name, int num1, int num2, boolean agree) {
        // 쿼리스트링의 동일 파라미터 값을 자동으로 매개변수에 적용
        System.out.println(name);
        System.out.println(num1+num2);
        System.out.println(agree);
        return "hello";
    }*/

    /*
    @GetMapping("/hello")
    public ModelAndView hello() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");
        return mv;
    }*/

}
