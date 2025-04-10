package kr.co.fitzstock.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.fitzstock.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
@Slf4j
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private final JwtUtil jwtUtil; // JwtUtil 주입

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        // 인증 성공 후 사용자 정보를 가져옴
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();

        // JWT 토큰 생성
        String token = jwtUtil.generateToken(userDetails.getUsername());

        // 토큰 로그
        log.debug("Generated JWT Token: " + token);

        // 생성된 토큰을 HTTP 헤더에 추가
        response.setHeader("Authorization", "Bearer " + token);

        // 로그인 성공 후 /main으로 리디렉션
        response.sendRedirect("/main");
    }
}