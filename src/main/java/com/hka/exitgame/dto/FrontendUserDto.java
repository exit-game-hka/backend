package com.hka.exitgame.dto;

import com.hka.exitgame.entities.FrontendUser;

public record FrontendUserDto(
        String username,
        String password
) {

    public FrontendUser toFrontendUser() {
        return FrontendUser.builder()
                .id(null)
                .username(username)
                .password(password)
                .build();
    }
}
