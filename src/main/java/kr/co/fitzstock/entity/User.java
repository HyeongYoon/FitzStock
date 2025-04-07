package kr.co.fitzstock.entity;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private String nickname;
    private String role; // USER or ADMIN
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}