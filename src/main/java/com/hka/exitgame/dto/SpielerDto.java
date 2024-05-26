package com.hka.exitgame.dto;

import com.hka.exitgame.entities.Spieler;

import java.util.UUID;

public record SpielerDto(

        String spielerId,
        UUID semesterId,
        UUID veranstaltungId
) {

    public Spieler toSpieler() {
        return Spieler.builder()
                .id(null)
                .spielerId(spielerId)
                .semesterId(semesterId)
                .veranstaltungId(veranstaltungId)
                .build();
    }
}
