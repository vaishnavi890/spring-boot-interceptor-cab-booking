package com.vaishnavi.spring.boot.repository;

import com.vaishnavi.spring.boot.model.Notification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;

public class NotificationRepository implements EntityRepository<Notification> {
    private static final Logger logger = LoggerFactory.getLogger(NotificationRepository.class);
    private List<Notification> notifications = new ArrayList<>();
    private int index = -1;

    @Override
    public boolean store(Notification notification) {
        logger.info("Inside NotificationRepository.store()");
        notification.setNotificationId(++index);
        notifications.add(notification);
        return true;
    }

    @Override
    public List<Notification> retrieve() {
        logger.info("Inside NotificationRepository.retrieve()");
        return notifications;
    }

    @Override
    public Notification search(int id) {
        logger.info("Inside NotificationRepository.search()");
        return notifications.stream().filter(n -> n.getNotificationId() == id).findFirst().orElse(null);
    }

    @Override
    public boolean delete(int id) {
        logger.info("Inside NotificationRepository.delete()");
        return notifications.removeIf(n -> n.getNotificationId() == id);
    }
}


