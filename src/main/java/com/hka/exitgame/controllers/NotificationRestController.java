package com.hka.exitgame.controllers;

import com.hka.exitgame.entities.Notification;
import com.hka.exitgame.services.NotificationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping(ApiRoute.NOTIFICATION_REST_ROUTE)
public class NotificationRestController {

    private final NotificationService notificationService;

    @GetMapping
    public List<Notification> findNotifications() {
        return notificationService.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteNotification(@PathVariable("id") final UUID id) {
        notificationService.deleteById(id);
    }

    @DeleteMapping("/all")
    public void deleteAllNotifications() {
        notificationService.deleteAll();
    }

    @PostMapping("/set-all-seen")
    public void setAllNotificationsAsSeen() {
        notificationService.setAllAsSeen();
    }
}
