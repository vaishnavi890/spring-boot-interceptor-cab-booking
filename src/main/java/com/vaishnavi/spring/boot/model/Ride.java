package com.vaishnavi.spring.boot.model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Ride {
    private int rideId;
    private int userId;
    private int driverId;
    private String pickupLocation;
    private String dropoffLocation;
    private double fare;
    private String status;

    public Ride(int userId, int driverId, String pickup, String dropoff) {
    }


    public void setId(int i) {
    }
}


