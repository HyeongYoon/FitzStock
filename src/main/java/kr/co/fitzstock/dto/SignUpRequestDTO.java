package kr.co.fitzstock.dto;

import lombok.Data;

@Data
public class SignUpRequestDTO {
    private String username;
    private String password;
    private String email;
}