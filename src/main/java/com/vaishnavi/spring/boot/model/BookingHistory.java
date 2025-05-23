package com.vaishnavi.spring.boot.model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BookingHistory {
    private int historyId;
    private int userId;
    private int rideId;
    private String bookingDate;
    private String status;

    public BookingHistory(int userId, int rideId, String status, String timestamp) {
    }


    public void setId(int i) {

    }
}

