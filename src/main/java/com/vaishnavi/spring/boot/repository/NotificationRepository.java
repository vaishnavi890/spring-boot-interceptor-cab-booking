package com.vaishnavi.spring.boot.repository;

import com.vaishnavi.spring.boot.model.Notification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class NotificationRepository implements EntityRepository<Notification> {
    private static final Logger logger = LoggerFactory.getLogger(NotificationRepository.class);
    private List<Notification> notificationList = new ArrayList<>();
    private int index = -1;

    @Override
    public boolean store(Notification notification) {
        logger.info("Inside NotificationRepository.store()");
        notification.setId(++index);
        notificationList.add(index, notification);
        return true;
    }

    @Override
    public boolean delete(int id) {
        logger.info("Inside NotificationRepository.delete()");
        notificationList.remove(id);
        return true;
    }

    @Override
    public List<Notification> retrieve() {
        logger.info("Inside NotificationRepository.retrieve()");
        return notificationList;
    }

    @Override
    public Notification search(int id) {
        logger.info("Inside NotificationRepository.search()");
        return notificationList.get(id);
    }
}

