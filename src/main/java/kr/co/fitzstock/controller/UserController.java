package kr.co.fitzstock.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    @GetMapping("/me")
    public String getCurrentUser(Authentication authentication) {
        return "현재 로그인한 사용자: " + authentication.getName();
    }
}