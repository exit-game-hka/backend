package com.hka.exitgame.dto;

import com.hka.exitgame.entities.Notification;

public record NotificationDto(
        String userName,

        String title,

        String content,

        String creationDate,

        Boolean viewed,

        String type
) {

    public Notification toNotification() {
        return Notification.builder()
                .id(null)
                .userName(userName)
                .title(title)
                .content(content)
                .creationDate(creationDate)
                .viewed(viewed)
                .type(type)
                .build();
    }
}
