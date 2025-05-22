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

    public User(String name, String email) {
    }

    public User() {

    }

    public void setUserId(int i) {
    }

    public int getUserId() {
        return 0;
    }

    public void setName(String name) {
    }

    public void setEmail(String email) {
    }
}


