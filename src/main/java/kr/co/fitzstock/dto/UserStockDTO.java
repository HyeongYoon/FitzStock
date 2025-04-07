package kr.co.fitzstock.dto;

import lombok.Data;

@Data
public class UserStockDTO {
    private String symbol;
    private String stockName;
    private int quantity;
    private float avgPrice;
}