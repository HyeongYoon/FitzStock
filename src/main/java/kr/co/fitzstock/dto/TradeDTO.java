package kr.co.fitzstock.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TradeDTO {
    private String symbol;
    private String tradeType;
    private float price;
    private int quantity;
    private LocalDateTime tradedAt;
}