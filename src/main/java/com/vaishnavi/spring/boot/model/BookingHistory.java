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

    public BookingHistory(int userId, int rideId) {
    }

    public void setBookingId(int i) {
    }

    public int getBookingId() {
        return 0;
    }
}

