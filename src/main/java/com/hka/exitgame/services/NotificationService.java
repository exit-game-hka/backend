package com.hka.exitgame.services;

import com.hka.exitgame.entities.Notification;
import com.hka.exitgame.repositories.NotificationRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public List<Notification> findAll() {
        return notificationRepository.findAll();
    }

    public void deleteById(final UUID id) {
        notificationRepository.deleteById(id);
    }

    public void deleteAll() {
        notificationRepository.deleteAll();
    }

    public void setAllAsSeen() {
        var allNotifications = notificationRepository.findAll();
        var notificationsToUpdate = allNotifications.stream()
                .map(notification -> {
                    notification.setViewed(true);
                    return notification;
                })
                .toList();
        notificationRepository.saveAll(notificationsToUpdate);
    }
}
