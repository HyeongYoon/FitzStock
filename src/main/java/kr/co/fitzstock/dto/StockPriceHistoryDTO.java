package kr.co.fitzstock.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class StockPriceHistoryDTO {
    private int id;
    private int stockId;
    private float price;
    private LocalDateTime recordedAt;
}