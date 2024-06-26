package com.hka.exitgame.dto;

import com.hka.exitgame.entities.Kommentar;

import java.util.UUID;

public record KommentarDto(
        UUID id,
        UUID spielerId,
        UUID semesterId,
        String inhalt,
        String creationTimestamp
) {

    public Kommentar toKommentar() {
        return Kommentar.builder()
                .id(null)
                .spielerId(spielerId)
                .semesterId(semesterId)
                .inhalt(inhalt)
                .creationTimestamp(creationTimestamp)
                .build();
    }
}
