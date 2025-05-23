package com.vaishnavi.spring.boot.model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Cab {
    private int cabId;
    private String cabNumber;
    private String cabModel;
    private String cabType;
    private String licensePlate;
    private int driverId;

    public Cab(String model, String plate, int driverId) {
    }


    public void setId(int i) {

    }
}


