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



    public void setId(int i) {

    }
}


