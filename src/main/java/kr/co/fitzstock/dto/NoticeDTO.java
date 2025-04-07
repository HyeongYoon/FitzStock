package kr.co.fitzstock.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NoticeDTO {
    private String title;
    private String content;
    private LocalDateTime createdAt;
}