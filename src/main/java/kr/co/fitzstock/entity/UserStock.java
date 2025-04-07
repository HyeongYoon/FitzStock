package kr.co.fitzstock.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserStock {
    private int id;
    private int userId;
    private int stockId;
    private int quantity;
    private float avgPrice;
    private LocalDateTime createdAt;
}