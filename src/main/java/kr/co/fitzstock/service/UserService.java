package kr.co.fitzstock.service;

import kr.co.fitzstock.entity.User;
import kr.co.fitzstock.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public void signup(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword())); // 비밀번호 암호화
        user.setRole("USER"); // 기본 역할 USER
        user.setCreatedAt(LocalDateTime.now()); // 생성 시간
        user.setUpdatedAt(LocalDateTime.now()); // 수정 시간
        userMapper.insertUser(user); // DB 저장
    }
}