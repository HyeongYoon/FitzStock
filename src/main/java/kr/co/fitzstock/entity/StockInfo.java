package kr.co.fitzstock.entity;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class StockInfo {
    private int id;
    private String symbol;
    private String name;
    private String description;
    private String market;
    private LocalDateTime createdAt;
}