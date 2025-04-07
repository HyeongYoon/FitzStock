package kr.co.fitzstock.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class WatchlistDTO {
    private String symbol;
    private String stockName;
    private LocalDateTime addedAt;
}