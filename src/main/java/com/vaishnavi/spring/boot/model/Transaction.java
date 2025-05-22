package com.vaishnavi.spring.boot.model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    private int transactionId;
    private int paymentId;
    private double amount;
    private String transactionDate;
    private String transactionType; // "Credit", "Debit"

    public Transaction(int userId, double amount, String type) {
    }

    public void setTransactionId(int i) {
    }

    public int getTransactionId() {
        return 0;
    }
}


