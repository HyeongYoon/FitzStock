package kr.co.fitzstock.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class StockPrice {
    private int id;
    private String symbol;
    private float price;
    private Float changeRate;
    private LocalDateTime updatedAt;
}