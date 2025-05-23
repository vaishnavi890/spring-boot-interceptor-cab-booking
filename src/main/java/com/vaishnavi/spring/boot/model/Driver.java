package com.vaishnavi.spring.boot.model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Driver {
    private int driverId;
    private String name;
    private String email;
    private String phone;
    private Cab cabDetails;

    public Driver(String name, String license, String phone) {
    }


    public void setId(int i) {

    }
}


