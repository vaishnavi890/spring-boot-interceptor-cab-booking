package com.vaishnavi.spring.boot.model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int userId;
    private String name;
    private String email;
    private String phone;

    public User(String name, String email, String phone) {
    }

    public void setId(int i) {
    }
}


