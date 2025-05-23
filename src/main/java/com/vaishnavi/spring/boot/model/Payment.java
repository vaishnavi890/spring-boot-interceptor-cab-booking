package com.vaishnavi.spring.boot.model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    private int paymentId;
    private int rideId;
    private int userId;
    private double amount;
    private String paymentMethod;
    private String status;

    public Payment(int rideId, int userId, double amount, String method) {
    }


    public void setId(int i) {

    }
}


