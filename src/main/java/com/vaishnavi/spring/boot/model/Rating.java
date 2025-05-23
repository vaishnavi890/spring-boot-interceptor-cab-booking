package com.vaishnavi.spring.boot.model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Rating {
    private int ratingId;
    private int rideId;
    private int userId;
    private int driverId;
    private int rating; // 1 to 5
    private String review;



    public void setId(int i) {

    }
}


