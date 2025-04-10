package kr.co.fitzstock.controller;

import jakarta.servlet.http.HttpServletResponse;
import kr.co.fitzstock.dto.LoginRequestDTO;
import kr.co.fitzstock.dto.LoginResponseDTO;
import kr.co.fitzstock.entity.User;
import kr.co.fitzstock.security.CustomUserDetails;
import kr.co.fitzstock.service.UserService;
import kr.co.fitzstock.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/auth")
@Slf4j
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserService userService;

    // JSP 로그인 폼
// 로그인 폼
    @GetMapping("/login")
    public String loginForm(@RequestParam(value = "error", required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("error", "이메일 또는 비밀번호가 잘못되었습니다.");
        }
        return "member/login";
    }
    // JSP 회원가입 폼
    @GetMapping("/signup")
    public String signupForm() {
        return "member/signup";
    }

    // JSP 폼 로그인 처리
    @PostMapping("/login-form")
    public String loginFromForm(@RequestParam("email") String email,
                                @RequestParam("password") String password,
                                Model model,
                                HttpServletResponse response) {
        log.debug("Login attempt with email: '{}', password: '{}'", email, password);
        if (email == null || email.trim().isEmpty()) {
            log.warn("Email is empty or null");
            model.addAttribute("error", "이메일을 입력해주세요.");
            return "member/login";
        }
        if (password == null || password.trim().isEmpty()) {
            log.warn("Password is empty or null");
            model.addAttribute("error", "비밀번호를 입력해주세요.");
            return "member/login";
        }
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(email, password)
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
            String token = jwtUtil.generateToken(userDetails.getUsername());
            response.setHeader("Authorization", "Bearer " + token);
            log.debug("Login successful for user: {}", email);
            return "redirect:/main";
        } catch (Exception e) {
            log.error("Login failed for user: " + email, e);
            model.addAttribute("error", "이메일 또는 비밀번호가 올바르지 않습니다.");
            return "member/login";
        }
    }

    // 회원가입 처리
    @PostMapping("/signup")
    public String signup(@ModelAttribute User user, Model model) {
        try {
            userService.signup(user);
            return "redirect:/auth/login";
        } catch (Exception e) {
            model.addAttribute("error", "회원가입 실패: " + e.getMessage());
            return "member/signup";
        }
    }

    // JSON 요청 처리 예시 (주석처리된 코드)
    // @ResponseBody
    // @PostMapping("/login")
    // public ResponseEntity<?> loginJson(@RequestBody LoginRequestDTO dto) {
    //     Authentication authentication = authenticationManager.authenticate(
    //             new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword())
    //     );
    //
    //     SecurityContextHolder.getContext().setAuthentication(authentication);
    //     CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
    //     String token = jwtUtil.generateToken(userDetails.getUsername());
    //
    //     return ResponseEntity.ok(new LoginResponseDTO(token, userDetails.getUsername()));
    // }
}