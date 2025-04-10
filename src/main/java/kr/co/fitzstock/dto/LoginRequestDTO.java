package kr.co.fitzstock.dto;

import lombok.Data;

@Data
public class LoginRequestDTO {
    private String email;
    private String password;
}