package kr.co.fitzstock.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Watchlist {
    private int id;
    private int userId;
    private int stockId;
    private LocalDateTime addedAt;
}