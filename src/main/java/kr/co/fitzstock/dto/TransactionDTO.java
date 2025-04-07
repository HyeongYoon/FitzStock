package kr.co.fitzstock.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TransactionDTO {
    private String type;
    private float amount;
    private float balance;
    private LocalDateTime createdAt;
}