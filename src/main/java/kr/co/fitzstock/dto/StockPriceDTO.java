package kr.co.fitzstock.dto;

import lombok.Data;

@Data
public class StockPriceDTO {
    private String symbol;
    private float price;
    private Float changeRate;
}