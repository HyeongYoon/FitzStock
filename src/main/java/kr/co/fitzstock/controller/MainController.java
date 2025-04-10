package kr.co.fitzstock.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    // 메인 페이지 (로그인 후 환영 메시지)
    @GetMapping("/main")
    public String mainPage(Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("username", username);
        return "main";
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }
}