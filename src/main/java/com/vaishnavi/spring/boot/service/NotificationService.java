package com.vaishnavi.spring.boot.service;

import com.vaishnavi.spring.boot.model.Notification;
import com.vaishnavi.spring.boot.repository.NotificationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    private static final Logger logger = LoggerFactory.getLogger(NotificationService.class);

    @Autowired
    private NotificationRepository repo;

    public List<Notification> retrieveNotifications() {
        logger.info("/inside the NotificationService.retrieveNotifications()");
        return repo.retrieve();
    }

    public boolean storeNotification(Notification notification) {
        logger.info("/inside the NotificationService.storeNotification()");
        return repo.store(notification);
    }

    public boolean deleteNotification(int id) {
        logger.info("/inside the NotificationService.deleteNotification()");
        return repo.delete(id);
    }

    public Notification searchNotification(int id) {
        logger.info("/inside the NotificationService.searchNotification()");
        return repo.search(id);
    }

    public Object search(int id) {
        return null;
    }
}


