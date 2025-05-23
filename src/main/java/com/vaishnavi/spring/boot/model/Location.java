package com.vaishnavi.spring.boot.model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Location {
    private int locationId;
    private String address;
    private String city;
    private String state;
    private String zipCode;



    public void setId(int i) {

    }
}



