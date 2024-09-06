package com.hka.exitgame.controllers;

import com.hka.exitgame.dto.NotificationDto;
import com.hka.exitgame.repositories.NotificationRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Controller
@Slf4j
@Tag(name = "Notification-WebSocket", description = "APIs zur Verwaltung von Benachrichtigungen über WebSocket")
public class NotificationWebsocketController {

    @Autowired
    private NotificationRepository notificationRepository;

    @MessageMapping("/new-notification")
    @SendTo("/topic/user-notifications")
    public NotificationDto notify(final NotificationDto notificationDto) {
        log.info("Received notification in NotificationWebsocketController: {}", notificationDto);

        var notificationToSave = notificationDto.toNotification();
        notificationToSave.setId(UUID.randomUUID());

        var notificationFromDb = notificationRepository
                .findByUserNameAndType(notificationToSave.getUserName(), notificationToSave.getType());

        if (notificationFromDb.isPresent()) {
            return notificationDto;
        }
        notificationRepository.save(notificationToSave);

        var savedNotification = notificationRepository.findById(notificationToSave.getId());

        log.info("Saved notification: {}", savedNotification);

//        simpMessagingTemplate.convertAndSend(
//                "/user-notifications",
//                notificationDto
//        );
        return notificationDto;
    }
}
