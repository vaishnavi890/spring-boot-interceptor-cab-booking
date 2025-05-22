package com.vaishnavi.spring.boot.model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Notification {
    private int notificationId;
    private int userId;
    private String message;
    private String timestamp;
    private boolean isRead;

    public Notification(int userId, String message) {
    }

    public void setNotificationId(int i) {
    }

    public int getNotificationId() {
        return 0;
    }
}



