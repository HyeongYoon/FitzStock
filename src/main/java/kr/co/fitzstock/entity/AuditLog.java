package kr.co.fitzstock.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AuditLog {
    private int id;
    private int userId;
    private String action;
    private String description;
    private LocalDateTime createdAt;
}