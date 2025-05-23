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


    public void setId(int i) {

    }
}


