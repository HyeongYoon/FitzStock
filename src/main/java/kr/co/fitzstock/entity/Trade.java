package kr.co.fitzstock.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Trade {
    private int id;
    private int userId;
    private int stockId;
    private String tradeType; // BUY or SELL
    private float price;
    private int quantity;
    private LocalDateTime tradedAt;
}