package com.hka.exitgame.dto;

import com.hka.exitgame.entities.Spieler;

public record SpielerDto(

        String spielerId,
        String semesterId,
        String veranstaltungId
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
