package com.hka.exitgame.dto;

import com.hka.exitgame.entities.Spieler;

public record SpielerDto(

        String avatarName,
        String semesterId,
        String veranstaltungId
) {

    public Spieler toSpieler() {
        return Spieler.builder()
                .id(null)
                .avatarName(avatarName)
                .semesterId(semesterId)
                .veranstaltungId(veranstaltungId)
                .build();
    }
}
