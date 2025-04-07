package kr.co.fitzstock.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Transaction {
    private int id;
    private int userId;
    private String type; // DEPOSIT or WITHDRAW
    private float amount;
    private float balance;
    private LocalDateTime createdAt;
}