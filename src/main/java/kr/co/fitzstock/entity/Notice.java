package kr.co.fitzstock.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Notice {
    private int id;
    private String title;
    private String content;
    private int adminId;
    private LocalDateTime createdAt;
}