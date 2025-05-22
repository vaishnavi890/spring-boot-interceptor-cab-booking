package com.vaishnavi.spring.boot.model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RideRequest {
    private int requestId;
    private int userId;
    private String pickupLocation;
    private String dropoffLocation;
    private String status; // e.g., "Pending", "Accepted", "Completed"

    public RideRequest(int userId, String from, String to) {
    }

    public void setRequestId(int i) {
    }

    public int getRequestId() {
        return 0;
    }
}


