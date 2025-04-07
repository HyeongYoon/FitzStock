package kr.co.fitzstock.dto;

import lombok.Data;

@Data
public class StockDTO {
    private String symbol;
    private String name;
    private String market;
    private float price;
}