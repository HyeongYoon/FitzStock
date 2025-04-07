package kr.co.fitzstock.dto;

import lombok.Data;

@Data
public class UserSignupDTO {
    private String username;
    private String password;
    private String email;
    private String nickname;
}