package com.hka.exitgame.controllers;

import com.hka.exitgame.entities.Notification;
import com.hka.exitgame.services.NotificationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping(ApiRoute.NOTIFICATION_REST_ROUTE)
@Tag(name = "Notification-Http", description = "APIs zur Verwaltung von Benachrichtigungen über Http")
public class NotificationRestController {

    private final NotificationService notificationService;

    @GetMapping
    @Operation(summary = "Alle Benachrichtigungen auslesen", description = "Alle Benachrichtigungen auslesen")
    public List<Notification> findNotifications() {
        return notificationService.findAll();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Benachrichtigung mit ID löschen", description = "Benachrichtigung mit ID löschen")
    public void deleteNotification(@PathVariable("id") final UUID id) {
        notificationService.deleteById(id);
    }

    @DeleteMapping("/all")
    @Operation(summary = "Alle Benachrichtigungen löschen", description = "Alle Benachrichtigungen löschen")
    public void deleteAllNotifications() {
        notificationService.deleteAll();
    }

    @PostMapping("/set-all-seen")
    @Operation(summary = "Alle Benachrichtigungen als gelesen markieren", description = "Alle Benachrichtigungen als gelesen markieren")
    public void setAllNotificationsAsSeen() {
        notificationService.setAllAsSeen();
    }
}
