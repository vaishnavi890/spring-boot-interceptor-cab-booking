package com.vaishnavi.spring.boot.service;

import com.vaishnavi.spring.boot.model.Notification;
import com.vaishnavi.spring.boot.model.User;
import com.vaishnavi.spring.boot.repository.NotificationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class NotificationService {

    private static final Logger logger = LoggerFactory.getLogger(NotificationService.class);
    private NotificationRepository repo = new NotificationRepository();

    public List<User> getAllNotifications() {
        logger.info("Inside NotificationService.getAllNotifications()");
        return repo.findAll();
    }

    public boolean addNotification(Notification notification) {
        logger.info("Inside NotificationService.addNotification()");
        return repo.save(notification);
    }

    public boolean deleteNotification(int notificationId) {
        logger.info("Inside NotificationService.deleteNotification()");
        return repo.delete(notificationId);
    }

    public User getNotificationById(int notificationId) {
        logger.info("Inside NotificationService.getNotificationById()");
        return repo.findById(notificationId);
    }

    public boolean markAsRead(int notificationId) {
        logger.info("Inside NotificationService.markAsRead()");
        return repo.markRead(notificationId);
    }

    public List<Notification> retrieveNotifications() {
        return List.of();
    }

    public boolean storeNotification(Notification n) {
        return false;
    }

    public Object search(int id) {
        return null;
    }
}


