package kr.co.fitzstock.entity;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class StockPriceHistory {
    private int id;
    private int stockId;
    private float price;
    private LocalDateTime recordedAt;
}